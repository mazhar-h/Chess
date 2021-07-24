package Pieces;
import java.util.ArrayList;
import java.util.List;

import ChessEngine.ChessState;
import ChessEngine.Move;

public class Pawn extends Piece{
	
	private boolean moved;
	
	public Pawn(ChessState state, char id, int player, int row, int column) {
		super(state, id, player, row, column);
		moved = false;
	}
	
	public List<Move> getMoves(){ 
		List<Move> list = new ArrayList<>();

		return null;
	}
	
	public boolean isMoved(){
		return moved;
	}
	
	public void setMoved(){
		moved = !moved;
	}
}
