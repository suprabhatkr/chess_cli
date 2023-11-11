package in.suprabhatkumar.chess.chess_cli;
import in.suprabhatkumar.chess.chess_cli.ChessPieces.*;
import in.suprabhatkumar.chess.chess_cli.Player.*;

import java.util.*;

public class ChessBoardCli {

    private ArrayList<ArrayList<ChessSquareCli>> chessBoard;
    private Map<String, ArrayList<String>> pieceMoves;
    ArrayList<Move> movesPlayed;
    boolean turn;
    private ChessPlayerCli player1, player2;
    
    public void initiateBoard() {
    	this.chessBoard = new ArrayList<>();
    	initializeSquares();
    	initializePieces();
    	this.pieceMoves = new HashMap<String, ArrayList<String>>();
    	this.movesPlayed = new ArrayList<Move>();
    	this.turn = true;
    }
    
    public ChessBoardCli(String name1, String name2) {
    	initiateBoard();
    	this.player1 = new ChessPlayerCli(name1, turn);
		this.player2 = new ChessPlayerCli(name2, !turn);
    }
    
    public ChessBoardCli(String name1) {
    	initiateBoard();
    	this.player1 = new ChessPlayerCli(name1, turn);
		this.player2 = new BotPlayerCli(!turn);
    }
    
    private void initializeSquares() {
    	for (int row = 0; row < 8; row++) {
    		ArrayList<ChessSquareCli> chessRow = new ArrayList<>();
    		for (int column = 0; column < 8; column++) {
    			chessRow.add(new ChessSquareCli(row, column));
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
    
    public ChessSquareCli getChessSquare(String positionString) {
    	return chessBoard.get(((int) positionString.charAt(0)) - 65).get(((int) positionString.charAt(1)) - 49);
    }
    
    public Map<String, ArrayList<String>> getPieceMoves() {
    	Map<String, ArrayList<String>> pieceMoves = new HashMap<String, ArrayList<String>>();
    	for (int i = 0; i < 8; i++) {
    		for (int j = 0; j < 8; j++) {
    			if (!this.getChessSquare(i, j).isEmpty()) {
    				ChessPieceCli chessPiece = this.getChessSquare(i, j).getChessPiece();
    				if (chessPiece.isGold() == this.turn){
    					ArrayList<String> validMoves = chessPiece.getValidMoves();
    					if (!validMoves.isEmpty()) {
    						pieceMoves.put(ChessBoardCli.getPositionString(i, j), validMoves);
    					}
    				}
    			}
    		}
    	}
    	return pieceMoves;
    }
    
    public void printPlayerStat() {
    	System.out.println(player1.getName() + " : " + player1.getPoints());
    	System.out.println(player2.getName() + " : " + player2.getPoints());
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
    
    public boolean isValidMove(String initPositionString, String destSquareString) {
    	this.pieceMoves = this.getPieceMoves();
		if (pieceMoves.containsKey(initPositionString)
				&& pieceMoves.get(initPositionString).contains(destSquareString)) {
			return true;
		}
		return false;
	}
    
    public int move(String initSquare, String destSquare) {
    	return this.move(this.getChessSquare(initSquare), this.getChessSquare(destSquare), this.movesPlayed);
    }
    
    public int move(String initSquare, String destSquare, ArrayList<Move> movesPlayed) {
    	return this.move(this.getChessSquare(initSquare), this.getChessSquare(destSquare), movesPlayed);
    }
    
    public int move(ChessSquareCli initSquare, ChessSquareCli destSquare, ArrayList<Move> movesPlayed) {
    	Move newMove = new Move(initSquare, destSquare);
    	movesPlayed.add(newMove);
    	initSquare.getChessPiece().setPosition(destSquare.getRow(), destSquare.getColumn());
    	destSquare.setChessPiece(initSquare.getChessPiece());
    	destSquare.markFilled();
    	initSquare.markEmpty();
    	getCurrentPlayer().addPoints(newMove.getPoints());
    	this.turn = !this.turn;
    	return newMove.getPoints();
    }
    
    public void undo(Move lastMove) {
    	try {
    		lastMove.getInitPiece().setPosition(lastMove.getInitRow(), lastMove.getInitColumn());
        	lastMove.getInitSquare().setChessPiece(lastMove.getInitPiece());
        	lastMove.getInitSquare().markFilled();
        	if (lastMove.getDestPiece() != null) {
        		lastMove.getDestPiece().setPosition(lastMove.getDestRow(), lastMove.getDestColumn());
        		lastMove.getDestSquare().setChessPiece(lastMove.getDestPiece());
        		lastMove.getDestSquare().markFilled();
        	} else {
        		lastMove.getDestSquare().markEmpty();
        	}
        	this.turn = !this.turn;
        	getCurrentPlayer().addPoints(-lastMove.getPoints());
    	} catch (Exception e) {
            System.out.println("An IndexOutOfBoundsException occurred: " + e.getMessage());
        }
    }
    
    public void undo(ArrayList<Move> movesPlayed) {
    	int lastIndex = movesPlayed.size() - 1;
    	try {
    		Move lastMove = movesPlayed.get(lastIndex);
    		this.undo(lastMove);
        	movesPlayed.remove(lastIndex);
    	} catch (IndexOutOfBoundsException e) {
            System.out.println("An IndexOutOfBoundsException occurred: " + e.getMessage());
        }
    }
    
    public void undo() {
    	this.undo(this.movesPlayed);
    }
    
    public String getBestMove(int level) {
    	if (level < 1) {
    		return "ABCD0";
    	}
    	int highestPoints = -151;
    	String bestMove = "";
    	Map<String, ArrayList<String>> currentMoves = getPieceMoves();
    	for (Map.Entry<String, ArrayList<String>> validMoves: currentMoves.entrySet()) {
    		String initPosition = validMoves.getKey();
			for (String validMove: validMoves.getValue()) {
				int points = this.move(initPosition, validMove);
				points -= Integer.parseInt(getBestMove(level - 1).substring(4));
				if (points >= highestPoints) {
					highestPoints = points;
					bestMove = initPosition + validMove + points;
				}
				this.undo();
			}
		}
    	return bestMove;
    }
    
    public ChessPlayerCli getCurrentPlayer() {
    	return this.turn? this.player1 : this.player2;
    }
    
    public ChessPlayerCli getOpponentPlayer() {
    	return this.turn? this.player2 : this.player1;
    }
    
    public static String getPositionString(int row, int column) {
    	return ((char)(row + 65) + Integer.toString(column + 1));
    }
    
}
