package isp.lab3.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(1,2,3);
        System.out.println( point1.distance(0,0,0));
        MyPoint point2 = new MyPoint(10,10,10);
        System.out.println( point1.distance(point2));
    }
}
