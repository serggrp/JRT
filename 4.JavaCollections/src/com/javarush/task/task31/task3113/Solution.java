package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Path trgt = Paths.get(line);

        if (!Files.isDirectory(trgt))
            System.out.println(line + " - не папка");
        else{
            CustomFileVisitor cfv = new CustomFileVisitor();
            Files.walkFileTree(trgt, cfv);
            System.out.println(String.format("Всего папок - %d\n" +
                    "Всего файлов - %d\n" +
                    "Общий размер - %d",cfv.folderCount, cfv.fileCount, cfv.byteCount));
        }
        br.close();
    }

    static class CustomFileVisitor extends SimpleFileVisitor<Path>{
        public int folderCount = -1, fileCount = 0, byteCount = 0;
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            fileCount++;
            byte[] arr = Files.readAllBytes(file);
            byteCount += arr.length;
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            folderCount++;
            return super.preVisitDirectory(dir, attrs);
        }
    }
}
