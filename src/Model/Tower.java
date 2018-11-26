package Model;

public class Tower extends Piece{
	public Tower(int user, int id) {
		super(Piece.START_1[user], Piece.START_TOWER[id], 1, 1, "tower");
	}
}
