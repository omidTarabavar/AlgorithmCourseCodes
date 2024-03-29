package OurImplementation;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick1 {
    private static final int CUTOFF = 10;
    private static int partition(Comparable[] a,int lo,int hi){
        int i = lo; int j = hi + 1;
        while(true){
            while (less(a[++i],a[lo]))
                if(i == hi)
                    break;
            while (less(a[lo],a[--j]))
                if(j == lo) // redundant
                    break;
            if(i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo, int hi){
        if(hi <= lo + CUTOFF - 1) {
            Insertion.sort(a,lo,hi+1);
            return;
        }
        // there is another improvement (MEDIAN) which we cover later
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    
    public static Comparable select(Comparable[] a,int k){
        StdRandom.shuffle(a);
        int lo = 0;
        int hi = a.length-1;
        while (hi > lo){
            int j = partition(a,lo,hi);
            if(j < k)
                lo = j + 1;
            else if(j > k)
                hi = j- 1;
            else
                    return a[k];
        }
        return a[k];
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
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
        StdOut.println(select(a,4));
    }
}
