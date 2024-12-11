import java.util.Scanner;

public class HangGame {
	public static void main(String[] args) throws Exception {

		// HANG GAME

		Scanner scanner = new Scanner(System.in);

		String wordToGuess = "inteligencia";
		int maxTries = 5;
		int currentTries = 0;
		boolean isGuessed = false;

		char[] guessedLetters = new char[wordToGuess.length()];

		for (int i = 0; i < guessedLetters.length; i++) {
			guessedLetters[i] = '_';
		}
		while (!isGuessed && currentTries < maxTries) {
			boolean rightLetter = false;
			
			System.out.println("Palabra a adivinar: " + String.valueOf(guessedLetters) + " (" + wordToGuess.length() + " letras)");
			System.out.println("Introduce la letra por favor, te quedan << " + (maxTries - currentTries) + " >> intentos" );
			
			char letter = Character.toLowerCase(scanner.next().charAt(0));

			for (int i = 0; i < wordToGuess.length(); i++) {
				if (wordToGuess.charAt(i) == letter) {
					guessedLetters[i] = letter;
					rightLetter = true;
				}
			}

			// Si la letra pulsada es incorrecta
			if (!rightLetter) {
				currentTries++;
				if (currentTries < 5)
					System.out.println("Letra incorrectra, te quedan << " + (maxTries - currentTries) + " >> intentos.");
			}
			;

			// Si se ha ha adivinado la palabra completa
			if (String.valueOf(guessedLetters).equals(wordToGuess)) {
				isGuessed = true;
				System.out.println("FELICIDADES, has adivinado la palabra secreta.!! 👌 >> " + wordToGuess);
			}

		}

		// Si se han acabado los intentos
		if (!isGuessed) {
			System.out.println("GAME OVER, te has quedado sin intentos 🫤");
		}

		scanner.close();

	}
}
