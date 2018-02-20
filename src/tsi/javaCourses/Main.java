package tsi.javaCourses;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("I think of number from 1 to 100. Try to guess it!");

        int myNum = random.nextInt(100) + 1;
        System.out.println(myNum);

        for (int i = 1; i < 5; i++) {

            int userNum = scanner.nextInt();
            System.out.println("Atempt " + i + "\n" + userNum);

            if (myNum > userNum) {
                System.out.println("My number is bigger ");
            } else if (myNum < userNum) {
                System.out.println("My number is smaller ");
            } else if (myNum == userNum) {
                System.out.println("You've guessed it right!");
            }
        }
        System.out.println("Last atempt");
        int userNum = scanner.nextInt();

        if (myNum > userNum) {
            System.out.println("My number is bigger by " + (myNum - userNum));
        } else if (myNum < userNum) {
            System.out.println("My number is smaller by " + (userNum - myNum));
        } else if (myNum == userNum) {
            System.out.println("You've guessed it right!");
        }
    }
}
