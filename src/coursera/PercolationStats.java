package coursera;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    // stores the mean proportion of open sites from this simulation
    private final double mu;

    // stores the standard deviation from this simulation
    private final double std;

    // stores the proportion of open sites for each run in the simulation
    private final double[] run;

    public PercolationStats(int N, int T) {
        if (N <= 0)
            throw new IllegalArgumentException("Invalid argument: non-positive N");
        if (T <= 0)
            throw new IllegalArgumentException("Invalid argument: non-positive T");

        this.run = new double[T];

        for (int i = 0; i < T; i++)
            this.run[i] = simulation(N);

        if (T == 1) {
            mu = this.run[0];
            std = Double.NaN;
        } else {
            mu = StdStats.mean(this.run);
            std = StdStats.stddev(this.run);
        }
    }

    public double mean() { return mu; }

    public double stddev() { return std; }

    public double confidenceLo() {
        return mu - ((1.96*std) / Math.sqrt(this.run.length));
    }

    public double confidenceHi() {
        return mu + ((1.96*std) / Math.sqrt(this.run.length));
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats s = new PercolationStats(N, T);
        StdOut.println("mean                    = " + s.mean());
        StdOut.println("stddev                  = " + s.stddev());
        StdOut.println("95% confidence interval = " + s.confidenceLo()
                + ", " + s.confidenceHi());
    }

    private double simulation(int N) {
        int i, j, count = 0;
        double p;

        Percolation perc = new Percolation(N);

        do {
            i = StdRandom.uniform(1, N+1);
            j = StdRandom.uniform(1, N+1);
            if (!perc.isOpen(i, j)) {
                perc.open(i, j);
                count++;
            }
        } while (!perc.percolates());

        p = count * 1.0 / (N*N);
        return p;
    }
}