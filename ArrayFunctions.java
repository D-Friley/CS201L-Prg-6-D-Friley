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
        String trimmedLine = inputLine.trim();
        if (trimmedLine.isEmpty()) {
            outFile.println("\tMatrix contains empty values.");
            return -1;
        }
        String[] tokens = trimmedLine.split("\\s+");
        if (tokens.length < 2) {
            outFile.println("\tMatrix does not contain enough values.");
            return -1;
        }

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
        if (row < 1 || row > 5 || col < 1 || col > 5) {
            outFile.println("\tMatrix dimensions are out of bounds (1-5).");
            return -1;
        }
        //PART 2:  check that tokens.length has enough data for the matrix
        if (tokens.length < 2 + row * col) {
            outFile.println("\tMatrix does not contain enough values.");
            return -1;
        }

        if (tokens.length != 2 + row * col) {
            outFile.println("\tMatrix does not contain the expected number of values.");
            return -1;
        }

        arr1.clear();
        for (int i = 0; i < row; i++) {
            arr1.add(new ArrayList<Integer>());
        }

        // Starting at position 2, verify each matrix value.
        for (int i = 2; i < tokens.length; i++) {
            if (!isBinary(tokens[i])) {
                outFile.println("\tMatrix contains invalid values (not 0 or 1).");
                return -1;
            }
        }

        int tokenIndex = 2;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                arr1.get(r).add(Integer.parseInt(tokens[tokenIndex++]));
            }
        }

        return 1;
    }

    //PRE: accepts a 2-D ArrayList that has been loaded with proper values and the output file
    //POST: prints the 2-D ArrayList to the output file
    public static void printArrayList(ArrayList<ArrayList<Integer>> arr1,
                                      PrintWriter outFile) {
        //print 2-D ArrayList
        for (ArrayList<Integer> row : arr1) {
            for (Integer value : row) {
                outFile.print(value + " ");
            }
        
            outFile.println();
        }
        outFile.println();
    }

    //PRE:  Accepts one 2 dimensional ArrayList that has been loaded with proper values
    //      and the output file
    //POST: Deterimines if the number of rows = number of columns for this ArrayList
    //      if not, prints the message: "Cannot determine reflexive/symmetric: Invalid dimensions"
    //      if so, determines if the ArrayList is reflexive or symmetric and prints out a message for each
    public static void processArrayList(ArrayList<ArrayList<Integer>> arr1,
                                       PrintWriter outFile) {
        if (arr1.isEmpty()) {
            outFile.println("Rows and columns are not equal. Cannot determine reflexive/symmetric.");
            return;
        }

        if (arr1.size() != arr1.get(0).size()) {
            outFile.println("Rows and columns are not equal. Cannot determine reflexive/symmetric.");
            return;
        }

        boolean reflexive = true;
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i).get(i) != 1) {
                reflexive = false;
            }
        }
        if (reflexive) {
            outFile.println("\tMatrix is reflexive");
        } else {
            outFile.println("\tMatrix is not reflexive");
        }

        boolean symmetric = true;
        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr1.get(i).size(); j++) {
                if (arr1.get(i).get(j) != arr1.get(j).get(i)) {
                    symmetric = false;
                }
            }
        }
        if (symmetric) {
            outFile.println("\tMatrix is symmetric");
        } else {
            outFile.println("\tMatrix is not symmetric");
        }

        printArrayList(arr1, outFile);
    }

    //PRE:  Accepts two 2 dimensional ArrayLists that have been loaded with proper values
    //      and the output file
    //POST: Determine if the the ArrayLists are the same size
    //       if not, print the message: "Unable to add Matrices: Matrices have different sizes." to the output file & return
    //       if so, add the corresponding elements (row,col) from each ArrayList and print to output file
    public static void addTwoMatrices(ArrayList<ArrayList<Integer>> arr1,
                                      ArrayList<ArrayList<Integer>> arr2,
                                      PrintWriter outFile) {
        if (arr1.isEmpty() || arr2.isEmpty() || arr1.size() != arr2.size()
                || arr1.get(0).size() != arr2.get(0).size()) {
            outFile.println("\tUnable to add Matrices: Matrices have different sizes.");
            return;
        }

        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr1.get(i).size(); j++) {
                int sum = arr1.get(i).get(j) + arr2.get(i).get(j);
                outFile.print(sum + " ");
            }
            outFile.println();
        }
        outFile.println();
    }
}