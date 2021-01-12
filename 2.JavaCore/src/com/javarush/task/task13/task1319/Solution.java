package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        BufferedWriter fWriter = new BufferedWriter(new FileWriter(fName));
        String line = "";
        do
        {
            line = reader.readLine();
            fWriter.write(line+System.lineSeparator());
        }
        while (!line.equals("exit"));
        fWriter.flush();

        reader.close();
        fWriter.close();
    }
}
