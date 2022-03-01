package main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class test {


    Device device = new Device();
    solution sol = new solution(device);

    @Test
    public void searchsomething(){
        Assert.assertEquals("plug into power",sol.Findsol("plug in to power"));
    }
    @Test
    public void searchnothing(){
        Assert.assertEquals("I couldn't understand that please try and rephrase your problem",sol.Findsol(""));
    }
    @Test
    public void searchnotther(){
        Assert.assertEquals("I couldn't understand that please try and rephrase your problem",sol.Findsol("I need a new phone"));//no keywords in search
    }
    @Test
    public void testsurvey() {
        Survey survey = new Survey();
        String title = survey.filename;
        survey.writer("test");
       String S1=survey.read(title);

       Assert.assertTrue(S1.equals(survey.filename+"\ntest"+"\n"));



    }
}
