public class Board {
    public String[][] grid;

    public Board (int row, int col)
    {
        grid = new String[row][col];
        for (int r = 0; r < row; r++)
        {
            int count = 1;
            for (int c = 0; c < col; c++)
            {
                grid[r][c] = (Integer.toString(count) + "|");
                count++;
            }
        }
    }

    public void printBoard()
    {
        for (String[] rows : grid)
        {
            for (String square : rows)
            {
                System.out.print(square);
            }
            System.out.println("\n--------------");
        }
    }

    public void dropPiece(int col, Player player)
    {
        for (int r = grid.length - 1; r >= 0; r--)
        {
            if (grid[r][col - 1].indexOf(Integer.toString(col)) != -1)
            {
                grid[r][col - 1] = player.getPiece() + "|";
                break;
            }
        }
    }

    public boolean horizontalWin()
    {
        String player1Win = "O|O|O|O|";
        String player2Win = "@|@|@|@|";
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[0].length - 3; c++)
            {
                String fourBoxes = grid[r][c] + grid[r][c + 1] + grid[r][c + 2] + grid[r][c + 3];
                if (fourBoxes.equals(player1Win))
                {
                    System.out.println("\nPlayer 1 Wins!");
                    return true;
                }
                if (fourBoxes.equals(player2Win))
                {
                    System.out.println("\nPlayer 2 Wins!");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verticalWin()
    {
        String player1Win = "O|O|O|O|";
        String player2Win = "@|@|@|@|";
        for (int r = 0; r < grid.length - 3; r++)
        {
            for (int c = 0; c < grid[0].length; c++)
            {
                String fourBoxes = grid[r][c] + grid[r + 1][c] + grid[r + 2][c] + grid[r + 3][c];
                if (fourBoxes.equals(player1Win))
                {
                    System.out.println("\nPlayer 1 Wins");
                    return true;
                }
                if (fourBoxes.equals(player2Win))
                {
                    System.out.println("\nPlayer 2 Wins!");
                    return true;
                }
            }
        }
        return false;
    }


}
