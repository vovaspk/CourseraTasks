package com.coursera;

import com.coursera.algorithms.QuickUnionUF;

public class Main {
    public static void main(String[] args) {
        QuickUnionUF quickUnionUF= new QuickUnionUF(10);
        quickUnionUF.union(2,3);
        System.out.println(quickUnionUF.connected(2,3));
    }
}
