package chess_cli;
import java.util.ArrayList;

public class ChessBoardCli {

    private ArrayList<ArrayList<ChessSquareCli>> chessBoard;
    
    public ChessBoardCli() {
    	chessBoard = new ArrayList<>();
    	initializeSquares();
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
    
//    private void initializePieces() {
//    	int sideAdjuster, row;
//    	boolean color;
//        ChessPiece chessPiece;
//
//        if (getCurrentPlayer() == getPlayer(0)) {
//            sideAdjuster = 7;
//        } else {
//            sideAdjuster = 0;
//        }
//        for (int i=0; i < 2; i++) {
//            if (getPlayer(i).isWhite()) {
//                row = Math.abs(sideAdjuster);
//            } else {
//                row = Math.abs(sideAdjuster - 7);
//            }
//
//            color = false ? i == 0 : true;
//
//            chessPiece = new RookCli(this, color, row, 0);
//            getPlayer(i).addChessPiece(chessPiece);
//            chessBoard.getChessSquare(row, 0).setChessPiece(chessPiece);
//
//            chessPiece = new KnightCli(this, color, row, 1);
//            getPlayer(i).addChessPiece(chessPiece);
//            chessBoard.getChessSquare(row, 1).setChessPiece(chessPiece);
//
//            chessPiece = new BishopCli(this, color, row, 2);
//            getPlayer(i).addChessPiece(chessPiece);
//            chessBoard.getChessSquare(row, 2).setChessPiece(chessPiece);
//
//            chessPiece = new QueenCli(this, color, row, 3);
//            getPlayer(i).addChessPiece(chessPiece);
//            chessBoard.getChessSquare(row, 3).setChessPiece(chessPiece);
//
//            chessPiece = new KingCli(this, color, row, 4);
//            getPlayer(i).addChessPiece(chessPiece);
//            chessBoard.getChessSquare(row, 4).setChessPiece(chessPiece);
//
//            chessPiece = new BishopCli(this, color, row, 5);
//            getPlayer(i).addChessPiece(chessPiece);
//            chessBoard.getChessSquare(row, 5).setChessPiece(chessPiece);
//
//            chessPiece = new KnightCli(this, color, row, 6);
//            getPlayer(i).addChessPiece(chessPiece);
//            chessBoard.getChessSquare(row, 6).setChessPiece(chessPiece);
//
//            chessPiece = new RookCli(this, color, row, 7);
//            getPlayer(i).addChessPiece(chessPiece);
//            chessBoard.getChessSquare(row, 7).setChessPiece(chessPiece);
//
//            for (int col = 0; col < 8; col++) {
//                chessPiece = new PawnCli(this, color, Math.abs(row - 1), col);
//                getPlayer(i).addChessPiece(chessPiece);
//                chessBoard.getChessSquare(Math.abs(row - 1), col).setChessPiece(chessPiece);
//            }
//
//        }
//    }
    
    public ArrayList<ArrayList<ChessSquareCli>> getChessBoard() {
    	return chessBoard;
    }

    public ChessSquareCli getChessSquare(int row, int column) {
        return chessBoard.get(row).get(column);
    }
}
