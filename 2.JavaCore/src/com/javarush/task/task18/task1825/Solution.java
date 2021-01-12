package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        HashMap<Integer, String> fMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = "";
        while(!(fName = reader.readLine()).equals("end")){
            fMap.put(Integer.parseInt(fName.substring(fName.lastIndexOf("part")).replace("part", "")), fName);
        }
        reader.close();
        FileOutputStream fos = new FileOutputStream(fMap.get(1).substring(0, fMap.get(1).lastIndexOf(".part")), true);
        for (int i = 1; i <= fMap.size(); i++) {
            FileInputStream fis = new FileInputStream(fMap.get(i));
            byte[] buf = new byte[4096];
            while (fis.available() > 0){
                int size = fis.read(buf);
                fos.write(buf, 0, size);
            }
            fis.close();
        }
        fos.flush();
        fos.close();

    }

}
