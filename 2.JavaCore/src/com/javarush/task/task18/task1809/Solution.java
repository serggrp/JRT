package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        FileOutputStream fos = new FileOutputStream(reader.readLine());
        reader.close();
        byte[] farr = new byte[fis.available()];
        fis.read(farr);
        for (int i = farr.length - 1; i >= 0 ; i--) {
            fos.write(farr[i]);
        }
        fos.flush();
        fis.close();
        fos.close();
    }
}
