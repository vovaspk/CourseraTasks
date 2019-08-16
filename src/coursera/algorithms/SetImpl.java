package com.coursera.algorithms;

import java.util.Set;

public class SetImpl {
    private Set<Integer> set;

    public SetImpl(int N) {
        for (int i = 0; i < N; i++) {
            set.add(i);
        }
    }

    public boolean add(int p){
        return set.add(p);
    }

    public boolean remove(int p){
        return set.remove(p);
    }

    public boolean findX(int x){
        return set.contains(x);
    }
}
