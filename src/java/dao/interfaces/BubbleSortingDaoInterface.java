/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import pojo.NumberPojo;

/**
 *
 * @author Mayada
 */
public interface BubbleSortingDaoInterface {

    public boolean insert(NumberPojo numberPojo) throws SQLException;
    public ArrayList<NumberPojo> retrieveNumbers();

    }
