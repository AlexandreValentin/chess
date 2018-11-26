package Model;

import java.util.ArrayList;

public class Player {
	private int id;
	private String name;
	private ArrayList<Piece> Pieces = new ArrayList<Piece>(); 
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setPieces(ArrayList<Piece> Pieces) {
		this.Pieces = Pieces;
	}
	
	public ArrayList<Piece> getPieces() {
		return this.Pieces;
	}
}
