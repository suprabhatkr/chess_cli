package chess_cli.Player;

public class ChessPlayerCli {
	protected String name;
	protected int points;
	protected boolean color;
	
	public ChessPlayerCli(String name, boolean color) {
		this.name = name;
		this.points = 0;
		this.color = color;
	}
	
	public void addPoints(int points) {
		this.points += points;
	}
}
