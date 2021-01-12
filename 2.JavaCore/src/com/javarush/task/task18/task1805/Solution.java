package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        Set<Integer> set = new TreeSet<Integer>(Comparator.comparing(Integer::valueOf));
        while(fis.available() > 0){
            set.add(fis.read());
        }
        fis.close();
        for (Integer in : set) {
            System.out.print(in + " ");
        }
    }
}
