package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        //start here - начни тут

        try {
            if (args.length > 0)
                switch (args[0]){
                    case "-c" : {
                        if (args[2].equals("м"))
                            allPeople.add(Person.createMale(args[1], sdf.parse(args[3])));
                        else
                            allPeople.add(Person.createFemale(args[1], sdf.parse(args[3])));
                        System.out.println(allPeople.size()-1);
                        break;
                    }
                    case "-u" : {
                        Person p = allPeople.get(Integer.parseInt(args[1]));
                        p.setName(args[2]);
                        p.setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
                        p.setBirthDate(sdf.parse(args[4]));
                        break;
                    }
                    case "-d" : {
                        Person p = allPeople.get(Integer.parseInt(args[1]));
                        p.setName(null);
                        p.setSex(null);
                        p.setBirthDate(null);
                        break;
                    }
                    case "-i" : {
                        Person p = allPeople.get(Integer.parseInt(args[1]));
                        System.out.println(p.getName() + " " + (p.getSex() == Sex.MALE ? "м " : "ж ") + sdf1.format(p.getBirthDate()));
                    }
                }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
