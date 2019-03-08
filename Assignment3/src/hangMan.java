import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
public class hangMan {

	private int guessCount = 10;									
	private Object[] result;
	private String randomWord;
	private boolean isRestart = false;
	private char in;
	protected void startHangMan(String args[]) {
		randomWord = getWord(args);
	}

	private String getWord(String args[]) {
		File file = new File(args[0]);
		Random rand = new Random();
		int randomN = rand.nextInt(50);
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext() && randomN != 0) 
			{
				randomWord = sc.next();
				randomN--;
				
			}
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		result = new Object[randomWord.length()];					
		for(int i = 0; i <= result.length-1; i++) 
		{
			result[i] = "-";
		}
		return randomWord;
	}

	protected void quit() {
		System.out.println("Game is Over");
		System.exit(0);
	}

	Scanner sc = new Scanner(System.in);
	private boolean validRestart;
	protected void wordGuessing(boolean isChar) {
		boolean isValidChar = false;
		guessCount = 10;
		System.out.println("You have only 10 attempts to complete the game");
		System.out.println(randomWord);
		System.out.println("The word is "+randomWord.length()+" Characters");
		do {
			
			String userInput = sc.next();
			isValidChar = isValidInput(userInput);
			if(isValidChar)
			{
				guessCount--;										
				checkLetter(in);							
				System.out.println(+guessCount+" attempts left");		
			}
			if(!isValidChar)
			{
				System.out.println("Only letters are possible"); 	
			}

		}while(isValidChar == false || (guessCount != 0 && checkResult() == false));
		

		if(checkResult() == true) 
		{					
			System.out.println("Congratulation You Win");
		}
		else 
		{
			System.out.println("Sorry You Lose");
			System.out.println("The correct word was : "+randomWord);
		}

		System.out.println("Restart the game");
		System.out.println("1. Yes");
		System.out.println("2. No");
		String input = "";
		do {
			input = sc.next();
			isRestart = isValidRestart(input);
			if(!isRestart && validRestart == true)
				quit();	
			if (isRestart == false && validRestart == false)
				System.out.println("Only numbers 1 and 2");
		}while(isRestart == false);
	}

	protected boolean isValidRestart(String input) {
		if(input.equals("1"))
			return true;
		if(input.equals("2"))
		{
			return true;
		}
		else return false;
	}

	boolean isValidInput(String userInput) {
		char in = userInput.charAt(0);
		boolean isChar = Character.isLetter(in);
		if(userInput.length() == 1 && isChar == true)
		return true;
		else
			return false;
	}

	protected boolean restart() {
		return isRestart;
	}

	private boolean checkResult() {
		for(Object o : result) 
		{
			if(o.equals("-")) 
			{
				return false;
			}
		}
		return true;
	}

	private void checkLetter(char userInput) {
		for(int index = 0; index < randomWord.length() ; index++)
		{
			Character ch = randomWord.charAt(index);
			if(ch.equals(userInput)) 
			{
				result[index] = userInput;
			}
		}
		System.out.print("Your Progress: ");
		for(Object ch : result) 
			System.out.print(ch);
		System.out.println();	
	}


}



