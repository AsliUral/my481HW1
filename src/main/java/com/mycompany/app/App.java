package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


//iki int arrayindeki sayıları topla  kendi alfabemdeki harfe karsılık gelen degeri al char be string arrayi ile birlestir
public class App 
{
     public static ArrayList<String> MakeNewWord(ArrayList<Integer> array, ArrayList<Integer> array2,ArrayList<String> lst, String s){
    
      if (array == null){
        return null;
      }
    	if (array2 == null){
        return null;
      }
      if (lst == null){
        return null;
      }
      String [] alf=new String[52];

      int index=0;
      //buyuk harfler
      for(int i=65; i<91; i++) {
        alf[index] = (char)i+"";
        index++;
      }
		
		  //kucuk harfler
      for(int i=97; i<123; i++) {
        alf[index] = (char)i+"";
        index++;
      }

      
      int sum=0;

      for(int i=0; i<array.size() ; i++){
        sum+=array.get(i);
      }
      for(int i=0; i<array2.size() ; i++){
        sum+=array2.get(i);
      }

      if(sum>alf.length){
        sum=sum%alf.length;
      }

      String plus=alf[sum];


      for(int i=0; i<lst.size(); i++){
        lst.set(i,lst.get(i)+plus+s);
      }
      return lst;


     }

     public static void main(String [] args){
       port(getHerokuAssignedPort());

        get("/", (req, res) -> {
            res.redirect("/compute",301);
            return "";
        });

        post("/compute", (req, res) -> {
        
        //input1
        String input1 = req.queryParams("input1");
        java.util.Scanner sc1 = new java.util.Scanner(input1);
        sc1.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
        while (sc1.hasNext()){
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
        }
        System.out.println(inputList);

        //second input2
        String input2 = req.queryParams("input2");
        java.util.Scanner sc2 = new java.util.Scanner(input2);
        sc2.useDelimiter("[;\r\n]+");
        java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
        while (sc2.hasNext()){
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
        }
        System.out.println(inputList2);
        
        //input3
        
        String input3 = req.queryParams("input3");
        java.util.Scanner sc3 = new java.util.Scanner(input3);
        sc3.useDelimiter("[;\r\n]+");
        java.util.ArrayList<String> inputList3 = new java.util.ArrayList<>();
        while (sc3.hasNext()){
            String value = sc3.next().replaceAll("\\s","");
            inputList3.add(value);
        }
        System.out.println(inputList3);
        
        //input 4

        String input4 = req.queryParams("input4");
        java.util.Scanner sc4 = new java.util.Scanner(input4);
        //sc4.useDelimiter("[;\r\n]+");
        String inputList4 = sc4.next();
        //while (sc4.hasNext()){
        //  int value = Integer.parseInt(sc4.next().replaceAll("\\s",""));
        //    inputList4.add(value);
        //}
        System.out.println(inputList4);


        ArrayList<String> result = App.MakeNewWord(inputList, inputList2 , inputList3 , inputList4 );
        
        
        


        Map map = new HashMap();
        map.put("result", result);
        return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
     }

