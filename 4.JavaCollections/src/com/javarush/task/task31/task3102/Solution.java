package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> queue = new ConcurrentLinkedQueue<>(Arrays.asList(new File(root).listFiles()));
        List<String> result = new ArrayList<>();
        Iterator<File> iter = queue.iterator();
        while(iter.hasNext()){
            File curr = iter.next();
            if (curr.isDirectory()){
                queue.addAll(Arrays.asList(curr.listFiles()));
                iter.remove();
            }
        }
        for (File file : queue) {
            result.add(file.getAbsolutePath());
        }
        return result;

    }

    public static void main(String[] args) throws  IOException{
        List<String> names = getFileTree("C:\\workflow\\jLearn\\test\\files");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
