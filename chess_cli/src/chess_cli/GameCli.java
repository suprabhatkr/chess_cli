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
			System.out.print("Enter Game type 1. Play with Friends   or   2. Play with Computer : ");
			int gameType = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter First Player Name : ");
			String name1 = scanner.nextLine();
			if (1 == gameType) {
				System.out.print("Enter Second Player Name : ");
				String name2 = scanner.nextLine();
				chessBoard = new ChessBoardCli(name1, name2);
			} else {
				chessBoard = new ChessBoardCli(name1);
			}
			
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
					if (2 == gameType) {
						chessBoard.undo();
					}
				} else {
					System.out.print("Enter your destination (or quit) : ");
					destSquare = scanner.nextLine();
					if (destSquare.equals("quit")) {
						break;
					}
					if (chessBoard.isValidMove(initSquare, destSquare)) {
						chessBoard.move(initSquare, destSquare);
					} else {
						System.out.println("Enter valid steps");
					}
					if (2 == gameType) {
						String bestMoveString = chessBoard.getBestMove(1);
						chessBoard.move(bestMoveString.substring(0, 2), bestMoveString.substring(2, 4));
					}
				}
			}
		}
	}
}
