package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int cnt = 0;
        while (fis.available() > 0){
            int b = fis.read();
            if (b > 64 && b < 91 || b > 96 && b < 123)
                cnt++;
        }
        fis.close();
        System.out.println(cnt);
    }
}
