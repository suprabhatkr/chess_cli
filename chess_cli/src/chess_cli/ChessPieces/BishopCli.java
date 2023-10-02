package chess_cli.ChessPieces;

import chess_cli.ChessBoardCli;
import java.util.ArrayList;

public class BishopCli extends ChessPieceCli {
    public BishopCli(ChessBoardCli chessBoard, boolean color, int row, int column) {
        super(chessBoard, color, row, column);
        this.name = "bshp";
        this.points = 3;
    }

    @Override
    public ArrayList<String> getValidMoves() {
        validMoves.clear();

        // Define diagonal move directions
        int[][] diagonalOffsets = {
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        for (int[] offset : diagonalOffsets) {
            int newRow = this.row + offset[0];
            int newColumn = this.column + offset[1];

            while (isValidPosition(newRow, newColumn)) {
                ChessPieceCli targetPiece = chessBoard.getChessSquare(newRow, newColumn).getChessPiece();

                if (targetPiece == null) {
                    validMoves.add(ChessBoardCli.getPositionString(newRow, newColumn));
                } else if (targetPiece.isGold() == this.isSilver()) {
                    validMoves.add(ChessBoardCli.getPositionString(newRow, newColumn));
                    break;  // Stop if an opponent's piece is encountered
                } else {
                    break;  // Stop if own piece is encountered
                }

                // Continue moving along the diagonal
                newRow += offset[0];
                newColumn += offset[1];
            }
        }

        return validMoves;
    }

    private boolean isValidPosition(int row, int column) {
        return row >= 0 && row < 8 && column >= 0 && column < 8;
    }
}
