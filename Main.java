import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        String User_Num_2 = null;
        String User_Num_1 = null;
        int Computer_Guessed_Number = 0;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean inputValidity = true;

        do {
            inputValidity = true;
            try {

                System.out.print("Enter A Number to Start: ");
                User_Num_1 = scanner.next();
                System.out.print("Enter A Number to End: ");
                User_Num_2 = scanner.next();
                Integer.parseInt(User_Num_1);
                Integer.parseInt(User_Num_2);

                if (Integer.parseInt(User_Num_1) > Integer.parseInt(User_Num_2)) {
                    System.out.println("The start number should be always lower than the end number");
                    inputValidity = false;
                }

            } catch (Exception e) {
                System.out.println("Invalid Input Try Again");
                inputValidity = false;
            }


        } while (!inputValidity || Objects.equals(User_Num_1, User_Num_2));

        String new_Number1 = User_Num_1;
        String new_Number2 = User_Num_2;
        String UserDecision = null;
        boolean UserDecisionValidity = true;
        Computer_Guessed_Number = random.nextInt(Integer.parseInt(new_Number1), Integer.parseInt(new_Number2));
//        Computer_Guessed_Number = Math.round(Integer.parseInt(new_Number1)+ Integer.parseInt(new_Number2))/2;
        int Comp_Try = 0;

        boolean CompAnsValidity;
        do {
            try {
                System.out.println("CGN: " + Computer_Guessed_Number);
                System.out.print("The number " + Computer_Guessed_Number + " is (Less = 1, greater = 2, equal = 3)than your guess: ");
                UserDecision = scanner.next();
                Integer.parseInt(UserDecision);
            } catch (Exception e) {
                System.out.println("Please Enter a valid Answer!");
                UserDecisionValidity = false;
            }

            CompAnsValidity = false;

            try {
                switch (Integer.parseInt(UserDecision)) {
                    case 1 -> {
                        new_Number1 = String.valueOf(Computer_Guessed_Number);
//                        System.out.println(new_Number1+"  "+new_Number2+"  "+Computer_Guessed_Number);
                        Computer_Guessed_Number = random.nextInt(Integer.parseInt(new_Number1), Integer.parseInt(new_Number2));
//                        Computer_Guessed_Number = Math.round(Integer.parseInt(new_Number1)+ Integer.parseInt(new_Number2))/2;
                        CompAnsValidity = false;
//                        System.out.println("Case 1");
                        Comp_Try++;
                        break;
                    }
                    case 2 -> {
                        new_Number2 = String.valueOf(Computer_Guessed_Number);
//                        System.out.println(new_Number1+"  "+new_Number2+"  "+Computer_Guessed_Number);
                        Computer_Guessed_Number = random.nextInt(Integer.parseInt(new_Number1), Computer_Guessed_Number);
//                        Computer_Guessed_Number = Math.round(Integer.parseInt(new_Number1)+ Integer.parseInt(new_Number2))/2;
//                        System.out.println("Case 2");
                        Comp_Try++;
                        CompAnsValidity = false;
                    }
                    case 3 -> {
                        System.out.println("Computer got the right answer");
                        CompAnsValidity = true;
                    }
                    default -> {
                        System.out.println("Please Enter an answer from the given options");
                        UserDecisionValidity = false;
                    }
                }
            }
            catch (IllegalArgumentException e){
                System.out.println("Please do not give invalid answer");
                break;
            }

            if (Comp_Try == 7){
                System.out.println("Computer Lost The Match");
                break;
            }

            if (Integer.parseInt(new_Number1)-Integer.parseInt(new_Number2) == 1 && !CompAnsValidity){
                System.out.println("Do not cheat with computer");
                break;
            }


        } while (!UserDecisionValidity || !CompAnsValidity);

        System.out.println("Done");
    }

}