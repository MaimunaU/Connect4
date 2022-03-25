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
}
