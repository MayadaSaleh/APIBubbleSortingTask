/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.interfaces;

import java.util.ArrayList;
import pojo.NumberPojo;
import pojo.ResultResponse;
/**
 *
 * @author Mayada
 */
public interface BubbleSortApiInterface {
    public ArrayList<NumberPojo> retriveNumbers();
    public ResultResponse insertNumber(NumberPojo numberPojo);
    
}
