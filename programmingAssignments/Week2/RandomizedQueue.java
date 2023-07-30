package programmingAssignments.Week2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int STARTMAX = 1;
    private Item[] s;
    private int n = 0;

    public RandomizedQueue() {
        s = (Item[]) new Object[STARTMAX];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        if (n == s.length) resize(2 * s.length);
        s[n++] = item;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        int index = StdRandom.uniformInt(n);
        Item item = s[index];
        s[index] = s[n - 1];
        s[n - 1] = null;
        n--;
        if (n > 0 && n == s.length / 4)
            resize(s.length / 2);
        return item;
    }

    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();
        int index = StdRandom.uniformInt(n);
        return s[index];
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++)
            copy[i] = s[i];
        s = copy;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Item[] copy = (Item[]) new Object[n];
        private int i = n;

        public ListIterator() {
            for (int j = 0; j < n; j++)
                copy[j] = s[j];
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            int index = StdRandom.uniformInt(i);
            Item item = copy[index];
            if (index != i - 1)
                copy[index] = copy[i - 1];
            copy[i - 1] = null;
            i--;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        StdOut.println(randomizedQueue.size());
        StdOut.println(randomizedQueue.dequeue());
        StdOut.println(randomizedQueue.sample());
        StdOut.println(randomizedQueue.dequeue());
        StdOut.println(randomizedQueue.dequeue());
        StdOut.println(randomizedQueue.isEmpty());


    }
}
