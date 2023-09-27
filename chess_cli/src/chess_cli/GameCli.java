package chess_cli;

import chess_cli.ChessPieces.*;
import chess_cli.Player.*;
import java.util.*;

public class GameCli {
	private ChessBoardCli chessBoard;
	private Scanner scanner;
	private ChessPlayerCli player1, player2;
	private boolean turn;
	
	public GameCli(boolean cli) {
		scanner = new Scanner(System.in);
		chessBoard = new ChessBoardCli();
		if (cli) {
			chessBoard.printChessBoard();
			
			System.out.print("Enter First Player Name : ");
			String name1 = scanner.nextLine();
			System.out.print("Enter Second Player Name : ");
			String name2 = scanner.nextLine();
			
			turn = true;
			
			player1 = new ChessPlayerCli(name1, turn);
			player2 = new ChessPlayerCli(name2, !turn);
			
			// TODO: loop for playing games until some result comes or quit is called
			while (true) {
				if (turn) {
					for (Map.Entry<PositionCli, ArrayList<PositionCli>> validMoves: chessBoard.getPieceMoves(turn).entrySet()) {
						System.out.print("Init Position : " + validMoves.getKey().getRow() + validMoves.getKey().getColumn() + " Valid Moves :");
						for (PositionCli validMove: validMoves.getValue()) {
							System.out.print(" " + validMove.getRow() + validMove.getColumn());
						}
						System.out.print("\n");
					}
					break;
				}
				break;
			}
		}
	}
}
