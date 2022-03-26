import java.util.Scanner;

public class Connect4 {
    public void run()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to 2-Player Connect4!");
        Player player1 = new Player("O");
        Player player2 = new Player("@");
        System.out.println("Player 1: " + player1.getPiece()
                + " Player 2: " + player2.getPiece());
        System.out.println();
        Board board = new Board(6, 7);
        board.printBoard();
        boolean running = true;
        while (running)
        {
            System.out.print("\nPlayer 1, choose a column: ");
            int column = scan.nextInt();
            scan.nextLine();
            board.dropPiece(column, player1);
            System.out.println();
            board.printBoard();
            if (board.horizontalWin() || board.verticalWin())
            {
                break;
            }
            System.out.print("\nPlayer 2, choose a column: ");
            column = scan.nextInt();
            scan.nextLine();
            board.dropPiece(column, player2);
            System.out.println();
            board.printBoard();
            if (board.horizontalWin() || board.verticalWin())
            {
                break;
            }
        }

    }
}
