package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-e")){
            FileInputStream fis = new FileInputStream(args[1]);
            FileOutputStream fos = new FileOutputStream(args[2]);
            while (fis.available() > 0){
                int b1 = fis.read();
                if (fis.available() > 0){
                    int b2 = fis.read();
                    fos.write(b2);
                    fos.write(b1);
                }
                else
                    fos.write(b1);
            }
            fis.close();
            fos.flush();
            fos.close();
        }
        else if (args[0].equals("-d")) {
            //haha
            FileInputStream fis = new FileInputStream(args[1]);
            FileOutputStream fos = new FileOutputStream(args[2]);
            while (fis.available() > 0){
                int b1 = fis.read();
                if (fis.available() > 0){
                    int b2 = fis.read();
                    fos.write(b2);
                    fos.write(b1);
                }
                else
                    fos.write(b1);
            }
            fis.close();
            fos.flush();
            fos.close();
        }

    }

}
