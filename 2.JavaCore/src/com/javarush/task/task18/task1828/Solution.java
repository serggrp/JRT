package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        StringBuilder sb = new StringBuilder();
        if (args.length > 1){
            BufferedReader fReader = new BufferedReader(new FileReader(filename));
            String id = args[1].length() < 8 ? String.format("%-8s", args[1]) : args[1].substring(0, 8);
            while(fReader.ready()){
                String line = fReader.readLine();
                if (line.substring(0, 8).equals(id)){
                    if (args[0].equals("-u")){
                        line = String.format("%-8s%-30s%-8s%-4s", args[1], args[2].length() > 30 ? args[2].substring(0, 30) : args[2],
                                args[3].length() > 8 ? args[3].substring(0, 8) : args[3], args[4].length() > 4 ? args[4].substring(0, 4) : args[4]);
                        sb.append(line + System.lineSeparator());
                    }
                }
                else
                    sb.append(line + System.lineSeparator());
            }
            fReader.close();
            BufferedWriter fWriter = new BufferedWriter(new FileWriter(filename));
            sb.deleteCharAt(sb.length()-1);
            fWriter.write(sb.toString());
            fWriter.close();
        }

    }
}
