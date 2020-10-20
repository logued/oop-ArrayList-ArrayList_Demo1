package org.dkit.dermotlogue;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ArrayList_Demo1
 * Demonstrates basic uses of ArrayList
 * KEY CONCEPTS:
 * - ArrayList is a wrapper class for an array, so data is stored
 *   in an array inside the ArrayList object
 * - ArayList can expand as required when elements are added
 * - ArrayList access is fast (because of underlying array data structure)
 * -  ArrayList stores class types only , so
 *    (NOT primitive types (which must be wrapped))
 * - ArrayList has many useful methods (e.g. add() , remove(),  get() ...)
 * - passing ArrayList into a method
 * - AUtoBoxing and Primitive Data Type conversions (int => Integer etc)
 */
public class App {

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    public void start() {
        System.out.println("ArrayList Samples");
        demoArrayListOfString();
        demoPrimitiveTypeWrapping();
        //demoArrayListGrowth();
    }

    private void demoArrayListOfString() {
        // ArrayLists store only class types (references to objects)
        // String is a class, so strings can be added
        // We must specify the type of class using a 'type parameter' <type>

        ArrayList<String> namesList = new ArrayList<>();

        namesList.add("Arya Stark");
        namesList.add("Jon Snow");
        namesList.add("Khal Drogo");
        namesList.add("Cersei Lannister");
        namesList.add("Tyrion Lannister");

        // use foreach loop to read each element
        for (String name : namesList) {
            System.out.println(name);
        }
        System.out.println();

        // remove an element by object comparison
        namesList.remove("Jon Snow");
        // remove element by index
        namesList.remove(0);  // remove first element
        // Add an element at the end ( ArrayList will grow)
        namesList.add("Robb Stark");

        // use get(index) method for index access
        for (int i = 0; i < namesList.size(); i++) {
            System.out.println(i + ": " + namesList.get(i));
        }

        // contains()
        if (namesList.contains("Robb Stark"))
            System.out.println("The list contains Robb Stark.\n");

        // set new value at index position
        namesList.set(0, "Eddard Stark");

        // Display all ArrayList values as one String
        System.out.println("namesList.toString() :\n" + namesList.toString());

        // convert ArrayList to array
        String[] namesArray = new String[namesList.size()];  // create right-sized array
        namesList.toArray(namesArray);
        for (String s : namesArray) {
            System.out.println(s);
        }


        //TODO Use a for loop to print the namesList in reverse order.
        System.out.println("Reverse order:");
        for (int i = namesList.size()-1; i>=0; i--) {
            System.out.println(i + ": " + namesList.get(i));
        }
        // clear all contents
        namesList.clear();


    }

    private void demoPrimitiveTypeWrapping() {
        // only class types can be stored in an ArrayList
        // Primitive Types (int, double,...) can be stored directly
        // but they can be wrapped in their corresponding Class type
        // int ==> Integer
        // double ==> Double  etc...
        // Byte, Boolean, Character, Double, Float, Integer, Long, Short


        // this line will not compile - it uses a Primitive Type int
        // ArrayList<int> intList = new ArrayList<>();

        // use the corresponding Integer wrapper class instead
        ArrayList<Integer> numList = new ArrayList<>();
        numList.add(20);
        numList.add(30);
        numList.add(40);

        // The primitive int values above are converted into Integer objects.
        // This is called AutoBoxing.
        // When we extract the values from the ArrayList, and assign them
        // to an int variable, they will be converted from Integer to int automatically)

        Integer refToInteger = numList.get(0);    // get reference to Integer object
        int x = refToInteger; // AutoBoxing - converts Integer to int
        int y = numList.get(0); // // Autoboxing - converts Integer to int on return

        //TODO - declare an ArrayList to store the heights of a class of students
        // e.g. 1.75, 1.80, 1.45, 1.98  etc.
        // Populate the ArrayList with 10 heights, print them out,
        // using a loop, calculate the average height and output it.

        ArrayList<Double> heightList = new ArrayList<>();
        heightList.add(1.67);
        heightList.add(1.64);
        heightList.add(1.57);
        heightList.add(1.86);
        heightList.add(1.87);
        heightList.add(1.98);
        heightList.add(1.85);
        heightList.add(1.83);
        heightList.add(1.75);
        heightList.add(1.54);
        System.out.println("\nList of heights");
        for (double height:heightList)
        {
            System.out.println(height);
        }
        double totalHeight = 0;
        for (double height:heightList)
        {
            totalHeight += height;
        }
        double averageHeight = totalHeight/heightList.size();
        System.out.printf("Average of all the heights = %.3f" , averageHeight);








    }

    private void demoArrayListGrowth() {
        // Read unknown number of floating point (double) values
        // from the keyboard and store them.
        // Must use wrapper class for declaration.

        ArrayList<Double> values = new ArrayList<>();  //Declare & Create

        // Read inputs from keyboard. ADD to ArrayList.
        // Much easier than using an array - WHY?

        System.out.println("Please enter values, Q to quit:");
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble()) {
            values.add(in.nextDouble());
        }

        System.out.println("\nDisplay all using toString() " + values.toString());
        System.out.println();

        // Find the largest value - similar to ARRAY processing except .....
        System.out.println("Find & MARK largest value :");

        // TODO Convert to method findLargest() - return largest value.  Change to use enhanced FOR

        // Find the largest value
        double largest = values.get(0);  // set initial current largest
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) > largest) {
                largest = values.get(i);
            }
        }
        System.out.println("Largest: " + largest);

        // Print all values, marking the largest
        for (double element : values)    // enhanced for loop (or "for each" loop)
        {
            System.out.print(element);
            if (element == largest) {
                System.out.print(" <== largest value");
            }
            System.out.println();
        }

        // TODO  Convert to method markLargest() -


        // Remove all numbers < 0 from ArrayList - Attempt!

        System.out.println("Remove all negative numbers from ArrayList");
        // Note that this code will fail (logically) in some cases
        for (int i = 0; i < values.size(); i++) {
            double num = values.get(i);
            if (num < 0) {
                values.remove(i);
            }
        }

        System.out.println("\nDisplay all using toString() " + values.toString());
        System.out.println();
        //TEST TEST TEST.....How would you modify so the removal works?
        //TODO  Modify so it works correctly!
        //TODO  Convert to method removeAllNegative()
    }

    // Passing an ArrayList<Type> to a method really means that
    // a reference to the ArrayList is passed.  The parameter
    // variable will have read and modify access to the original ArrayList.
    //TODO - finish this method and test it.
    //
    //    public static double findLargest(ArrayList<Double> values)
    //    {
    //        return 0;
    //    }
}
