package in.suprabhatkumar.chess.chess_cli.ChessPieces;

import in.suprabhatkumar.chess.chess_cli.ChessBoardCli;
import java.util.ArrayList;

public class QueenCli extends ChessPieceCli {
    public QueenCli(ChessBoardCli chessBoard, boolean color, int row, int column) {
        super(chessBoard, color, row, column);
        this.name = "quen";
        this.points = 5;
    }

    @Override
    public ArrayList<String> getValidMoves() {
    	ArrayList<String> validMoves = new ArrayList<String>();

        // Horizontal and vertical moves
        for (int offset = -1; offset <= 1; offset++) {
            if (offset != 0) {
                for (int newRow = this.row + offset; isValidPosition(newRow, this.column); newRow += offset) {
                    if (chessBoard.getChessSquare(newRow, this.column).isEmpty()) {
                        validMoves.add(ChessBoardCli.getPositionString(newRow, this.column));
                    } else if (chessBoard.getChessSquare(newRow, this.column).getChessPiece().isGold() == this.isSilver()) {
                        validMoves.add(ChessBoardCli.getPositionString(newRow, this.column));
                        break;
                    } else {
                        break;
                    }
                }

                for (int newColumn = this.column + offset; isValidPosition(this.row, newColumn); newColumn += offset) {
                    if (chessBoard.getChessSquare(this.row, newColumn).isEmpty()) {
                        validMoves.add(ChessBoardCli.getPositionString(this.row, newColumn));
                    } else if (chessBoard.getChessSquare(this.row, newColumn).getChessPiece().isGold() == this.isSilver()) {
                        validMoves.add(ChessBoardCli.getPositionString(this.row, newColumn));
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

        // Diagonal moves
        int[] diagonalOffsets = {-1, 1};
        for (int rowOffset : diagonalOffsets) {
            for (int colOffset : diagonalOffsets) {
                for (int newRow = this.row + rowOffset, newColumn = this.column + colOffset;
                     isValidPosition(newRow, newColumn);
                     newRow += rowOffset, newColumn += colOffset) {
                    if (chessBoard.getChessSquare(newRow, newColumn).isEmpty()) {
                        validMoves.add(ChessBoardCli.getPositionString(newRow, newColumn));
                    } else if (chessBoard.getChessSquare(newRow, newColumn).getChessPiece().isGold() == this.isSilver()) {
                        validMoves.add(ChessBoardCli.getPositionString(newRow, newColumn));
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

        return validMoves;
    }

    private boolean isValidPosition(int row, int column) {
        return row >= 0 && row < 8 && column >= 0 && column < 8;
    }
}
