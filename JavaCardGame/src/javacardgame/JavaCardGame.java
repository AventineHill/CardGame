/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacardgame;
import java.util.Scanner;
/**
 *
 * @author Connor
 */
public class JavaCardGame {

    
    public static void main(String[] args) {
     int y = 0; 
        
        
        
        System.out.println("Welcome to this program, which allows you to play a simple card game against the computer.");

    System.out.println("In this game, four cards from a standard deck are dealt to you and the computer.");
    System.out.println("Each turn, your total will inrease as a card is dealt to each player");
    System.out.println("Each turn, you may play a card from your hand to modify your total up or down by the value displayed on the card.");
    System.out.println("When played from your hand, Black cards have a negative value.");
    System.out.println("Try to reach 21 without going over!");
    int plwin = 0;
    int comwin = 0;
   do{
    
    Scanner scanner = new Scanner(System.in);
    Deck deck = new Deck();
    deck.shuffle();
    Card P1=deck.dealCard();
    int P1val;
    Card P2=deck.dealCard();
    int P2val;
    Card P3=deck.dealCard();
    int P3val;
    Card P4=deck.dealCard();
    int P4val;
    Card C1=deck.dealCard();
    int C1val;
    Card C2=deck.dealCard();
    int C2val;
    Card C3=deck.dealCard();
    int C3val;
    Card C4=deck.dealCard();
    int C4val;

    int x;
   
    int turn = 1;
    
    int usertotal=0;
    int comtotal=0;
   
    
    
      if ("Spades".equals(P1.getSuitAsString())||"Clubs".equals(P1.getSuitAsString()))
      { P1val = 0-P1.getValue();}
      else{P1val=P1.getValue();}
          
          if ("Spades".equals(P2.getSuitAsString())||"Clubs".equals(P2.getSuitAsString()))
      { P2val = 0-P2.getValue();}
      else{P2val=P2.getValue();}
          
                if ("Spades".equals(P3.getSuitAsString())||"Clubs".equals(P3.getSuitAsString()))
      { P3val = 0-P3.getValue();}
      else{P3val=P3.getValue();}
                
                      if ("Spades".equals(P4.getSuitAsString())||"Clubs".equals(P4.getSuitAsString()))
      { P4val = 0-P4.getValue();}
      else{P4val=P4.getValue();}
                      
         if ("Spades".equals(C1.getSuitAsString())||"Clubs".equals(C1.getSuitAsString()))
      { C1val = 0-C1.getValue();}
      else{C1val=C1.getValue();}
          
          if ("Spades".equals(C2.getSuitAsString())||"Clubs".equals(C2.getSuitAsString()))
      { C2val = 0-C2.getValue();}
      else{C2val=C2.getValue();}
          
                if ("Spades".equals(C3.getSuitAsString())||"Clubs".equals(C3.getSuitAsString()))
      { C3val = 0-C3.getValue();}
      else{C3val=C3.getValue();}
                
                      if ("Spades".equals(C4.getSuitAsString())||"Clubs".equals(C4.getSuitAsString()))
      { C4val = 0-C4.getValue();}
      else{C4val=C4.getValue();}

       int[] userhand = {P1val, P2val, P3val, P4val};
    
    int[] comhand = {C1val, C2val, C3val, C4val};
                   
                      

                      

    
    
    do{
     System.out.println("Turn " +turn);
    Card PRan=deck.dealCard();
    Card CRan=deck.dealCard();
    
     usertotal=usertotal+PRan.getValue();
     comtotal=comtotal+CRan.getValue();
      System.out.println("Your total: " +usertotal);
      System.out.println("Computer total: " +comtotal);
      System.out.println("Your hand: " +"|" +userhand[0] +"|" + " " +"|"+userhand[1]+"|" +" " +"|" +userhand[2]+"|" +" " +"|" +userhand[3]+"|");
        do{
       x = 0;
           System.out.println("Your turn. Play or stand? (p/s)");
       String res = scanner.next();
       if("p".equals(res)||"P".equals(res)){
        System.out.println("Enter the number of the card you wish to play. (1-4)");
        String cardno = scanner.next();
        if(null != cardno)switch (cardno) {
               case "1":
                   usertotal=usertotal+userhand[0];
                   System.out.println("Current score: " +usertotal);
                   userhand[0]=0;
                   x++;
                   break;
               case "2":
                   usertotal=usertotal+userhand[1];
                   System.out.println("Current score: " +usertotal);
                   userhand[1]=0;
                   x++;
                   break;
               case "3":
                   usertotal=usertotal+userhand[2];
                   System.out.println("Current score: " +usertotal);
                   userhand[2]=0;
                   x++;
                   break;
               case "4":
                   usertotal=usertotal+userhand[3];
                   System.out.println("Current score: " +usertotal);
                   userhand[3]=0;
                   x++;
                   break;
               default:
                   System.out.println("Invalid input. Standing instead.");
                   x++;
                   break;
           }
       }
       else if("s".equals(res)||"S".equals(res)){x++;}
       else { System.out.println("Invalid input."); }
      
       
       }while(x==0);
    
    
     if((comhand[0]+comtotal)==21){comtotal=comtotal+comhand[0]; comhand[0]=0;}
     else if((comhand[1]+comtotal)==21){comtotal=comtotal+comhand[1]; comhand[1]=0;}
     else if((comhand[2]+comtotal)==21){comtotal=comtotal+comhand[2]; comhand[2]=0;}
     else if((comhand[3]+comtotal)==21){comtotal=comtotal+comhand[3]; comhand[3]=0;}
     else if ((comhand[0]+comtotal)<14){comtotal=comtotal+comhand[0]; comhand[0]=0;}
     else if((comhand[1]+comtotal)<14){comtotal=comtotal+comhand[1]; comhand[1]=0;}
     else if((comhand[2]+comtotal)<14){comtotal=comtotal+comhand[2]; comhand[2]=0;}
     else if((comhand[3]+comtotal)<14){comtotal=comtotal+comhand[3]; comhand[3]=0;}
    
     
     
     System.out.println("Computer's current total: " +comtotal);
    
     turn++;
    
    }while(usertotal<21&&comtotal<21);
    if(usertotal==comtotal){System.out.println("A draw.");}
    else if(usertotal>21&&comtotal>21){System.out.println("A draw.");}
    else if(usertotal==21){System.out.println("You win!"); plwin++;}
    else if(comtotal==21){System.out.println("The computer wins."); comwin++;}
    else if(comtotal>21){System.out.println("You win!"); plwin++;}
    else if(usertotal>21){System.out.println("The computer wins."); comwin++;}
    
    System.out.println("You have won " +plwin +" time(s).");
     System.out.println("The computer has won " +comwin +" time(s).");
    System.out.println("Would you like to play again? (y/n)");
    String ans = scanner.next();
    if("n".equals(ans)||"N".equals(ans)){y++;}
    
     }while(y==0);
    }
    }
    

