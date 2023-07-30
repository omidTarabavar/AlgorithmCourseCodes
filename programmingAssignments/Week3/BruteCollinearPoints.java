package programmingAssignments.Week3;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> lineSegments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException();
        for (Point point : points) {
            if (point == null)
                throw new IllegalArgumentException();
        }
        Point[] tempPoints = Arrays.copyOf(points, points.length);
        Arrays.sort(tempPoints);
        for (int i = 1; i < tempPoints.length; i++)
            if (tempPoints[i].compareTo(tempPoints[i - 1]) == 0)
                throw new IllegalArgumentException();
        lineSegments = new ArrayList<>();
        for (int i = 0; i < tempPoints.length; i++) {
            for (int j = i + 1; j < tempPoints.length; j++) {
                for (int k = j + 1; k < tempPoints.length; k++) {
                    double slopPQ = tempPoints[i].slopeTo(tempPoints[j]);
                    double slopPR = tempPoints[i].slopeTo(tempPoints[k]);
                    if (slopPQ == slopPR) {
                        for (int m = k + 1; m < tempPoints.length; m++) {
                            double slopPS = tempPoints[i].slopeTo(tempPoints[m]);
                            if (slopPQ == slopPS) {
                                lineSegments.add(new LineSegment(tempPoints[i], tempPoints[m]));
                            }
                        }
                    }
                }
            }
        }
    }


    public int numberOfSegments() {
        return lineSegments.size();
    }

    public LineSegment[] segments() {
        return lineSegments.toArray(new LineSegment[0]);
    }

}
