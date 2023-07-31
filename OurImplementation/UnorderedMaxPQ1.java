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
            if(less(max,i))
                max = i;
        exch(max,N-1);
        return pq[--N];
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j){
        Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
    }

    public static void main(String[] args) {
        UnorderedMaxPQ1<Integer> pq = new UnorderedMaxPQ1<>(3);
        pq.insert(2);
        pq.insert(10);
        pq.insert(1);
        StdOut.println(pq.delMax());
    }
}
