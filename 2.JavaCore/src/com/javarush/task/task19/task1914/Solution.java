package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream origin = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream wrap = new PrintStream(bos);
        System.setOut(wrap);
        testString.printSomething();
        System.setOut(origin);
        String s = bos.toString().replaceAll(System.lineSeparator(), "");
        String[] arr = s.split(" ");
        int result = 0;
        switch (arr[1]){
            case "+" : {
                result = Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]);
                break;
            }
            case "-" : {
                result = Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]);
                break;
            }
            case "*" : {
                result = Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]);
                break;
            }
        }
        System.out.println(s+result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

