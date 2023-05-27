import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champ = "";
        double i = 0;
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            i++;
            if (StdRandom.bernoulli(1/i)) {
                champ = name;
            }
        }
        StdOut.println(champ);
    }
}
