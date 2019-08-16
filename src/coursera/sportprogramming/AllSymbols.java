package com.coursera.sportprogramming;

public class AllSymbols {

    private static void printAllSymbols() {
        for (char c1 = 'a'; c1 <= 'c'; c1++) {
            for (char c2 = 'a'; c2 <= 'c'; c2++) {
                for (char c3 = 'a'; c3 <= 'c'; c3++) {
                    System.out.print(c1 + "" + c2 + "" + c3);
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        printAllSymbols();
    }


}
