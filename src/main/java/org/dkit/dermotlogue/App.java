package org.dkit.dermotlogue;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ArrayList_Demo1
 * Demonstrates basic uses of ArrayList
 * KEY CONCEPTS:
 * - ArrayList is a wrapper class for an array of elements, so data is stored
 *   in an array 'inside' the ArrayList object
 * - ArrayList can expand as required when elements are added
 * - ArrayList access is fast (because of underlying array data structure)
 * -  ArrayLists can store class types only (NOT primitive types like int, double)
 * - Primitive Type values must be Wrapped in corresponding classes Integer, Double etc.
 * - ArrayList API has many useful methods (e.g. add() , remove(),  get() ...)
 * - passing ArrayList into a method
 * - AutoBoxing and Primitive Data Type conversions (int => Integer etc)
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
        namesList.toArray(namesArray);  // copy ArrayList elements into the Array
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
        // Primitive Types (int, double,...) can not be stored directly
        // but, they can be wrapped in their corresponding Class type
        // int ==> Integer
        // double ==> Double  etc...
        // Byte, Boolean, Character, Double, Float, Integer, Long, Short

        // The following line will not compile - as it attempts to use a Primitive Type int
        // ArrayList<int> intList = new ArrayList<>();

        // Use the corresponding Integer wrapper class instead
        ArrayList<Integer> numList = new ArrayList<>();
        numList.add(20);
        numList.add(30);
        numList.add(40);

        // The primitive int values (20,30,40) above are converted into Integer objects automatically.
        // This is called AutoBoxing.
        // When we extract the values from the ArrayList, and assign them
        // to an int variable, they will be converted from Integer to int automatically.

        Integer refToInteger = numList.get(0);    // get reference to Integer object
        int x = refToInteger; // AutoBoxing - converts Integer to int
        int y = numList.get(0); // // Autoboxing - converts Integer to int on return

        //TODO - declare an ArrayList to store the heights of a class of students
        // e.g. 1.75, 1.80, 1.45, 1.98  etc.
        // Populate the ArrayList with 10 heights, print them out,
        // using a loop, calculate the average height and output it.

        ArrayList<Double> heights = new ArrayList<>();
        heights.add(1.75);
        heights.add(1.80);
        heights.add(1.45);
        heights.add(1.98);
        System.out.println("Display all heights:");
        for (Double height : heights)
        {
            System.out.println(height);
        }

        double totalHeight = 0;
        for (Double height : heights)
        {
            totalHeight += height;
        }
        double averageHeight = totalHeight/heights.size();
        System.out.println("Average height = " + averageHeight);
    }

    private void demoArrayListGrowth() {
        // Read an unknown number of floating point (double) values
        // from the keyboard and store them.
        // Must use wrapper class for declaration.

        ArrayList<Double> values = new ArrayList<>();  //Declare & Create

        // Read inputs from keyboard. Add to ArrayList.
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
        double largest = values.get(0);  // use first element as initial current largest
        for (int i = 1; i < values.size(); i++) {  // look through list to find a larger value
            if (values.get(i) > largest) {
                largest = values.get(i);
            }
        }
        System.out.println("Largest: " + largest);

        // Print all values, marking the largest
        for (double d : values)    // enhanced for loop (or "for each" loop) // autobox happens
        {
            System.out.print(d);
            if (d == largest) {
                System.out.print(" <== largest value");
            }
            System.out.println();
        }

        // TODO  Convert to method markLargest() -


        // Remove all numbers < 0 from ArrayList
        // Caution: when an element is removed, elements to the right are
        // shifted to the left, to fill the space.  However, if we increment i;
        // then we will skip past the element that filled the space.

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
        //TEST TEST TEST.....How would you modify so the removal works correctly.
        //TODO  Modify so it works correctly!
        //TODO  Convert to a new method called removeAllNegative()
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
