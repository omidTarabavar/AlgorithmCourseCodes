import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.UF;

public class Temp {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c;
        Stopwatch stopwatch = new Stopwatch();
        for(int i = 0; i < 1000000; i++){
            c = a+b;
        }
        double time = stopwatch.elapsedTime();
        System.out.println(time);
    }
}
