package com.javarush.task.task19.task1904;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            fileScanner.useDelimiter(System.lineSeparator());
            String[] arr = fileScanner.next().split(" ");
            Person p = null;
            try {
                p = new Person(arr[1], arr[2], arr[0], (new SimpleDateFormat("ddMMyyyy").parse(arr[3]+arr[4]+arr[5])));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return p;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
