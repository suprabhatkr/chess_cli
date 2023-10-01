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
				chessBoard.printChessBoard();
				for (Map.Entry<String, ArrayList<String>> validMoves: chessBoard.getPieceMoves(turn).entrySet()) {
					System.out.print("Init Position : " + validMoves.getKey() + " Valid Moves :");
					for (String validMove: validMoves.getValue()) {
						System.out.print(" " + validMove);
					}
					System.out.print("\n");
				}
				System.out.print("Enter you current Position (or quit) : ");
				String initSquare = scanner.nextLine();
				if (initSquare.equals("quit")) {
					break;
				}
				System.out.print("Enter your destination (or quit) : ");
				String destinationSquare = scanner.nextLine();
				if (destinationSquare.equals("quit")) {
					break;
				}
				if (chessBoard.isValidMove(initSquare, destinationSquare)) {
					chessBoard.move(initSquare, destinationSquare);
					turn = !turn;
				} else {
					System.out.println("Enter valid steps");
				}
			}
		}
	}
}
