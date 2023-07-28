package OurImplementation;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class Student {
    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_SECTION = new BySection();

    private final String name;
    private final int section;

    public Student(String name,int section){
        this.name = name;
        this.section = section;
    }

    private static class ByName implements Comparator<Student>{

        @Override
        public int compare(Student v, Student w) {
            return v.name.compareTo(w.name);
        }
    }
    private static class BySection implements Comparator<Student>{

        @Override
        public int compare(Student v, Student w) {
            return v.section - w.section;
        }
    }

    @Override
    public String toString() {
        return name +", "+section;
    }
    public static void printStdArr(Student[] a){
        for(Student std: a)
            StdOut.println(std);
    }
    public static void main(String[] args) {
        Student a = new Student("omid",1);
        Student b = new Student("amir",3);
        Student c = new Student("hossein",4);
        Student d = new Student("reza",2);
        Student[] arr = {a,b,c,d};
        StdOut.println("Natural order: ");
        printStdArr(arr);
        StdOut.println("\nSort by Name: ");
        Arrays.sort(arr,Student.BY_NAME);
        printStdArr(arr);
        StdOut.println("\nSort by Section: ");
        Arrays.sort(arr,Student.BY_SECTION);
        printStdArr(arr);
    }

}
