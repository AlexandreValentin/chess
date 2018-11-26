package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Chess;
import View.Board;

public class Piece implements ActionListener{
	public final static int[] START_1 = {8, 0};
	public final static int[] START_2 = {7, 1};

	public final static int TOWER = 0;
	public final static int PION = 1;
	public final static int FOOL = 2;
	public final static int KING = 3;
	public final static int QWEEN = 4;

	public final static int[] START_TOWER = {0, 7};
	public final static int[] START_HORSE = {1, 6};
	public final static int[] START_FOOL = {2, 5};
	public final static int[] START_KING = {3, 4};
	public final static int[] START_QWEEN = {4, 3};
	public final static int[] START_PAWN = {0, 1, 2, 3, 4, 5, 6, 7};

	public final static int MAP_SIZE_X = 8;
	public final static int MAP_SIZE_Y = 8;

	protected int posX;
	protected int posY;

	protected int moveX;
	protected int moveY;
	
	private String name;

	public Piece(int posX, int posY, int moveX, int moveY, String name) {
		this.posX = posX;
		this.posY = posY;
		this.moveX = moveX;
		this.moveY = moveY;
		this.name = name;
	}

	public Piece() {
		this.name = "";
	}

	public int getPosX() {
		return this.posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public int getMoveX() {
		return this.moveX;
	}

	public int getMoveY() {
		return this.moveY;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int row = 0; row < Chess.SIZE_SCREEN; row++) {
		    for (int col = 0; col < Chess.SIZE_SCREEN; col++) {
	    		if (Chess.buttonGrid[row][col] == e.getSource()) {
	    			if (Chess.pieces[row][col].getName() != "") {
	    				System.out.println(Chess.pieces[row][col].getName());
	    				Chess.selectedPiece = Chess.pieces[row][col];
	    			}
    			}
		    }
		}
	}

	public void move(int row, int col) {
		this.posX = row;
		this.posX = col;
	}
}
