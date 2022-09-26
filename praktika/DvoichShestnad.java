package com.javarush.task.praktika;

import java.util.regex.Pattern;

public class DvoichShestnad {

    // из двоичного перевести в шестнадцатиричный
    public static String toHex(String binaryNumber) {

        // условия возврата пустой строки
        if ((binaryNumber == "") | (binaryNumber == null)) {
            return "";
        }


        StringBuilder indexChisla = new StringBuilder(binaryNumber);
        StringBuilder polnuiVid = new StringBuilder(binaryNumber);
        Pattern pattern = Pattern.compile("[01]");
        boolean flag = false; // для проброса условия и дальнейшего выполнения
        String odinSimvol = "";
        int dobavNulei = 0;
        String shestChislo = "";



        for (int i = 0, j = 1; i < binaryNumber.length(); i++, j++) {
            odinSimvol = indexChisla.substring(i,j);

            // if (proverka.equals("0") || proverka.equals("1")) // это старое решение проверки

            if (odinSimvol.matches("[01]"))
                flag = true;
            else
                return "";
        }

        if (flag) { // если проверка пройдена, то выполняем перевод числа

            dobavNulei = binaryNumber.length() % 4; // находим сколько не хватает по остатку
            if (dobavNulei > 0) {
                dobavNulei = 4 - dobavNulei;
                for (int i = 0; i < dobavNulei; i++) {
                    polnuiVid.insert(0, "0");
                    binaryNumber = polnuiVid + "";
                }
            }

            int kolvoTetrad = binaryNumber.length() / 4;
            String[] tetraduChisla = new String[kolvoTetrad];

            tetraduChisla = binaryNumber.split("(?<=\\G.{"+4+"})");


            for (int i = 0; i < tetraduChisla.length; i++) {
                switch (tetraduChisla[i]) {
                    case "0000":
                        shestChislo = shestChislo + "0";
                        break;
                    case "0001":
                        shestChislo = shestChislo + "1";
                        break;
                    case "0010":
                        shestChislo = shestChislo + "2";
                        break;
                    case "0011":
                        shestChislo = shestChislo + "3";
                        break;
                    case "0100":
                        shestChislo = shestChislo + "4";
                        break;
                    case "0101":
                        shestChislo = shestChislo + "5";
                        break;
                    case "0110":
                        shestChislo = shestChislo + "6";
                        break;
                    case "0111":
                        shestChislo = shestChislo + "7";
                        break;
                    case "1000":
                        shestChislo = shestChislo + "8";
                        break;
                    case "1001":
                        shestChislo = shestChislo + "9";
                        break;
                    case "1010":
                        shestChislo = shestChislo + "a";
                        break;
                    case "1011":
                        shestChislo = shestChislo + "b";
                        break;
                    case "1100":
                        shestChislo = shestChislo + "c";
                        break;
                    case "1101":
                        shestChislo = shestChislo + "d";
                        break;
                    case "1110":
                        shestChislo = shestChislo + "e";
                        break;
                    case "1111":
                        shestChislo = shestChislo + "f";
                        break;
                }
            }
        } // end flag

        return shestChislo;

    }



    // из шестнадцатиричного в двоичный
    public static String toBinary(String hexNumber) {

        // условия возврата пустой строки
        if ((hexNumber == "") | (hexNumber == null)) {
            return "";
        }

        StringBuilder indexChisla = new StringBuilder(hexNumber);
        boolean flag = false;
        String[] masElementov = new String[hexNumber.length()];
        String odinSimvol = "";
        String dvoChislo = "";

        for (int i = 0, j = 1; i < indexChisla.length(); i++, j++) {
            odinSimvol = indexChisla.substring(i,j);

            if (odinSimvol.matches("[a-fA-F0-9]+"))
                flag = true;
            else
                return "";
        }

        if (flag) { // если проверка пройдена, то выполняем перевод числа
            masElementov = hexNumber.split("(?<=\\G.{"+1+"})");

            for (int i = 0; i < masElementov.length; i++) {
                if (masElementov[i].equals("0"))
                    dvoChislo = dvoChislo + "0000";
                else if (masElementov[i].equals("1"))
                    dvoChislo = dvoChislo + "0001";
                else if (masElementov[i].equals("2"))
                    dvoChislo = dvoChislo + "0010";
                else if (masElementov[i].equals("3"))
                    dvoChislo = dvoChislo + "0011";
                else if (masElementov[i].equals("4"))
                    dvoChislo = dvoChislo + "0100";
                else if (masElementov[i].equals("5"))
                    dvoChislo = dvoChislo + "0101";
                else if (masElementov[i].equals("6"))
                    dvoChislo = dvoChislo + "0110";
                else if (masElementov[i].equals("7"))
                    dvoChislo = dvoChislo + "0111";
                else if (masElementov[i].equals("8"))
                    dvoChislo = dvoChislo + "1000";
                else if (masElementov[i].equals("9"))
                    dvoChislo = dvoChislo + "1001";
                else if (masElementov[i].equalsIgnoreCase("a"))
                    dvoChislo = dvoChislo + "1010";
                else if (masElementov[i].equalsIgnoreCase("b"))
                    dvoChislo = dvoChislo + "1011";
                else if (masElementov[i].equalsIgnoreCase("c"))
                    dvoChislo = dvoChislo + "1100";
                else if (masElementov[i].equalsIgnoreCase("d"))
                    dvoChislo = dvoChislo + "1101";
                else if (masElementov[i].equalsIgnoreCase("e"))
                    dvoChislo = dvoChislo + "1110";
                else if (masElementov[i].equalsIgnoreCase("f"))
                    dvoChislo = dvoChislo + "1111";
            }
        }

        return dvoChislo;
    }

}
