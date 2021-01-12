package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        print(1);
        print(new Integer(100));
    }

    //Напишите тут ваши методы
    static void print(int i){
        System.out.println("int");
    }
    static void print(Integer i){
        System.out.println("Integer");
    }
}
