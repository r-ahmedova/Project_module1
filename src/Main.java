import java.util.Scanner;

public class Main {
    public static char printHangmanImage(int lives) {
       if (lives == 4) {
           System.out.println("   _____  ");
           System.out.println("  |     | ");
           System.out.println("  |       ");
           System.out.println("  |       ");
           System.out.println("__|__     ");
       }
        if (lives == 3) {
            System.out.println("   _____ ");
            System.out.println("  |    () ");
            System.out.println("  | ");
            System.out.println("  | ");
            System.out.println("__|__");
        }
        if (lives == 2) {
            System.out.println("   _____  ");
            System.out.println("  |    () ");
            System.out.println("  |    |  ");
            System.out.println("  |       ");
            System.out.println("__|__     ");
        }
        if (lives == 1) {
            System.out.println("   _____  ");
            System.out.println("  |    () ");
            System.out.println("  |    /|\\ ");
            System.out.println("  |       ");
            System.out.println("__|__     ");
        }
        if (lives == 0) {
            System.out.println("   _____  ");
            System.out.println("  |     () ");
            System.out.println("  |    /|\\ ");
            System.out.println("  |     /\\");
            System.out.println("__|__       ");
        }
        return (char) lives;
    }
    public static void main(String[] args) {
        System.out.println("Starting game !");
        String[] words = new String[]{"Popovo", "Yambol", "Asenovgrad", "Silistra", "Pleven", "Sandanski", "Burgas", "Svishtov"};
        String notUsed = " a b c d e f g h i j k l m n o p q r s t u v w x y z ";
        String randomWord = words[(int) (Math.random() * words.length)];
        System.out.println("The word has " + randomWord.length() + " letters.");
        char[] letters = new char[randomWord.length()];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = '-';
        }
        int lives = 5;
        Scanner scan = new Scanner(System.in);
        while (lives > 0) {
            System.out.print("Lives : ");
            for (int i = 0; i < lives; i++) {
                System.out.print(" o ");
            }
            System.out.println();
            System.out.println("Input : ");
            String input = scan.nextLine();
            char letter = input.charAt(0);
            letter = Character.toLowerCase(letter);
            boolean isGuessCorrect = false;
            for (int i = 0; i < randomWord.length(); i++) {
                char let = randomWord.charAt(i);
                let = Character.toLowerCase(let);
                if (let == letter) {
                    letters[i] = let;
                    isGuessCorrect = true;
                }
            }
            if (!isGuessCorrect) {
                lives = lives - 1;
            }
            boolean isGameFinished = true;
            System.out.print("Word : ");
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == '-') {
                    isGameFinished = false;
                }
                System.out.print(letters[i]);
            }
            System.out.println();
            notUsed = notUsed.replace(letter, '.');
            System.out.println("Not used : " + notUsed);
            printHangmanImage(lives);
            if (isGameFinished) {
                System.out.println("You won!");
                break;
            }
        }
        if (lives == 0) {
            System.out.println("You lost ! The word was : " + randomWord);
        }
        System.out.println("Exiting game ");
    }
}