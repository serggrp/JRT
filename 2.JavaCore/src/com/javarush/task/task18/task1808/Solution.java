package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(file1);
        int sBuf1 = fis.available() / 2;
        int sBuf2 = fis.available() % 2 == 0 ? sBuf1 : sBuf1 + 1;
        byte[] arr1 = new byte[sBuf2];
        byte[] arr2 = new byte[sBuf1];
        fis.read(arr1);
        fis.read(arr2);
        fis.close();
        FileOutputStream fos1 = new FileOutputStream(file2);
        fos1.write(arr1);
        fos1.flush();
        fos1.close();
        FileOutputStream fos2 = new FileOutputStream(file3);
        fos2.write(arr2);
        fos2.flush();
        fos2.close();

    }
}
