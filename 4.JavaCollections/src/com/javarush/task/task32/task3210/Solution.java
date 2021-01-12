package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        long pos = Long.valueOf(args[1]);
        raf.seek(pos);
        byte[] arr = new byte[args[2].length()];
        raf.read(arr, 0, arr.length);
        raf.seek(raf.length());
        if (args[2].equals(new String(arr))){
            raf.write("true".getBytes());
        }
        else{
            raf.write("false".getBytes());
        }
    }
}
