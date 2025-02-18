import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hangaman_game {

    // intializing array for collecting words it will be string array and also how many attempts cna
    // player have
    private static final String[] words = {"java", "python", "kotlin", "go"};
    private static final int MAX_ATTEMPTS = 6;

    private String wordToGuess;
    private ArrayList<Character> guessedWord;
    private ArrayList<Character> guessedLetters;
    private int attemptsLeft;

    public hangaman_game() {
        wordToGuess = words[new Random().nextInt(words.length)];
        guessedLetters = new ArrayList<>();
        guessedWord = new ArrayList<>();
        attemptsLeft = MAX_ATTEMPTS;

        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord.add('_');
        }
    }

    private void displayGameState() {
        System.out.println("\nword :" + guessedWord);
        System.out.println("Guessed letters : " + guessedLetters);
        System.out.println("attemptsLeft : " + attemptsLeft);
    }

    private void updateGuessedWord(char guess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedWord.set(i, guess);
            }
        }
    }

    private void endGame() {
        if (!guessedWord.contains('_')) {
            System.out.println("you have won the game : " + wordToGuess);
        } else {
            System.out.println("you lost awwwwwwwwww!!!");
        }
    }

    public void play() {
        Scanner game = new Scanner(System.in);

        while (attemptsLeft > 0 && guessedWord.contains('_')) {
            displayGameState();
            System.out.println("enter letter : ");
            char guess = game.next().charAt(0);

            if (!Character.isLetter(guess)) {
                System.out.println("enter valid letter to play the game");
                continue;
            }
            if (guessedLetters.contains(guess)) {
                System.out.println("you have already use guessed this letter try something else :");
                continue;
            }

            guessedLetters.add(guess);
            if (wordToGuess.indexOf(guess) != -1) {
                updateGuessedWord(guess);
            } else {
                attemptsLeft--;
                System.out.println("wrong guess, attemptsLeft : " + attemptsLeft);
            }
        }

        endGame();
        game.close();
    }

    public static void main(String[] args) {

        new hangaman_game().play();
    }
}
