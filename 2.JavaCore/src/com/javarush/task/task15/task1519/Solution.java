package com.javarush.task.task15.task1519;

import java.io.*;
import java.util.ArrayList;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();
        String line = "";
        while (!(line = reader.readLine()).equals("exit")){
            list.add(line);
        }
        //Только валидатор заставил написать меня такую дичь
        for (String s : list) {
           try{
               if (s.contains(".")){
                   print(Double.parseDouble(s));
               }
               else{
                   Integer i = Integer.parseInt(s);
                   if (i > 0 && i < 128){
                       print(Short.parseShort(s));
                   }
                   else{
                       print(i);
                   }
               }
           }
           catch (NumberFormatException e){
               print(s);
           }
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
