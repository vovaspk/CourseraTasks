package com.coursera.sportprogramming;

public class NumbersFragmentation {
    private static int[] a;
    private static int n = 35;

    public static void main(String[] args) {
        a = new int[35];
        rec(0, 0, 1);
    }

    private static void rec(int idx, int sum, int last) {
        if (sum == n) {
            out(idx);
            return;
        }

        for (int i = last; i <= n - sum; i++) {

            a[idx] = i;
            rec(idx + 1, sum + i, i);

        }

    }
    private static int count = 1;
    private static void out(int idx) {
        for (int i = 0; i <idx; i++) {
            System.out.print(a[i] + " + ");
        }
        System.out.println(" count: " + count++);
        System.out.println();
    }
}
