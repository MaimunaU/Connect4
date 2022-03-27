/**
 * This class represents a Player object
 *
 * @author Maimuna Ullah
 */
public class Player {
    /** String representing a player's piece */
    private final String piece;

    /**
     * Initializes a Player object with a piece
     *
     * @param piece The player's piece
     */
    public Player(String piece)
    {
        this.piece = piece;
    }

    /**
     * @return Returns the player's piece
     */
    public String getPiece() { return piece; }
}
