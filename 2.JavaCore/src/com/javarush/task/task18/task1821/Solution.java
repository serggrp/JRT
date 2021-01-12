package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        HashMap<Character, Integer> map = new HashMap<>();
        while(fis.available() > 0){
            char b = (char) fis.read();
            if (map.keySet().contains(b)){
                map.put(b, map.get(b) + 1);
            }
            else
                map.put(b, 1);
        }
        LinkedList<Character> list = new LinkedList<>(map.keySet());
        Collections.sort(list);
        for (Character i : list) {
            System.out.println(i + " " + map.get(i));
        }
        fis.close();
    }
}
