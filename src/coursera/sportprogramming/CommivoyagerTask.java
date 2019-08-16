package com.coursera.sportprogramming;

import static java.lang.Math.min;

public class CommivoyagerTask {
    private static int[] p;
    private static boolean[] used;
    private static int[][] a;
    private static int n = 10;
    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        a = new int[][]{
                { 0, 41 ,67 ,0 ,78 ,5, 91, 4 ,18, 67},
                {41, 0 ,34, 69 ,58, 45 ,95 ,2 ,95 ,99},
                {67, 34 ,0, 24, 62, 81, 42, 53, 47, 35},
                {0 ,69 ,24, 0 ,64, 27 ,27, 92 ,26, 94},
                {78 ,58 ,62, 64, 0 ,61 ,36, 82 ,71, 3},
                {5, 45, 81, 27 ,61, 0 ,91 ,21 ,38 ,11},
                {91, 95, 42 ,27 ,36, 91 ,0 ,16, 69 ,22},
                {4 ,2 ,53 ,92 ,82 ,21, 16, 0 ,12, 33},
                {18, 95 ,47, 26, 71, 38, 69, 12, 0, 73},
                {67, 99, 35, 94, 3, 11, 22, 33, 73, 0}
        };
//        a = new int[][]{
//                {0, 1, 4, 6},
//                {1, 0, 5, 2},
//                {4, 5, 0, 3},
//                {6, 2, 3, 0}
//        };
        used = new boolean[n];
        p = new int[n];
        p[0] = 0;

        rec(1, 0);
        System.out.println(ans);
        out();
    }

    private static void rec(int idx, int len) {
        if (len >= ans) {
            return;
        }
        if (idx == n) {
            ans = min(ans, len + a[p[idx - 1]][0]);
        }

        for (int i = 1; i <= n - 1; i++) {
            if (used[i]) {
                continue;
            }
            p[idx] = i;
            used[i] = true;
            rec(idx + 1, len + a[p[idx - 1]][i]);
            used[i] = false;
        }
    }

    private static int count() {
        return 0;
    }

    private static void out() {
        for (int i = 1; i < n - 1; i++) {
           // if (i != 0) {
            //    System.out.println(" ");
          //  }
            System.out.print(p[i]);
        }
        System.out.println();
    }


}
