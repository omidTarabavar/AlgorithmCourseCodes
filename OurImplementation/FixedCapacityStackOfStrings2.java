package OurImplementation;

public class FixedCapacityStackOfStrings2 {
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings2(int capacity) { // cheat
        s = new String[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        return item;
    }
}
