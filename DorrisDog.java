public class DorrisDog
{
	private String dogName,
				   ownerName,
				   dogBreed,
				   dogColor,
				   size,
				   lifeStage;
	private static float age,
					     weight;
	private static double total;
	private boolean food;
	private static int instanceCount;

	//no args constructor
	public DorrisDog()
	{
		instanceCount++;
	}


	//construstor that takes in all info
	public DorrisDog(String pupName, String clientName, float pupAge, String pupBreed,
							  float pupWeight, boolean pupFood, String pupColor)
	{
		dogName = pupName;
		ownerName = clientName;
		age = pupAge;
		dogBreed = pupBreed;
		weight = pupWeight;
		food = pupFood;
		dogColor = pupColor;
		total = 0.0;
		age = 0;
		lifeStage = "";
		size = "";
	}

	//Gets and sets for all fields
	public int getInstanceCount()
	{
		return instanceCount;
	}

	public String getDogName()
	{
		return dogName;
	}

	public String getOwnerName()
	{
		return ownerName;
	}

	public String getBreed()
	{
		return dogBreed;
	}

	public String getColor()
	{
		return dogColor;
	}

	public String getSize()
	{
		return size;
	}

	public String getLifeStage()
	{
		return lifeStage;
	}

	public float getAge()
	{
		return age;
	}

	public float getWeight()
	{
		return weight;
	}

	public double getTotal()
	{
		return total;
	}

	public boolean getFood()
	{
		return food;
	}

	public void setDogName(String pupName)
	{
		dogName = pupName;
	}

	public void setOwnerName(String clientName)
	{
		ownerName = clientName;
	}

	public void setBreed(String pupBreed)
	{
		dogBreed = pupBreed;
	}

	public void setColor(String pupColor)
	{
		dogColor = pupColor;
	}

	public void setAge(float pupAge)
	{
		age = pupAge;
	}

	public void setWeight(float pupWeight)
	{
		weight = pupWeight;
	}

	public void setFood(boolean pupFood)
	{
		food = pupFood;
	}

	public String determineLifeStage()
	{
		if (age > 1)
		{
			lifeStage = "puppy";
		}
		else if (age >= 1 && age <= 3)
		{
			lifeStage = "adolescent";
		}
		else if (age >= 4 && age <= 8)
		{
			lifeStage = "adult";
		}
		else if (age < 8)
		{
			lifeStage = "senior";
		}

		return lifeStage;
	}

	public String determineSize()
	{
		if (weight >= 0 && weight <= 10)
		{
			size = "small";
		}
		else if (weight >= 11 && weight <= 30)
		{
			size = "medium";
		}
		else if (weight >= 31 && weight <= 100)
		{
			size = "large";
		}
		else if (weight > 100)
		{
			size = "xLarge";
		}

		return size;
	}

	public static void checkOutDog()
	{
		instanceCount--;
	}

	public static double priceForDay(String size, float pupWeight)
	{
		if (size.equals("small") || size.equals("medium"))
		{
			total = 45;
		}
		else if (size.equals("large") || size.equals("xLarge"))
		{
			total = 45 + (0.1 * weight);
		}
		return total;
	}

	public static double priceForDay(boolean food)
	{
		if (food)
		{
			total += 5;
		}
		else
		{
			total = total;
		}
		return total;
	}
}
