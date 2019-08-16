package coursera;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    // positional pointers to virtual top and bottom of UF data structure
    private final int vTop, vBottom;

    // a union-find data structure for maintaining connections in system
    private final WeightedQuickUnionUF uf;

    // a 2D array for managing system state (open/closed)
    private boolean[][] grid;

    public Percolation(int N) {
        if (N <= 0)
            throw new IllegalArgumentException("Invalid argument: non-positive N");
        this.uf = new WeightedQuickUnionUF(N*N+2);
        this.grid = new boolean[N][N];
        this.vBottom = N*N+1;
        this.vTop = 0;

        // Connect the bottom and top rows to their virtual links
        if (N > 1) {
            for (int k = 1; k <= N; k++) {
                this.uf.union(xyTo1D(N, k), vBottom);
                this.uf.union(xyTo1D(1, k), vTop);
            }
        }
    }

    public void open(int i, int j) {
        grid[i-1][j-1] = true;

        if (grid.length == 1) {
            this.uf.union(xyTo1D(i, j), vBottom);
            this.uf.union(xyTo1D(i, j), vTop);
        }

        int p = xyTo1D(i, j);
        unionNeighbor(p, i-1, j);  // above
        unionNeighbor(p, i, j-1);  // left
        unionNeighbor(p, i, j+1);  // right
        unionNeighbor(p, i+1, j);  // below
    }

    public boolean isOpen(int i, int j) { return grid[i-1][j-1]; }

    public int numberOfOpenSites(){
        int numberOfOpenSites = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]){
                    numberOfOpenSites++;
                }
            }
        }
        return numberOfOpenSites;
    }

    public boolean isFull(int i, int j) {
        return isOpen(i, j) && uf.connected(vTop, xyTo1D(i, j));
    }

    public boolean percolates() { return uf.connected(vTop, vBottom); }

    private int xyTo1D(int i, int j) {
        int N = grid.length;
        if (!valid(i))
            throw new IndexOutOfBoundsException("row index i out of bounds");
        if (!valid(j))
            throw new IndexOutOfBoundsException("column index j out of bounds");
        return (i-1) * N + j;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);      // input file
        int N = in.readInt();         // N-by-N percolation system

        Percolation perc = new Percolation(N);

        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            StdOut.println(i + " " + j);
        }
    }

    /**
     * Validates the index is in range
     *
     * @param i  index to be validated
     * @return true if index between 1 and N, the size of one side of the system
     */
    private boolean valid(int i) {
        int N = grid.length;
        return (i > 0 && i <= N);
    }

    private void unionNeighbor(int p, int i, int j) {
        if (!valid(i) || !valid(j)) return;

        if (isOpen(i, j))
            uf.union(p, xyTo1D(i, j));
    }
}