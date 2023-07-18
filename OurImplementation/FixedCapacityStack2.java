package OurImplementation;

public class FixedCapacityStack2<Item> {
    private Item[] s;
    private int N = 0;

    public FixedCapacityStack2(int capacity) {
        s = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        s[N++] = item;
    }

    public Item pop() {
        return s[--N];
    }
}
