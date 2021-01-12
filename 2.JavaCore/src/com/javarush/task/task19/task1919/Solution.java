package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        SortedMap<String, Double> map = new TreeMap<>();
//        FileReader reader = new FileReader("C:\\workflow\\jLearn\\test\\1919.txt");
        FileReader reader = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(reader);
        while (br.ready()){
            String line = br.readLine();
            String name = line.split(" ")[0];
            Double val = Double.parseDouble(line.split(" ")[1]);
            if (map.containsKey(name)){
                map.put(name, map.get(name)+val);
            }
            else
                map.put(name, val);
        }
        reader.close();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
