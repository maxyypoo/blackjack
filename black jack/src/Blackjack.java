//Doga Akpinaroglu

import java.util.Scanner;
import java.util.Random;

public class Blackjack {

    public static boolean check (int x , int y )
    {
        if (x + y > 21)
        {
            //System.out.println (" busted");
            return false;
        }  
        else if (x + y < 21)
        {
            return true;
        }
        else
        {
            //System.out.println ( " black jack!");
            return false;
        }
    }

    public static void main (String args[])
    {
        int newCardPlayer;
        int heldTotalPlayer;
        int newCardDealer;
        int heldTotalDealer;
        int dealerCardCount;
        String goAgain = "y";
        String dealAgain = "n";
        
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        

        while (goAgain.charAt(0) != 'n')
            {
                newCardDealer = random.nextInt(10) + 1;
                heldTotalPlayer = random.nextInt(10) + 1;
                newCardPlayer = random.nextInt(10) + 1;
                heldTotalDealer = random.nextInt(10) + 1;
                dealerCardCount = 2;

                System.out.println ("You were dealt " + newCardPlayer + " Your total is " + (heldTotalPlayer + newCardPlayer));
                System.out.println ("Dealers visible card is " + heldTotalDealer);
                System.out.println ( "Would you like a card? (y/n): ");
                dealAgain = input.next();
                while (heldTotalDealer + newCardDealer < 17)
                {
                    heldTotalDealer += newCardDealer;
                    newCardDealer = random.nextInt(10) + 1;
                    dealerCardCount++;
                }


                while (dealAgain.charAt(0) != 'n')
                {
                    heldTotalPlayer += newCardPlayer;
                    newCardPlayer = random.nextInt(10) + 1;
                    System.out.println ("You were dealt " + newCardPlayer + " Your total is " + (heldTotalPlayer + newCardPlayer));
                    if (check (heldTotalPlayer, newCardPlayer))
                    {
                        System.out.println ( "Continue drawing?(c): ");
                        dealAgain = input.next();
                    }
                    else
                    {
                        dealAgain = "n";
                    }

                }
                System.out.println ("Your hand total is " + (heldTotalPlayer + newCardPlayer) );
                
                if ((heldTotalPlayer + newCardPlayer) > 21)
                {
                    System.out.println("Player loses!");
                    //System.exit(0);
                }
                else{

                
                    System.out.println ("Dealer drew " + dealerCardCount + " cards.");
                    System.out.println ("Dealer hand total is " + (heldTotalDealer + newCardDealer));

                    if ((newCardPlayer + heldTotalPlayer <= 21) && (((newCardDealer + heldTotalDealer) < (newCardPlayer + heldTotalPlayer)) || (newCardDealer + heldTotalDealer) > 21) )
                    {
                        System.out.println("Player wins!");
                    }
                    else if ((newCardPlayer + heldTotalPlayer) == (newCardDealer + heldTotalDealer))
                    {
                        System.out.println("Push!");
                    }
                    else
                    {
                        System.out.println("Player loses!");
                    }

                    System.out.println ("Would you like to play again?(y/n): ");
                    goAgain = input.next();
                }


            }
    }
}