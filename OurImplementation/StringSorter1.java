package OurImplementation;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StringSorter1 {
    public static void main(String[] args) {
        String[] a = new In(args[0]).readAllStrings(); // original method was deprecated
        Insertion.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }

    }
}
