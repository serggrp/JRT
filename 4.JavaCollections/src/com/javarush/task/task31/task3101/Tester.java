package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Tester {
    public static void main(String[] args) throws IOException {
//        String startPath = "C:\\workflow\\jLearn\\test\\files\\1";
//        File rootDir = new File(startPath);
//        if (!rootDir.exists()) {
//            if (rootDir.mkdir())
//                System.out.println("Folder created successfully");
//            else
//                System.out.println("Folder WAS NOT created successfully");
//        }
//        else {
//            if (rootDir.delete())
//                System.out.println("Folder deleted successfully");
//            else {
//                System.out.println("Folder WAS NOT deleted successfully");
//            }
//            System.exit(0);
//        }
//        for (int i = 1; i < 6; i++) {
//            Random rand = new Random();
//            int size = rand.nextInt(90) + 10;
//            File randFile=  File.createTempFile("arand_"+i, ".txt", rootDir);
//            try(FileOutputStream fos = new FileOutputStream(randFile)){
//                byte[] buf = new byte[size];
//                for (int j = 0; j < buf.length; j++) {
//                    buf[j] = 'A';
//                }
//                fos.write(buf);
//            }
//        }
        Solution.main(new String[]{"C:\\workflow\\jLearn\\test\\files", "C:\\workflow\\jLearn\\test\\3101.txt"});
    }
}
