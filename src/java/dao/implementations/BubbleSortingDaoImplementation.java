/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementations;

import dao.interfaces.BubbleSortingDaoInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.NumberPojo;

/**
 *
 * @author Mayada
 */
public class BubbleSortingDaoImplementation implements BubbleSortingDaoInterface {

    Connection con = null;
    PreparedStatement pst = null;

    @Override
    public boolean insert(NumberPojo numberPojo) throws SQLException {

        try {
            con = database.connection.DatabaseConnection.getConnection();
            pst = con.prepareStatement("INSERT INTO BubbleNumber"
                    + "(number)"
                    + " VALUES(?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            pst.setInt(1, numberPojo.getNumber());
            pst.executeUpdate();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }

    @Override
    public ArrayList<NumberPojo> retrieveNumbers() {

        ArrayList<NumberPojo> allNumbers = new ArrayList<>();

        try (Connection connection = database.connection.DatabaseConnection.getConnection()) {
            con = database.connection.DatabaseConnection.getConnection();
            pst = con.prepareStatement("SELECT * FROM bubblenumber");
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                NumberPojo myNumber = new NumberPojo();
                myNumber.setId(resultSet.getInt(1));
                myNumber.setNumber(resultSet.getInt(2));
                allNumbers.add(myNumber);

            }
            
            //Bubble Sorting
            for (int i = 0; i < allNumbers.size() - 1; i++) {
                for (int j = 0; j < allNumbers.size() - i - 1; j++) {
                    if (allNumbers.get(j).getNumber() > allNumbers.get(j + 1).getNumber()) {
                        NumberPojo temp = allNumbers.get(j);
                        allNumbers.set(j,allNumbers.get(j + 1));
                        allNumbers.set((j + 1),(temp));
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(BubbleSortingDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }

        return allNumbers;

    }

}
