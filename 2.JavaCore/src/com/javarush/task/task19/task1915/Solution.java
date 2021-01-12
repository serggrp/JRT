package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        reader.close();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream origin = System.out;
        PrintStream wrap = new PrintStream(bos);
        System.setOut(wrap);
        testString.printSomething();
        FileOutputStream fos = new FileOutputStream(fname);
        fos.write(bos.toByteArray());
        fos.close();
        System.setOut(origin);
        System.out.println(bos);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

