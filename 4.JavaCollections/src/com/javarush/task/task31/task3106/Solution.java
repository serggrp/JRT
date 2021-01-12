package com.javarush.task.task31.task3106;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.zip.ZipInputStream;
import java.io.IOException;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        try {
            String dest = args[0];
            String[] fileArr = new String[args.length - 1];
            System.arraycopy(args, 1, fileArr, 0, fileArr.length);
            Arrays.sort(fileArr);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            for (String s : fileArr) {
                Files.copy(Paths.get(s), bos);
            }
            byte[] byteArr = bos.toByteArray();
            bos.close();
            try (FileOutputStream fos = new FileOutputStream(dest)) {
                try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(byteArr))) {
                    zis.getNextEntry();
                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    byte[] buffer1 = new byte[8 * 1024];
                    int len;
                    while ((len = zis.read(buffer1)) > 0) {
                        buffer.write(buffer1, 0, len);
                    }
                    buffer.flush();
                    buffer.writeTo(fos);
                    buffer.close();
                    fos.flush();
                }
            }
        } catch (IOException e) {

        }
    }
}
