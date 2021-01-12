package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        Random rand = new Random();
        int numCount = rand.nextInt(3)+1;
        ArrayList<String> result = new ArrayList<>(8);
        for (int i = 0; i < numCount; i++) {
            result.add(String.valueOf(rand.nextInt(10)%10));
        }
        result.add(String.valueOf((char)(rand.nextInt(24)+65)));
        result.add(String.valueOf((char)(rand.nextInt(24)+97)));
        for (int i = 0; i < 6 - numCount; i++) {
            if (rand.nextInt(2) == 1)
                result.add(String.valueOf((char)(rand.nextInt(24)+65)));
            else
                result.add(String.valueOf((char)(rand.nextInt(24)+97)));
        }
        Collections.shuffle(result);
        ByteArrayOutputStream baos = new ByteArrayOutputStream(8);
        for (String s : result) {
            baos.write(s.getBytes());
        }
        return baos;
    }
}