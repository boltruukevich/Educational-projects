package com.firstTask.model;

import java.util.Objects;

public class Plane {

    private final Double coeffA;
    private final Double coeffB;
    private final Double coeffC;
    private final Double coeffD;

    public Plane(Double coeffA, Double coeffB, Double coeffC, Double coeffD){
        this.coeffA = coeffA;
        this.coeffB = coeffB;
        this.coeffC = coeffC;
        this.coeffD = coeffD;
    }

    public static Plane of(Double coeffA, Double coeffB,
                           Double coeffC, Double coeffD) {
        return new Plane(coeffA, coeffB, coeffC, coeffD);
    }

    public static Plane of(String coeffA, String coeffB, String coeffC, String coeffD) {
        return new Plane(new Double(coeffA), new Double(coeffB),
                new Double(coeffC), new Double(coeffD));
    }

    public static Plane of(double coeffA, double coeffB, double coeffC, double coeffD) {
        return new Plane(coeffA, coeffB, coeffC, coeffD);
    }
    public Double getcoeffA(){
        return coeffA;
    }
    public Double getcoeffB(){
        return coeffB;
    }
    public Double getcoeffC(){
        return coeffC;
    }
    public Double getcoeffD() { return coeffD; }


    @Override
    public String toString() {
        return "Flatness{" +
                "coeffA=" + coeffA +
                ", coeffB=" + coeffB +
                ", coeffC=" + coeffC +
                ", coeffD=" + coeffD +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Double.compare(plane.coeffA, coeffA) == 0 && Double.compare(plane.coeffB, coeffB)
                == 0 && Double.compare(plane.coeffC, coeffC) == 0 && Double.compare(plane.coeffD, coeffD) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coeffA, coeffB, coeffC, coeffD);
    }
}
