import org.example.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.Utils.*;

public class Tests {
    HashMap<ArrayList<Double>, Integer> shapesWithSandP = new HashMap<>();
    ArrayList<Double> keys = new ArrayList<>();

    double firstLength = Math.random() * 10;
    double secondLength = Math.random() * 10;

    @Test
    public void countPerimeterTest(){
        Rectangle r = new Rectangle(firstLength, secondLength);
        Double perimeter = (firstLength + secondLength)*2;

        Assert.assertEquals(r.getPerimeter(), perimeter);
    }

    @Test
    public void countAreaTest(){
        Rectangle r = new Rectangle(firstLength, secondLength);
        Double area = firstLength * secondLength;

        Assert.assertEquals(r.getSquare(), area);
    }

    @Test
    public void programTest(){
        boolean notNumber = true;
        int usersChoice = (int) ( Math.random() * 10 );
        double length = 0;
        double width = 0;
        double leg = 0;

        HashMap<ArrayList<Double>, Integer> shapesWithSandP = new HashMap<>();
        ArrayList<Double> areaAndPerimeters = new ArrayList<>();
        areaAndPerimeters.add(0, Math.random() * 10);
        areaAndPerimeters.add(1, Math.random() * 10);
        shapesWithSandP.put(areaAndPerimeters, 2);

        Scanner input = new Scanner(System.in);

        String mainMenuMessage = """
                Choose (from 1 till 7) what you want to do:\s
                1. Create a figure
                2. Calculate a perimeter
                3. Calculate an area
                4. Show all figures
                5. Show the figure and its area and perimeter
                6. Show the biggest figure
                7. Exit""";
        while(notNumber){
            try{
                while (usersChoice != 7) {
                    System.out.println(mainMenuMessage);
                    usersChoice = (int)(Math.random()*(20+1)) - 10;
                    System.out.println(usersChoice);
                    switch (usersChoice) {
                        case 1:
                            System.out.println("Choose a shape: 1. square, 2. rectangle, 3. triangle");
                            int choiceShape = (int)(Math.random()*(10+1)) - 5;
                            System.out.println(choiceShape);

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
                        case 2:
                            System.out.println("Choose the shape to show its perimeter: 1. square, 2. rectangle, 3. triangletest ");
                            choiceShape = (int)(Math.random()*(10+1)) - 5;
                            switch (choiceShape) {
                                case 1 -> showPerimeters(shapesWithSandP, 1);
                                case 2 -> showPerimeters(shapesWithSandP, 2);
                                case 3 -> showPerimeters(shapesWithSandP, 3);
                            }
                            break;
                        case 3:
                            System.out.println("Choose the shape to show its area: 1. square, 2. rectangle, 3. triangle");
                            choiceShape = (int)(Math.random()*(10+1)) - 5;
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
                            choiceShape = (int)(Math.random()*(10+1)) - 5;
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
                Math.random();
                System.out.println("Please enter a number, not symbol");
            }
        }
        System.out.println("Thank you!");
    }

}
