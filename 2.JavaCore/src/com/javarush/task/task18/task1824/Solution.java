package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            while (true) {
                line = reader.readLine();
                FileInputStream fis = new FileInputStream(line);
                fis.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(line);
        }
        finally {
            reader.close();
        }
    }
}
