package Pieces;
import java.util.ArrayList;
import java.util.List;

import ChessEngine.ChessState;
import ChessEngine.Move;

public class King extends Piece {
	
	private boolean moved;
	
	public King(ChessState state, char id, int player, int row, int column) {
		super(state, id, player, row, column);
		moved = false;
	}
	
	public List<Move> getMoves(){ 
		Piece[][] board = state.getBoard();
		List<Move> list = new ArrayList<>();
		int[] coordX = {row-1, row, row+1};
		int[] coordY = {column-1, column, column+1};
		
		for(int i = 0; i < coordX.length; i++)
			for(int j = 0; j < coordY.length; j++)
			{
				if ( isEmpty(coordX[i], coordY[j]) )
				{
					list.add( new Move(coordX[i], coordY[j]) );
					continue;
				}
				if ( isEnemy(board[coordX[i]][coordY[j]]) )
				{
					list.add( new Move(coordX[i], coordY[j]) );
					break;
				}
			}
		
		return list;
	}
	
	public boolean isMoved(){
		return moved;
	}
	
	public void setMoved(){
		moved = !moved;
	}
}
