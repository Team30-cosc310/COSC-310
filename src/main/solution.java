package main;

import java.util.List;
import java.util.Locale;

public class solution {
    static Device d1;
    private static String keyword;

    public solution(Device device) {
        d1 = device;


    }

    public static String Findsol(String Q) {//takes in Sting
        Q = Q.toLowerCase(Locale.ROOT);//convert to lowercase
        Boolean ex = false;
        if(Q.equals("exit")||Q.equals("done"))//check if user entered an exit phrase
            return("exit");
        for (int i = 0; i < d1.master.size(); i++) {//double for loop to search each list in master list for keywords
            if(ex)//break controler
                break;
            List<String> L1 = d1.master.get(i);
            for (int j = 0; j < L1.size(); j++) {
                if (Q.contains(L1.get(j))) {
                    keyword = (L1.get(j));
                    ex = true;
                    break;
                } else {
                    keyword = "not found";
                }
            }
        }

        if (keyword.equals("not found")) {//match keyword to its list and find solution that acompanies key vale
            return ("I couldn't understand that please try and rephrase your problem");
        }
        for (int i = 0; i < d1.master.size(); i++) {
            for (int j = 0; j < d1.master.get(i).size(); j++) {
                if (d1.master.get(i).get(j).equals(keyword)) {
                    //System.out.println(d1.problems.get(d1.master.get(i)));
                    return d1.problems.get(d1.master.get(i));
                }
            }
        }

        return ("an error has occurred");//if nothing is found an error has occured
    }
}

