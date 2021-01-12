package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.HashSet;

public class Tester {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        AmigoSet<String> as = new AmigoSet<>();
        as.add("Number 1");
        as.add("Number 2");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(baos);
        os.writeObject(as);
        baos.flush();
        os.flush();
        os.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        AmigoSet<String> asD = (AmigoSet<String>) ois.readObject();
        for (String s : asD) {
            System.out.println(s);
        }


    }
}
