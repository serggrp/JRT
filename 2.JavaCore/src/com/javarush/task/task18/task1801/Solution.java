package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        int maxInt = Integer.MIN_VALUE;
        FileInputStream fis = new FileInputStream(fname);
        while(fis.available() > 0){
            int b = fis.read();
            if (b > maxInt)
                maxInt = b;
        }
        System.out.println(maxInt);
        reader.close();
        fis.close();
    }
}
