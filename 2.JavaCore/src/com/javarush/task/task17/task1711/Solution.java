package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        try {
            switch (args[0]){
                case "-c" : synchronized (allPeople){
                    for (int i = 1; i < args.length; i+=3) {
                        if (args[i+1].equals("м")) {
                            allPeople.add(Person.createMale(args[i], sdf.parse(args[i+2])));
                        }
                        else {
                            allPeople.add(Person.createFemale(args[i], sdf.parse(args[i+2])));
                        }
                        System.out.println(allPeople.size()-1);
                    }
                    break;
                }
                case "-u" : synchronized (allPeople){
                    for (int i = 1; i < args.length; i+=4) {
                        Person p = allPeople.get(Integer.parseInt(args[i]));
                        p.setName(args[i+1]);
                        p.setSex(args[i+2].equals("м") ? Sex.MALE : Sex.FEMALE);
                        p.setBirthDate(sdf.parse(args[i+3]));
                    }
                    break;
                }
                case "-d" : synchronized (allPeople){
                    for (int i = 1; i < args.length; i++) {
                        Person p = allPeople.get(Integer.parseInt(args[i]));
                        p.setName(null);
                        p.setSex(null);
                        p.setBirthDate(null);
                    }
                    break;
                }
                case "-i" : synchronized (allPeople){
                    for (int i = 1; i < args.length; i++) {
                        Person p = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(p.getName() + (p.getSex() == Sex.MALE ? " м " : " ж ") + sdf1.format(p.getBirthDate()));
                    }
                    break;
                }

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
