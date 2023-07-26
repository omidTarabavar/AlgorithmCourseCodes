package OurImplementation;

public class Date1 implements Comparable<Date1>{
    private final int month,day,year;
    public Date1(int m, int d, int y){
        month = m;
        day = d;
        year = y;
    }

    @Override
    public int compareTo(Date1 o) {
        if(this.year < o.year)
            return -1;
        if(this.year > o.year)
            return 1;
        if(this.month < o.month)
            return -1;
        if(this.month > o.month)
            return 1;
        if(this.day < o.day)
            return -1;
        if(this.day > o.day)
            return 1;
        return 0;
    }
}
