package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader cr = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(cr.readLine());
        FileWriter fw = new FileWriter(cr.readLine());
        cr.close();
        BufferedReader reader = new BufferedReader(fr);
        BufferedWriter writer = new BufferedWriter(fw);
        while (reader.ready()){
            String line = reader.readLine();
            writer.write(line.replaceAll("\\p{Punct}", "").replace(System.lineSeparator(), ""));
        }
        reader.close();
        writer.close();
    }
}
