package org.example;

import java.util.Arrays;

public class Lesson1 {

    public void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public void checkSumSign() {
        int a = 5;
        int b = -3;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public void printColor() {
        int value = 50;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public void compareNumbers() {
        int a = 7;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public void printPositiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public boolean isNegative(int number) {
        return number < 0;
    }

    public void printStringMultipleTimes(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    public boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
    }

    public int[] fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public void modifyArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    public int[][] fillDiagonals(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
            array[i][size - i - 1] = 1;
        }
        return array;
    }

    public int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    public static void main(String[] args) {
        Lesson1 lesson = new Lesson1();

        // Примеры вызова методов
        lesson.printThreeWords();
        lesson.checkSumSign();
        lesson.printColor();
        lesson.compareNumbers();
        System.out.println(lesson.isSumInRange(10, 5));
        lesson.printPositiveOrNegative(-5);
        System.out.println(lesson.isNegative(-5));
        lesson.printStringMultipleTimes("Hello", 3);
        System.out.println(lesson.isLeapYear(2020));

        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        lesson.invertArray(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] filledArray = lesson.fillArray();
        for (int i : filledArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] modifyArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        lesson.modifyArray(modifyArray);
        for (int i : modifyArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[][] diagonalsArray = lesson.fillDiagonals(5);
        for (int[] row : diagonalsArray) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }

        int[] customArray = lesson.createArray(5, 7);
        for (int i : customArray) {
            System.out.print(i + " ");
        }
    }
}