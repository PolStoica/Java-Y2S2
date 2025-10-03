package isp.lab3.exercise4;

public class MyPoint {
    private int x;
    private int y;
    private int z;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    public MyPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setXYZ(int x, int y, int z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public String toString() {
        return "(" +String.valueOf(x) +"," +String.valueOf(y) +"," +String.valueOf(z) + ")" ;
    }

    public String distance(int x, int y, int z) {
        return "("+ String.valueOf(Math.abs(x - this.x)) +"," + String.valueOf(Math.abs(y - this.y)) +","+ String.valueOf(Math.abs(z - this.z)) +")";
    }

    public String distance(MyPoint another) {
        return "("+ String.valueOf(Math.abs(this.x - another.x)) +"," + String.valueOf(Math.abs(this.y - another.y)) +","+ String.valueOf(Math.abs(this.z - another.z)) +")";
    }
}