package org.example.lesson5.telephone;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Ivanov", "123456");
        phoneBook.add("Petrov", "654321");
        phoneBook.add("Ivanov", "789012");

        System.out.println("Ivanov's phone numbers: " + phoneBook.get("Ivanov"));
        System.out.println("Petrov's phone numbers: " + phoneBook.get("Petrov"));
        System.out.println("Sidorov's phone numbers: " + phoneBook.get("Sidorov"));
    }
}