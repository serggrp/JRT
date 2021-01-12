package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static{
        threads.add(new Thread(new Thread1()));
        threads.add(new Thread(new Thread2()));
        threads.add(new Thread(new Thread3()));
        threads.add(new Thread4());
        threads.add(new Thread(new Thread5()));
    }

    public static void main(String[] args) {
    }

    public static class Thread1 implements Runnable{
        @Override
        public void run() {
            while(true){

            }
        }
    }

    public static class Thread2 implements Runnable{

        @Override
        public void run() {
            try{
                while (true){
                    Thread.sleep(100);
                }
            }
            catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 implements Runnable{

        @Override
        public void run() {
            try {
                while(true){
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public static class Thread4 extends Thread implements Message{
        private boolean isAlive = true;

        @Override
        public void showWarning() {
            isAlive = false;
        }

        @Override
        public void run() {
            while (isAlive){

            }
        }
    }

    public static class Thread5 implements Runnable{
        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int sum = 0;
                String line;
                while (!(line = reader.readLine()).equals("N")){
                    try{
                        int a = Integer.parseInt(line);
                        sum += a;
                    }
                    catch (NumberFormatException e){}
                }
                System.out.println(sum);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}