package org.example.lesson3.geometry;

public interface Colored {
    String getFillColor();

    String getBorderColor();

    default void printColors() {
        System.out.println("Fill Color: " + getFillColor());
        System.out.println("Border Color: " + getBorderColor());
    }
}