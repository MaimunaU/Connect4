/**
 * This class represents a Connect4 object
 *
 * @author Maimuna Ullah
 */

import java.util.Scanner;

public class Connect4 {
    /** An array of Player objects which represents the players */
    private Player[] players;

    /** Initializes the Player array */
    public Connect4()
    {
        players = new Player[2];
    }

    /**
     * The general logic for this program.
     * Welcomes the player and prints the game board.
     *
     * Goes back and forth between the two players asking
     * them to choose a column to drop their piece.
     *
     * After each move the board is checked for winning combinations
     * and whether the board is full. If full, corresponding
     * tie message is printed.
     */
    public void run()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to 2-Player Connect4!");
        players[0] = new Player("O");
        players[1] = new Player("@");
        System.out.println("Player 1: " + players[0].getPiece()
                + " Player 2: " + players[1].getPiece());
        System.out.println();
        Board board = new Board(6, 7);
        board.printBoard();
        boolean running = true;
        while (running)
        {
            System.out.print("\nPlayer 1, choose a column: ");
            int column = scan.nextInt();
            scan.nextLine();
            board.dropPiece(column, players[0]);
            System.out.println();
            board.printBoard();
            if (board.horizontalWin() || board.verticalWin() || board.diagonalWin1() || board.diagonalWin2())
            {
                break;
            }
            if (board.boardFull())
            {
                System.out.println("\nIt's a TIE!");
                break;
            }
            System.out.print("\nPlayer 2, choose a column: ");
            column = scan.nextInt();
            scan.nextLine();
            board.dropPiece(column, players[1]);
            System.out.println();
            board.printBoard();
            if (board.horizontalWin() || board.verticalWin() || board.diagonalWin1() || board.diagonalWin2())
            {
                break;
            }
            if (board.boardFull())
            {
                System.out.println("It's a TIE!");
                break;
            }
        }
    }
}
