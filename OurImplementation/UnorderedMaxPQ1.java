package OurImplementation;

import edu.princeton.cs.algs4.StdOut;

public class UnorderedMaxPQ1 <Key extends Comparable<Key>>{
    private Key[] pq;
    private int N;

    public UnorderedMaxPQ1(int capacity){
        pq = (Key[]) new Comparable[capacity];
    }
    public boolean isEmpty(){
        return N==0;
    }
    public void insert(Key x){
        pq[N++] = x;
    }
    public Key delMax(){
        int max = 0;
        for(int i = 0; i < N; i++)
            if(less(max,pq[i]))
                max = i;
        exch(pq,max,N-1);
        return pq[--N];
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        UnorderedMaxPQ1<Integer> pq = new UnorderedMaxPQ1<>(3);
        pq.insert(2);
        pq.insert(10);
        pq.insert(1);
        StdOut.println(pq.delMax());
    }
}
