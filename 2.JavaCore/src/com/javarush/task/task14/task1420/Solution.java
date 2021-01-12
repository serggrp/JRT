package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        try {
            int a = Integer.parseInt(reader.readLine());
            if (a <= 0) {
                throw new Exception();
            }
            int b = Integer.parseInt(reader.readLine());
            if (b <= 0){
                throw new Exception();
            }
            for (int i = a > b ? b : a; i >= 1; i--) {
                if (a % i == 0 && b % i == 0){
                    System.out.println(i);
                    break;
                }
            }

//        }
//        finally {
            reader.close();
//        }
    }
}
