package com.coursera.algorithms;

public class QuickUnionUF {
    private int[] id;
    private int[] sz;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int find(int i){
        int max = 0;
        for (int j = 0; j < id.length; j++) {
            if(connected(id[j], i)){
                return i;
            }
        }
        return i;
    }

    private int root(int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public void improvedUnion(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i==j){
            return;
        }
        if(sz[i] < sz[j]){
            id[i] = i;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
