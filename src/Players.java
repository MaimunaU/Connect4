public class Players {
    private static final String[] playerPieces = {"O", "@"};
    private final String piece;

    public Players(String piece)
    {
        this.piece = piece;
    }

    public String getPiece()
    {
        return piece;
    }
}
