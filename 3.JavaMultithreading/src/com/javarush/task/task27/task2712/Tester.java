package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) throws IOException {
        System.out.println(Dish.allDishesToString());
        System.out.println(Dish.valueOf("Steak"));
        Tablet tablet = new Tablet(1);
        List<Dish> list = new ArrayList<>();
        list.add(Dish.Juice);
        list.add(Dish.Steak);
        System.out.println(list);
        System.out.println(tablet);
        Order emptyOrder = new Order(tablet);
    }
}
