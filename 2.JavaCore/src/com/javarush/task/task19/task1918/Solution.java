package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.ArrayList;

public class Solution {

    static ArrayList<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(br.readLine());
//        FileReader reader = new FileReader("C:\\workflow\\jLearn\\test\\test.txt");
        br.close();
        String tgo = "<a", tgc = "</a>";

        StringBuilder sb = new StringBuilder();
        while(reader.ready()){
            char[] cbuf = new char[200];
            int len = reader.read(cbuf);
            sb.append(new String(cbuf, 0, len));
        }
        reader.close();
        String content = sb.toString().replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "");
        content = content.substring(content.indexOf(tgo), content.lastIndexOf(tgc)+tgc.length());

        while ((content = getTag(new StringBuilder(), content, tgo, tgc)).contains(tgo));
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static String getTag(StringBuilder line, String content, String tgo, String tgc){
        int bal = -1;
        while (bal != 0 && content.length() > 0){
            line.append(content.substring(0, content.indexOf(tgc)+tgc.length()));
            content = content.substring(content.indexOf(tgc)+tgc.length());
            bal = line.toString().split(tgc).length + 1 - line.toString().split(tgo).length;
        }
        result.add(line.toString());
        if(line.indexOf(tgc) != line.lastIndexOf(tgc)){
            String line2 = line.substring(line.indexOf(tgo, 2));
            line2 = line2.substring(0, line2.lastIndexOf(tgc));
            line2 = line2.substring(0, line2.lastIndexOf(tgc)+tgc.length());
            while ((line2 = getTag(new StringBuilder(), line2, tgo, tgc)).contains(tgo));
        }
        if (content.contains(tgo))
            content = content.substring(content.indexOf(tgo));
        return content;
    }
}
