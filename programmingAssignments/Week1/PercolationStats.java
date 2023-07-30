package programmingAssignments.Week1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCECONST = 1.96;

    private double[] xi;
    private int n, trials;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();
        this.n = n;
        this.trials = trials;
        xi = new double[trials];
        for (int i = 1; i <= trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniformInt(n) + 1;
                int col = StdRandom.uniformInt(n) + 1;
                percolation.open(row, col);
            }
            xi[i - 1] = 1.0 * percolation.numberOfOpenSites() / (n * n);
        }

    }

    public double mean() {
        return StdStats.mean(xi);
    }

    public double stddev() {
        return StdStats.stddev(xi);
    }

    public double confidenceLo() {
        return mean() - ((CONFIDENCECONST * stddev()) / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean() + ((CONFIDENCECONST * stddev()) / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        StdOut.println("mean                    = " + percolationStats.mean());
        StdOut.println("stddev                  = " + percolationStats.stddev());
        StdOut.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi() + "]");
    }
}
