package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        String result = "";
        if (reader != null){
            StringBuilder sb = new StringBuilder();
            int symb = reader.read();
            while (symb != -1){
                sb.append((char)(symb+key));
                symb = reader.read();
            }
            result = sb.toString();
        }
        return result;
    }
}
