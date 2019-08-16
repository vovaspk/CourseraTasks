package com.coursera.sportprogramming;

public class ReShuffle {
    private static int[] a;
    private static boolean[] used;
    private static int n = 7;

    public static void main(String[] args) {
        a = new int[n];
        used = new boolean[n+1];
        rec(0);
    }

    private static void rec(int idx){
        if(idx == n){
            out();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(used[i]){
                continue;
            }
            a[idx] = i;
            used[i] = true;
            rec(idx + 1);
            used[i] = false;
        }
    }
    private static int count = 1;
    private static void out(){
        for (int i = 0; i < n; i++)
        {
            if (i != 0){
                System.out.print(" ");
            }

            System.out.print(a[i]);
        }
        System.out.println(" count: " + count++);
        System.out.println();
    }

}
