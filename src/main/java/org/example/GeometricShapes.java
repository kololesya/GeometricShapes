package org.example;

import java.util.ArrayList;

public abstract class GeometricShapes {
    private static double lengthFirst;
    private static double lengthSecond;
    private static double lengthThird;

    public double getLengthFirst() {
        return lengthFirst;
    }

    public static void setLengthFirst(double lengthFirst) {

        GeometricShapes.lengthFirst = lengthFirst;
    }

    public double getLengthSecond() {
        return lengthSecond;
    }

    public static void setLengthSecond(double lengthSecond) {
        GeometricShapes.lengthSecond = lengthSecond;
    }

    public static double getLengthThird() {
        return lengthThird;
    }

    public static void setLengthThird(double lengthThird) {
        GeometricShapes.lengthThird = lengthThird;
    }

    public GeometricShapes(double lengthFirst, double lengthSecond, double lengthThird) {
        this.lengthFirst = lengthFirst;
        this.lengthSecond = lengthSecond;
        this.lengthThird = lengthThird;
    }

    public GeometricShapes(double lengthFirst, double lengthSecond) {
        this.lengthFirst = lengthFirst;
        this.lengthSecond = lengthSecond;
    }

    public GeometricShapes(double lengthFirst) {
        this.lengthFirst = lengthFirst;
    }

    public abstract Double getPerimeter();

    public abstract ArrayList<Double> createObjectShape();

    public abstract Double getSquare();


}
