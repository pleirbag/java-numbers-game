import java.math.MathContext;

public class GuessGame {
	public static void main(String[] args) {
		guessingGame();
	}

	public static void guessingGame(){
		int nbrToGuess = (int)(Math.random() * 100) + 1;
		int nbrOfGuesses = 3;
		int guessInt = -1;
		System.out.println("Hello and welcome to the number guessing game \nyou have " + nbrOfGuesses +
				" tries to guess a random number from 1-100\nPlease input your number in the console:\n");
		while (nbrOfGuesses > 0) {
			String guess = System.console().readLine();
			try {
				guessInt = Integer.parseInt(guess);
			}
			catch (NumberFormatException e) {
				guessInt = -1;
			}
			if (guessInt < 1 || guessInt > 100){
				System.out.println("Sorry, but thats not a valid guess =( \nPlease try a number between 1-100");
				nbrOfGuesses++;
			} else if ( guessInt == nbrToGuess) {
				System.out.println("Congratulations, " + guessInt + " was the correct number!\nWould you like to play again? y/n");
				String yesOrNo = System.console().readLine();
				if (yesOrNo.equals("y") || yesOrNo.equals("yes") || yesOrNo.equals("Y") || yesOrNo.equals("Yes") || yesOrNo.equals("YES")) {
					nbrOfGuesses = 0;
					guessingGame();
				} else {
					System.out.println("See you next time!");
					System.exit(0);
				}
			} else if (guessInt < nbrToGuess) {
				System.out.println("Sorry, your guess was smaller than the solution");
			} else
				System.out.println("Sorry, your guess was bigger than the solution");
			nbrOfGuesses--;
		}
		System.out.println("Sorry, out of guesses, the correct number was " + nbrToGuess + "\nBetter luck next time");
	}
}
