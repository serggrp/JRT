package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            char[] arr = args[0].toUpperCase().replaceAll("-", "").replaceAll("0", "1").toCharArray();
            char max = 0;
            for (char c : arr) {
                if (c < 48 || c > 90 || (c > 57 && c < 65)) {
                    System.out.println("incorrect");
                    return;
                }
                if (c > max)
                    max = c;
            }
            if (max < 58)
                System.out.println((Integer.valueOf(String.valueOf(max)) + 1));
            else
                System.out.println((max - 54));

        }
        catch (Exception e){
            System.out.println("incorrect");
        }
    }
}