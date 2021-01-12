package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> result = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Enter dish's name.");
        String line = readString();
        while (!line.toLowerCase().equals("exit")){
            try{
                writeMessage(Dish.allDishesToString());
                writeMessage("Enter dish's name.");
                Dish dish = Dish.valueOf(line);
                result.add(dish);
            }
            catch (IllegalArgumentException e){
                writeMessage("There are no such dish in menu. Please, choose another...");
            }
            line = readString();
        }
        return result;
    }
}
