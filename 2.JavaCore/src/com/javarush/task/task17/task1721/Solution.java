package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            reader.close();
            read(new BufferedReader(new InputStreamReader(new FileInputStream(file1))), allLines);
            read(new BufferedReader(new InputStreamReader(new FileInputStream(file2))), forRemoveLines);
            new Solution().joinData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void read(BufferedReader reader, List trgt) throws IOException{
        while (reader.ready()){
            trgt.add(reader.readLine());
        }
        reader.close();
    }
    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            for (String line : forRemoveLines) {
                allLines.remove(line);
            }
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
