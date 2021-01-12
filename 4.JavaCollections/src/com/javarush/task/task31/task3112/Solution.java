package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:/tmp"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL link = new URL(urlString);
        InputStream is = link.openStream();
        Path tmpFile = Files.createTempFile("tmp-", ".tmp");
        Files.copy(is, tmpFile);
        return Files.move(tmpFile, Paths.get(downloadDirectory.toString(), urlString.substring(urlString.lastIndexOf("/"))));
    }
}
