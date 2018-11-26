package Model;

public class Pawn extends Piece{

	private boolean firstMove;
	
	public Pawn(int user, int id) {
		super(Piece.START_2[user], Piece.START_PAWN[id], 1, 0, "pawn");
	}
	
	public void move(int posX, int posY) {

	}
}
