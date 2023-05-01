package org.example;

import java.util.*;

public class Utils {

    public static <K, V> ArrayList<K> getKeys(Map<K, V> map, V value){
        ArrayList<K> keys = new ArrayList<>();
        for (Map.Entry<K, V> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    public static List perimetersAndAreas(HashMap shapesWithSandP){
        return shapesWithSandP
                .keySet()
                .stream().toList();
    }

    public static void biggestShapeByPerimeter(HashMap shapesWithSandP){
        List<ArrayList<Double>> perimetersAdAreas = perimetersAndAreas(shapesWithSandP);
        List<Double> perimeters = new ArrayList<>();
        for (int i = 0; i < perimetersAdAreas.size(); i++){
            perimeters.add(perimetersAdAreas.get(i).get(0));
        }

        System.out.println("The biggest perimeter of the shapes is " + Collections.max(perimeters));
    }

    public static void biggestShapeByArea(HashMap shapesWithSandP){
        List<ArrayList<Double>> perimetersAndAreas = perimetersAndAreas(shapesWithSandP);
        List<Double> areas = new ArrayList<>();
        for (int i = 0; i < perimetersAndAreas.size(); i++){
            areas.add(perimetersAndAreas.get(i).get(1));
        }

        System.out.println("The biggest area of the shapes is " + Collections.max(areas));
    }

    public static void showPerimeters(HashMap shapesWithSandP, int choiceShape){
        List<ArrayList<Double>> valuesShape = getKeys(shapesWithSandP, choiceShape);
        for (int i = 0; i < valuesShape.size(); i++){
            System.out.println("The perimeter of " + nameOfShape(choiceShape) + " is: " +
                    valuesShape.get(i).get(0));
        }
    }

    public static void showAreas(HashMap shapesWithSandP, int choiceShape){
        List<ArrayList<Double>> valuesShape = getKeys(shapesWithSandP, choiceShape);
        for (int i = 0; i < valuesShape.size(); i++){
            System.out.println("The area of " + nameOfShape(choiceShape) + " is: " +
                    valuesShape.get(i).get(1));
        }
    }

    public static void showShapeWithSandP(HashMap shapesWithSandP, int choiceShape){
        List<ArrayList<Double>> valuesShape = getKeys(shapesWithSandP, choiceShape);

        for (int i = 0; i < valuesShape.size(); i++){
        System.out.println("The perimeters of " +
                nameOfShape(choiceShape) + " is " + valuesShape.get(i).get(0) + "\n" +
                "The area of " + nameOfShape(choiceShape) + " is " + valuesShape.get(i).get(1));}
    }

    public static String nameOfShape(int choiceShape){
        String nameOfShape = " ";
        if (choiceShape == 1){
            return nameOfShape = "square";
        } else if (choiceShape == 2){
            return nameOfShape = "rectangle";
        } else if (choiceShape == 3) {
            return nameOfShape = "triangle";
        }
        return nameOfShape;
    }

    public static Map<ArrayList<Double>, String> listShapesWithName(HashMap<ArrayList<Double>, Integer> shapesWithSandP){
        Map<ArrayList<Double>, String> listShapesWithName = new HashMap<>();
        shapesWithSandP.entrySet().forEach(entry -> {
                    if (entry.getValue() == 1){
                        listShapesWithName.put(entry.getKey(), "Square");
                    } else if (entry.getValue() == 2) {
                        listShapesWithName.put(entry.getKey(), "Rectangle");
                    } else{
                        listShapesWithName.put(entry.getKey(), "Triangle");
                    } }
                    );
        return listShapesWithName;
    }

    public static Double oneSizeOfShape(Scanner input) {
        double oneSizeOfShape = 0;
        boolean notNumber = true;

        while (notNumber) {
            try {
                System.out.print("Enter the length: ");
                oneSizeOfShape = input.nextDouble();

                while (oneSizeOfShape <= 0)
                {
                    System.out.print("Please enter a positive number: ");
                    oneSizeOfShape = input.nextDouble();
                }
                notNumber = false;
            }
            catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Please enter a number, not symbol");
            }
        }
        return oneSizeOfShape;
    }

}
