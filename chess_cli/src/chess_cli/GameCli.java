package chess_cli;

import chess_cli.ChessPieces.*;
import chess_cli.Player.*;
import java.util.*;

public class GameCli {
	private ChessBoardCli chessBoard;
	private Scanner scanner;
	
	public GameCli(boolean cli) {
		scanner = new Scanner(System.in);
		
		if (cli) {
			System.out.print("Enter First Player Name : ");
			String name1 = scanner.nextLine();
			System.out.print("Enter Second Player Name : ");
			String name2 = scanner.nextLine();
			
			chessBoard = new ChessBoardCli(name1, name2);
			
			// TODO: loop for playing games until some result comes or quit is called
			while (true) {
				chessBoard.printPlayerStat();
				chessBoard.printChessBoard();
				for (Map.Entry<String, ArrayList<String>> validMoves: chessBoard.getPieceMoves().entrySet()) {
					System.out.print("Init Position : " + validMoves.getKey() + " Valid Moves :");
					for (String validMove: validMoves.getValue()) {
						System.out.print(" " + validMove);
					}
					System.out.print("\n");
				}
				System.out.print("Enter you current Position (or quit/undo) : ");
				String initSquare = scanner.nextLine();
				String destSquare = "quit";
				if (initSquare.equals("quit")) {
					break;
				} else if (initSquare.equals("undo")) {
					chessBoard.undo();
				} else {
					System.out.print("Enter your destination (or quit) : ");
					destSquare = scanner.nextLine();
					if (destSquare.equals("quit")) {
						break;
					}
				}
				if (chessBoard.isValidMove(initSquare, destSquare)) {
					chessBoard.move(initSquare, destSquare);
				} else {
					System.out.println("Enter valid steps");
				}
			}
		}
	}
}
