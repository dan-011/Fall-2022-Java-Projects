import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter; // this import and all above imports are the ones required to access the objects used in this program
public class PrintOdd {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in); // initialize the scanner
        String inputFileName; // declare the string for the input file name
        String outputFileName; // declare the string for the output file name
        System.out.print("Enter the name of the input file: "); // prompt the user
        inputFileName = stdin.nextLine(); // read the input file name from standard input
        Scanner input = null; // initialize the scanner to null. This will allow us to try to set its value given that the input file exists. Without setting it to null, we will receive an error as the compiler cannot confirm that it will have a value after the following try block. We must declare this outside of the scope of the try block so that it exists after the try block.
        try{
            input = new Scanner(new File(inputFileName)); // try to create a scanner from the file object created with that file name. This will allow us to read from the file.
        }
        catch(FileNotFoundException e){ // if the file does not exist, then the above line will result in a FileNotFoundException, meaning the file does not exist
            System.out.println("Error opening input file " + inputFileName); // print to the user that there was an error opening the file
            System.exit(0); // exit the program
        }

        System.out.print("Enter the name of the output file: "); // prompt the user for the output file
        outputFileName = stdin.nextLine(); // read the output file name from standard input
        PrintWriter output = null; // initialize the PrintWriter object to null. This way the PrintWriter object will exist after the try block. We must set it to null so that we can ensure to the compiler that the variable will have a value after the try block.
        try{
            output = new PrintWriter(outputFileName); // Attempt to create the PrintWriter object with the output file name. This will allow us to create and write to the output file.
        }
        catch(FileNotFoundException e){ // if there was a FileNotFoundException generated when creating the PrintWriter object, then we would enter the catch block. This is not expected as PrintWriter should create an empty file under that name.
            System.out.println("Error opening output file " + outputFileName); // if an error occurred, print that information to the user
            System.exit(0); // exit the program
        }

        String line; // declare the string that will handle each line in the input file.
        String writeLine = ""; // initialize the empty string that will be used as a buffer to build each line in the output file.
        char c; // declare the char that will handle each character from the input file
        boolean beforeSecond = true; // this boolean keeps track of (is true) when we are before the second word in the line take from the input file. This is used to determine when we can begin building the string that will be written to the output file. This allows us to avoid the first word in the input file.
        while(input.hasNextLine()){ // while the input file has a line to read (while it is not empty)
            line = input.nextLine(); // read the next line from the input file and store it in line
            String trimmed = line.trim(); // trim the line from input, removing any leading or trailing whitespace
            String arr[] = trimmed.split(" "); // break the trimmed input line down into an array of words
            String word = arr[0]; // get the first word in the line
            int index = line.indexOf(word); // find the index of the first word in the line
            index += word.length(); // Add to the index the length of the word. This is all done to set our start index in the line to be after the first word so as we build our buffer to write to the output file, we can start after the first word, excluding the first word in the line in the input file from the output file.
            for(int i = index; i < line.length(); i++) { // starting at the index after the first word, do a for loop incrementing i until we reach the length of the string
                c = line.charAt(i); // c gets the character at index i
                if(beforeSecond && c != ' ') { // if we are before the second word but the character is not a space, then we have entered the second word. So we can set our beforeSecond boolean to false.
                    beforeSecond = false; // set beforeSecond to false since we have entered the second word.
                }
                if(!beforeSecond){ // if beforeSecond is false, meaning we are either inside of or past the second word in line, then add the character c to the buffer that will be written to the output file.
                    writeLine += c; // add the character to the writeLine buffer
                }
            }
            output.println(writeLine); // write the writeLine buffer to the output file
            writeLine = ""; // reset the buffer to be empty for the next iteration
            beforeSecond = true; // reset the beforeSecond boolean to be false for the next iteration, since we know that for every iteration we are starting before the second word.
        }

        input.close(); // close the Scanner object
        output.close(); // close the PrintWriter object
    }
}
