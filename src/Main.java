import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting game !");
        String[] words = new String[] { "Popovo", "Yambol" , "Asenovgrad" , "Silistra" , "Pleven" , "Sandanski" , "Burgas" , "Svishtov" };
        String notUsed = " a b c d e f g h i j k l m n o p q r s t u v w x y z " ;
        String randomWord = words[(int) (Math.random() * words.length)];
        System.out.println("The word has " + randomWord.length() + " letters.");
        char[] letters = new char[randomWord.length()];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = '.';
        }
        int lives = 3;
        Scanner scan = new Scanner(System.in);
        while (lives > 0) {
            System.out.print("Lives : ");
            for (int i = 0; i < lives; i++) {
                System.out.print(" o ");
            }
            System.out.println();
        }
    }
}