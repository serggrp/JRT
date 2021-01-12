package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        FileOutputStream fos = new FileOutputStream(reader.readLine());
        BufferedReader fReader = new BufferedReader(new InputStreamReader(fis));
        reader.close();
        String content = fReader.readLine();
        for (String s : content.split(" ")) {
            if (s.matches("\\d+")){
                fos.write(s.getBytes());
                fos.write(32);
            }
            else{
               fos.write((Math.round(Double.parseDouble(s))+" ").getBytes());
            }

        }
        fReader.close();
        fis.close();
        fos.close();
    }
}
