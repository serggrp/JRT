package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader cReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(cReader.readLine());
        FileWriter fw = new FileWriter(cReader.readLine());
        cReader.close();
        BufferedReader reader = new BufferedReader(fr);
        BufferedWriter writer = new BufferedWriter(fw);
        while (reader.ready()){
            String[] line = reader.readLine().split(" ");
            for (String s : line) {
                if (s.matches("\\d+")){
                    writer.write(s+" ");
                }
            }
        }
        reader.close();
        writer.close();
    }
}
