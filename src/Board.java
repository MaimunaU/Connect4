/**
 * This class represents a Board object
 *
 * @author Maimuna Ullah
 */
public class Board {
    /** The game board */
    public String[][] grid;

    /**
     * Initializes the Board object with a corresponding column number starting at 1.
     *
     * @param row The number of rows the board has
     * @param col The number of colums the board has
     */
    public Board (int row, int col)
    {
        grid = new String[row][col];
        for (int r = 0; r < row; r++)
        {
            int count = 1;
            for (int c = 0; c < col; c++)
            {
                grid[r][c] = (" " + Integer.toString(count) + " |");
                count++;
            }
        }
    }

    /** Prints out the Board object in a grid-like format */
    public void printBoard()
    {
        for (String[] rows : grid)
        {
            for (String square : rows)
            {
                System.out.print(square);
            }
            System.out.println();
        }
    }

    /**
     * Drops the player's piece/symbol into the designated column
     *
     * @param col The column the piece is being dropped into
     * @param player The player who is dropping the piece
     */
    public void dropPiece(int col, Player player)
    {
        for (int r = grid.length - 1; r >= 0; r--)
        {
            if (grid[r][col - 1].indexOf(Integer.toString(col)) != -1)
            {
                grid[r][col - 1] = " " + player.getPiece() + " |";
                break;
            }
        }
    }

    /**
     * Determines if grid is full or not.
     * Grid is full if all grid squares have a piece in them.
     *
     * @return true if grid is full; false otherwise
     */
    public boolean boardFull()
    {
        String box1 = " O |";
        String box2 = " @ |";
        int count = 0;
        for (int c = 0; c < 7; c++)
        {
            if (grid[0][c].equals(box1) || grid[0][c].equals(box2))
            {
                count++;
            }
        }

        if (count == 7)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Determines if there are any winning combinations in the horizontal direction.
     * Prints corresponding win messages if true.
     *
     * @return true if 4 adjacent pieces in the horizontal direction are the same; false otherwise
     */
    public boolean horizontalWin()
    {
        String player1Win = " O | O | O | O |";
        String player2Win = " @ | @ | @ | @ |";
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length - 3; c++)
            {
                String fourBoxes = grid[r][c] + grid[r][c + 1] + grid[r][c + 2] + grid[r][c + 3];
                if (fourBoxes.equals(player1Win))
                {
                    System.out.println("\nPLAYER 1 WINS!");
                    return true;
                }
                if (fourBoxes.equals(player2Win))
                {
                    System.out.println("\nPLAYER 2 WINS!");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines if there are any winning combinations in the vertical direction.
     * Prints corresponding win messages if true.
     *
     * @return true if 4 adjacent pieces in the vertical direction are the same; false otherwise
     */
    public boolean verticalWin()
    {
        String player1Win = " O | O | O | O |";
        String player2Win = " @ | @ | @ | @ |";
        for (int r = 0; r < grid.length - 3; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                String fourBoxes = grid[r][c] + grid[r + 1][c] + grid[r + 2][c] + grid[r + 3][c];
                if (fourBoxes.equals(player1Win))
                {
                    System.out.println("\nPLAYER 1 WINS!");
                    return true;
                }
                if (fourBoxes.equals(player2Win))
                {
                    System.out.println("\nPLAYER 2 WINS!");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines if there are any winning combinations in top to bottom diagonal direction (\).
     * Prints corresponding win messages if true.
     *
     * @return true if 4 adjacent pieces in the top to bottom diagonal direction (\) are the same; false otherwise
     */
    public boolean diagonalWin1()
    {
        String player1Win = " O | O | O | O |";
        String player2Win = " @ | @ | @ | @ |";
        for (int r = 0; r < grid.length - 3; r++)
        {
            for (int c = 0; c < grid[0].length - 3; c++)
            {
                String fourBoxes = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] + grid[r + 3][c + 3];
                if (fourBoxes.equals(player1Win))
                {
                    System.out.println("\nPLAYER 1 WINS!");
                    return true;
                }
                if (fourBoxes.equals(player2Win))
                {
                    System.out.println("\nPLAYER 2 WINS!");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines if there are any winning combinations in bottom to top diagonal direction (/).
     * Prints corresponding win messages if true.
     *
     * @return true if 4 adjacent pieces in the bottom to top diagonal direction (/) are the same; false otherwise
     */
    public boolean diagonalWin2()
    {
        String player1Win = " O | O | O | O |";
        String player2Win = " @ | @ | @ | @ |";
        for (int r = grid.length - 1; r >= 3 ; r--)
        {
            for (int c = 0; c < grid[0].length - 3; c++)
            {
                String fourBoxes = grid[r][c] + grid[r - 1][c + 1] + grid[r - 2][c + 2] + grid[r - 3][c + 3];
                if (fourBoxes.equals(player1Win))
                {
                    System.out.println("\nPLAYER 1 WINS!");
                    return true;
                }
                if (fourBoxes.equals(player2Win))
                {
                    System.out.println("\nPLAYER 2 WINS!");
                    return true;
                }
            }
        }
        return false;
    }
}
