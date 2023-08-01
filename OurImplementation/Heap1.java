package OurImplementation;

import edu.princeton.cs.algs4.StdOut;

public class Heap1 {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--)
            sink(a, k, n);
        while (n > 1) {
            exch(a, 1, n);
            sink(a, 1, --n);
        }
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i-1].compareTo(a[j-1]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 2; i <= a.length; i++)
            if (less(a,i, i - 1))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 3, 2, 5};
        StdOut.println(isSorted(a));
        sort(a);
        StdOut.println(isSorted(a));

    }
}
