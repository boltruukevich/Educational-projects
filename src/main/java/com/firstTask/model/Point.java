package com.firstTask.model;

import java.util.Objects;

public class Point {

    private final Double x;
    private final Double y;
    private final Double z;

    public Point(Double x, Double y, Double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Point of(String x, String y, String z) {
        return new Point(Double.valueOf(x),Double.valueOf(y),Double.valueOf(z));
    }

    public static Point of(int x, int y, int z) {
        return new Point(Double.valueOf(x),Double.valueOf(y),Double.valueOf(z));
    }

    public Double getX(){
        return x;
    }

    public Double getY(){
        return y;
    }

    public Double getZ(){
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) && Objects.equals(y, point.y) && Objects.equals(z, point.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
