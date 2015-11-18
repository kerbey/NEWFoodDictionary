import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
public class driverClass
{
	static Scanner input= new Scanner(System.in);
	static String recieptFile="food.txt",line=null,completeIngredients="",completeFood="";;
	static String recieptFile1 ="food1.txt";
	static int  maxCount, amount, i;
	static String food, foodsIngredients;
	static Scanner scanFile;
	static PrintWriter textStream;
	static binarySearchTree<String> tree= new binarySearchTree<>();
	static ingredientsLinkedList<String> ingredients= new ingredientsLinkedList<>();
	public static void main(String [] args)
	{
		BSTNode<String> bstn= new BSTNode<String>(null);
		textStream = createTextWrite(recieptFile);
		System.out.println("main");
		System.out.println("how many food items do you want to add?");
		amount=input.nextInt();
		for (i=0;i<amount;i++)
		{
			System.out.println("what food item would you like to buy?");
			food=input.next();
			input.nextLine();
			System.out.println("what is that food's ingredients?");
			foodsIngredients=input.nextLine();
			add(food, foodsIngredients);
		}
		textStream.close();
		scanFile=createTextRead(recieptFile);
		createTextRead();
		System.out.println();
		textStream = createTextWrite(recieptFile1);
		System.out.println("how many times do you want to search?");
		amount=input.nextInt();	
		for(int r=0;r<amount;r++)
		{
			System.out.println("which food would you like to search?");
			food = input.next();
			input.nextLine();
			System.out.println("And what are the food's ingredients do you want to search?");
			foodsIngredients= input.nextLine();
			tree.contains(food, foodsIngredients);
			if(line.contains(food+" "+foodsIngredients))
			{
				completeIngredients = completeIngredients+foodsIngredients;
				completeFood=completeFood+food;
				System.out.println("line is already in the file.");
			}
			else
			{
				completeIngredients = completeIngredients+foodsIngredients;
				completeFood=completeFood+line+"\n"+food;
				System.out.println("line is not added and will be added to the file");
				System.out.println("Please enter that food again..!");
				food=input.nextLine();	
				System.out.println("Please enter that ingredient again..!");
				foodsIngredients= input.nextLine();

				add(food, foodsIngredients);
				textStream.close();
				scanFile = createTextRead(recieptFile1);
				createTextRead();


				System.out.println("line that is returned after second reading is: "+ line);
				textStream = createTextWrite(recieptFile);

				add(completeFood ,completeIngredients);

				textStream.close();
			}
		}
		System.out.println("want to delete any food?");
		String answer=input.next();
		if (answer.contains("yes"))
		{
			System.out.println("what food?");
			food=input.next();
			input.nextLine();
			System.out.println("what ingredients?");
			foodsIngredients=input.nextLine();
			Gui g= new Gui();
			g.removeLineFromFile(recieptFile, food+" "+foodsIngredients);
			System.out.println("program now done");
		}
		else
		{
			System.out.println("program now done");
			System.exit(0);
		}
	}
	public static String createTextRead()
	{
		System.out.println("textfile method");		
		System.out.println("scanning the line");
		line = scanFile.nextLine();
		System.out.println("line createtextread= "+line);
		scanFile.close();
		return line;
	}
	public static void add(String Food, String FoodsIngredients)
	{
		line=(Food+" "+FoodsIngredients);
		textStream.println(line);
		ingredients.Add(FoodsIngredients);
		tree.add(Food);
	}
	public static PrintWriter createTextWrite(String S)
	{
		PrintWriter TStream=null;
		try
		{
			TStream= new PrintWriter(new FileOutputStream(S));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file in createTextWrite "+S.toString());
		}
		return TStream;
	}
	/**
	 * method made to read the file
	 * @param S will now make file readable for people
	 * @return textFile
	 */
	public static Scanner createTextRead(String S)
	{
		Scanner textFile=null;
		try 
		{
			textFile= new Scanner(new FileInputStream(new File(S)));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("file not found "+S.toString());
			System.out.println("or could not be opened. "+S.toString());
		}
		return textFile;
	}
}