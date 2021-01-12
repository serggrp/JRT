package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        StringBuilder result = new StringBuilder(Dish.values()[0].toString());
        for (int i = 1; i < Dish.values().length; i++) {
            result.append(", ").append(Dish.values()[i]);
        }
        return result.toString();
    }
}
