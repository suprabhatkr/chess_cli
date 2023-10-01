package chess_cli.ChessPieces;

import chess_cli.ChessBoardCli;
import java.util.ArrayList;

public class RookCli extends ChessPieceCli {
    public RookCli(ChessBoardCli chessBoard, boolean color, int row, int column) {
        super(chessBoard, color, row, column);
        this.name = "rook";
    }

    @Override
    public ArrayList<String> getValidMoves() {
        validMoves.clear();

        // Define horizontal and vertical move directions
        int[][] moveOffsets = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        for (int[] offset : moveOffsets) {
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

                // Continue moving in the same direction
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
