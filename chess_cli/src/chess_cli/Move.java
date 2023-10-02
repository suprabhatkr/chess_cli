package chess_cli;

import chess_cli.ChessPieces.*;

public class Move {
	private ChessSquareCli initSquare, destSquare;
	private ChessPieceCli initPiece, destPiece;
	
	public Move(ChessSquareCli initSquare, ChessSquareCli destSquare) {
		this.initSquare = initSquare;
		this.destSquare = destSquare;
		this.initPiece = initSquare.getChessPiece();
		this.destPiece = destSquare.getChessPiece();
	}
	
	public ChessSquareCli getInitSquare() {
		return this.initSquare;
	}
	
	public ChessSquareCli getDestSquare() {
		return this.destSquare;
	}
	
	public ChessPieceCli getInitPiece() {
		return this.initPiece;
	}
	
	public ChessPieceCli getDestPiece() {
		return this.destPiece;
	}
	
	public int getInitRow() {
		return this.initSquare.getRow();
	}
	
	public int getInitColumn() {
		return this.initSquare.getColumn();
	}
	
	public int getDestRow() {
		return this.destSquare.getRow();
	}
	
	public int getDestColumn() {
		return this.destSquare.getColumn();
	}
}
