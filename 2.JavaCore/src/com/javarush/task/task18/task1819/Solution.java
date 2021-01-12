package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();
        FileInputStream fis1 = new FileInputStream(f1);
        byte[] arr1 = new byte[fis1.available()];
        fis1.read(arr1);
        fis1.close();
        FileInputStream fis2 = new FileInputStream(f2);
        byte[] arr2 = new byte[fis2.available()];
        fis2.read(arr2);
        fis2.close();
        FileOutputStream fos = new FileOutputStream(f1);
        fos.write(arr2);
        fos.write(arr1);
        fos.close();

    }
}
