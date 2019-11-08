/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoe_game;

/**
 *
 * @author Tamires D Boniolo
 */

public class TicTacToe_Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               
        TicTacToe ticTacToe = new TicTacToe(); /*create object
        
        /*Get user input until game is over - either win or tie*/
        while(true != ticTacToe.done())
        {
            ticTacToe.input();
        }
        /*Status and winner of the game*/
        System.out.println("Game status true- game over; false - not over :  "+ticTacToe.done());
        System.out.println("Who won :  "+ticTacToe.whoWon());
               
    }
    
}