package Pieces;
import java.util.ArrayList;
import java.util.List;

import ChessEngine.ChessState;
import ChessEngine.Move;

public class Rook extends Piece {
	
	private boolean moved;
	
	public Rook(ChessState state, char id, int player, int row, int column){
		super(state, id, player, row, column);
		moved = false;
	}

	@Override
	public List<Move> getMoves(){
		Piece[][] board = super.state.getBoard();
		List<Move> list = new ArrayList<>();
		
		//up
		for (int i = row - 1; i >= 0; i--)
		{
			if ( isEmpty(i, column) )
			{
				list.add( new Move(i, column) );
				continue;
			}
			if ( isEnemy(board[i][column]) )
			{
				list.add( new Move(i, column) );
				break;
			}
			else
				break;

		}
		
		//down
		for (int i = row + 1; i < 8; i++)
		{
			if ( isEmpty(i, column) )
			{
				list.add( new Move(i, column) );
				continue;
			}
			if ( isEnemy(board[i][column]) )
			{
				list.add( new Move(i, column) );
				break;
			}
			else
				break;
		}
		
		//left
		for (int i = column - 1; i >= 0; i--)
		{
			if ( isEmpty(row, i) )
			{
				list.add( new Move(row, i) );
				continue;
			}
			if ( isEnemy(board[row][i]) )
			{
				list.add( new Move(row, i) );
				break;
			}
			else
				break;
		}
		
		//right
		for (int i = column + 1; i < 8; i++)
		{
			if ( isEmpty(row, i) )
			{
				list.add( new Move(row, i) );
				continue;
			}
			if ( isEnemy(board[row][i]) )
			{
				list.add( new Move(row, i) );
				break;
			}
			else
				break;
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
