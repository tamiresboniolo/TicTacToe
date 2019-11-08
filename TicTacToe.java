/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_game;

import java.util.Scanner;

/**
 *
 *  @author Tamires D Boniolo
 */
public class TicTacToe {
        //a private two-dimensional array of size 4x4
        private final char[][] board = new char[4][4]/*{
         {1, 2, 3, 4},
         {5, 6, 7, 8},
         {9, 'a', 'b', 'c'},
         {'d', 'e','f','g'}
        }*/;
        
        private boolean status; /*status of the game*/
        private char winner; /*winner of the game*/
        private char whoseTurn;/*who is playing next*/
        private int moves; /*number of inputs*/
        private char lastPlayer; /*last player player*/
        private char lastLetter;/*last inserted position*/
        /**
         * No argument constructor TicTacToe - This constructor initializes the board
         * @param - none
         * @return - none
         */
        public TicTacToe()
        {
          board[0][0] = '1';
          board[0][1] = '2';
          board[0][2] = '3';
          board[0][3] = '4';
          board[1][0] = '5';
          board[1][1] = '6';
          board[1][2] = '7';
          board[1][3] = '8';
          board[2][0] = '9';
          board[2][1] = 'a';
          board[2][2] = 'b';
          board[2][3] = 'c';
          board[3][0] = 'd';
          board[3][1] = 'e';
          board[3][2] = 'f';
          board[3][3] = 'g';
          
          whoseTurn = 'X';
        }
        
        /**
         * printBoard method displays the board
         * @param - none
         * @return - none
         */
        public void printBoard()
        {    
            for(int i=0;i<4;i++)
            {
              for(int j=0;j<4;j++)
              {
                  System.out.printf("%c\t",board[i][j]);
                  
              }
              System.out.print("\n");
              
            }
        }
        /**
         * input method prompts user for input. It validates input and print board after inserting character.
         * @param - none
         * @return -  none
         */
        public void input()
        {
            char str = 0;
            Scanner keyboard = new Scanner(System.in);
            boolean again =true;
            System.out.println("Please Enter the position Player: "+whoseTurn);
            printBoard();
           while(again)
           {
                while(again)
                {
                    //trim() takes the spaces away
                    str = keyboard.next().trim().charAt(0);
                    
                    again = validateInput(str);
                
                    if(again == true)
                    {
                        System.out.println("Entered position is not valid position\n Please Enter the valid position\n Player: "+whoseTurn); 
                    }    
                }
            again = validatePosition(str);
            if(again == true)
            {
                System.out.println("Entered position is already filled \n Please Enter the valid position\n Player: "+whoseTurn); 
            }
        }
        
            setPositionValue(whoseTurn,str);
            lastPlayer = whoseTurn;
            if(whoseTurn == 'X')
            {
              whoseTurn = 'O'; 
            }
            else
            {
               whoseTurn = 'X';   
            }
            analyzeBoard();
            
            
        }
        /**
         * validateInput method validates the input 
         * @param val - holds the character to be validated 
         * @return boolean value; true - character is not valid, false - input is okay.
         */
        private boolean validateInput(char val)
        {
            if((val >= '1' ) && (val <= '9') || (val >= 'a' ) && (val <= 'g')||(val >= 'A' ) && (val <= 'G') )
            {
                return(false);
            }
            else
            {
                return(true);
            }
        }
        
