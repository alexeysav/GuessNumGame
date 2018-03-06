package tsi.javaCourses;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.net.SocketOptions;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        ArrayList<GameResult> leaderBoard = new ArrayList<>();
        try {
            String repeatAnswer;
            do {
                System.out.println("What is your name?");
                String name = scanner.next();
                GameResult r = doGame(name);
                if (r != null) {
                    leaderBoard.add(r);
                }
                System.out.print("Do you want to play once more? (yes / no): ");
                repeatAnswer = askAnswer();
            } while ("yes".equalsIgnoreCase(repeatAnswer));
        } catch (NoSuchElementException e) {
            System.out.println("User cancels the game :(");
        }
        for (GameResult r : leaderBoard) {
            System.out.println("User: " + r.userName + "\t" + "Attempts: " + r.attempts + "\t" + "Game length: " + r.gameTime);
        }
        System.out.println("Good bye!");
    }

    private static GameResult doGame(String userName) {
        int myNum = random.nextInt(100) + 1;

        System.out.println("Hello, " + userName);
        System.out.println("I think of number from 1 to 100. Try to guess it!");
        System.out.println("Spoiler " + myNum);

        GameResult result = new GameResult();
        result.userName = userName;

        long t1 = System.currentTimeMillis();

        for (int i = 1; i <= 3; i++) {
            System.out.print("Attempt " + i + ". Your guess: ");
            int userNum = askNumber();
            if (userNum > myNum) {
                System.out.println("Your number is greater than mine!");
            } else if (userNum < myNum) {
                System.out.println("Your number is less than mine!");
            } else {
                System.out.println("Congrats! You won in " + i + " attempts!");
                result.attempts = i;
                long t2 = System.currentTimeMillis();
                result.gameTime = t2 - t1;
                return result;
            }
        }
        System.out.println("Sorry, you lost, my friend! The number was " + myNum);
        return null;
    }

    static String askAnswer() {
        for (; ; ) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                return input;
            }
            System.out.println("Only YES or NO answers accepted");
        }
    }

    static int askNumber() {
        for (; ; ) {
            try {
                int num = scanner.nextInt();
                if (num <= 100 && num >= 1) {
                    return num;
                }
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("oops!");
            }
            System.out.print("Oh no! Wrong Number. Guess again.");
        }
    }
}
//    static int askNumber () {
//        int num;
//        do {
//            num = scanner.nextInt();
//            if (num > 100 || num < 1) {
//                System.out.print("Oh no! Wrong Number. Guess agann.");
//            }
//        } while (num > 100 || num < 1);
//        return num;
//    }
