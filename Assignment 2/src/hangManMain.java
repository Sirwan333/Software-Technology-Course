import java.io.FileNotFoundException;
import java.util.Scanner;
public class hangManMain {
	static boolean restart = false;
	public static void main(String[] args) throws FileNotFoundException {
				do {
				hangMan game = new hangMan();
				game.startHangMan(args);
				Scanner sc = new Scanner(System.in);
				System.out.println("What do you want to do? 1 or 2?");
				System.out.println("1.Strat Playing The Game");
				System.out.println("2.Quit The Game");
				String number = "";
				do {
					number = sc.next();
					
					if(number.equals("1"))
					{
						game.wordGuessing(false);
					}
					else if(number.equals("2"))
					{
						game.quit();
					}		
					else 
					{
						System.out.println("please choose a valid number");
					}
				}
				while((!number.equals("1")) && (!number.equals("2")));
				restart = game.restart();
			}while(restart == true);


	}
	
}


