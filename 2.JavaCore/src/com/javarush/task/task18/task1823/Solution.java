package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (!(line = reader.readLine()).equals("exit")){
            ReadThread rt = new ReadThread(line);
            rt.start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileNmae;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileNmae = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(fileNmae);
                int[] barr = new int[256];
                while (fis.available() > 0){
                    int i = fis.read();
                    barr[i]++;
                }
                fis.close();
                int max = 0, indx = 0;
                for (int i = 0; i < barr.length; i++) {
                    if (barr[i] > max){
                        max = barr[i];
                        indx = i;
                    }
                }
                resultMap.put(fileNmae, indx);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
