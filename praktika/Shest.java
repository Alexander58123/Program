package com.javarush.task.praktika;

public class Shest {

    private static String HEX = "0123456789abcdef";

    // из десятичной в шестнадцатиричное число
    public static String toHex(int decimalNumber) {

        // условие возврата пустой строки, если пользователь ввел 0
        if (decimalNumber <= 0) {
            return "";
        }


        String shestChislo = ""; // итоговое
        StringBuilder index = new StringBuilder(HEX);
        String ostatok = "";


        while (decimalNumber != 0) {

            switch (decimalNumber % 16) {
                case 0:
                    ostatok = index.substring(0, 1); // Возвращает подстроку, заданную интервалом
                    break;
                case 1:
                    ostatok = index.substring(1, 2);
                    break;
                case 2:
                    ostatok = index.substring(2, 3);
                    break;
                case 3:
                    ostatok = index.substring(3, 4);
                    break;
                case 4:
                    ostatok = index.substring(4, 5);
                    break;
                case 5:
                    ostatok = index.substring(5, 6);
                    break;
                case 6:
                    ostatok = index.substring(6, 7);
                    break;
                case 7:
                    ostatok = index.substring(7, 8);
                    break;
                case 8:
                    ostatok = index.substring(8, 9);
                    break;
                case 9:
                    ostatok = index.substring(9, 10);
                    break;
                case 10:
                    ostatok = index.substring(10, 11); // Возвращает подстроку, заданную интервалом
                    ostatok = ostatok.toUpperCase();    // буквы в верхний регистр делаем
                    break;
                case 11:
                    ostatok = index.substring(11, 12);
                    ostatok = ostatok.toUpperCase();
                    break;
                case 12:
                    ostatok = index.substring(12, 13);
                    ostatok = ostatok.toUpperCase();
                    break;
                case 13:
                    ostatok = index.substring(13, 14);
                    ostatok = ostatok.toUpperCase();
                    break;
                case 14:
                    ostatok = index.substring(14, 15);
                    ostatok = ostatok.toUpperCase();
                    break;
                case 15:
                    ostatok = index.substring(15, 16);
                    ostatok = ostatok.toUpperCase();
                    break;
                default:
                    System.out.println("Ошибка в программе");
            }


            shestChislo = ostatok + shestChislo;
            decimalNumber = decimalNumber / 16;

        }

        return  shestChislo;

    }


    // из шестнадцатиричного в десятичное
    public static long toDecimal(String hexNumber) {

        // условие возврата 0
        if ((hexNumber == "") | (hexNumber == null)) {
            return 0;
        }

        long desChislo = 0;
        String indexHEX = "";
        StringBuilder index = new StringBuilder(HEX); // для индекса с HEX строкой, где все значения
        StringBuilder indexShestnad = new StringBuilder(hexNumber); // для индекса входящего числа

        for (int i = 0, j =1; i < hexNumber.length(); i++, j++) {

            switch (indexShestnad.substring(i, j)) { // если символ из входящей строки с индексом i равен
                case "0":
                    indexHEX = index.substring(0, 1);
                    break;
                case "1":
                    indexHEX = index.substring(1, 2);
                    break;
                case "2":
                    indexHEX = index.substring(2, 3);
                    break;
                case "3":
                    indexHEX = index.substring(3, 4);
                    break;
                case "4":
                    indexHEX = index.substring(4, 5);
                    break;
                case "5":
                    indexHEX = index.substring(5, 6);
                    break;
                case "6":
                    indexHEX = index.substring(6, 7);
                    break;
                case "7":
                    indexHEX = index.substring(7, 8);
                    break;
                case "8":
                    indexHEX = index.substring(8, 9);
                    break;
                case "9":
                    indexHEX = index.substring(9, 10);
                    break;
                case "10":
                    indexHEX = index.substring(10, 11);
                    break;
                case ("a"):
                    indexHEX = index.substring(1, 2) + index.substring(0, 1);
                    break;
                case "b":
                    indexHEX = index.substring(1, 2) + index.substring(1, 2);
                    break;
                case "c":
                    indexHEX = index.substring(1, 2) + index.substring(2, 3);
                    break;
                case "d":
                    indexHEX = index.substring(1, 2) + index.substring(3, 4);
                    break;
                case "e":
                    indexHEX = index.substring(1, 2) + index.substring(4, 5);
                    break;
                case "f":
                    indexHEX = index.substring(1, 2) + index.substring(5, 6);
                    break;
                default:
                    System.out.println("Ошибка в программе");


            }

            desChislo = 16 * desChislo + Integer.valueOf(indexHEX);

        }

        return desChislo;

    }

}
