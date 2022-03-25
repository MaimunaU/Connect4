import java.util.Scanner;

public class Connect4 {
    public void run()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Connect4!");
        System.out.println("*This is a 2-Player only game*");
        System.out.println();
        //System.out.println("What board size would you like? ");
        Player player1 = new Player("O");
        Player player2 = new Player("@");
        Board board = new Board(6, 7);
        board.printBoard();
        System.out.print("Player 1, choose a column: ");
        int column = scan.nextInt();
        scan.nextLine();
        board.dropPiece(column, player1);
        board.printBoard();
        System.out.print("Player 2, choose a column: ");
        column = scan.nextInt();
        scan.nextLine();
        board.dropPiece(column, player2);
        board.printBoard();


    }
}
