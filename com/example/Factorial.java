
//package com.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Change me.
 *
 * @author Spencer Scarlett
 * @version 1.0
 * @since 2024-04-24
 */

// Factorial class
public final class Factorial {

    /** Private constructor to prevent instantiation. */
    private Factorial() {
        throw new UnsupportedOperationException("Cannot instantiate");
    }

    /**
     * This is the main method.
     *
     * @param args Unused
     */
    public static void main(final String[] args) {

        try {
            // preps file access and writing/reading
            final File fileInput = new File("input.txt");
            final File fileOutput = new File("output.txt");
            final Scanner sc = new Scanner(fileInput);
            final FileWriter fW = new FileWriter(fileOutput);
            final PrintWriter write = new PrintWriter(fW);

            // reads each line of file
            while (sc.hasNextLine()) {
                final String StrLine = sc.nextLine();
                try {
                    // Parse the input as int
                    final int intLine = Integer.parseInt(StrLine);
                    // if the input is a number, check if less than 0, no -1!
                    if (intLine < 0) {
                        System.out.println("Input can't be less than 0");
                    } else {
                        // Call function.
                        final int factorialNum = FactorialNum(intLine);
                        write.println(intLine + "! is = to " + factorialNum);
                    }

                } catch (NumberFormatException Error) {
                    System.err.println("Error: " + StrLine + " is a invalid input!");
                }
            }

            // program finished
            System.out.println("Done");

            // closes resources
            write.close();
            sc.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
     * Performs factorial calculation
     *
     * @param n
     * @return factorial of inputped number
     */
    public static int FactorialNum(int n) {
        // if input number is equal to 0, return 1 (end) as 0! = 1
        if (n == 0) {
            return 1;
        }
        // performs the calculates factorial 
        else {
            return n * FactorialNum(n - 1);
        }
    }
}
