package main;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Survey {

    java.util.Date date;
    String filename;
    List<String> SurveyQuestions;


    public Survey() {
        //get current date and time
        date = new java.util.Date();

        asave();


        String Q1 = "How accessible was this service";
        String Q2 = "How detailed were the responses";
        String Q3 = "How fast were the responses";
        String Q4 = "Did you receive all the help you needed";
        String Q5 = "How likely are you to recommend this to a friend";
        String Q6 = "";//leave this here
        SurveyQuestions = new ArrayList<>(Arrays.asList(Q1, Q2, Q3, Q4, Q5, Q6));

    }

    public void questionuser() {
        Scanner sc = new Scanner(System.in);
        // System.out.println("please answer the following questions by entering a score from 1-10");
        //System.out.println("1-not at all. 10-totaly agree");
        for (String S : SurveyQuestions) {

            System.out.println(S);
            String answer = sc.nextLine();

            writer(S + ":" + answer);

        }

    }


    public void asave() {

        //System.out.println("SURV_"+date+".txt");
        filename = maketitle("SURV_" + date + ".txt");//string that includes name and date of creation

        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {//make a new file
                // System.out.println("File created: " + myObj.getName());
                writer(filename);//write filename as first line in file
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Requires a string
    //modifies filename
    //effects eddit filename to appropriate format
    public String maketitle(String title) {
        String name = title;
        name = name.replace(" ", "_");
        name = name.replace(":", ".");

        return name;
    }

    //requires file to be created
    //modifies filename file
    //effect writes texts on file
    public void writer(String text) {
        try {
            FileWriter myWriter = new FileWriter(filename, true);
            myWriter.write(text + "\n");
            myWriter.close();
            // System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String read(String name) {
       String content="";
       String total;
        try {
            File myObj = new File(name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                content = content + data;
                content = content +"\n";
                System.out.println(data);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return content;
    }



}