        /**
         * validatePosition method checks whether position is already taken or not
         * @param val - holds the character represents the position
         * @return boolean value true- position is already taken false- position is empty
         */
        private boolean validatePosition(char val)
        {
            if(getPositionValue(val) == ('x') || getPositionValue(val)==('o') || getPositionValue(val) == ('X') || getPositionValue(val)==('O'))
            {
                return(true);
                
            }
            else
            {
                return(false);
            }
        }
        /**
         * getPositionValue method determines the board array index value for 
         * particular character and returns the character stored in the position 
         * @param val - holds the character represents the position
         * @return char returns the value stored in array 
         */
        private char getPositionValue(char val)
        {
            int i=0, j=0;
            switch(val)
            {
                case '1':
                    i=0;
                    j=0;
                  break;
                case '2':
                    i=0;
                    j=1;
                  break;
                case '3':
                    i=0;
                    j=2;
                    break;
                case '4':
                    i=0;
                    j=3;
                    break;
                case '5':
                    i=1;
                    j=0;
                    break;
                case '6':
                    i=1;
                    j=1;
                    break;
                case '7':
                    i=1;
                    j=2;
                    break;
                case '8':
                    i=1;
                    j=3;
                    break;
                case '9':
                    i=2;
                    j=0;
                    break;
                case 'A':
                case 'a':
                    i=2;
                    j=1;
                    break;
                case 'B':
                case 'b':
                    i=2;
                    j=2;
                    break;
                case 'C':
                case 'c':
                    i=2;
                    j=3;
                    break;
                case 'D':
                case 'd':
                    i=3;
                    j=0;
                    break;
                case 'E':
                case 'e':
                    i=3;
                    j=1;
                    break;
                case 'F':
                case 'f':
                    i=3;
                    j=2;
                    break;
                case 'G':
                case 'g':
                    i=3;
                    j=3;
                    break;
                default:
                    break;
            } 
            return(board[i][j]);
                    
        }
        /**
         * simulateInput method is or debugging purpose. It throws exception when letter is invalid,
         * when current turn is not player's turn and when position i already taken. When all conditions are 
         * satisfied it writes 'X' or 'O' to the board also handles which player ha to play next
         * @param player - 'X' or 'O' - which player is playing
         * @param letter - 1-9 or a-g tells the board position
         * return none
         */
        public void simulateInput(char player, char letter)
        {
            
            if(whoseTurn != player)
            {
                throw new IllegalArgumentException("Exception:Player is out of turn"); 
            } 
            
            if(validateInput(letter) == true)
            {
                throw new IllegalArgumentException("Exception:Character is invalid"); 
            }
            
            if(validatePosition(letter) == true)
            {
                throw new IllegalArgumentException("Exception:Position is already taken"); 
            }
            
            System.out.println("\nPlayer "+player+" made a move at "+letter+"\n");
            setPositionValue(player,letter);
            
            //The method must also be taking care of changing the value of field that tracks whose turn it is to play (whoseTurn).  
           /* printBoard();*/
            lastPlayer = whoseTurn;
            if(whoseTurn == 'X')
            {
              whoseTurn = 'O'; 
            }
            else
            {
               whoseTurn = 'X';   
            }
            analyzeBoard();
        }
        
