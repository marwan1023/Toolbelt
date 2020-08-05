package misc;
/**
	* @author Marcus Johnson
	* @date September 11, 1999
	* @project Pascal's Triangle
	* @instructions Write a Java program that will generate Pascal's triangle
*/


import corejava.Console;
import corejava.Format;

public class Johnson1
{

// Define function that calculates the factorials for Pascal's triangle
	private static long Calculation (int large, int number)
	{

		//interface Enumeration;
		// Declare variables used in the calculation of factorials
		long x = 1;
		int y;
		//Enumeration condition = {bad,good};
		// Create for loop that is responsible for the calculation of the factorials
		for (y = 1;y <= number;y++)
		{
			x = x * large / y;
			large--;
		}
		return x;
	}

// Define function that allocates, fills , and prints out the triangular array for Pascal's triangle

	public static void calculatePascal (int rows)
	{
		// Declare variables used in arrays
		int n;
		int r;
		char z = 0;
		int space = 19;

		// Create loop that allocates the triangular array
		long[][] answers = new long[rows + 1][];
		for (n = 0;n <= rows;n++)
		{
			answers[n] = new long[n + 1];
		}

		// Create loop that fills the triangular array
		for (n = 0; n < answers.length; n++)
			for (r = 0;r < answers[n].length;r++)
			answers[n][r] = Calculation(n, r);

		// Create loop that prints the triangular array
		for (n = 0;n < answers.length;n++)
		{
			for (int i = space;i > 0;i--)
				Format.printf("%2c", z);
			for (r = 0;r < answers[n].length;r++)
				Format.printf("%4d", answers[n][r]);
				System.out.println();
			    space = space - 1;
		}
	}

// Define main function

	public static void main(String[] args)
	{
		// Define variable that indicates the desired number of lines the user wants
		int lines;
		// Define variable that handles user options
		int option;

		// Create printed welcome statement
		System.out.println("Welcome to Pascal's Triangle!");
		System.out.println("By: Marcus Johnson");
		// Read in option
		option = Console.readInt
		("Press 1 for a triangle or 2 to end the program: ");
		// Create loop that will request infinite triangles for the user after they request their first one
		while (option == 1 || option == 2)
		{
			if (option == 1)
			{
				// Read in number of lines
				lines = Console.readInt
				("Please enter number of lines (up to 30): ");
				System.out.println("\n");
				System.out.println("If you want to exit, press Control and C simultaneously.\n");
				calculatePascal (lines);
				System.out.println("Thank you for using Pascal's triangle!");
			}
			else if (option == 2)
			{
				System.out.println("Thank you for using Pascal's triangle!");
				break;
			}
		}
	}
}







