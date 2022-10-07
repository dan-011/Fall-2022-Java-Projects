import java.util.Scanner;
public class CompareStrings {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in); // create the standard input scanner
        String str1; // declare the first string
        String str2; // declare the second string
        System.out.print("Enter the first string: "); // prompt the user for the first string
        str1 = stdin.nextLine(); // store what is entered by the user from standard input into str1

        System.out.print("Enter the second string: "); // prompt the user for the second string
        str2 = stdin.nextLine(); // store what is entered by the user from standard input into str2

        System.out.print("\n");

        if(str1.equals(str2)){ // use the .equals() method to compare str1 and str2 for equivalence
            System.out.println("The two strings are equal"); // if the strings are equal, write the message
            System.exit(0); // exit the program
        }
        else{
            System.out.println("The two strings are not equal"); // otherwise, if str1 does not equal str2 exactly, print the appropriate message
        }
        if(str1.toLowerCase().equals(str2.toLowerCase())){ // use the .toLowerCase() method to get str1 and str2 as lowercase strings and compare them for equality using the .Equals() method. If we use .ToLowerCase(), then the casing is ignored since all characters in both strings will be lowercase
            System.out.println("But the two strings are equal, ignoring case"); // if the lowercase of str1 equals the lowercase of str2, print the appropriate message
        }
        else{
            System.out.println("The two strings are not equal, even ignoring case"); // otherwise, if the lowercase of str1 does not equal the lowercase of str2, then the two strings are not equal even ignoring case. Print the appropriate message.
        }
    }
}
