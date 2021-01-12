package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        Set<String> set = new HashSet<>(Arrays.asList("user", "loser", "coder", "proger"));
        //тут цикл по чтению ключей, пункт 1
        while (set.contains(key = reader.readLine()))
        {
            //создаем объект, пункт 2
            person = PersonFactory.getPerson(key);
            doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User)
            ((Person.User) person).live();
        if (person instanceof Person.Loser)
            ((Person.Loser) person).doNothing();
        if (person instanceof Person.Coder)
            ((Person.Coder) person).writeCode();
        if (person instanceof Person.Proger)
            ((Person.Proger) person).enjoy();
    }

    static class PersonFactory{
        public static Person getPerson(String key){
            Person res = null;
            switch (key){
                case "user": res = new Person.User(); break;
                case "loser": res = new Person.Loser(); break;
                case "coder": res = new Person.Coder(); break;
                case "proger": res = new Person.Proger(); break;
            }
            return res;
        }
    }
}
