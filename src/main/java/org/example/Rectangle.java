package org.example;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends GeometricShapes {

    private double lengthFirst;
    private double lengthSecond;

    public Rectangle(double lengthFirst, double lengthSecond) {
        super(lengthFirst, lengthSecond);
    }

    @Override
    public Double getPerimeter() {
        return (getLengthFirst() + getLengthSecond())*2;
    }

    @Override
    public Double getSquare() {
        return getLengthFirst() * getLengthSecond();
    }

    @Override
    public ArrayList<Double> createObjectShape() {
        this.getPerimeter();
        this.getSquare();
        ArrayList<Double> sizesOfShapes = new ArrayList<>();
        sizesOfShapes.add(this.getPerimeter());
        sizesOfShapes.add(this.getSquare());
        return sizesOfShapes;
    }
}
