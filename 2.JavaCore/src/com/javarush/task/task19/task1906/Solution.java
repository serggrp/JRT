package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        while (fileReader.ready()){
            int bt = fileReader.read();
            if (fileReader.ready())
                fileWriter.write(fileReader.read());
        }
        reader.close();
        fileReader.close();
        fileWriter.close();

    }
}
