package ChessEngine;
import java.util.List;

import Pieces.Piece;

public class ChessController {
	
	public static void main(String[] args){
		ChessController t = new ChessController();
		
		t.printBoard();
		
		/*
		Piece b = t.state.getPiece(4, 3);
		
		System.out.println(b.getMoves().size());
		
		for (int i = 0; i < 11; i++)
		{
			int r = b.getMoves().get(i).getRow();
			int c = b.getMoves().get(i).getColumn();
			
			System.out.printf("r:%d c:%d\n", r, c);
		}
		*/
	}
	
	private ChessState state;
	
	public ChessController(){
		state = new ChessState();
	}
	
	private boolean isLegal(int row, int column, int attackRow, int attackColumn){
		Piece p = state.getPiece(row, column);
		List<Move> l = p.getMoves();
		
		for (int i = 0; i < l.size(); i++)
		{
			Move m = l.get(i);
			int currentRow = m.getRow();
			int currentColumn = m.getColumn();
			
			if ( currentRow == attackRow && currentColumn == attackColumn )
				return true;
		}
		
		return false;
	}
	
	private Move[] translateMove(String s){
		if ( s.length() > 4 || s.length() < 4 )
			return null;
		
		Move[] m = new Move[2];
		
		s = s.toLowerCase();
		
		for (int i = 0; i < 2; i++)
		{
			if ( Character.isAlphabetic(s.charAt(2*i) ) && Character.isDigit(s.charAt(2*i+1)) )
			{
				int row = s.charAt(2*i) - 'a' - '0';
				int column = s.charAt(2*i+1) - '0';
				
				m[i] = new Move(row, column);
			}
			else
				return null;
		}
		
		return m;
	}
	
	public void printBoard(){
		Piece[][] board = state.getBoard();
		
		System.out.print("     ");
		
		for (int i = 0; i < 8; i++)
		{
			char top = (char) ('A' + i);
			System.out.printf("%c ", top);
		}
		
		System.out.println();
	
		System.out.print("    ");
		
		for (int i = 0; i < 10*2-2; i++)
			System.out.print("_");
		
		System.out.println();
				
		for (int i = 0; i < board.length; i++){
			
			int left = 8 - i;
			System.out.printf(" %d  |", left);
		
			for (int j = 0; j < board[0].length; j++){

				int c = board[i][j].getId();
				
				if ( c == 0 )
				{
					if (  (i % 2 != 0 && j % 2 == 0) || (i % 2 == 0 && j % 2 != 0) )
					{
						System.out.print('\u2588');
						System.out.print('\u2588');
					}
					else {
						System.out.print(" ");
						System.out.print(" ");
					}
				}
				else {
					System.out.print(board[i][j].getId());
					System.out.print(" ");
				}
			}
			
			System.out.print("|");
			System.out.println();
		}
		
		System.out.print("    ");
		
		for (int i = 0; i < 10*2-2; i++)
			System.out.print("-");
		
		System.out.println();
	}
}
