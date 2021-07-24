package Pieces;
import java.util.ArrayList;
import java.util.List;

import ChessEngine.ChessState;
import ChessEngine.Move;

public class Piece {
	
	protected char id;
	protected int player;
	protected int row;
	protected int column;
	protected ChessState state;
	
	public Piece(){
		id = 0;
		player = 0;
		row = -1;
		column = -1;
		state = null;
	}
	
	public Piece(ChessState state, char id, int player, int row, int column){
		this.state = state;
		this.player = player;
		this.id = id;
		this.row = row;
		this.column = column;
	}
	
	public Piece(Piece p){
		id = p.id;
		state = p.state;
		player = p.player;
		row = p.row;
		column = p.column;
	}
	
	public char getId() { 
		return id; 
	}
	
	public List<Move> getMoves(){ 
		return new ArrayList<>(); 
	}
	
	protected boolean isEmpty(int r, int c){
		Piece[][] board = state.getBoard();
		
		if ( board[r][c].player == 0 )
			return true;
		else
			return false;
	}
	
	protected boolean isEnemy(Piece other){
		if ( player > 0 && other.player > 0 && player != other.player )
			return true;
	
		return false;
	}

	public void setRow(int row) {
		this.row = row;
	}
}
