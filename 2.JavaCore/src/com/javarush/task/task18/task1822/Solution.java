package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fReader = new BufferedReader(new FileReader(reader.readLine()));
        String line = "";
        while (fReader.ready()){
            line = fReader.readLine();
            if (line.split(" ")[0].equals(args[0])){
                System.out.println(line);
            }
        }
        reader.close();
        fReader.close();
    }
}
