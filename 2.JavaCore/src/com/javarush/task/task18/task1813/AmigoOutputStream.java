package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream fos;

    public AmigoOutputStream(String name) throws FileNotFoundException {
        super(name);
    }

    public AmigoOutputStream(String name, boolean append) throws FileNotFoundException {
        super(name, append);
    }

    public AmigoOutputStream(File file) throws FileNotFoundException {
        super(file);
    }

    public AmigoOutputStream(File file, boolean append) throws FileNotFoundException {
        super(file, append);
    }


    public AmigoOutputStream(FileDescriptor fdObj) {
        super(fdObj);
    }

    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException{
        super("null");
        this.fos = fos;
    }

    @Override
    public void write(byte[] b) throws IOException {
        fos.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fos.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        flush();
        write("JavaRush © All rights reserved.".getBytes());
        fos.close();
    }

    @Override
    public FileChannel getChannel() {
        return super.getChannel();
    }

    @Override
    public void flush() throws IOException {
        fos.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(int b) throws IOException {
        fos.write(b);
    }
}
