package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.9, "h");
        labels.put(1.8, "h1");
        labels.put(1.7, "h2");
        labels.put(1.5, "h3");
        labels.put(1.1, "h5");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
