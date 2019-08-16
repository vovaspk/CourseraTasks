package com.coursera.sportprogramming;

public class A {
   private static int n = 6, m = 5;
    private static int[] a;


    public static void main(String[] args) {
        a = new int[n];
        rec(0);
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
        System.out.println("count: " + count++);
        System.out.println();
    }

    private static void rec(int idx){
        if (idx == n) {
            out();
            return;
        }
        for (int i = 1; i <= m; i++) {
            a[idx] = i;
            rec(idx + 1);
        }

    }




}
