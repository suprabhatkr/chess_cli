package chess_cli;

import chess_cli.ChessPieces.ChessPieceCli;

public class ChessSquareCli {
	private boolean filled;
	private ChessPieceCli chessPiece;
	
	public boolean isEmpty() {
		return !this.filled;
	}
	
	public ChessPieceCli getChessPiece() {
		return this.chessPiece;
	}
	
	public void setChessPiece(ChessPieceCli chessPiece) {
		this.chessPiece = chessPiece;
	}
}