package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("C:\\workflow\\jLearn\\test\\text.txt".getBytes())));
        FileReader freader = new FileReader(reader.readLine());
        reader.close();
        BufferedReader fbr = new BufferedReader(freader);
        int cnt = 0;
        while (fbr.ready()) {
            String[] words = fbr.readLine().split("[^\\w]");
            for (String word : words) {
                if (word.toLowerCase().equals("world"))
                    cnt++;
            }
        }
        freader.close();
        System.out.println(cnt);
    }

}
