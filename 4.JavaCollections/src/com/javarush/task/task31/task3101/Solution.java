package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File dir = new File(path);
        File result = new File(resultFileAbsolutePath);
        File resultTo = new File(result.getParent() + "\\allFilesContent.txt");
        if (FileUtils.isExist(result)) {
            FileUtils.renameFile(result, resultTo);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(resultTo);
        TreeSet<File> fileSet = new TreeSet<>(Comparator.comparing(File::getName));
        fileSearcher(dir, fileSet);
        for (File currentFile: fileSet) {
            FileInputStream fileInputStream = new FileInputStream(currentFile);
            byte[] buffer = new byte[fileInputStream.available()];

            fileInputStream.read(buffer, 0, buffer.length);
            fileOutputStream.write(buffer);
            fileOutputStream.write('\n');
            fileInputStream.close();
        }

        fileOutputStream.close();
    }
    public static void fileSearcher(File directory, Set<File> set){
        for (File file : directory.listFiles()) {
            if (file.isDirectory())
                fileSearcher(file, set);
            else{
                if(file.length() <= 50){
                    set.add(file);
                }
            }
        }
    }
}
