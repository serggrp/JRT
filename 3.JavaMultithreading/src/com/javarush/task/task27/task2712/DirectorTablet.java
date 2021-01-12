package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DirectorTablet {
    public void printAdvertisementProfit(){
        Map<Date, Double> result = StatisticManager.getInstance().getAdvAmountPerDay();
        double total = 0;
        for (Map.Entry<Date, Double> entry : result.entrySet()) {
            ConsoleHelper.writeMessage(String.format("%1$te-%1$tb-%1$tY - %2$.2f", entry.getKey(), entry.getValue()));
            total += entry.getValue();
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", total));
    }
    public void printCookWorkloading(){
        Map<Date, Map<String, Integer>> map = StatisticManager.getInstance().getCookLoad();
        for (Map.Entry entry : map.entrySet()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            String date = simpleDateFormat.format(entry.getKey());
            ConsoleHelper.writeMessage(date);
            Map<String, Integer> map1 = (Map) entry.getValue();

            for (Map.Entry entry1 : map1.entrySet()) {
                ConsoleHelper.writeMessage(entry1.getKey() + " - " + entry1.getValue() + " min");
            }
        }
    }
    public void printActiveVideoSet(){}
    public void printArchivedVideoSet(){}
}
