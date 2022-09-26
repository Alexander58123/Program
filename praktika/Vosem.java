package com.javarush.task.praktika;

public class Vosem {

    // метод из десятичной в восьмеричную
    public static int toOctal(int decimalNumber) {
        if (decimalNumber <= 0) { // условие возврата нуля, когда ноль или отрицательное
            return 0;
        }

        int vosChislo = 0;
        int i = 0;
        while (decimalNumber != 0) {
            vosChislo = vosChislo + (decimalNumber % 8) * (int) Math.pow(10, i); // здесь остаток
            decimalNumber = decimalNumber / 8; // следующее значение десятичного
            i++;
        }
        return vosChislo;
    }

    // метод из восьмеричной в десятичную
    public static int toDecimal(int octalNumber) {
        if (octalNumber <= 0) {
            return 0;
        }

        int i = 0;
        int desChislo = 0;
        while (octalNumber != 0) {
            desChislo = desChislo + (octalNumber % 10) * (int) Math.pow(8, i);
            octalNumber = octalNumber / 10;
            i++;
        }
        return  desChislo;
    }

}
