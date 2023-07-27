package OurImplementation;

import edu.princeton.cs.algs4.StdOut;

public class MergeBU1 {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
        assert isSorted(a, lo, hi);
    }
    public static void sort(Comparable[] a){
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for(int sz = 1; sz < n; sz += sz)
            for(int lo = 0; lo < n-sz; lo += sz + sz)
                merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1,n-1));
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    public static boolean isSorted(Comparable[] a){
        for(int i = 1; i < a.length; i++)
            if(less(a[i],a[i-1]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {4,2,7,1,9,2};
        StdOut.println(isSorted(a));
        sort(a);
        StdOut.println(isSorted(a));
    }
}
