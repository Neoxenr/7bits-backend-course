package main.it.sevenbits;

import main.it.sevenbits.segments.Segment;
import main.it.sevenbits.segments.Point;

public class Main {
    public static void main(String[] args) {
        double max = 0.0;

        Segment segment1 = new Segment(new Point(7, 4), new Point(8, 4));
        Segment segment2 = new Segment(new Point(-1, 10), new Point(15, 4));
        Segment segment3 = new Segment(new Point(3, -5), new Point(5, 10));
        Segment segment4 = new Segment(new Point(1, 18), new Point(18, 14));
        Segment segment5 = new Segment(new Point(-5, 4), new Point(0, 1));

        Segment[] segments = {segment1, segment2, segment3, segment4, segment5};

        for (int i = 0; i < segments.length; i++) {
            if(segments[i].getSegmentLength() > max) {
                max = segments[i].getSegmentLength();
            }
            System.out.printf("Segment's %d length: %.3f \n", i + 1, segments[i].getSegmentLength());
        }

        System.out.printf("Maximum segment's length: %.3f \n", max);
    }
}
