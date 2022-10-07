import java.util.Scanner; // this will be used to read from standard input
public class ChocolateBars {
    static private double BMR(double weight, double height, double age, boolean isFemale, char activity){ // this is a private method that takes height, weight, age, and gender as arguments and returns the BMR
        double bmr; // declare the BMR
        if(isFemale){
            bmr = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age); // if they are female, compute with the corresponding equation
        }
        else{
            bmr = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age); // if they are not female (male), compute with the corresponding equation
        }
        switch (activity){ // an S, O, A, or H will be passed as a parameter
            case 'S':{ // if activity is S
                double inc = bmr/100; // compute what 1% of the bmr is
                inc *= 20; // compute what 20% of the bmr is
                bmr += inc; // increase the bmr by 20%
                break; // break out of the switch statement
            }
            case 'O':{ // if activity is O
                double inc = bmr/100; // compute what 1% of the bmr is
                inc *= 30; // compute what 30% of the bmr is
                bmr += inc; // increase the bmr by 30%
                break; // break out of the switch statement
            }
            case 'A':{
                double inc = bmr/100;
                inc *= 40; // compute what 40% of the bmr is
                bmr += inc; // increase the bmr by 40%
                break; // break out of the switch statement
            }
            case 'H': {
                double inc = bmr / 100;
                inc *= 50; // compute what 50% of the bmr is
                bmr += inc; // increase the bmr by 50%
                break; // break out of the switch statement
            }
        }
        return bmr; // return the calculated bmr
    }
    static private int numChocolateBars(double bmr){ // this method takes the BMR as an argument and returns the integer number of chocolate bars to satisfy that BMR
        return (int)Math.floor(bmr/230); // we use the Math.floor() function to round down
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in); // initialize a scanner
        System.out.print("Enter the weight in pounds: "); // print the weight request message
        double weight = stdin.nextDouble(); // read the weight from standard input

        System.out.print("Enter the height in inches: "); // print the height request message
        double height = stdin.nextDouble(); // read the height from standard input

        System.out.print("Enter the age in years: "); // print the age request
        double age = stdin.nextDouble(); // read the age from standard input

        String _sex; // declare the string for the sex of the user
        while(true) { // loop
            System.out.print("Enter M for man, W for woman: "); // request M or F
            _sex = stdin.nextLine(); // assign the _sex string the result from standard input
            if( _sex.length() == 0){
               _sex = stdin.nextLine(); // if nothing was read from standard input, read again
            }
            if(_sex.equals("M") || _sex.equals("W")){ // if the entered sex is M or W, break out of the loop
                break;
            }
            else{
                System.out.println("'" + _sex + "' is not a valid sex (M or W)."); // otherwise, print the error message and the loop will reoccur
            }
        }
        char sex = _sex.charAt(0); // the sex character variable is the first item in the _sex string (char sex will be 'M' or 'W')

        String _activity; // declare a string to store the activity from standard input
        while(true){ // loop
            System.out.print("Enter S for Sedentary, O for Occasionally, A for Active, H for Highly Active: "); // request the activity level from the user
            _activity = stdin.nextLine(); // read the activity from standard input
            if(_activity.equals("S") || _activity.equals("O") || _activity.equals("A") || _activity.equals("H")){
                break; // if the activity is one of the activity options, break out of the loop
            }
            else{
                System.out.println("'" + _activity + "' is not a valid activity level (S, O, A, or H)."); // otherwise, print the error message, then loop again
            }
        }
        char activity = _activity.charAt(0); // assign the char activity to the first character in the _activity string

        double bmr = BMR(weight, height, age, sex == 'W', activity); // pass the weight, height, age, if sex is W, and the activity character to our BMR() method
        System.out.println("BMR adjusted for gender and lifestyle: " + bmr); // print the bmr with the corresponding message
        System.out.println("Number of chocolate bars: " + numChocolateBars(bmr)); // calculate the number of chocolate bars with the numChocolateBars() method, then print it with its corresponding message
    }
}