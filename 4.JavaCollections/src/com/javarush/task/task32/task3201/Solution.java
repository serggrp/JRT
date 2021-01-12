package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        long pos = Long.valueOf(args[1]);
        byte[] data = args[2].getBytes();
        if (raf.length() < pos+data.length)
            raf.seek(raf.length());
        else
            raf.seek(pos);
        raf.write(args[2].getBytes());
    }
}
