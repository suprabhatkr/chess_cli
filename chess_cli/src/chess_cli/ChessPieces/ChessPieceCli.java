package chess_cli.ChessPieces;
import chess_cli.ChessBoardCli;
import java.util.ArrayList;

public class ChessPieceCli {
	protected String name;
	protected boolean color;
	protected PositionCli position;
	protected ChessBoardCli chessBoard;
	
	public ChessPieceCli(ChessBoardCli chessBoard, boolean color, int row, int column) {
		this.color = color;
		this.position = new PositionCli(row, column);
		this.chessBoard = chessBoard;
	}
	
	public boolean isGold() {
		return this.color;
	}
	
	public boolean isSilver() {
		return !this.color;
	}
	
	public ArrayList<PositionCli> getValidMoves() {
		return null;
	}
}

