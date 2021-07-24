package Pieces;
import java.util.ArrayList;
import java.util.List;

import ChessEngine.ChessState;
import ChessEngine.Move;

public class Queen extends Piece {

	public Queen(ChessState state, char id, int player, int row, int column) {
		super(state, id, player, row, column);
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
		
		//*********diagonals********
		int i = row;
		int j = column;
		
		//top right
		while ( --i >= 0 && ++j < 8 )
		{			
			if ( isEmpty(i, j) )
			{
				list.add( new Move(i, j) );
				continue;
			}
			if ( isEnemy(board[i][j]) )
			{
				list.add( new Move(i, j) );
				break;
			}
			else
				break;
		}
		
		i = row;
		j = column;
		
		//top left
		while ( --i >= 0 && --j >= 0 )
		{
			if ( isEmpty(i, j) )
			{
				list.add( new Move(i, j) );
				continue;
			}
			if ( isEnemy(board[i][j]) )
			{
				list.add( new Move(i, j) );
				break;
			}
			else
				break;
		}
		
		i = row;
		j = column;
		
		//bottom right
		while ( ++i < 8 && ++j < 8 )
		{
			if ( isEmpty(i, j) )
			{
				list.add( new Move(i, j) );
				continue;
			}
			if ( isEnemy(board[i][j]) )
			{
				list.add( new Move(i, j) );
				break;
			}
			else
				break;
		}
		
		i = row;
		j = column;
		
		//bottom left
		while ( ++i < 8 && --j >= 0 )
		{
			if ( isEmpty(i, j) )
			{
				list.add( new Move(i, j) );
				continue;
			}
			if ( isEnemy(board[i][j]) )
			{
				list.add( new Move(i, j) );
				break;
			}
			else
				break;
		}
		
		return list;
	}

}
