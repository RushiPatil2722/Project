/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraud;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Details {

    static String inPath = "in1.csv";
    static String cols = "";
    static ArrayList dataList = new ArrayList();
    static String orgData[][];

    static double clsData[][];
    static ArrayList disList = new ArrayList();
    static ArrayList typeList = new ArrayList();
    static String user_id;
    static String username;
    static int age;
    static String gender;

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

}
