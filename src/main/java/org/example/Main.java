package org.example;

import java.util.*;
import java.util.Scanner;
import java.util.InputMismatchException;

import static org.example.Utils.*;

public class Main {

    public static void main(String[] args) {
        boolean notNumber = true;
        int usersChoice = 0;
        double length = 0;
        double width = 0;
        double leg = 0;

        String mainMenuMessage = """
                Choose (from 1 till 7) what you want to do:\s
                1. Create a figure
                2. Calculate a perimeter
                3. Calculate an area
                4. Show all figures
                5. Show the figure and its area and perimeter
                6. Show the biggest figure
                7. Exit""";

        HashMap<ArrayList<Double>, Integer> shapesWithSandP = new HashMap<>();

        Scanner input = new Scanner(System.in);

        while(notNumber){
            try{
                while (usersChoice != 7) {
                    System.out.println(mainMenuMessage);
                    usersChoice = input.nextInt();
                    switch (usersChoice) {
                        case 1:
                            try{
                                System.out.println("Choose a shape: 1. square, 2. rectangle, 3. triangle");
                                int choiceShape = input.nextInt();

                                switch (choiceShape) {
                                    case 1 -> {
                                        length = oneSizeOfShape(input);
                                        Square s = new Square(length);
                                        shapesWithSandP.put(s.createObjectShape(), choiceShape);
                                    }
                                    case 2 -> {
                                        length = oneSizeOfShape(input);
                                        width = oneSizeOfShape(input);
                                        Rectangle r = new Rectangle(length, width);
                                        shapesWithSandP.put(r.createObjectShape(), choiceShape);
                                    }
                                    case 3 -> {
                                        length = oneSizeOfShape(input);
                                        width = oneSizeOfShape(input);
                                        leg = oneSizeOfShape(input);
                                        Triangle t = new Triangle(length, width, leg);
                                        shapesWithSandP.put(t.createObjectShape(), choiceShape);
                                    }

                                }
                                break;
                        } catch (InputMismatchException e) {

                            System.out.println("Please enter a number, not symbol");
                                input.nextLine();
                        }
                        case 2:
                            System.out.println("Choose the shape to show its perimeter: 1. square, 2. rectangle, 3. triangletest ");
                            int choiceShape = input.nextInt();
                            switch (choiceShape) {
                                case 1 -> showPerimeters(shapesWithSandP, 1);
                                case 2 -> showPerimeters(shapesWithSandP, 2);
                                case 3 -> showPerimeters(shapesWithSandP, 3);
                            }
                            break;
                        case 3:
                            System.out.println("Choose the shape to show its area: 1. square, 2. rectangle, 3. triangle");
                            choiceShape = input.nextInt();
                            switch (choiceShape) {
                                case 1 -> showAreas(shapesWithSandP, 1);
                                case 2 -> showAreas(shapesWithSandP, 2);
                                case 3 -> showAreas(shapesWithSandP, 3);
                            }
                            break;
                        case 4:
                            System.out.println(listShapesWithName(shapesWithSandP));
                            break;
                        case 5:
                            System.out.println("Choose the shape to show its area and perimeter: 1. square, 2. rectangle, 3. triangle");
                            choiceShape = input.nextInt();
                            Utils.showShapeWithSandP(shapesWithSandP, choiceShape);
                            break;
                        case 6:
                            Utils.biggestShapeByPerimeter(shapesWithSandP);
                            Utils.biggestShapeByArea(shapesWithSandP);
                            break;
                        case 7:
                            break;

                        default:
                            System.out.println("Make your choice: ");
                            break;

                    }
                    notNumber = false;
                }
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Please enter a number, not symbol");
            }
        }
        System.out.println("Thank you!");
    }
}