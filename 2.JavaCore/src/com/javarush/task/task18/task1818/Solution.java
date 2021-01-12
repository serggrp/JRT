package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fos = new FileOutputStream(reader.readLine());
        FileInputStream fis2 = new FileInputStream(reader.readLine());
        FileInputStream fis3 = new FileInputStream(reader.readLine());
        reader.close();
        byte [] buf = new byte[4096];
        while(fis2.available() > 0){
            int len = fis2.read(buf);
            fos.write(buf, 0, len);
        }
        fis2.close();

        while(fis3.available() > 0){
            int len = fis3.read(buf);
            fos.write(buf, 0, len);
        }
        fis3.close();
        fos.close();
    }
}
