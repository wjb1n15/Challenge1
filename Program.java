import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;

public class Program
{
	public static void main(String[] args)
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));								//new object 'in' to read lines from user input
		String input = new String();																			//to hold user input
		System.out.print("Username: ");																			//prompt user for input
		try {																									//try/catch blocks to make BufferedReader work
			input = in.readLine();																				//get user input
			String urlStr = "http://www.ecs.soton.ac.uk/people/" + input;										//add it to the end of the URL
			URL urlObj = new URL(urlStr);																		//new URL object for getting HTML
			BufferedReader htmlReader = new BufferedReader(new InputStreamReader(urlObj.openStream()));			//open an input stream from urlObj and attach it to a new BufferedReader through an InputStreamReader
			String htmlLine = new String();																		//for storing the relevant line of HTML
			do {
				htmlLine = htmlReader.readLine();																//load a new line of HTML into htmlLine
			} while (!htmlLine.contains("property=\"name\""));													//repeat until the line contains property="name"
			String name = htmlLine.substring(htmlLine.indexOf("property=\"name\"") + 16);						//new string to hold the part of the line starting with the name, 16 = number of characters after the p in property that the name starts
			name = name.substring(0, name.indexOf("<"));														//only keep what's before the next <
			System.out.println(name);																			//print name to user
		} catch (IOException ioEx) {																			//if something goes wrong
			System.out.println("Something went wrong.");														//let me know
		}
	}
}