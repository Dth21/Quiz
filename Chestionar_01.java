import java.util.Scanner;

public class Chestionar_01{
    public static void main(String[] dth21){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";

        String[][] questions = new String[5][5];
        int rows = 5;
        int columns = 5;
        int min = 0;
        int max = rows - 1;
        int points = 0;
        int qnmr = 1;
 
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

        while(points<=rows){
            int random_question = (int)Math.floor(Math.random()*(max-min+1)+min); //select random question
            System.out.println("\nRandom is " + random_question + ".\n");
    
            int random_number = random_question;
              
            System.out.println(ANSI_YELLOW + qnmr + ". " + questions[random_number][0] + ANSI_RESET); // output question and possible answers
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
                points++;
                if(points<5){
                    System.out.println(ANSI_PURPLE + "\nYou have " + points + " points." + ANSI_RESET);
                }
                else{
                    System.out.println("/nYou won! congratulations!");
                    break;
                }
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
                --points;
                if(points>0){ // exit game or show earned points
                    System.out.println(ANSI_PURPLE + "You have " + points + " points." + ANSI_RESET);
                }
                else{
                    System.out.println(ANSI_YELLOW + "\nYou failed, but you can try again!" + ANSI_RESET);
                    break;
                }
            }
            qnmr++;
        }
    }
}