package chess_cli;

import chess_cli.ChessPieces.ChessPieceCli;

public class ChessSquareCli {
	private boolean filled;
	private ChessPieceCli chessPiece;
	private int row, column;
	
	public ChessSquareCli(int row, int column) {
		this.markEmpty();
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public boolean isEmpty() {
		return !this.filled;
	}
	
	public ChessPieceCli getChessPiece() {
		return this.chessPiece;
	}
	
	public void markEmpty() {
		this.filled = false;
		this.chessPiece = null;
	}
	
	public void markFilled() {
		this.filled = true;
	}
	
	public void setChessPiece(ChessPieceCli chessPiece) {
		this.chessPiece = chessPiece;
		this.markFilled();
	}
}
