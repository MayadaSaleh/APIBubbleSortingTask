/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.implementations;

import dao.implementations.BubbleSortingDaoImplementation;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pojo.NumberPojo;
import pojo.ResultResponse;

/**
 *
 * @author Mayada
 */
@Path("/bubblesortingnumber")
public class BubbleSortApiImplementation {

    static BubbleSortingDaoImplementation daoImplementation = new BubbleSortingDaoImplementation();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<NumberPojo> retriveNumbers() {
        ArrayList<NumberPojo> numbers = new ArrayList();
        numbers = daoImplementation.selectAllNumbers();
        if (!numbers.isEmpty()) {
            return numbers;
        } else {
            return null;
        }
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultResponse insertNumber(NumberPojo numberPojo) {
        Boolean checkInsertion = false;
        NumberPojo insertedNumber = new NumberPojo();
        ResultResponse result = new ResultResponse();
        insertedNumber.setNumber(numberPojo.getNumber());

        try {
            checkInsertion = daoImplementation.insertNumber(insertedNumber);
            if (checkInsertion) {
                result.setError(1);
                result.setMessage("Insertion Done");
                result.setStatus(true);
            } else {
                result.setError(0);
                result.setMessage("Error in Insertion");
                result.setStatus(false);
            }
        } catch (Exception ex) {
            result.setError(1);
            result.setMessage("Error in Insertion");
            result.setStatus(false);
        }
        return result;
    }
}
