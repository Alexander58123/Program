package com.javarush.task.praktika;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {

    static int GlobInput = 0;
    static int GlobOutput = 0;
    static long GlobOutputLong = 0;
    static String GlobStringOutput = "";
    static String GlobStringInput = "";
    static int PunktMenu = 0;
    static boolean uslovie = true;



    public static void main(String[] args) throws InputMismatchException {

        // Основное меню do-while
        do {

            // каждый раз создаем потоки ввода заново, т.к сбрасываем их в конце do-while цикла
            Scanner keyboard = new Scanner(System.in);
            Scanner menu = new Scanner(System.in);

            System.out.println("Нажмите цифру (порядковый номер), чтобы выполнить операцию");
            System.out.println("1 - Из десятичной в восьмеричную");
            System.out.println("2 - Из восьмеричной в десятичную");
            System.out.println("3 - Из десятичной в двоичную");
            System.out.println("4 - Из двоичной в десятичную");
            System.out.println("5 - Из десятичной в шестнадцатиричную");
            System.out.println("6 - Из шестнадцатиричной в десятичную");
            System.out.println("7 - Из двоичной в шестнадцатиричную");
            System.out.println("8 - Из шестнадцатиричной в двоичную");
            System.out.println("Для выхода нажмите 0");
            System.out.println("------");

            // обработка ошибок и ввод числа для меню
            while (uslovie) {
                try {
                    menu = new Scanner(System.in);
                    PunktMenu = menu.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка!!! Введите цифру для выбора пункта");
                }
            }



                if (PunktMenu == 1) {
                    System.out.println("Конвертируем (из десятичной в восьмеричную)");
                    System.out.println("Напишите цифру для конвертации");


                    if (keyboard.hasNextInt()) { // проверка ввода типа
                        GlobInput = keyboard.nextInt();
                        GlobOutput = Vosem.toOctal(GlobInput);
                        System.out.println("Десятичное " + GlobInput + " -> " + "Восьмеричное " + GlobOutput);
                        System.out.println("-------------\n");
                    } else {
                        System.out.println("Ошибка! Введите целое число\n");
                    }


                } else if (PunktMenu == 2) {
                    System.out.println("Конвертируем (из восьмеричной в десятичную)");
                    System.out.println("Напишите цифру для конвертации");

                    if (keyboard.hasNextInt()) {
                        GlobInput = keyboard.nextInt();
                        GlobOutput = Vosem.toDecimal(GlobInput);
                        System.out.println("Восьмеричное " + GlobInput + " -> " + "Десятичное " + GlobOutput);
                        System.out.println("-------------\n");
                    } else {
                        System.out.println("Ошибка! Введите целое число\n");
                    }


                } else if (PunktMenu == 3) {
                    System.out.println("Конвертируем (из десятичной в двоичную)");
                    System.out.println("Напишите цифру для конвертации");

                    if (keyboard.hasNextInt()) {
                        GlobInput = keyboard.nextInt();
                        GlobStringOutput = Dva.toBinary(GlobInput);
                        System.out.println("Десятичное " + GlobInput + " -> " + "Двоичное " + GlobStringOutput);
                        System.out.println("-------------\n");
                    } else {
                        System.out.println("Ошибка! Введите целое число\n");
                    }

                } else if (PunktMenu == 4) {
                    System.out.println("Конвертируем (из двоичной в десятичную)");
                    System.out.println("Напишите цифру для конвертации");

                    if (keyboard.hasNextLine())                         // если ввели строку
                        GlobStringInput = keyboard.nextLine();

                        if (GlobStringInput.matches("[0-1]+")) {   // если числа только 0 и 1 - регулярное выражение
                            GlobOutput = (Dva.toDecimal(GlobStringInput));
                            System.out.println("Двоичное " + GlobStringInput + " -> " + "Десятичное " + GlobOutput);
                            System.out.println("-------------\n");
                        } else {
                        System.out.println("Ошибка! Введите число в двоичном формате\n");
                    }

                } else if (PunktMenu == 5) {
                    System.out.println("Конвертируем (из десятичной в шестнадцатиричную)");
                    System.out.println("Напишите цифру для конвертации");

                    if (keyboard.hasNextInt()) {
                        GlobInput = keyboard.nextInt();
                        GlobStringOutput = Shest.toHex(GlobInput);
                        System.out.println("Десятичное " + GlobInput + " -> " + "Шестнадцатиричное " + GlobStringOutput);
                        System.out.println("-------------\n");
                    } else {
                        System.out.println("Ошибка! Введите целое число\n");
                    }


                } else if (PunktMenu == 6) {
                    System.out.println("Конвертируем (из шестандцатиричной в десятичную)");
                    System.out.println("Напишите цифру для конвертации");

                    if (keyboard.hasNext()) {
                        GlobStringInput = keyboard.next();

                        if (GlobStringInput.matches("[a-fA-F0-9]+")) { // цифры и включающие буквы
                            GlobOutputLong = Shest.toDecimal(GlobStringInput);
                            System.out.println("Шестнадцатиричное " + GlobStringInput + " -> " + "Десятичное " + GlobOutputLong);
                            System.out.println("-------------\n");
                        } else {
                            System.out.println("Ошибка! Введите число в шестандцатиричном формате\n");
                        }

                    }


                } else if (PunktMenu == 7) {
                    System.out.println("Конвертируем (из двоичной в шестандцатиричную)");
                    System.out.println("Напишите цифру для конвертации");

                    if (keyboard.hasNextLine()) {
                        GlobStringInput = keyboard.nextLine();

                        if (GlobStringInput.matches("[0-1]+")) {
                            GlobStringOutput = DvoichShestnad.toHex(GlobStringInput);
                            System.out.println("Двоичное " + GlobStringInput + " -> " + "Шестандцатиричное " + GlobStringOutput);
                            System.out.println("-------------\n");
                        } else {
                            System.out.println("Ошибка! Введите число в двоичном формате\n");
                        }
                    }

                } else if (PunktMenu == 8) {
                    System.out.println("Конвертируем (из шестнадцатиричной в двоичную)");
                    System.out.println("Напишите цифру для конвертации");

                    if (keyboard.hasNextLine()) {
                        GlobStringInput = keyboard.nextLine();

                        if (GlobStringInput.matches("[a-fA-F0-9]+")) {
                            GlobStringOutput = DvoichShestnad.toBinary(GlobStringInput);
                            System.out.println("Шестнадцатиричное " + GlobStringInput + " -> " + "Двоичное " + GlobStringOutput);
                            System.out.println("-------------\n");
                        } else {
                            System.out.println("Ошибка! Введите число в шестандцатиричном формате\n");
                        }

                    }

                }

        // сбрасываем поток, чтобы снова в цикле while использовать чистый
        keyboard.reset();
        menu.reset();


        } while (PunktMenu != 0);
        // выход из основного меню

    }
}
