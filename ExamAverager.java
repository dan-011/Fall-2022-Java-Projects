import java.util.ArrayList; // used to store exam scores
import java.util.Scanner; // used to read from standard input
public class ExamAverager {
    private static String Compare(double score, double average){ //  this method will produce the correct string comparing the score with the average
        if(average > score){
            return "Below average"; // if the score is less than the average, return "Below average"
        }
        else if (average < score) {
            return "Above average"; // if the score is greater than the average, return "Above average"
        }
        else{
            return "Average"; // otherwise (when the score equals the average), return "Average"
        }
    }

    public static void main(String[] args){
        System.out.println("This program computes the average of a list of (non-negative) exam scores."); // print title message
        Scanner stdin = new Scanner(System.in); // create the scanner for the standard input
        while(true){ // loop
            System.out.println("Enter all the scores to be averaged."); // request scores
            System.out.println("Enter a negative number after you have entered all the scores."); // instruct how to indicate being done entering scores
            ArrayList<Double> scores = new ArrayList<Double>(); // initialize an empty arraylist of doubles to hold the scores
            double sum = 0.0; // initialize double sum to 0
            int count = 0; // initialize int count to 0
            double score = 0.0; // initialize double score to 0
            while(true){ // loop
                score = stdin.nextDouble(); // read the score entered from standard input
                if(score < 0){ // if the score is negative...
                    if(count == 0){ // if no scores have been entered
                        System.out.println("No scores have been entered."); // instruct the user that no scores have been entered
                        System.out.println("Enter all the scores to be averaged."); // re-print the request for scores
                        System.out.println("Enter a negative number after you have entered all the scores."); // re-print the message on how to terminate entering scores
                        continue; // if no scores were entered, loop again
                    }
                    else{
                        break; // if scores were entered, break out of the loop
                    }
                }
                scores.add(score); // add the score from standard input to the arraylist of scores
                sum += score; // add the score to sum
                count++; // increment the count
            }
            double average = sum/count; // calculate the average
            System.out.println("The average is " + average); // print the average
            for(int i = 0; i < scores.size(); i++){
                System.out.println("Score #" + (i+1) + ": " + scores.get(i) + " -- " + Compare(scores.get(i), average)); // for each score in the arraylist of scores, print the score and use the compare function to get the string revealing how it compares to teh average
            }
            System.out.print('\n'); // newline formatting
            System.out.println("Want to average another exam?"); // offer to take another exam
            boolean askingYorN = true; // set boolean for when we are asking yes or no
            while(askingYorN){ // loop
                System.out.print("Enter yes or no: "); // request yes or no
                String another = stdin.nextLine(); // read from standard input
                if(another.length() == 0){
                    another = stdin.nextLine(); // if we didn't read anything, read again (it may read a blank)
                }
                if(another.equals("n") || another.equals("N")){ // if the string is n or N, we can stop looping and we can also exit the outer loop
                    askingYorN = false; // set askingYorN to false
                }
                else if(another.equals("y") || another.equals("Y")){ // if the string is y or Y, we want to stop the inner loop but continue the outer loop, as more scores will be entered
                    break; // break out of the inner loop
                }
                else{
                    System.out.println("Invalid Command"); // if something other than y, Y, n, or N was entered into standard input, it's an invalid command. Tell this to the user and loop again/
                    continue; // loop again
                }
            }
            if(!askingYorN){
                break; // if n or N was entered, break out of the loop
            }
        }
        stdin.close(); // close the scanner

    }
}