import java.util.ArrayList; // used to store triangle sides
import java.util.Scanner; // used to read from standard input

public class TriangleTester {
    private static boolean IsTriangle(double l1, double l2, double l3){ // this method returns if the lines form a triangle
        return (l1 < (l2 + l3)) && (l2 < (l1 + l3)) && (l3 < (l2 + l1)); // return true if the sum of each two of the lines is greater than the third line
    }

    private static ArrayList<Double> Order(double l1, double l2, double l3){ // this method returns an ArrayList of line lengths
        ArrayList<Double> rv = new ArrayList<Double>(); // initialize an empty ArrayList of doubles
        rv.add(l1); // add l1 to the ArrayList
        rv.add(l2); // add l2 to the ArrayList
        rv.add(l3); // add l3 to the ArrayList
        return rv; // return the ArrayList
    }

    private static ArrayList<Double> FindMax(double l1, double l2, double l3){ //  this function returns an ArrayList where the largest line is the last item
        ArrayList<Double> res = null; // initialize an ArrayList of doubles to null
        if(l1 >= l2 && l1 >= l3){ // if l1 is bigger than l2 and l3
            res = Order(l2, l3, l1); // make the arraylist with l1 last using the Order() method
        }
        else if(l2 >= l1 && l2 >= l3){ // if l2 is bigger than l3 and l1
            res = Order(l1, l3, l2); // make the arraylist with l2 last using the Order() method
        }
        else{ // the else clause is that l3 is bigger than l1 and l2
            res = Order(l1, l2, l3); // make the arraylist with l3 last using the Order() method
        }
        return res; // return the ArrayList of doubles
    }
    private static String TriangleType(double l1, double l2, double l3){ // this method returns the string of the triangle typ
        ArrayList<Double> abc = FindMax(l1, l2, l3); // declare an ArrayList of doubles and assign it the value returned from the FindMax() method
        double a = abc.get(0); // double a gets the first value
        double b = abc.get(1); // double b gets the second value
        double c = abc.get(2); // double c gets the third value (the largest value)

        if((c*c) < ((a*a) + (b*b))){ // if a squared plus b squared is greater than c squared, then the triangle is acute
            return "acute"; // return the string "acute"
        }
        else if((c*c) > ((a*a) + (b*b))){ // if a squared plus b squared is less than c squared, then the triangle is obtuse
            return "obtuse"; // return the string "obtuse"
        }
        else{ // the else clause is if a squared plus b squared equals c squared, then the triangle is a right triangle
            return "right"; // return the string "right"
        }
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in); // initialize the scanner to standard input
        double l1; // declare line 1
        double l2; // declare line 2
        double l3; // declare line 3

        System.out.print("Enter the first length: "); // prompt the user for the first line
        l1 = stdin.nextDouble(); // read the double from standard input and assign l1 it's value

        System.out.print("Enter the second length: "); // prompt the user for the second line
        l2 = stdin.nextDouble(); // read the double from standard input and assign l2 it's value

        System.out.print("Enter the third length: "); // prompt the user for the third line
        l3 = stdin.nextDouble(); // read the double from standard input and assign l3 it's value

        stdin.close(); // close the scanner to standard input

        if(IsTriangle(l1, l2, l3)){ // run the method IsTriangle()
            System.out.println("These lengths can form a triangle"); // if IsTriangle() returns true, print that the lines create a triangle
            String type = TriangleType(l1, l2, l3); // initialize the string to the value returned from TriangleType()
            System.out.println("It is a " + type + " triangle"); // print the triangle type
        }
        else{ // if IsTriangle() returned false, the lines do not form a triangle
            System.out.println("These lengths cannot form a triangle"); // display to the user that the lines do not form a triangle
        }
    }
}
