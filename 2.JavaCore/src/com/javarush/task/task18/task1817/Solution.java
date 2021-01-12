package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int size = fis.available();
        int cnt = 0;
        while (fis.available() > 0){
            if (fis.read() == 32)cnt++;
        }
        fis.close();
        double ratio = (double)cnt / size * 100;
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println(df.format(ratio));
    }
}
