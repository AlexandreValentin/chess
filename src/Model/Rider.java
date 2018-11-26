package Model;

public class Rider extends Piece{
	public Rider(int user, int id) {
		super(Piece.START_1[user], Piece.START_KING[id], 1, 1, "rider");
	}
}
