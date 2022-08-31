import java.util.Scanner; // Needed for the Scanner class
import java.io.*;
import java.text.SimpleDateFormat; // Needed for date
import java.util.Date;// Needed for date

public class DorrisProgram6
{
	public static void main (String[] args) throws IOException
	{
		int userInput,
			index;
		float pupAge,
			  pupWeight;
		String pupName,
			   clientName,
			   pupBreed,
			   pupColor,
			   foodAns;
		Boolean pupFood = false;
		final int NUM_DOGS = 30;


		System.out.print("Select one of the following. \n" +
						 "1 to Check in Dog \n" +
						 "2 to Check out Dog \n" +
						 "3 to Exit \n");

		// Create a Scanner object for keyboard input.
      	Scanner input = new Scanner(System.in);

		// Create the array
      	DorrisDog[] dog = new DorrisDog[NUM_DOGS];

      	//new dog object name
      	DorrisDog dogClass;

      	System.out.print("\n");

      	System.out.print("Enter an option: ");
      	userInput = input.nextInt();
		input.nextLine();

		while (userInput != 3)
		{
			if (userInput == 1)
			{
				DorrisDog dog1 = new DorrisDog();
				if (dog1.getInstanceCount() <= 30)
				{
					System.out.print("Client's name: ");
					clientName = input.nextLine();

					System.out.print("Dog's name: ");
					pupName = input.nextLine();

					System.out.print("Dog's breed: ");
					pupBreed = input.nextLine();

					System.out.print("Dog's color: ");
					pupColor = input.nextLine();

					System.out.print("Dog's age(in years): ");
					pupAge = input.nextFloat();

					//Input validation for age
					if (pupAge <= 0.0)
					{
						System.out.print("\n");
						System.out.print("Age must be greater than 0.\n");
						System.out.print("Enter another age: ");
						pupAge = input.nextFloat();
					}

					System.out.print("Dog's weight(in pounds): ");
					pupWeight = input.nextFloat();

					//Input validation for weight
					if (pupWeight <= 0.0)
					{
						System.out.print("\n");
						System.out.print("Weight must be greater than 0.\n");
						System.out.print("Enter another weight: ");
						pupWeight = input.nextFloat();
					}

					input.nextLine();

					System.out.print("Did client bring dog food?(y/n): ");
					foodAns = input.nextLine();

					if (foodAns.equals("y") || foodAns.equals("Y"))
					{
						pupFood = true;
					}

					if (foodAns.equals("n") || foodAns.equals("N"))
					{
						pupFood = false;
					}

					System.out.print("\n");

					dogClass = new DorrisDog(pupName, clientName, pupAge, pupBreed,
											   pupWeight, pupFood, pupColor);

					dogClass.priceForDay(dogClass.determineSize(), pupWeight);

					System.out.printf("Total amount due: $%,.2f\n", dogClass.priceForDay(pupFood));

					index = dogClass.getInstanceCount() - 1;

					dog[index] = dogClass;

					dog[index].setDogName(pupName);
					dog[index].setOwnerName(clientName);
					dog[index].setBreed(pupBreed);
					dog[index].setColor(pupColor);
					dog[index].setAge(pupAge);
					dog[index].setWeight(pupWeight);
					dog[index].setFood(pupFood);
				}
				else
				{
					System.out.println("Sorry, the Doggy Day Care is at capacity.");
				}
			}

			if (userInput == 2)
			{
				int count = 0;
				System.out.print("Enter the client's name: ");
				clientName = input.nextLine();

				System.out.print("\n");

				//Search the array, find name, and set it to null
				//Then shift elements to close gaps
				for (int Index = 0; Index <= dog.length - 1; Index++)
				{
					if (dog[Index] != null && dog[Index].getOwnerName().equals(clientName))
					{
						System.out.print(dog[Index].getDogName() + " is checked out.\n");
						dog[Index] = null;
						DorrisDog.checkOutDog();
						count++;
					}
					else
					{
						dog[Index - count] = dog[Index];
					}
				}

				for ( int i = 1; i <= count; i++)
				{
					dog[dog.length - i] = null;
				}
			}

			System.out.print("\n");
			System.out.print("Enter another selection: ");
			userInput = input.nextInt();
			input.nextLine();
		}

		if (userInput == 3)
		{
			//Bonus points
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			File file = new File(dateFormat.format(date)+ "LatePickups" + ".txt");

			//create printWriter instance and open the file
			PrintWriter outputFile = new PrintWriter(file);
			//loop through array
			for (int INDEX = 0; INDEX <= dog.length - 1; INDEX++)
			{
				if (dog[INDEX] != null)
					{
						outputFile.println("Client Name: " + dog[INDEX].getOwnerName());
						outputFile.println("Dog Name: " + dog[INDEX].getDogName());
						outputFile.println("Dog Breed: " + dog[INDEX].getBreed());
						outputFile.println("Dog Color: " + dog[INDEX].getColor());
						outputFile.println("Dog Age: " + dog[INDEX].getAge());
						outputFile.println("Dog Weight: " + dog[INDEX].getWeight());

						if (dog[INDEX].getFood() == true)
						{
							outputFile.println("Food: Yes");
						}
						else
						{
							outputFile.println("Food: No");
						}

						outputFile.println();
					}
			}
			//close file
			outputFile.close();
			System.out.print("The doggy daycare is closed.");
			System.out.println();
		}
	}
}
