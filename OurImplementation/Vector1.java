package OurImplementation;

public class Vector1 {
    private final int n;
    private final double[] data;

    public Vector1(double[] data){
        this.n = data.length;
        this.data = new double[n];
        for(int i = 0; i < n; i++){
            this.data[i] = data[i];
        }
    }
}
