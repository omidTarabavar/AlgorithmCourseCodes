package OurImplementation;

public class MaxPQ1<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    public MaxPQ1(int capacity){
        pq = (Key[]) new Comparable[capacity+1];
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public void insert(Key key){
        pq[++n] = key;
        swim(n);
    }
    private void swim(int k){
        while(k > 1 && less(k/2,k)){
            exch(k,k/2);
            k = k/2;
        }
    }

    public Key delMax(){
        Key max = pq[1];
        exch(1,n--);
        sink(1);
        pq[n+1] = null;
        return max;
    }
    private void sink(int k){
        while (2*k <= n){
            int j = 2*k;
            if(j < n && less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j){
        Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
    }

}
