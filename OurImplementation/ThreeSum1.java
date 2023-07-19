package OurImplementation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSum1 {
    static final int MAX = 100;
    public static void main(String[] args) {
        for(int i = 1; i <= 16000; i *= 2){
            System.out.println("N: "+i+"\tTime: "+timeTrial(i));
        }
    }
    public static double timeTrial(int n){
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = StdRandom.uniformInt(-MAX,MAX);
        }
        Stopwatch stopwatch = new Stopwatch();
        count(nums);
        return stopwatch.elapsedTime();
    }
    public static int count(int[] nums) {
        int result = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0)
                        result++;
                }
            }
        }
        return result;
    }
}
