package com.javarush.task.kursovaya;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
Курсовая работа СГА 2022 г.
Лукьянов Александр Сергеевич
 */


public class Glavnaya {

    public static void main(String[] args) throws FileNotFoundException {

        String separator = File.separator; // разделитель для разных ОС
        String path = "C:" + separator + "Kursovaya" + separator + "f1.txt";
        String path2 = "C:" + separator + "Kursovaya" + separator + "f2.txt";
        String path3 = "C:" + separator + "Kursovaya" + separator + "f3.txt";


        File f1 = new File(path); // создали объект файла с конкретным путем для f1
        File f2 = new File(path2); // создали объект файла с конкретным путем для f2

        Scanner fileF1 = new Scanner(f1); // в поток сканера отдаем наш объект f1 для чтения
        Scanner fileF2 = new Scanner(f2); // в поток сканера отдаем наш объект f2 для чтения


        // file1 исходный
        String strokaF1 = fileF1.nextLine(); // считываем из файла
        String[] word = strokaF1.split("\\b");
        for (int i = 0; i < word.length; i++) {

            System.out.println(word[i]);
        }

        System.out.println("------------------");


        // file2 синономимы
        String strokaF2 = fileF2.nextLine();
        String[] sinonimu = strokaF2.split(", ");

        // переводим в двумерный для удобства работы
        String[][] sinonimuMassive = new String[2][sinonimu.length / 2];

        int i = 0, j = 0, k = 0;
        while (i < sinonimu.length) {
            if (i % 2 == 0) {// четное
                sinonimuMassive[0][j] = sinonimu[i];
                j++;
            } else { // нечетное
                sinonimuMassive[1][k] = sinonimu[i];
                k++;
            }
            i++;
        }

        System.out.println(Arrays.deepToString(sinonimuMassive));


        System.out.println("------------------");


        // здесь сравнение и замена пошла
        for (int l = 0; l < word.length; l++) {
            for (int m = 0; m < sinonimuMassive[0].length; m++) {

                if (word[l].equals(sinonimuMassive[0][m])) { // если истина, то
                    word[l] = sinonimuMassive[1][m];
                }
                // else return;
            }
        }

        String itog = "";
        for (int l = 0; l < word.length; l++) {
            itog = itog + word[l];
        }

        System.out.println(itog);

        // запись в f3 файл
        PrintWriter pw = null;
        try {
            File fileF3 = new File(path3);
            pw = new PrintWriter(fileF3);
            pw.println(itog);
        } catch (Exception exception) {
            exception.getMessage();
        } finally {
            fileF1.close();
            fileF2.close();
            pw.close();
        }



    }

}
