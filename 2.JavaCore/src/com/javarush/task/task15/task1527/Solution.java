package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String url = reader.readLine();
            String params = url.split("\\?")[1];
            ArrayList<String> list = new ArrayList<>();
            String obj = null;
            for (String s : params.split("&")) {
                if (!s.contains("="))
                    list.add(s);
                else {
                    list.add(s.substring(0, s.indexOf("=")));
                    if (s.split("=")[0].equals("obj"))
                        obj = s.split("=")[1];
                }
            }

            for (String s : list) {
                System.out.print(s + " ");
            }
            if (obj != null){
                System.out.println();
                try{
                    alert(Double.parseDouble(obj));
                }
                catch (NumberFormatException e){
                    alert(obj);
                }
            }
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
