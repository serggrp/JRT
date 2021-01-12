package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(1);
        Cook cook = new Cook("Chief");
        tablet1.addObserver(cook);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        tablet1.createOrder();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
//        tablet1.createOrder();
//        tablet1.createOrder();
//        tablet1.createOrder();
    }
}
