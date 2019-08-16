package com.coursera.sportprogramming;

public class NumbersUtil {
    private static int n = 2, m = 3;
    private static int[] a;

    public static void main(String[] args) {
        a = new int[n];
        rec(0);
    }

    private static void rec(int idx) {
        if(idx == n){
            out();
            return;
        }

        for (int i = 1; i <= m; i++) {
            a[idx] = i;
            rec(idx + 1);
        }

    }

    private static void out(){
        for (int i = 0; i < n; i++)
        {
            if (i != 0){
                System.out.print(" ");
            }

            System.out.print(a[i]);
        }
        System.out.println();
    }
}
