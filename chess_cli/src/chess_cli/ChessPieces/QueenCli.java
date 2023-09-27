package chess_cli.ChessPieces;

import chess_cli.ChessBoardCli;
import java.util.ArrayList;

public class QueenCli extends ChessPieceCli {
    public QueenCli(ChessBoardCli chessBoard, boolean color, int row, int column) {
        super(chessBoard, color, row, column);
        this.name = "quen";
    }

    @Override
    public ArrayList<PositionCli> getValidMoves() {
        ArrayList<PositionCli> validMoves = new ArrayList<PositionCli>();

        // Horizontal and vertical moves
        for (int offset = -1; offset <= 1; offset++) {
            if (offset != 0) {
                for (int newRow = this.position.getRow() + offset; isValidPosition(newRow, this.position.getColumn()); newRow += offset) {
                    if (chessBoard.getChessSquare(newRow, this.position.getColumn()).isEmpty()) {
                        validMoves.add(new PositionCli(newRow, this.position.getColumn()));
                    } else if (chessBoard.getChessSquare(newRow, this.position.getColumn()).getChessPiece().isGold() == this.isSilver()) {
                        validMoves.add(new PositionCli(newRow, this.position.getColumn()));
                        break;
                    } else {
                        break;
                    }
                }

                for (int newColumn = this.position.getColumn() + offset; isValidPosition(this.position.getRow(), newColumn); newColumn += offset) {
                    if (chessBoard.getChessSquare(this.position.getRow(), newColumn).isEmpty()) {
                        validMoves.add(new PositionCli(this.position.getRow(), newColumn));
                    } else if (chessBoard.getChessSquare(this.position.getRow(), newColumn).getChessPiece().isGold() == this.isSilver()) {
                        validMoves.add(new PositionCli(this.position.getRow(), newColumn));
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
                for (int newRow = this.position.getRow() + rowOffset, newColumn = this.position.getColumn() + colOffset;
                     isValidPosition(newRow, newColumn);
                     newRow += rowOffset, newColumn += colOffset) {
                    if (chessBoard.getChessSquare(newRow, newColumn).isEmpty()) {
                        validMoves.add(new PositionCli(newRow, newColumn));
                    } else if (chessBoard.getChessSquare(newRow, newColumn).getChessPiece().isGold() == this.isSilver()) {
                        validMoves.add(new PositionCli(newRow, newColumn));
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
