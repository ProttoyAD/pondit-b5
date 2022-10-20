package src.conditions;

import java.util.Scanner;

public class ConditionalStatements {



    public static void main(String[] args) {

        int _50K = 50000;
        int _100k = 100000;

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        String customerName = sc.nextLine();
        System.out.println("Are you a member?");

        var isMemberAnswer =  sc.nextLine();

        var abc = 9;

        boolean isMember = "yes".equalsIgnoreCase(isMemberAnswer) ;
//        isMember = isMemberAnswer.equalsIgnoreCase("yes") ;

        System.out.println("How much did you purchase in last month?");
        double amountPurchased = sc.nextDouble();


        boolean conditionMatched = isMember || amountPurchased >= _50K;


        // If the customer is a member
        // And purchased over 50k

        var greeting = "Congratulations!!!";

        if (isMember) {
            if (amountPurchased >= _50K && amountPurchased < _100k) {
                System.out.println(greeting);
                System.out.println("You have received 20% discount on your next month purchase");
            }

            if (amountPurchased >= _100k) {
                System.out.println(greeting);
                System.out.println("You have received 40% discount on your next month purchase");
            } else {
                System.out.println("Sorry, we couldn't give you a discount on next month purchase!!");
            }
        }
    }
}
