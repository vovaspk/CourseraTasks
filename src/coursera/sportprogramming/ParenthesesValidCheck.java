package com.coursera.sportprogramming;

public class ParenthesesValidCheck {
    private static char[] s;
    private static int n;

    public static void main(String[] args) {
        System.out.println(correct("((())())))"));
        rec(0, 0);
    }

    private static void rec(int idx, int bal) {
        if(idx == 2 * n){
            if(bal ==0){
                out();
                return;
            }
        }
        s[idx] = '(';
        rec(idx + 1, bal + 1);
        if (bal == 0) {
            return;
        }
        s[idx] = ')';
        rec(idx + 1, bal - 1);
    }

    private static void out(){
        for (int i = 0; i < n; i++)
        {
            if (i != 0){
                System.out.print(" ");
            }

            System.out.print(s[i]);
        }
        System.out.println();
    }

    private static boolean correct(String s) {
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
            }
            if (bal < 0) {
                return false;
            }
        }
        return (bal == 0);
    }
}
