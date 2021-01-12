package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream fis = new FileInputStream(filename);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fis));
        List<Integer> list = new ArrayList<>();
        while (fileReader.ready()){
            int a = Integer.parseInt(fileReader.readLine());
            if (a % 2 == 0)
                list.add(a);
        }
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        reader.close();
        fis.close();
        fileReader.close();
    }
}
