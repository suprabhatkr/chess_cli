package chess_cli.ChessPieces;

import chess_cli.ChessBoardCli;

public class RookCli extends ChessPieceCli {
	public RookCli(ChessBoardCli chessBoard, boolean color, int row, int column) {
		super(chessBoard, color, row, column);
		this.name = "rook";
	}
}
