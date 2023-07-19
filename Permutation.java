import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        int n = 0;
        String temp;
        while (!StdIn.isEmpty()) {
            temp = StdIn.readString();
            n++;
            if (randomizedQueue.size() < k) {
                randomizedQueue.enqueue(temp);
            } else {
                if (StdRandom.uniformDouble() < ((double) k / n)) {
                    randomizedQueue.dequeue();
                    randomizedQueue.enqueue(temp);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(randomizedQueue.dequeue());
        }
    }
}
