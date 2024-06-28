package org.example.classes;

public class R2Point {
    private double x;
    private double y;

    public R2Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public void print() {
        System.out.println("(" + x + ", " + y + ")");
    }
}