        /**
         * setPositionValue method writes the value 'X' or 'O' to array position
         * @param player - 'X' or 'O' - which player is playing
         * @param letter - 1-9 or a-g tells the board position
         * @return - none
         */
         private void setPositionValue(char player, char letter)
        {
            switch(letter)
            {
                case '1':
                   board[0][0] = player;
                  break;
                case '2':
                    board[0][1] = player;
                  break;
                case '3':
                    board[0][2] = player;
                    break;
                case '4':
                    board[0][3] = player;
                    break;
                case '5':
                    board[1][0] = player;
                    break;
                case '6':
                    board[1][1] = player;
                    break;
                case '7':
                    board[1][2] = player;
                    break;
                case '8':
                    board[1][3] = player;
                    break;
                case '9':
                    board[2][0] = player;
                    break;
                case 'A':
                case 'a':
                   board[2][1] = player;
                    break;
                case 'B':
                case 'b':
                   board[2][2] = player;
                    break;
                case 'C':
                case 'c':
                    board[2][3] = player;
                    break;
                case 'D':
                case 'd':
                    board[3][0] = player;
                    break;
                case 'E':
                case 'e':
                    board[3][1] = player;
                    break;
                case 'F':
                case 'f':
                    board[3][2] = player;
                    break;
                case 'G':
                case 'g':
                    board[3][3] = player;
                    break;
                default:
                    break;
            }
            moves++;
            printBoard();
            lastLetter = letter;
        }
        /**
         * analyzeBoard method analyzes the board and determines the status of the game and winner of the game
         *@param - none
         * @return - none
         */
      public void analyzeBoard()
      {
        if(status != true)
        {
            switch(lastLetter)
            {
                case '1':
                    if(((board[0][0] == board[0][1]) && (board[0][0] == board[0][2]))
                    ||((board[0][0] == board[1][0]) && (board[0][0] == board[2][0]))
                    ||((board[0][0] == board[1][1]) && (board[0][0] == board[2][2])))
                    {
                        status = true;
                    }
                    break;

                case '2':
                    if(((board[0][1] == board[0][2]) && (board[0][1] == board[0][3]))
                    ||((board[0][1] == board[1][1]) && (board[0][1] == board[2][1]))
                    ||((board[0][1] == board[1][2]) && (board[0][1] == board[2][3]))
                    ||((board[0][1] == board[0][0]) && (board[0][1] == board[0][2])))
                    {
                        status = true;
                    }
                    break;

                case '3':
                    if(((board[0][2] == board[1][2]) && (board[0][2] == board[2][2]))
                    ||((board[0][2] == board[1][1]) && (board[0][2] == board[2][0]))
                    ||((board[0][0] == board[0][1]) && (board[0][0] == board[0][2]))
                    ||((board[0][2] == board[0][1]) && (board[0][2] == board[0][3])))
                    {
                        status = true;
                    }
                    break;

                case '4':
                    if(((board[0][3] == board[1][3]) && (board[0][3] == board[2][3]))
                    ||((board[0][3] == board[1][2]) && (board[0][3] == board[2][1]))
                    ||((board[0][1] == board[0][2]) && (board[0][1] == board[0][3])))
                    {
                        status = true;
                    }
                    break;

                case '5':
                    if(((board[1][0] == board[1][1]) && (board[1][0] == board[1][2]))
                    ||((board[1][0] == board[2][0]) && (board[1][0] == board[3][0]))
                    ||((board[1][0] == board[2][1]) && (board[1][0] == board[3][2]))
                    ||((board[1][0] == board[0][0]) && (board[1][0] == board[2][0])))
                    {
                        status = true;
                    }
                    break;

                case '6':
                    if(((board[1][1] == board[1][2]) && (board[1][1] == board[1][3]))
                    ||((board[1][1] == board[2][1]) && (board[1][1] == board[3][1]))
                    ||((board[1][1] == board[2][2]) && (board[1][1] == board[3][3]))
                    ||((board[1][1] == board[0][0]) && (board[1][1] == board[2][2]))
                    ||((board[1][1] == board[0][2]) && (board[1][1] == board[2][0]))
                    ||((board[1][1] == board[0][1]) && (board[1][1] == board[2][1]))
                    ||((board[1][1] == board[1][0]) && (board[1][1] == board[1][2])))
                    {
                        status = true;
                    }
                    break;

                case '7':
                    if(((board[1][2] == board[2][2]) && (board[1][2] == board[3][2]))
                    ||((board[1][2] == board[2][1]) && (board[1][2] == board[3][0]))
                    ||((board[1][2] == board[1][1]) && (board[1][2] == board[1][0]))
                    ||((board[1][2] == board[0][3]) && (board[1][2] == board[2][1]))
                    ||((board[1][2] == board[0][1]) && (board[1][2] == board[2][3]))
                    ||((board[1][2] == board[0][2]) && (board[1][2] == board[2][2]))
                    ||((board[1][2] == board[1][3]) && (board[1][2] == board[1][1])))
                    {
                        status = true;
                    }
                    break;

                case '8':
                    if(((board[1][3] == board[2][3]) && (board[1][3] == board[3][3]))
                    ||((board[1][3] == board[2][2]) && (board[1][3] == board[3][1]))
                    ||((board[1][1] == board[1][2]) && (board[1][1] == board[1][3]))
                    ||((board[1][3] == board[0][3]) && (board[1][3] == board[2][3])))
                    {
                        status = true;
                    }
                    break;

                case '9':
                    if(((board[0][0] == board[1][0]) && (board[0][0] == board[2][0]))
                    ||((board[2][0] == board[2][1]) && (board[2][0] == board[2][2]))
                    ||((board[0][2] == board[1][1]) && (board[0][2] == board[2][0]))
                    ||((board[2][0] == board[1][0]) && (board[2][0] == board[3][0])))
                    {
                        status = true;
                    }
                    break;

                case 'A':
                case 'a':
                    if(((board[0][1] == board[1][1]) && (board[0][1] == board[2][1]))
                    ||((board[2][1] == board[2][2]) && (board[2][1] == board[2][3]))
                    ||((board[0][3] == board[1][2]) && (board[0][3] == board[2][1]))
                    ||((board[2][1] == board[3][0]) && (board[2][1] == board[1][2]))
                    ||((board[2][1] == board[2][0]) && (board[2][1] == board[2][2]))
                    ||((board[2][1] == board[1][0]) && (board[2][1] == board[3][2]))
                    ||((board[2][1] == board[1][1]) && (board[2][1] == board[3][1])))
                    {
                        status = true;
                    }
                    break;

                case 'B':
                case 'b':
                    if(((board[2][0] == board[2][1]) && (board[2][0] == board[2][2]))
                    ||((board[0][0] == board[1][1]) && (board[0][0] == board[2][2]))
                    ||((board[2][2] == board[1][2]) && (board[2][2] == board[0][2]))
                    ||((board[2][2] == board[1][1]) && (board[2][2] == board[3][3]))
                    ||((board[2][2] == board[3][1]) && (board[2][2] == board[1][3]))
                    ||((board[2][2] == board[1][2]) && (board[2][2] == board[3][2]))
                    ||((board[2][2] == board[2][1]) && (board[2][2] == board[2][3])))
                    {
                        status = true;
                    }
                    break;
                case 'C':
                case 'c':
                    if(((board[2][1] == board[2][2]) && (board[2][1] == board[2][3]))
                    ||((board[0][3] == board[1][3]) && (board[0][3] == board[2][3]))
                    ||((board[0][1] == board[1][2]) && (board[0][1] == board[2][3]))
                    ||((board[2][3] == board[1][3]) && (board[2][3] == board[3][3])))
                    {
                        status = true;
                    }
                    break;
                case 'D':
                case 'd':
                    if(((board[3][0] == board[3][1]) && (board[3][0] == board[3][2]))
                    ||((board[1][0] == board[2][0]) && (board[1][0] == board[3][0]))
                    ||((board[1][2] == board[2][1]) && (board[1][2] == board[3][0])))
                    {
                        status = true;
                    }
                    break;
                case 'E':
                case 'e':
                    if(((board[3][1] == board[3][2]) && (board[3][1] == board[3][3]))
                    ||((board[1][1] == board[2][1]) && (board[1][1] == board[3][1]))
                    ||((board[1][3] == board[2][2]) && (board[1][3] == board[3][1]))
                    ||((board[3][0] == board[3][1]) && (board[3][0] == board[3][2])))
                    {
                        status = true;
                    }
                    break;
                case 'F':
                case 'f':
                    if(((board[3][0] == board[3][1]) && (board[3][0] == board[3][2]))
                    ||((board[1][2] == board[2][2]) && (board[1][2] == board[3][2]))
                    ||((board[1][0] == board[2][1]) && (board[1][0] == board[3][2]))
                    ||((board[3][2] == board[3][1]) && (board[3][2] == board[3][3])))
                    {
                        status = true;
                    }
                    break;
                case 'G':
                case 'g':
                    if(((board[3][1] == board[3][2]) && (board[3][1] == board[3][3]))
                    ||((board[1][3] == board[2][3]) && (board[1][3] == board[3][3]))
                    ||((board[1][1] == board[2][2]) && (board[1][1] == board[3][3])))
                    {
                        status = true;
                    }
                    break;
                default:
                    status = false;
                    break;
            }   
            if(status == true)
            {
                if(lastPlayer == 'X')
                {
                    winner = 'X';
                }
                else
                {
                    winner = 'O'; 
                }   
            }
            if(moves == 16)
            {
                status = true;
                winner = 'T';
            }
    }
          
              
          else if((status!=true) && (moves != 16))
          {
              status = false;
          }
          else if(status!=true)
          {
              status = true;
              winner = 'T';
          }
                
      }
      /**
       *done accessor gives the status of the game 
       * @return boolean status - status of the game true - game over false - not over
       */
      public boolean done()
      {
         return(status); 
      }
      /**
       *whoWon accessor gives the winner of the game 
       * @return boolean winner - winner of the game X or O or T
       */
      public char whoWon()
      {
         return(winner); 
      }
}
