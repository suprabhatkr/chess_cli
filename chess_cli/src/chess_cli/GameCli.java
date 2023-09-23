package chess_cli;

import chess_cli.ChessPieces.ChessPieceCli;

public class GameCli {
	ChessBoardCli chessBoard = new ChessBoardCli();
	
	
	
	public void PrintChessBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				ChessPieceCli chessPiece = chessBoard.getChessSquare(i, j).getChessPiece();
				if (chessPiece == null)
					System.out.print("****  ");
				else 
					System.out.print(chessPiece.getName() + " ");
			}
			System.out.print("\n");
		}
	}
}
