package org.example.lesson2;

import java.time.LocalTime;

public class Park {
    public static class Attraction {
        private final String name;
        private final LocalTime openingTime;
        private final LocalTime closingTime;
        private final double price;

        public Attraction(String name, LocalTime openingTime, LocalTime closingTime, double price) {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Название аттракциона: " + name);
            System.out.println("Время открытия: " + openingTime);
            System.out.println("Время закрытия: " + closingTime);
            System.out.println("Стоимость: " + price);
        }
    }

    public static void main(String[] args) {
        Attraction attraction1 = new Attraction("Аттракцион1", LocalTime.of(9, 0), LocalTime.of(18, 0), 50.0);
        Attraction attraction2 = new Attraction("Аттракцион2", LocalTime.of(10, 0), LocalTime.of(19, 0), 60.0);

        attraction1.printInfo();
        System.out.println();
        attraction2.printInfo();
    }
}