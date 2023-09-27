package chess_cli.ChessPieces;

import chess_cli.ChessBoardCli;
import java.util.ArrayList;

public class KnightCli extends ChessPieceCli {
    public KnightCli(ChessBoardCli chessBoard, boolean color, int row, int column) {
        super(chessBoard, color, row, column);
        this.name = "kngt";
    }

    @Override
    public ArrayList<PositionCli> getValidMoves() {
        ArrayList<PositionCli> validMoves = new ArrayList<PositionCli>();

        // Define knight move offsets
        int[][] moveOffsets = {
            {-2, -1}, {-2, 1},
            {-1, -2}, {-1, 2},
            {1, -2},  {1, 2},
            {2, -1},  {2, 1}
        };

        for (int[] offset : moveOffsets) {
            int newRow = this.position.getRow() + offset[0];
            int newColumn = this.position.getColumn() + offset[1];

            if (isValidPosition(newRow, newColumn)) {
                ChessPieceCli targetPiece = chessBoard.getChessSquare(newRow, newColumn).getChessPiece();

                if (targetPiece == null || targetPiece.isGold() != this.isSilver()) {
                    validMoves.add(new PositionCli(newRow, newColumn));
                }
            }
        }

        return validMoves;
    }

    private boolean isValidPosition(int row, int column) {
        return row >= 0 && row < 8 && column >= 0 && column < 8;
    }
}