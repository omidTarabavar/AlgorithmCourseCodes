package OurImplementation;

public class Date2 implements Comparable<Date2>{
    private final int month,day,year;

    public Date2(int m, int d, int y){
        month = m;
        day = d;
        year = y;
    }

    @Override
    public int compareTo(Date2 o) {
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

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null) return false;
        if(obj.getClass() != this.getClass())
            return false;
        Date2 that = (Date2) obj;
        if(this.day != that.day) return false;
        if(this.month != that.month) return false;
        if(this.year != that.year) return false;
        return true;
    }
}
