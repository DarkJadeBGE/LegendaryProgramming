import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.*;
import java.util.Scanner;

class QuickSearch2
{
	public static Scanner keyboard = new Scanner(System.in);

	public static boolean validFileName;

	public static boolean fileNameValidator(String fileNameIn)
	{
		try
		{
			File file = new File(fileNameIn);
			FileReader fileReader = new FileReader(file);
			fileReader.close();
			return true;
		}
		catch (IOException e)
		{
			System.out.println("You have entered an invalid file name.");
			return false;
		}
	}

	public static String[] fileArray(String fileNameIn, int lengthIn)
	{
		int index = 0;
		String[] inputArray = new String[lengthIn]; // Creates an array for putting the text file into

		try
		{
			File file = new File(fileNameIn);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			// Puts each line into the array.
			while ((line = bufferedReader.readLine()) != null)
			{
				inputArray[index] = line;
				index++;
			}
			fileReader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return inputArray;
    }

	public static int numberOfLines(String fileNameIn)
	{
		int arrayLength = 0;
		try
		{
			File file = new File(fileNameIn);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null)
			{
				arrayLength++;
			}
			fileReader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return arrayLength;
	}


	public static void checkString(String stringIn, String[] arrayIn, int lengthIn)
	{
		for (int i=0; i < lengthIn; i++)
		{
			if (arrayIn[i].contains(stringIn))
			{
				System.out.println( arrayIn[i]); //i+1 + " " +
				while (arrayIn[i+1].charAt(0) == ' ')
				{
					System.out.println( arrayIn[i+1]);//i+2 + " " +
					i++;
				}

			}
			else{}
		}
	}

	public static void quickSearchDriver()
	{
		String fileName = "";
		String searchFor = "";
		char quit = 'y';
		char quit2 = 'y';
		int length=0;
		boolean validFileName = false;
		String dummy;

		while (quit == 'y' || quit == 'Y')
		{
			// This checks your filename and keeps prompting you until you pick a correct one.
			while (!validFileName)
			{

			System.out.println("Please enter a filename you want to lookup: ");
			fileName = keyboard.nextLine();
			if (fileName.length() ==0)
			{
				return;
			}
			else
			{
				validFileName = fileNameValidator(fileName);
			}
			}
			// This finds the number of lines in your file and sets the array up accordingly. 
			// (Change to a linked list or stack in future implementations.)
			length = numberOfLines(fileName);

			// The user interface. Gives simple instructions.
			while(quit2 == 'y' || quit2 == 'Y')
			{
				System.out.println("Please enter the word you are searching for: ");
				searchFor = keyboard.nextLine();
				if (searchFor.length() == 0)
				{}
				else{
				String[] myArray = fileArray(fileName, length);
				System.out.println("");
				checkString(searchFor,myArray, length);
				System.out.println("");
				System.out.println("Would you like to continue searching the file? (press y or Y for yes.) Press any other key and enter to quit");
				dummy = keyboard.nextLine();
				quit2 = dummy.charAt(0);
				}
			}
			System.out.println("");
			System.out.println("Would you like to search another file? (press y or Y for yes.) Press any other key and enter to quit");
			dummy = keyboard.nextLine();
			quit = dummy.charAt(0);
			validFileName = false;
			quit2 = 'y';
		}
	}

	public static void main(String args[])
	{
		quickSearchDriver();
	}
}
