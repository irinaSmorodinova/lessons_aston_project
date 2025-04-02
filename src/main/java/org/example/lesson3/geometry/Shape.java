package org.example.lesson3.geometry;

public interface Shape {
    double getPerimeter();

    double getArea();

    default void printCharacteristics() {
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Area: " + getArea());
    }
}