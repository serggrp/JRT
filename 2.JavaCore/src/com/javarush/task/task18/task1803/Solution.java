package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        while (fis.available() > 0){
            int b = fis.read();
            if (map.containsKey(b)){
                map.put(b, map.get(b)+1);
                if (map.get(b) > max)
                    max = map.get(b);
            }
            else
                map.put(b, 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max)
                System.out.print(entry.getKey() + " ");
        }
        fis.close();
    }
}
