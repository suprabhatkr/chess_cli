package chess_cli.ChessPieces;

public class PositionCli {
	private int row, column;
	
	public PositionCli(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public String getPositionString() {
		return ((char)(getRow() + 64) + Integer.toString(getColumn() + 1));
	}
	
}
