package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String line2 = null;
        while (file1.ready()){
            String line1 = file1.readLine();
            if (line2 != null && line1.equals(line2)){
                    lines.add(new LineItem(Type.SAME, line1));
                    line2 = null;
            }
            else {
                if (file2.ready()) {
                    if (line2 == null)
                        line2 = file2.readLine();
                    if (line1.equals(line2)) {
                        lines.add(new LineItem(Type.SAME, line1));
                        line2 = null;
                    } else {
                        if (file2.ready()) {
                            String nLine = file2.readLine();
                            if (nLine.equals(line1)) {
                                lines.add(new LineItem(Type.ADDED, line2));
                                lines.add(new LineItem(Type.SAME, line1));
                                line2 = null;
                            } else {
                                lines.add(new LineItem(Type.REMOVED, line1));
                                lines.add(new LineItem(Type.SAME, file1.readLine()));
                                line2 = nLine;
                            }
                        }
                    }
                } else
                    lines.add(new LineItem(Type.REMOVED, line1));

            }

        }
        if (file2.ready()){
            lines.add(new LineItem(Type.ADDED, file2.readLine()));
        }
        if (line2 != null)
            lines.add(new LineItem(Type.ADDED, line2));
        file1.close();
        file2.close();
//        for (LineItem line : lines) {
//            System.out.println(line);
//        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
//        @Override
//        public String toString() {
//            return line + " " + type;
//        }
    }


}
