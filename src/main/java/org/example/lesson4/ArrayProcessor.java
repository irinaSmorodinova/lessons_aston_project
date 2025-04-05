package org.example.lesson4;

import org.example.lesson4.exception.MyArrayDataException;
import org.example.lesson4.exception.MyArraySizeException;

public class ArrayProcessor {
    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4");
        }

        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4x4");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]: не удалось преобразовать '" + array[i][j] + "' в число");
                }
            }
        }

        return sum;
    }
}