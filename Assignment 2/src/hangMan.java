import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
public class hangMan {

	private int guessCount = 10;									
	private Object[] result;
	private String randomWord;
	private boolean isRestart = false;

	protected void startHangMan(String args[]) {
		randomWord = getWord(args);
	}

	private String getWord(String args[]) {
		File file = new File(args[0]);
		Random rand = new Random();
		int randomN = rand.nextInt(100);
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
	protected void wordGuessing(boolean isChar) {
		guessCount = 10;
		System.out.println("You have only 10 attempts to complete the game");
		System.out.println(randomWord);
		System.out.println("The word is "+randomWord.length()+" Characters");
		do {
			String userInput = sc.next();
			char in = userInput.charAt(0);
			isChar = Character.isLetter(in);
			if(userInput.length() == 1 && isChar == true)
			{
				guessCount--;										
				checkLetter(in);							
				System.out.println(+guessCount+" attempts left");		
			}
			else 
			{
				System.out.println("Only letters are possible"); 	
			}
		}while(guessCount != 0 && checkResult() == false);
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
			if(input.equals("1")) {
				isRestart = true;
				restart();
			}
			else if(input.equals("2")) {
				isRestart = false;
				quit();
			}
			else 
			{
				System.out.println("Only numbers 1 and 2");
			}
		}while(!input.equals("1") && !input.equals("2"));
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



