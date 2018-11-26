package Model;

public class Qween extends Piece{
	public Qween(int user) {
		super(Piece.START_1[user], Piece.START_KING[user], 1, 1, "qween");
	}
	
	public void move(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
}
