import java.util.*;
import java.io.*;

public class chestionar_01{
    public static void main(String[] dth21){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";

        int isReady = 1; //used for restarting the program
    
        while(isReady>0){
            String[][] questions = new String[5][6];
            int rows = 5;
            int columns = 6;
            int correct = 0; //correct answers
            int wrong = 0; //wrong answers
            int qnmr = 1; //question number in output
            int a = 0; //loop through randomised list

            questions[0][0] = "Who is the oldest person in Bible?"; // first question
            questions[0][1] =  "a. Moises";
            questions[0][2] = "b. Jesus";
            questions[0][3] = "c. Methuselah";
            questions[0][4] = "c"; // right answer
            questions[0][5] = "Moses lived 120 years, Jesus lived 3.5 years and Methuselah lived 969 years."; // explanation

            questions[1][0] = "When was the moon created?"; // second question
            questions[1][1] = "a. Second Dary";
            questions[1][2] = "b. Forth Day";
            questions[1][3] = "c. Sixth Day";
            questions[1][4] = "b"; // right answer
            questions[1][5] = "Read Genesis 1:16-19"; // explanation


            questions[2][0] = "What was God’s sign to Noah that he would never destroy the earth again?"; // third question
            questions[2][1] = "a. rainbow";
            questions[2][2] = "b. cloud";
            questions[2][3] = "c. fire from heaven";
            questions[2][4] = "a"; // right answer
            questions[2][5] = "Read Genesis 9:13 "; // explanation

            questions[3][0] = "Through what did God speak to Moses in the desert?"; // forth question
            questions[3][1] = "a. a donkey";
            questions[3][2] = "b. a burning bush";
            questions[3][3] = "c. a sheep";
            questions[3][4] = "b"; // right answer
            questions[3][5] = "Read Exodus 3:2 "; // explanation

            questions[4][0] = "How many plagues did God send on Egypt?"; // fifth question
            questions[4][1] = "a. 10";
            questions[4][2] = "b. 11";
            questions[4][3] = "c. 8";
            questions[4][4] = "a"; // right answer
            questions[4][5] = "Read Exodus 8-10 "; // explanation

            ArrayList<Integer> myQuestions = new ArrayList<Integer>(); //creating an list to randomise
            for(int q=0;q<rows;q++){
               myQuestions.add(q);
            }
            System.out.println("Original List: " + myQuestions);
            Collections.shuffle(myQuestions); // randomise list of questions
            System.out.println("Shuffled list: " + myQuestions);

            while(qnmr<=myQuestions.size() && wrong<3){
                int random_number = myQuestions.get(a); // output question and possible answers
                System.out.println(ANSI_YELLOW + "\n" + qnmr + ". " + questions[random_number][0] + ANSI_RESET); 
                for(int i=1;i<columns-2;i++){
                    System.out.println(questions[random_number][i]);
                }
            
                Scanner firstObj = new Scanner (System.in); // user answer input 
                System.out.println(ANSI_CYAN + "\nChoose the right answer(a / b / c)" + ANSI_RESET);
                String userInput = firstObj.nextLine();
            
                if(questions[random_number][4].equals(userInput) == true){
                    System.out.println("\nCorrect!");
                    System.out.println(questions[random_number][5]);
                    correct++;
                }
                else{
                    switch(questions[random_number][4]){ //show the right answer
                        case "a":
                        System.out.println("\nIncorrect! The right answer was " + questions[random_number][1]);
                        System.out.println(questions[random_number][5]);
                        break;
                        case "b":
                        System.out.println("\nIncorrect! The right answer was " + questions[random_number][2]);
                        System.out.println(questions[random_number][5]);
                        break;
                        case "c":
                        System.out.println("\nIncorrect! The right answer was " + questions[random_number][3]);
                        System.out.println(questions[random_number][5]);
                        break;
                    }
                    wrong++;  
                }
                System.out.println(ANSI_PURPLE + "You have " + correct + " points and " + wrong + " wrong answers." + ANSI_RESET);
                qnmr++;
                a++;
            }
            if(correct<wrong){
                System.out.println(ANSI_YELLOW + "\nYou failed, but you can try again!" + ANSI_RESET);
            }
            else{
                System.out.println(ANSI_YELLOW + "\nYou won! congratulations!" + ANSI_RESET);                
            }

            user(correct);

            Scanner userObj = new Scanner(System.in);
            System.out.println(ANSI_YELLOW + "\nDo you want to play again?" + ANSI_RESET);
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

    static void user(int correct){
        String userName = null;
        int userChoice = 0;

        Scanner userchoiceObj = new Scanner(System.in);
        System.out.println("1. Register new username.\n2. Show users and scores.");
        userChoice = userchoiceObj.nextInt();

        switch(userChoice){
            case 1:
            Scanner usernameObj = new Scanner(System.in);
            System.out.println("Insert username:");
            userName = usernameObj.nextLine();

            try{ // check if file exists
                File fileObj = new File ("Users.txt");
                if(fileObj.createNewFile()){
                    System.out.println("File created.");
                }
                else{
                    System.out.println("File existent.");
                }
            }
            catch(IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            try{ // write next line
                FileWriter writer = new FileWriter("D:\\GitHub\\Quiz\\Users.txt", true);
                writer.append(userName + " :: " + new java.util.Date() + " : " + correct + " points\n");
                writer.close();
            } 
            catch (IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            break;

            case 2:
            try{
                FileReader reader = new FileReader("D:\\GitHub\\Quiz\\Users.txt");
                int data = reader.read();
                while(data != -1){
                    System.out.print((char)data);
                    data = reader.read();
                }
                reader.close();
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            break;
        }


        
    }
}