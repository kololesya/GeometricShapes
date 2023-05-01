package org.example;

import java.util.ArrayList;

public class Triangle extends GeometricShapes {
    private double lengthFirst;
    private double lengthSecond;
    private double lengthThird;

    public Triangle(double lengthFirst, double lengthSecond, double lengthThird) {
        super(lengthFirst, lengthSecond, lengthThird);
    }

    @Override
    public Double getPerimeter() {
        return getLengthFirst() + getLengthSecond() + getLengthThird();
    }

    @Override
    public ArrayList<Double> createObjectShape() {
        ArrayList<Double> sizesOfShapes = new ArrayList<>();
        sizesOfShapes.add(Math.ceil(this.getPerimeter()));
        sizesOfShapes.add(Math.ceil(this.getSquare()));
        return sizesOfShapes;
    }

    @Override
    public Double getSquare() {
        double p = (getLengthFirst() + getLengthSecond() + getLengthThird())/2;
        return Math.sqrt(p*(p - getLengthFirst())*(p - getLengthSecond())*(p - getLengthThird())) ;
    }
}
