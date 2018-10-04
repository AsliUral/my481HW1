package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
   
    public void testApp()
    {
        assertTrue( true );
    }

    
    public void test1() {
      ArrayList<String> result  = new ArrayList<>(Arrays.asList("Ayseky","Fatmaky","Hayriyeky"));
      ArrayList<String> strck  = new ArrayList<>(Arrays.asList("Ayse","Fatma","Hayriye"));
      ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1,2,3,4));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(5,6,7,8));
      String s="y";
      ArrayList<String> resultMethod = new App().MakeNewWord(array1 , array2 , strck , s);
      assertEquals(result,resultMethod);
      
    }

    public void test2size() {
      ArrayList<String> result  = new ArrayList<>(Arrays.asList("AsliyK","TunayK","İremyK","EdizyK"));
      ArrayList<String> strck  = new ArrayList<>(Arrays.asList("Asli","Tuna","İrem","Ediz"));
      ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1,2,3,4,9000,7,99,8));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(5,6,7,8));
      String s="K";
      ArrayList<String> resultMethod = new App().MakeNewWord(array1 , array2 , strck , s);
      assertEquals(result,resultMethod);
     
      
    }
    public void test3negative() {
      ArrayList<String> result  = new ArrayList<>(Arrays.asList("elmacW","armutcW","portakalcW"));
      ArrayList<String> strck  = new ArrayList<>(Arrays.asList("elma","armut","portakal"));
      ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(-1,-2,3,4,9000,7,99,8));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(5,6,7,-8));
      String s="W";
      ArrayList<String> resultMethod = new App().MakeNewWord(array1 , array2 , strck , s);
      assertEquals(result,resultMethod);
     
      
    }
     public void test4word() {
      ArrayList<String> result  = new ArrayList<>(Arrays.asList("kitapdasli","defterdasli","kalemdasli","silgidasli"));
      ArrayList<String> strck  = new ArrayList<>(Arrays.asList("kitap","defter","kalem","silgi"));
      ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(10,9,4,5));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1));
      String s="asli";
      ArrayList<String> resultMethod = new App().MakeNewWord(array1 , array2 , strck , s);
      assertEquals(result,resultMethod);
     
      
    }
      public void test5null() {
      ArrayList<String> result  = null;
      ArrayList<String> strck  = null;
      ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(10,9,4,5));
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1));
      String s="asli";
      ArrayList<String> resultMethod = new App().MakeNewWord(array1 , array2 , strck , s);
      assertEquals(result,resultMethod);
     
      
    }

    public void test5null2() {
      ArrayList<String> result  = null;
      ArrayList<String> strck  = new ArrayList<>(Arrays.asList("kitapcik","deftercik","kalemcik","silgicik"));;
      ArrayList<Integer> array1 = null;
      ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1));
      String s="asli";
      ArrayList<String> resultMethod = new App().MakeNewWord(array1 , array2 , strck , s);
      assertEquals(result,resultMethod);
     
      
    }

    public void test5null3() {
      ArrayList<String> result  = null;
      ArrayList<String> strck  = new ArrayList<>(Arrays.asList("tobb","etu","bil","odev"));;
      ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(0,9,14,5));
      ArrayList<Integer> array2 = null;
      String s="asli";
      ArrayList<String> resultMethod = new App().MakeNewWord(array1 , array2 , strck , s);
      assertEquals(result,resultMethod);
     
      
    }
    public void test6null3() {
      ArrayList<String> result  = new ArrayList<>(Arrays.asList("bilz","481z","canimz","odevimz"));;
      ArrayList<String> strck  = new ArrayList<>(Arrays.asList("bil","481","canim","odevim"));;
      ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(0,9,14,5));
      ArrayList<Integer> array2 =  new ArrayList<>(Arrays.asList(9,6,3,5));
      String s="";
      ArrayList<String> resultMethod = new App().MakeNewWord(array1 , array2 , strck , s);
      assertEquals(result,resultMethod);
     
      
    }

   

    



    





   
   
    

}
