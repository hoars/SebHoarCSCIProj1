import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Collections;

public class ReadFileExample
{
	public static HashMap<String,Integer> wcloud = new HashMap<String,Integer>();
	public void readIt(Scanner infile)
	{
		ArrayList<String> text = new ArrayList<String>();
		while (infile.hasNext())
		{
			String word = infile.next();
			text.add(word);			
		}
			
			for(String w: text)
			{
				Integer count = wcloud.get(w);
				if(count == null)
				{
					wcloud.put(w, 1);
				}
				else
				{
					wcloud.put(w, count+1);
				}
		    }
			Set<String> wkeys = wcloud.keySet();
			for(String s : wkeys)
			{
				System.out.println("Word: " + s + " Frequency: " + wcloud.get(s) );
			}
	}

	// public void sortIt(HashMap m)
	// {
	// 	List<Integer> wordfreq = new ArrayList<Integer>(m.values());

	// 	collections
	// }
	
	public void writeIt(PrintWriter outputFile, ArrayList<String> someWords)
	{
		for (String word: someWords) 
		{
			outputFile.println(word);
		}
	}

	public static void main(String [] args)
	{
		if (args.length < 1) 
		{
			System.out.println("You are a bad person. Give a filename to read");
		}
		else 
		{
			ReadFileExample mainObject = new ReadFileExample();
			File fileToRead = new File(args[0]);
			try {
				Scanner in = new Scanner(fileToRead);
				mainObject.readIt(in);
				/* Now demonstrate a PrintWriter for printing a file */
				//PrintWriter outFile = new PrintWriter("words.txt");
				//ArrayList<String> words = new ArrayList<String>();
				//words.add("how");
				//words.add("now");
				//words.add("brown");
				//words.add("cow");
				//mainObject.writeIt(outFile,words);
				//outFile.close();
			} catch(IOException e) {
				System.out.println("Uh oh, file error! "+ e);
			}

		}
	}
}			