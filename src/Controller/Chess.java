package Controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Fool;
import Model.King;
import Model.Pawn;
import Model.Piece;
import Model.Player;
import Model.Qween;
import Model.Rider;
import Model.Tower;

public class Chess {
	
	public final static int ID_PLAYER_1 = 0;
	public final static int ID_PLAYER_2 = 1;
	
	public final static Color BLACK = Color.gray;
	public final static Color WHITE = Color.white;
	
	public static Piece selectedPiece;
	
	public final static int SIZE_SCREEN = 8;
	
	public static JButton[][] buttonGrid = new JButton[SIZE_SCREEN][SIZE_SCREEN];
	public static Piece[][] pieces = new Piece[SIZE_SCREEN][SIZE_SCREEN];
	
	public ArrayList<Piece> initGamePiece(Player p) {
		ArrayList<Piece> newList = new ArrayList<Piece>();
		
		if (p.getID() == Chess.ID_PLAYER_1) {
			newList.add(new Tower(p.getID(), 0));
			newList.add(new Rider(p.getID(), 1));
			newList.add(new Fool(p.getID(), 0));
			newList.add(new King(p.getID()));
			newList.add(new Qween(p.getID()));
			newList.add(new Fool(p.getID(), 1));
			newList.add(new Rider(p.getID(), 1));
			newList.add(new Tower(p.getID(), 1));
			newList.add(new Pawn(p.getID(), 0));
			newList.add(new Pawn(p.getID(), 1));
			newList.add(new Pawn(p.getID(), 2));
			newList.add(new Pawn(p.getID(), 3));
			newList.add(new Pawn(p.getID(), 4));
			newList.add(new Pawn(p.getID(), 5));
			newList.add(new Pawn(p.getID(), 6));
			newList.add(new Pawn(p.getID(), 7));
		} else {
			newList.add(new Pawn(p.getID(), 0));
			newList.add(new Pawn(p.getID(), 1));
			newList.add(new Pawn(p.getID(), 2));
			newList.add(new Pawn(p.getID(), 3));
			newList.add(new Pawn(p.getID(), 4));
			newList.add(new Pawn(p.getID(), 5));
			newList.add(new Pawn(p.getID(), 6));
			newList.add(new Pawn(p.getID(), 7));
			newList.add(new Tower(p.getID(), 0));
			newList.add(new Rider(p.getID(), 1));
			newList.add(new Fool(p.getID(), 0));
			newList.add(new Qween(p.getID()));
			newList.add(new King(p.getID()));
			newList.add(new Fool(p.getID(), 1));
			newList.add(new Rider(p.getID(), 1));
			newList.add(new Tower(p.getID(), 1));			
		}
		return newList;
	}
	
	public JPanel initGame(Player p1, Player p2) throws IOException {
		JPanel buttons = new JPanel(new GridLayout(Chess.SIZE_SCREEN, Chess.SIZE_SCREEN));
		BufferedImage buttonIcon = null;
		
		int i = 0;
		int j = 0;
		
		for (Piece piece : p1.getPieces()) {
			buttonIcon = ImageIO.read(new File("images/black_" + piece.getName() + ".png"));
			JButton btn = new JButton(new ImageIcon(buttonIcon));

			btn.addActionListener(piece);
			
			if ((i+j) % 2 == 0) {
				btn.setBackground(Chess.BLACK);
				btn.setForeground(Chess.WHITE);
			} else {
				btn.setBackground(Chess.WHITE);
				btn.setForeground(Chess.BLACK);
			}
			if (++i % 8 == 0) {
				j++; i = 0;
			}

			Chess.buttonGrid[i][j] = btn;
			Chess.pieces[i][j] = piece;
			buttons.add(btn);
		}

		for (int k = 0; k < Chess.SIZE_SCREEN * 4; k++) {
			JButton btn = new JButton();
			btn.setText("");
			
			if ((i+j) % 2 == 0) {
				btn.setBackground(Chess.BLACK);
				btn.setForeground(Chess.WHITE);
			} else {
				btn.setBackground(Chess.WHITE);
				btn.setForeground(Chess.BLACK);
			}
			if (++i % 8 == 0) {
				j++; i = 0;
			}
			
			buttons.add(btn);
			Chess.buttonGrid[i][j] = btn;
			Chess.pieces[i][j] = null;
		}
		
		for (Piece piece : p2.getPieces()) {
			buttonIcon = ImageIO.read(new File("images/white_" + piece.getName() + ".png"));
			
			JButton btn = new JButton(new ImageIcon(buttonIcon));
			btn.addActionListener(piece);

			if ((i+j) % 2 == 0) {
				btn.setBackground(Chess.BLACK);
				btn.setForeground(Chess.WHITE);
			} else {
				btn.setBackground(Chess.WHITE);
				btn.setForeground(Chess.BLACK);
			}
			if (++i % 8 == 0) {
				j++; i = 0;
			}
			buttons.add(btn);
			Chess.buttonGrid[i][j] = btn;
			Chess.pieces[i][j] = piece;
		}
		
		return buttons;
	}
	
	public static void main(String args[]) {
		ArrayList<Piece> PIECES_JOUEUR_1 = new ArrayList<Piece>();
		ArrayList<Piece> PIECES_JOUEUR_2 = new ArrayList<Piece>();
		Chess game = new Chess();
		JFrame frame = new JFrame ("Echéquier - Projet Génie Logiciel - LP PRISM 2018/2019 - ALEXANDRE VALENTIN");

		Player Player1 = new Player(Chess.ID_PLAYER_1, "");
		Player Player2 = new Player(Chess.ID_PLAYER_2, "");
		
		PIECES_JOUEUR_1 = game.initGamePiece(Player1);
		PIECES_JOUEUR_2 = game.initGamePiece(Player2);
		
		Player1.setPieces(PIECES_JOUEUR_1);
		Player2.setPieces(PIECES_JOUEUR_2);
		
		frame.add(game.initGame(Player1, Player2));

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
