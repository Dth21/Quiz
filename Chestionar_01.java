import java.util.Scanner;
import java.util.ArrayList;
import java.util.Coleections;
import java.util.Collections;

public class Chestionar_01{
    public static void main(String[] dth21){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";

        int isReady = 1;

        while(isReady>0){
            String[][] questions = new String[5][5];
            int rows = 5;
            int columns = 5;
            int correct = 0;
            int wrong = 0;
            int qnmr = 1; //question number in output
            int a = 0;

            questions[0][0] = "Who is the oldest person in Bible?"; // first question
            questions[0][1] =  "a. Moises";
            questions[0][2] = "b. Jesus";
            questions[0][3] = "c. Methuselah";
            questions[0][4] = "c"; // right answer

            questions[1][0] = "When was the moon created?"; // second question
            questions[1][1] = "a. Second Dary";
            questions[1][2] = "b. Forth Day";
            questions[1][3] = "c. Sixth Day";
            questions[1][4] = "b"; // right answer

            questions[2][0] = "What was God’s sign to Noah that he would never destroy the earth again?"; // third question
            questions[2][1] = "a. rainbow";
            questions[2][2] = "b. cloud";
            questions[2][3] = "c. fire from heaven";
            questions[2][4] = "a"; // right answer

            questions[3][0] = "Through what did God speak to Moses in the desert?"; // forth question
            questions[3][1] = "a. a donkey";
            questions[3][2] = "b. a burning bush";
            questions[3][3] = "c. a sheep";
            questions[3][4] = "b"; // right answer

            questions[4][0] = "How many plagues did God send on Egypt?"; // fifth question
            questions[4][1] = "a. 10";
            questions[4][2] = "b. 11";
            questions[4][3] = "c. 8";
            questions[4][4] = "a"; // right answer

            ArrayList<Integer> myQuestions = new ArrayList<Integer>();
            for(int q=0;q<rows;q++){
               myQuestions.add(q);
            }
            System.out.println("Original List: " + myQuestions);
            Collections.shuffle(myQuestions);
            System.out.println("Shuffled list: " + myQuestions);

            while(qnmr<=myQuestions.size() && wrong<3){
                int random_number = myQuestions.get(a);
                    
                System.out.println(ANSI_YELLOW + "\n" + qnmr + ". " + questions[random_number][0] + ANSI_RESET); // output question and possible answers
                for(int i=1;i<columns-1;i++){
                System.out.println(questions[random_number][i]);
                }
            
                Scanner firstObj = new Scanner (System.in); // user input answer
                System.out.println(ANSI_CYAN + "\nChoose the right answer(a / b / c)" + ANSI_RESET);
                String userInput = firstObj.nextLine();
            
                if(questions[random_number][4].equals(userInput) == true){
                    switch(random_number){ // explainations
                        case 0:
                        System.out.println("\nCorrect! Moses lived 120 years, Jesus lived 3.5 years and Methuselah lived 969 years");
                        break;
                        case 1:
                        System.out.println("\nCorrect! Read Genesis 1:16-19");
                        break;
                        case 2:
                        System.out.println("\nCorrect! Read Genesis 9:13");
                        break;
                        case 3:
                        System.out.println("\nCorrect! Read Exodus 3:2");
                        break;
                        case 4:
                        System.out.println("\nCorrect! Read Exodus 8-10");
                        break;
            
                    }
                    correct++;
                }
                else{
                    switch(questions[random_number][4]){ //show the right answer
                        case "a":
                        System.out.println("\nIncorrect! The right answer was " + questions[random_number][1]);
                        break;
                        case "b":
                        System.out.println("\nIncorrect! The right answer was " + questions[random_number][2]);
                        break;
                        case "c":
                        System.out.println("\nIncorrect! The right answer was " + questions[random_number][3]);
                        break;
                    }
                    wrong++;  
                }
                System.out.println(ANSI_PURPLE + "You have " + correct + " right answers and " + wrong + " wrong answers." + ANSI_RESET);
                qnmr++;
                a++;
            }
            if(correct<wrong){
                System.out.println(ANSI_YELLOW + "\nYou failed, but you can try again!" + ANSI_RESET);
            }
            else{
                System.out.println(ANSI_YELLOW + "\nYou won! congratulations!" + ANSI_RESET);                
            }

            Scanner userObj = new Scanner(System.in);
            System.out.println(ANSI_YELLOW + "Do you want to play again?" + ANSI_RESET);
            System.out.println("a. Yes\nb.No");
            String userReady = userObj.nextLine();

            switch(userReady){
                case "a":
                isReady++;
                break;
                
                case "b":
                isReady=0;
            }
        }
    }
}