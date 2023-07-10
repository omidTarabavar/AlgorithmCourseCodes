import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] table; //
    private int n;
    private int numOfOpenSites;
    private WeightedQuickUnionUF wquWithTopBot; //
    private WeightedQuickUnionUF wquWithTop; //
    private int top = 0, bottom;

    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        table = new boolean[n][n];
        this.n = n;
        numOfOpenSites = 0;
        wquWithTopBot = new WeightedQuickUnionUF((n * n) + 2); //
        wquWithTop = new WeightedQuickUnionUF((n * n) + 1); //
        bottom = (n * n) + 1;
    }

    public void open(int row, int col) {
        validate(row, col);
        if (!isOpen(row, col)) {
            table[row - 1][col - 1] = true;
            numOfOpenSites++;
            if (row - 1 > 0 && isOpen(row - 1, col)) {
                wquWithTopBot.union(findItemINWQU(row, col), findItemINWQU(row - 1, col));
                wquWithTop.union(findItemINWQU(row, col), findItemINWQU(row - 1, col));
            }
            if (row + 1 <= n && isOpen(row + 1, col)) {
                wquWithTopBot.union(findItemINWQU(row, col), findItemINWQU(row + 1, col));
                wquWithTop.union(findItemINWQU(row, col), findItemINWQU(row + 1, col));
            }
            if (col - 1 > 0 && isOpen(row, col - 1)) {
                wquWithTopBot.union(findItemINWQU(row, col), findItemINWQU(row, col - 1));
                wquWithTop.union(findItemINWQU(row, col), findItemINWQU(row, col - 1));
            }
            if (col + 1 <= n && isOpen(row, col + 1)) {
                wquWithTopBot.union(findItemINWQU(row, col), findItemINWQU(row, col + 1));
                wquWithTop.union(findItemINWQU(row, col), findItemINWQU(row, col + 1));
            }
            if (row == 1) { //
                wquWithTopBot.union(top, findItemINWQU(row, col));
                wquWithTop.union(top, findItemINWQU(row, col));
            }
            if (row == n) //
                wquWithTopBot.union(bottom, findItemINWQU(row, col));
        }
    }

    private int findItemINWQU(int row, int col) {
        return (row - 1) * n + col; //
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);
        return table[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        validate(row, col);
        return isOpen(row, col) && isConnectedTop(top, findItemINWQU(row, col));
    }

    public int numberOfOpenSites() {
        return numOfOpenSites;
    }

    public boolean percolates() {
        return isConnectedTopBot(top, bottom);
    }

    private boolean isConnectedTopBot(int p, int q) {
        return wquWithTopBot.find(p) == wquWithTopBot.find(q);
    }

    private boolean isConnectedTop(int p, int q) {
        return wquWithTop.find(p) == wquWithTop.find(q);
    }

    private void validate(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException();
    }

}
