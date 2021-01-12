package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name="shop")
@XmlRootElement
public class Shop {
    public Goods goods;
    @XmlElement(name="count")
    public int count;
    @XmlElement(name="profit")
    public double profit;
    @XmlElement(name="secretData")
    public String[] secretData;

    @XmlType(name="goods")
    public static class Goods{
        @XmlElement(name = "names")
        public List<String> names;
    }
}
