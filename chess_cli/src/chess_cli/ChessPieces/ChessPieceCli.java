package chess_cli.ChessPieces;
import chess_cli.ChessBoardCli;

public class ChessPieceCli {
	protected String name;
	protected boolean color;
	protected int row, column;
	protected ChessBoardCli chessBoard;
	
	public ChessPieceCli(ChessBoardCli chessBoard, boolean color, int row, int column) {
		this.color = color;
		this.row = row;
		this.column = column;
		this.chessBoard = chessBoard;
	}
}

