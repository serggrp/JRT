package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        byte[] a = new byte[257];
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        String fname = reader.readLine();
        int min = Integer.MAX_VALUE;
        reader.close();
        FileInputStream fis = new FileInputStream(fname);
        while(fis.available() > 0){
            int b = fis.read();
            a[b] += 1;
            if (a[b] < min)
                min = a[b];
        }
        fis.close();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == min) System.out.print(i + " ");
        }
    }
}
