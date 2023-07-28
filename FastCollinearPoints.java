import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private ArrayList<LineSegment> lineSegments;

    public FastCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException();
        for (Point point : points) {
            if (point == null)
                throw new IllegalArgumentException();
        }
        lineSegments = new ArrayList<>();
        Point[] tempPoints = Arrays.copyOf(points, points.length);
        // duplicate check
        Arrays.sort(tempPoints);
        for (int i = 1; i < tempPoints.length; i++)
            if (tempPoints[i].compareTo(tempPoints[i - 1]) == 0)
                throw new IllegalArgumentException();
        if (points.length > 3) {
            makeLines(points);
        }
    }

    private void makeLines(Point[] points) {
        Point[] tempPoints = Arrays.copyOf(points, points.length);
        for (Point p : points) {
            Arrays.sort(tempPoints, p.slopeOrder());
            double slope = p.slopeTo(tempPoints[1]);
            int cnt = 1;
            int i;
            for (i = 2; i < tempPoints.length; i++) {
                double tempSlop = p.slopeTo(tempPoints[i]);
                if (slope == tempSlop) {
                    cnt++;
                } else {
                    if (cnt >= 3) {
                        Arrays.sort(tempPoints, i - cnt, i);
                        if (p.compareTo(tempPoints[i - cnt]) < 0) {
                            lineSegments.add(new LineSegment(p, tempPoints[i - 1]));
                        }
                    }
                    slope = tempSlop;
                    cnt = 1;
                }
            }
            if (cnt >= 3) {
                Arrays.sort(tempPoints, i - cnt, i);
                if (p.compareTo(tempPoints[i - cnt]) < 0) {
                    lineSegments.add(new LineSegment(p, tempPoints[i - 1]));
                }
            }
        }
    }

    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
