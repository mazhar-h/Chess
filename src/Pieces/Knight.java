package Pieces;
import java.util.ArrayList;
import java.util.List;

import ChessEngine.ChessState;
import ChessEngine.Move;

public class Knight extends Piece {

	public Knight(ChessState state, char id, int player, int row, int column) {
		super(state, id, player, row, column);
	}
	
	@Override
	public List<Move> getMoves(){
		Piece[][] board = super.state.getBoard();
		List<Move> list = new ArrayList<>();
		
		//2x top left, 2x top right, 2x bottom left, 2x bottom right
		int[] coordX = {row-1, row-2, row-2, row-1, row+1, row-1, row+2, row+1};
		int[] coordY = {column-2, column-1, column+1, column+2, column-2, column-2, column+1, column+2};
		
		for (int i = 0; i < coordX.length; i++)
		{
			int tempX = coordX[i];
			int tempY = coordY[i];
			
			if ( tempX >= 0 && tempX < 8 && tempY >= 0 && tempY < 8 )
			{
				if ( isEmpty(tempX, tempY) )
				{
					list.add( new Move(tempX, tempY) );
				}
				else if ( isEnemy(board[tempX][tempY]) )
				{
					list.add( new Move(tempX, tempY) );
				}
			}
		}
		
		return list;
	}

}
