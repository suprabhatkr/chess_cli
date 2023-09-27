package chess_cli;
import java.util.ArrayList;
import chess_cli.ChessPieces.*;
import java.util.*;

public class ChessBoardCli {

    private ArrayList<ArrayList<ChessSquareCli>> chessBoard;
    
    public ChessBoardCli() {
    	chessBoard = new ArrayList<>();
    	initializeSquares();
    	initializePieces();
    }
    
    private void initializeSquares() {
    	for (int i = 0; i < 8; i++) {
    		ArrayList<ChessSquareCli> chessRow = new ArrayList<>();
    		for (int j = 0; j < 8; j++) {
    			chessRow.add(new ChessSquareCli());
    		}
    		chessBoard.add(chessRow);
    	}
    }
    
    private void initializePieces() {
    	int sideAdjuster, row;
        ChessPieceCli chessPiece;
        Boolean color;

        if (false) {
            sideAdjuster = 7;
        } else {
            sideAdjuster = 0;
        }
        for (int i=0; i < 2; i++) {
            if (i == 0) {
                row = Math.abs(sideAdjuster);
            } else {
                row = Math.abs(sideAdjuster - 7);
            }

            if (i == 0) {
            	color = false;
            } else {
            	color = true;
            }

            chessPiece = new RookCli(this, color, row, 0);
            this.getChessSquare(row, 0).setChessPiece(chessPiece);

            chessPiece = new KnightCli(this, color, row, 1);
            this.getChessSquare(row, 1).setChessPiece(chessPiece);

            chessPiece = new BishopCli(this, color, row, 2);
            this.getChessSquare(row, 2).setChessPiece(chessPiece);

            chessPiece = new QueenCli(this, color, row, 3);
            this.getChessSquare(row, 3).setChessPiece(chessPiece);

            chessPiece = new KingCli(this, color, row, 4);
            this.getChessSquare(row, 4).setChessPiece(chessPiece);

            chessPiece = new BishopCli(this, color, row, 5);
            this.getChessSquare(row, 5).setChessPiece(chessPiece);

            chessPiece = new KnightCli(this, color, row, 6);
            this.getChessSquare(row, 6).setChessPiece(chessPiece);

            chessPiece = new RookCli(this, color, row, 7);
            this.getChessSquare(row, 7).setChessPiece(chessPiece);

            for (int col = 0; col < 8; col++) {
                chessPiece = new PawnCli(this, color, Math.abs(row - 1), col);
                this.getChessSquare(Math.abs(row - 1), col).setChessPiece(chessPiece);
            }

        }
    }
    
    public ArrayList<ArrayList<ChessSquareCli>> getChessBoard() {
    	return chessBoard;
    }

    public ChessSquareCli getChessSquare(int row, int column) {
        return chessBoard.get(row).get(column);
    }
    
    // write method for get all player with its valid moves of particular type
    public Map<PositionCli, ArrayList<PositionCli>> getPieceMoves(boolean color) {
    	Map<PositionCli, ArrayList<PositionCli>> pieceMoves = new HashMap<PositionCli, ArrayList<PositionCli>>();
    	for (int i = 0; i < 8; i++) {
    		for (int j = 0; j < 8; j++) {
    			if (!this.getChessSquare(i, j).isEmpty()) {
    				ChessPieceCli chessPiece = this.getChessSquare(i, j).getChessPiece();
    				if (chessPiece.isGold() == color){
    					pieceMoves.put(new PositionCli(i, j), chessPiece.getValidMoves());
    				}
    			}
    		}
    	}
    	return pieceMoves;
    }
    
    public void printChessBoard() {
    	System.out.print("  ");
    	for (int j = 1; j <= 8; j++) {
    		System.out.print("  " + j + "  ");
    	}
    	System.out.print("\n");
		for (int i = 0; i < 8; i++) {
			System.out.print((char) (65 + i) + " ");
			for (int j = 0; j < 8; j++) {
				ChessPieceCli chessPiece = this.getChessSquare(i, j).getChessPiece();
				if (chessPiece == null)
					System.out.print("**** ");
				else 
					System.out.print(chessPiece.getName() + " ");
			}
			System.out.print("\n");
		}
	}
}
