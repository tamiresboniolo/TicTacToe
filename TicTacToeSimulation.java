/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_game;

/**
 *
 *  @author Tamires D Boniolo
 */
public class TicTacToeSimulation {
    
public static void main(String[] args) {
        
        TicTacToe ticTacToe = new TicTacToe();
        
        /*Test case 1  - valiates the printBoard method*/
        System.out.println("Test Case 1 - Print board");
        ticTacToe.printBoard(); 
        
        /*Test case 2  -X winning scenario*/
        System.out.println("\nTest Case 2");
        try{
            
            ticTacToe.simulateInput('X','1');
            ticTacToe.simulateInput('O','2');
            ticTacToe.simulateInput('X','6');
            ticTacToe.simulateInput('O','4');
            ticTacToe.simulateInput('X','b');
            
            /*ticTacToe.analyzeBoard();*/
            System.out.println("Game status true- game over; false - not over :  "+ticTacToe.done());
            System.out.println("Who won :  "+ticTacToe.whoWon());
            
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%s",e.getMessage());
        }
        
        /*Test case 3  -O winning scenario*/
        System.out.println("\nTest Case 3");
        try{
            TicTacToe ticTacToe1 = new TicTacToe();
            ticTacToe1.printBoard();
            ticTacToe1.simulateInput('X','g');
            ticTacToe1.simulateInput('O','7');
            ticTacToe1.simulateInput('X','e');
            ticTacToe1.simulateInput('O','3');
            ticTacToe1.simulateInput('X','1');
            ticTacToe1.simulateInput('O','b');
            
            /*ticTacToe.analyzeBoard();*/
            System.out.println("Game status true- game over; false - not over :  "+ticTacToe1.done());
            System.out.println("Who won :  "+ticTacToe1.whoWon());
            
        }
        catch(IllegalArgumentException e)
        {
            //%s- string value
            System.out.printf("%s",e.getMessage());
        }
        
        /*Test case 4  -Throw exception 'Player is out of turn'*/
        System.out.println("\nTest Case 4");
        try{
            TicTacToe ticTacToe2 = new TicTacToe();
            ticTacToe2.printBoard();
            ticTacToe2.simulateInput('X','7');
            ticTacToe2.simulateInput('X','1');
            
            
            /*ticTacToe.analyzeBoard();*/
            System.out.println("Game status true- game over; false - not over :  "+ticTacToe2.done());
            System.out.println("Who won :  "+ticTacToe2.whoWon());
            
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%s",e.getMessage());
        }
        /*Test case 5  -Throw exception 'Character is invalid'*/
        System.out.println("\nTest Case 5");
        try{
            TicTacToe ticTacToe3 = new TicTacToe();
            ticTacToe3.printBoard();
            ticTacToe3.simulateInput('X','0');
                        
            /*ticTacToe.analyzeBoard();*/
            System.out.println("Game status true- game over; false - not over :  "+ticTacToe3.done());
            System.out.println("Who won :  "+ticTacToe3.whoWon());
            
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%s",e.getMessage());
        }
              
         /*Test case 6  -Throw exception 'Position is already taken'*/
        System.out.println("\nTest Case 6");
        try{
            TicTacToe ticTacToe4 = new TicTacToe();
            ticTacToe4.printBoard();
            ticTacToe4.simulateInput('X','1');
            ticTacToe4.simulateInput('O','1');
                        
            /*ticTacToe.analyzeBoard();*/
            System.out.println("Game status true- game over; false - not over :  "+ticTacToe4.done());
            System.out.println("Who won :  "+ticTacToe4.whoWon());
            
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%s",e.getMessage());
        }
        /*Test case 7  - Check tie condition*/
        System.out.println("\nTest Case 7");
        try{
            TicTacToe ticTacToe5 = new TicTacToe();
            ticTacToe5.printBoard();
            ticTacToe5.simulateInput('X','1');
            ticTacToe5.simulateInput('O','2');
            ticTacToe5.simulateInput('X','3');
            ticTacToe5.simulateInput('O','4');
            ticTacToe5.simulateInput('X','5');
            ticTacToe5.simulateInput('O','6');
            ticTacToe5.simulateInput('X','7');
            ticTacToe5.simulateInput('O','8');
            ticTacToe5.simulateInput('X','a');
            ticTacToe5.simulateInput('O','9');
            ticTacToe5.simulateInput('X','c');
            ticTacToe5.simulateInput('O','b');
            ticTacToe5.simulateInput('X','e');
            ticTacToe5.simulateInput('O','d');
            ticTacToe5.simulateInput('X','g');
            ticTacToe5.simulateInput('O','f');

            
            /*ticTacToe.analyzeBoard();*/
            System.out.println("Game status true- game over; false - not over :  "+ticTacToe5.done());
            System.out.println("Who won :  "+ticTacToe5.whoWon());
            
        }
        catch(IllegalArgumentException e)
        {
            System.out.printf("%s",e.getMessage());
        }
        
        /*Test case 8 - This test case will validate method input - ask for user input five times and 
        display whether game is over or not and the winner if game is over*/
        System.out.println("Test Case 8\n");
        TicTacToe ticTacToe6 = new TicTacToe();
        for(int i=0;i<5;i++)
        {
            ticTacToe6.input();
        }
        /*Status and winner of the game*/
        System.out.println("Game status true- game over; false - not over :  "+ticTacToe6.done());
        System.out.println("Who won :  "+ticTacToe6.whoWon());
        
    }
    
}
