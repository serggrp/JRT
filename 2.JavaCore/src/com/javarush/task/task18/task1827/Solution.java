package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

            BufferedReader fReader = new BufferedReader(new FileReader(fileName));
            int max = 0;
            while (fReader.ready()) {
                String line = fReader.readLine().substring(0, 8);
                int cur = Integer.parseInt(line.trim());
                if (cur > max) {
                    max = cur;
                }
            }
            fReader.close();
        if (args.length != 0) {
            BufferedWriter fWriter = new BufferedWriter(new FileWriter(fileName, true));
            fWriter.write(System.lineSeparator());
            fWriter.write(String.format("%-8s%-30s%-8s%-4s", String.valueOf(++max), args[1].length() > 30 ? args[1].substring(0, 30) : args[1],
                    args[2].length() > 8 ? args[2].substring(0, 8) : args[2], args[3].length() > 4 ? args[3].substring(0, 4) : args[3]));
            fWriter.flush();
            fWriter.close();
        }
    }
}
