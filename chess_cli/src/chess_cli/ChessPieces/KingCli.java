package chess_cli.ChessPieces;

import chess_cli.ChessBoardCli;
import java.util.ArrayList;

public class KingCli extends ChessPieceCli {
    public KingCli(ChessBoardCli chessBoard, boolean color, int row, int column) {
        super(chessBoard, color, row, column);
        this.name = "KING";
    }

    @Override
    public ArrayList<String> getValidMoves() {
        validMoves.clear();

        // Possible king move offsets
        int[][] moveOffsets = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] offset : moveOffsets) {
            int newRow = this.row + offset[0];
            int newColumn = this.column + offset[1];

            if (isValidPosition(newRow, newColumn)) {
                ChessPieceCli targetPiece = chessBoard.getChessSquare(newRow, newColumn).getChessPiece();
                
                if (targetPiece == null || targetPiece.isGold() == this.isSilver()) {
                    validMoves.add(ChessBoardCli.getPositionString(newRow, newColumn));
                }
            }
        }

        return validMoves;
    }

    private boolean isValidPosition(int row, int column) {
        return row >= 0 && row < 8 && column >= 0 && column < 8;
    }
}
