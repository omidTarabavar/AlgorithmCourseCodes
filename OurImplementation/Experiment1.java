package OurImplementation;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Experiment1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Double[] a = new Double[n]; // we use Double instead of double because Double class implements Comparable (which is needed for Insertion.sort).
        for(int i = 0; i < n; i++)
            a[i] = StdRandom.uniformDouble();
        Insertion.sort(a);
        for(int i = 0; i < n; i++)
            StdOut.println(a[i]);



    }
}
