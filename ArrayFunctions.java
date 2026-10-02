import java.io.PrintWriter;
import java.util.ArrayList;

public class ArrayFunctions{
    //PRE:  accepts a string
    //POST: determines that each character in the string is a digit
    //      returns true if so, false if not
    public static boolean isDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!(Character.isDigit(str.charAt(i))))
                return false;
        }
        return true;
    }

    //PRE: accepts a string
    //POST: verifies that the string only contains 0s and 1s
    //      returns true if so, false if not
    public static boolean isBinary(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0' || str.charAt(i) == '1')
                continue;
            else
                return false;
        }
        return true;
    }

    //PRE: This function will accept the input string, an empty 2-D ArrayList, and the output file
    //POST: if ‘valid’ return 1, if not print a message and return -1
	//      if ‘valid’ load the ArrayList with the values in the input string and return 1

    public static int verifyArrayList(String inputLine, 
                                      ArrayList<ArrayList<Integer>> arr1, 
                                      PrintWriter outFile) {
        String[] tokens = inputLine.trim().split(" ");

        //test to make sure there are at least 2 tokens for row & col
 
        
        //use position [0] for number of rows and position[1] for number of cols
        int row, col;
        try {
            row = Integer.parseInt(tokens[0]);
            col = Integer.parseInt(tokens[1]);
        } catch (NumberFormatException e) {
            outFile.println("\tMatrix contains invalid row/col values.");
            return -1;
        }

        //PART 2:  check the row & col values are between 1 and 5 (inclusive) 
        //PART 2:  check that tokens.length has enough data for the matrix


        //starting at position 2 in tokens, read remaining characters
        //see lecture example for loading individual entries in tokens into the ArrayList
        //PART 2:  verfiy that each value in token is isBinary
         

        return 0;
    }


    //PRE: accepts a 2-D ArrayList that has been loaded with proper values and the output file
    //POST: prints the 2-D ArrayList to the output file
    public static void printArrayList(ArrayList<ArrayList<Integer>> arr1, 
                                      PrintWriter outFile) {
        //print 2-D ArrayList

    }

    
    //PRE:  Accepts one 2 dimensional ArrayList that has been loaded with proper values
    //      and the output file
    //POST: Deterimines if the number of rows = number of columns for this ArrayList
    //   	if not, prints the message: "Cannot determine reflexive/symmetric: Invalid dimensions"
    //  	if so, determines if the ArrayList is reflexive or symmetric and prints out a message for each  

    public static void processArrayList(ArrayList<ArrayList<Integer>>  arr1, 
                                                  PrintWriter outFile) {
   
        //If the number of rows != number of columns, print message & return

        //Check for Reflexive
        
        //Check for Symmetric
        
        //Print results
        
    }

    //PRE:  Accepts two 2 dimensional ArrayLists that have been loaded with proper values
    //      and the output file
    //POST: Determine if the the ArrayLists are the same size
    //       if not, print the message: "Unable to add Matrices: Matrices have different sizes." to the output file & return
    //       if so, add the corresponding elements (row,col) from each ArrayList and print to output file 
    //
    public static void addTwoMatrices(ArrayList<ArrayList<Integer>>  arr1, 
                                      ArrayList<ArrayList<Integer>>  arr2,
                                      PrintWriter outFile) {
        //verify if matrices can be added 
        //If the matrix sizes do not match print message & return

        //add corresponding elements & prints the result to the output file
 
    }
}