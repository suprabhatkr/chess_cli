package in.suprabhatkumar.chess.chess_cli.ChessPieces;
import in.suprabhatkumar.chess.chess_cli.ChessBoardCli;
import java.util.*;

public class ChessPieceCli {
	protected String name;
	protected boolean color;
	protected int row, column;
	protected ChessBoardCli chessBoard;
	protected int points;
	
	public ChessPieceCli(ChessBoardCli chessBoard, boolean color, int row, int column) {
		this.color = color;
		this.row = row;
		this.column = column;
		this.chessBoard = chessBoard;
	}
	
	public boolean isGold() {
		return this.color;
	}
	
	public boolean isSilver() {
		return !this.color;
	}
	
	public ArrayList<String> getValidMoves() {
		return null;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPosition(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getPoints() {
		return this.points;
	}
	
}

