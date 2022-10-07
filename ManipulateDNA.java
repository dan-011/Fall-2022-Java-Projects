import java.util.ArrayList; // used to store DNA sequences
import java.util.Scanner; // used to read from an input file
import java.io.FileNotFoundException; // used to throw an error if a file does not exist
import java.io.File; // used to read from an input file
public class ManipulateDNA {
    private static void PrintInfo(int iteration, String sequence){ // this method will print the info given the loop iteration and the DNA sequence
        int sequenceNumber = iteration + 1; // the sequence number will the iteration number plus 1 (because strings are 0 indexed)
        String reverse = Reverse(sequence); // get the reverse of the sequence with our Reverse() method
        String complement = Complement(sequence); // get the complement of the sequence with our Complement() method
        String revComplement = Reverse(complement); // get the reverse of the complement with our Reverse() method
        System.out.println(); // print an empty line for formatting
        System.out.println("Sequence Number: " + sequenceNumber); // print the sequence number
        System.out.println("Input Sequence: " + sequence); // print the sequence
        System.out.println("Reverse Sequence: " + reverse); // print the reverse of the sequence
        System.out.println("Complement: " + complement); // print the complement
        System.out.println("Reverse Complement: " + revComplement); // print the reverse of the complement
    }
    private static boolean IsValidGene(char c){
        return c == 'A' || c == 'T' || c == 'G' || c == 'C';
    } // this method tests if a char is a valid gene by seeing if it has the value A, T, G, or C
    private static String Complement(String sequence){ // this method returns the complement of a sequence
        String comp = ""; // create an empty string to hold the complement
        for(int i = 0; i < sequence.length(); i++){ // for each index in the sequence
            char c = sequence.charAt(i); // get the character at index i
            if(!IsValidGene(c)){ // test if the character is a valid gene
                System.out.println("Invalid Sequence"); // if it is invalid tell the user
                System.exit(0); // exit the program
            }
            char _c = '\0'; // initialize the character (which will hold the complement character) with the null character
            switch(c) { // switch statement taking the current character in the string
                case 'A': { // if the character is A
                    _c = 'T'; // set the complement character to T
                    break; // break out of the switch statement
                }
                case 'T': { // if the character is T
                    _c = 'A'; // set the complement character to A
                    break; // break out of the switch statement
                }
                case 'G': { // if the character is G
                    _c = 'C'; // set the complement character to C
                    break; // break out of the switch statement
                }
                case 'C': { // if the character is C
                    _c = 'G'; // set the complement character to G
                    break; // break out of the switch statement
                }
            }
            comp += _c; // add the complement character to the comp string
        }
        return comp; // return the comp string
    }
    private static String Reverse(String str){ // this method returns the reverse of the string passed to it
        String rev = ""; // initialize an empty string to hold the reverse string
        for(int i = str.length() - 1; i >= 0; i--){ // for each index in str, starting at the last index and ending at 0...
            rev += str.charAt(i); // add the character at the index to the rev string
        }
        return rev; // return the reverse string
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in); // initialize the scanner from standard input
        System.out.print("Please enter the filename: "); // request the filename
        String inputFileName = stdin.nextLine(); // read the file name from standard input
        stdin.close(); // close standard input
        Scanner input = null; // initialize the scanner to null. This will allow us to try to set its value given that the input file exists. Without setting it to null, we will receive an error as the compiler cannot confirm that it will have a value after the following try block. We must declare this outside of the scope of the try block so that it exists after the try block.
        try{
            input = new Scanner(new File(inputFileName)); // try to create a scanner from the file object created with that file name. This will allow us to read from the file.
        }
        catch(FileNotFoundException e){ // if the file does not exist, then the above line will result in a FileNotFoundException, meaning the file does not exist
            System.out.println("Error opening file " + inputFileName); // print to the user that there was an error opening the file
            System.exit(0); // exit the program
        }
        ArrayList<String> list = new ArrayList<String>(); // initialize an empty ArrayList of strings
        while(input.hasNextLine()){ // for each line in the input file
            String line = input.nextLine(); // read the next line from the input file
            list.add(line); // add the line to the ArrayList of strings
        }
        input.close(); // close the scanner to the input file
        for(int i = 0; i < list.size(); i++){ // for each index in the ArrayList of strings
            PrintInfo(i, list.get(i)); // call the PrintInfo() method with the index and the string at that index as arguments
        }
    }
}
