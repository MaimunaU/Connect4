public class Player {
    private static final String[] playerPieces = {"O", "@"};
    private final String piece;

    public Player(String piece)
    {
        this.piece = piece;
    }

    public String getPiece()
    {
        return piece;
    }
}
