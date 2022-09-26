package com.javarush.task.praktika;

public class Dva {

    // метод из десятичной в двоичную систему счисления, возвращает строковое представление
    // т.к. длинные числа получаются
    public static String toBinary(int decimalNumber) {
        String Predstavlenie = "";

        if (decimalNumber <= 0) {
            return Predstavlenie;
        }

        while (decimalNumber != 0) { // пока не дойдет до 0 в числе, который передается для конвертир.

            Predstavlenie = (decimalNumber % 2) + Predstavlenie;
            decimalNumber = decimalNumber / 2; // Делим на 2 для следующего цикла

        }
        return Predstavlenie;
    }


    // метод из двоичной в десятичную систему
    public static int toDecimal(String binaryNumber) {

        // условие при пустой и null строке возвращаем 0
        if ((binaryNumber == "") | (binaryNumber == null)) {
            return 0;
        }

        String[] tekuchee = binaryNumber.split("\\B");

        int desChislo = 0;
        for (int i = tekuchee.length-1, j = 0; i >= 0; i--, j++) {
            //  desChislo = desChislo + Integer.parseInt(tekuchee[i]) * (int) Math.pow(2, j);
            desChislo = desChislo + Integer.valueOf((tekuchee[i])) * (int) Math.pow(2, j);

        }
        return desChislo;
    }
}
