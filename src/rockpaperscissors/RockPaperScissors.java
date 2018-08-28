/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public class RockPaperScissors {

    /**
     * @param args the command line arguments
     */  
    
    static int win = 0;
    static int loss = 0;
    static int tie = 0;
    
    public static void main(String[] args) 
    {
     /* 1. User enters 'C' to play another game.
        2. User enters 'Q' to quit.
        3. On quit, the program displays the statistics including: number of games played, number of wins, 
           number of losses, and number of ties.
        4. For each round, the computer chooses a random choice.
        5. The user enters 'R', 'P', or 'S'.
        6. The results of each round are displayed.
*/
        String strUserInput = JOptionPane.showInputDialog("Enter C to play the game or Q to quit");
        int nGames;
      
        
         for (nGames=0;!(strUserInput.equalsIgnoreCase("Q")); nGames++)
        {
            if (strUserInput.equalsIgnoreCase("C"))
            {       
                String strUserTry = promptUserForStr("Enter R for Rock; P for Paper or S for Scissors ");
                String strRandomString = generateRandomString();
                
                System.out.println("User's Try\tComputer's Try ");
                System.out.println(strUserTry +  "\t\t" + strRandomString);
                
                playGame(strUserTry, strRandomString);
            }
        
            else
            {
                JOptionPane.showMessageDialog(null, "Enter C to play the game or Q to quit. Other inputs will not be accepted", "WRONG INPUT", JOptionPane.ERROR_MESSAGE);
                nGames--;
            }
            
            strUserInput = JOptionPane.showInputDialog("Enter C to play the game or Q to quit");
        }
        if (nGames==0)
        {
            JOptionPane.showMessageDialog(null, "You havn't played yet. Try when you have time!", "Unfortunately", JOptionPane.PLAIN_MESSAGE);
        }
        else
        {
                JOptionPane.showMessageDialog(null, "You played " + nGames + " time" + (nGames>1?"s. ":". ") + " You won " + win + " time" + (win>1?"s. ":".  ")+ " You lost " + loss  + " time" + (nGames>1?"s. ":".  ") + " You played a tie " + tie + " time" + (nGames>1?"s. ":".  "), "Thanks for the game!", JOptionPane.PLAIN_MESSAGE);
        }

    }
    
    public static String promptUserForStr(String strInput)
    {
        boolean goodString = false;
        String str = "";
        while (!goodString)
        {
            str = JOptionPane.showInputDialog(strInput);
            if (str.equalsIgnoreCase("R") || str.equalsIgnoreCase("P") || str.equalsIgnoreCase("S"))
            {
                goodString = true;
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Enter R for Rock, S for Scossors, P for paper. Other letter are not accepted", "WRONG INPUT", JOptionPane.ERROR_MESSAGE);
            }           
        }
        return str;
    }
    
    public static String generateRandomString()
    {
        String computerTry[] = {"R", "P", "S"};
        Random randLetter = new Random();
        int n = randLetter.nextInt(3);

        return computerTry[n];
    }
    
    public static void playGame(String you, String computer)
    {
        if (you.equalsIgnoreCase(computer))
        {
            System.out.println("The winner can't be determined. Play one more time");
            tie++;
        }
        else
        {
            switch(you)
            {
                case "r":
                case "R":
                    switch(computer)
                    {
                        case "S": System.out.println("Congrats! You are the champion!");
                        win++;
                        break;
                        case "P": System.out.println("Sorry, you lost :( . Try again");
                        loss++;
                        break;
                    }
                break;
                case "s":
                case "S":
                    switch(computer)
                    {
                        case "R": System.out.println("Sorry, you lost :( . Try again");
                        loss++;
                        break;
                        case "P": System.out.println("Congrats! You are the champion!");
                        win++;
                        break;
                    }
                break;
                case "p":
                case "P":
                    switch(computer)
                    {
                        case "S": System.out.println("Sorry, you lost :( . Try again");
                        loss++;
                        break;
                        case "R": System.out.println("Congrats! You are the champion!");
                        win++;
                        break;
                    }
                break;
                default: System.out.println("Ooops, Smth went wrong... Try again");
            }
        }
    }
}
       
