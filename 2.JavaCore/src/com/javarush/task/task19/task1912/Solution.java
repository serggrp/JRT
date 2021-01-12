package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
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
        String s = bos.toString().replaceAll("te", "??");
        System.setOut(origin);
        System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
