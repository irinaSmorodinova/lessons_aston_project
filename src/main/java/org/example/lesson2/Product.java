package org.example.lesson2;

import java.time.LocalDate;

public class Product {
    private final String name;
    private final LocalDate productionDate;
    private final String manufacturer;
    private final String countryOfOrigin;
    private final double price;
    private final boolean isReserved;

    public Product(String name, LocalDate productionDate, String manufacturer, String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования: " + (isReserved ? "Забронирован" : "Не забронирован"));
    }

    public static void main(String[] args) {
        Product[] array = new Product[5];

        array[0] = new Product("Товар1", LocalDate.of(2023, 1, 1), "Производитель1", "Страна1", 100.0, false);
        array[1] = new Product("Товар2", LocalDate.of(2023, 2, 1), "Производитель2", "Страна2", 200.0, true);
        array[2] = new Product("Товар3", LocalDate.of(2023, 3, 1), "Производитель3", "Страна3", 300.0, false);
        array[3] = new Product("Товар4", LocalDate.of(2023, 4, 1), "Производитель4", "Страна4", 400.0, true);
        array[4] = new Product("Товар5", LocalDate.of(2023, 5, 1), "Производитель5", "Страна5", 500.0, false);

        for (Product product : array) {
            product.printInfo();
            System.out.println();
        }
    }
}