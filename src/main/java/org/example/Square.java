package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Square extends GeometricShapes {

    private double lengthFirst;

    public Square(double lengthFirst) {
        super(lengthFirst);
    }

    @Override
    public Double getPerimeter() {
        return (getLengthFirst())*4;
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

    @Override
    public Double getSquare() {
        return getLengthFirst() * getLengthFirst();
    }
}
