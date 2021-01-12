package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();
    private StatisticManager(){
    }
    public static StatisticManager getInstance(){
        if (instance == null)
            instance = new StatisticManager();
        return instance;
    }
    public void register(EventDataRow data){
        statisticStorage.put(data);
    }
    public void register(Cook cook){
        cooks.add(cook);
    }

    public Map<Date, Double> getAdvAmountPerDay(){
        Map<Date, Double> result = new TreeMap<>(Collections.reverseOrder());
        List<EventDataRow> eventDataRowList = statisticStorage.get(EventType.SELECTED_VIDEOS);
        double amount;
        Date date;
        Calendar calendar;
        for (EventDataRow eventDataRow : eventDataRowList) {
            VideoSelectedEventDataRow adVideo = (VideoSelectedEventDataRow) eventDataRow;
            amount = adVideo.getAmount()/100.0;
            calendar = Calendar.getInstance();
            calendar.setTime(adVideo.getDate());
            GregorianCalendar gc = new GregorianCalendar(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            date = gc.getTime();
            if (result.containsKey(date))
                amount += result.get(date);
            result.put(date, amount);
        }
        return result;
    }

    public Map<Date, Map<String, Integer>> getCookLoad(){
        Map<Date, Map<String, Integer>> result = new TreeMap<>();
        List<EventDataRow> eventDataRowList = statisticStorage.get(EventType.COOKED_ORDER);
        for (EventDataRow dataRow : eventDataRowList) {
            CookedOrderEventDataRow orderEvent = (CookedOrderEventDataRow) dataRow;
            String name = orderEvent.getCookName();
            if (result.containsKey(dataRow.getDate())){
                Map<String, Integer> daylyLoadMap = result.get(dataRow.getDate());
                if (daylyLoadMap.containsKey(name)){
                    daylyLoadMap.put(name, daylyLoadMap.get(name) + orderEvent.getCookingTimeSeconds());
                }
                else
                    daylyLoadMap.put(name, orderEvent.getCookingTimeSeconds());
                result.put(dataRow.getDate(), daylyLoadMap);
            }
            else{
                Map<String, Integer> daylyLoadMap = new TreeMap<>();
                daylyLoadMap.put(name, orderEvent.getCookingTimeSeconds());
                result.put(dataRow.getDate(), daylyLoadMap);
            }

        }

        return result;

    }
    private class StatisticStorage{
        public Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
            for (EventType value : EventType.values()) {
                storage.put(value, new ArrayList<EventDataRow>());
            }
        }
        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> get(EventType type){
            return storage.get(type);
        }
    }
}
