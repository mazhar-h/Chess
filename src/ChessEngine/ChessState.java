package ChessEngine;
import java.util.HashMap;
import java.util.Map;

import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;

public class ChessState {	
	final char PAWN = 'p';
	final char ROOK = 'r';
	final char KNIGHT = 'n';
	final char BISHOP = 'b';
	final char QUEEN = 'q';
	final char KING = 'k';
	final int PLAYER_1 = 1;
	final int PLAYER_2 = 2;
	final int EMPTY = 0;
	private Piece[][] board;
	private Map<Character, Integer> capturedPieces;
	
	public ChessState(){ 
		initializePieces();
		initializeCapturedPieces();
	}
	
	public void initializeCapturedPieces(){
		capturedPieces = new HashMap<>();
		capturedPieces.put(PAWN, 0);
		capturedPieces.put(ROOK, 0);
		capturedPieces.put(KNIGHT, 0);
		capturedPieces.put(BISHOP, 0);
		capturedPieces.put(QUEEN, 0);
		capturedPieces.put(KING, 0);
		capturedPieces.put((char) (PAWN - 32), 0);
		capturedPieces.put((char) (ROOK - 32), 0);
		capturedPieces.put((char) (KNIGHT - 32), 0);
		capturedPieces.put((char) (BISHOP - 32), 0);
		capturedPieces.put((char) (QUEEN - 32), 0);
		capturedPieces.put((char) (KING - 32), 0);
	}
	
	public void initializePieces(){
		board = new Piece[8][8];
		
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				board[i][j] = new Piece(this, (char) EMPTY, EMPTY, i, j);

		
		board[0][0] = new Rook(this, (char) (ROOK - 32), PLAYER_2, 0, 0);
		board[0][1] = new Knight(this, (char) (KNIGHT - 32), PLAYER_2, 0, 1);
		board[0][2] = new Bishop(this, (char) (BISHOP - 32), PLAYER_2, 0, 2);
		board[0][3] = new Queen(this, (char) (QUEEN - 32), PLAYER_2, 0, 3);
		board[0][4] = new King(this, (char) (KING - 32), PLAYER_2, 0, 4);
		board[0][5] = new Bishop(this, (char) (BISHOP - 32), PLAYER_2, 0, 5);
		board[0][6] = new Knight(this, (char) (KNIGHT - 32), PLAYER_2, 0, 6);
		board[0][7] = new Rook(this, (char) (ROOK - 32), PLAYER_2, 0, 7);

		
		for (int i = 0; i < 8; i++)
			board[1][i] = new Pawn(this, (char) (PAWN - 32), PLAYER_2, 1, i);

		board[7][0] = new Rook(this, ROOK, PLAYER_1, 7, 0);
		board[7][1] = new Knight(this, KNIGHT, PLAYER_1, 7, 1);
		board[7][2] = new Bishop(this, BISHOP, PLAYER_1, 7, 2);
		board[7][3] = new Queen(this, QUEEN, PLAYER_1, 7, 3);
		board[7][4] = new King(this, KING, PLAYER_1, 7, 4);
		board[7][5] = new Bishop(this, BISHOP, PLAYER_1, 7, 5);
		board[7][6] = new Knight(this, KNIGHT, PLAYER_1, 7, 6);
		board[7][7] = new Rook(this, ROOK, PLAYER_1, 7, 7);
		
		for (int i = 0; i < 8; i++)
			board[6][i] = new Pawn(this, PAWN, PLAYER_1, 6, i);
	}
	
	public Piece[][] getBoard(){
		Piece[][] copy = new Piece[8][8];	//deep copy board
		
		for(int row = 0; row < board.length; row++)
				System.arraycopy(board[row], 0, copy[row], 0, board.length);
		
		return copy;
	}
	
	public void addCapturedPiece(char p){
		int value = capturedPieces.get(p);
		capturedPieces.replace(p, ++value);
	}
	
	public int getCountOfCapturedPiece(char p){
		return capturedPieces.get(p);
	}
	
	public Piece getPiece(int r, int c){
		return board[r][c];
	}
	
	public void removeCapturedPiece(char p){
		int value = capturedPieces.get(p);
		capturedPieces.replace(p, --value);
	}
	
	public void setPiece(Piece p, int r, int c){
		board[r][c] = p;
	}	
}
