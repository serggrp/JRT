package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        int bCode = (int) ',';
        int cnt = 0;
        while(fis.available() > 0){
            if (fis.read() == bCode)
                cnt++;
        }
        fis.close();
        System.out.println(cnt);
    }
}
