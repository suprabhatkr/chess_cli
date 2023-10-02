package chess_cli.ChessPieces;

import chess_cli.ChessBoardCli;
import java.util.ArrayList;

public class PawnCli extends ChessPieceCli {
    public PawnCli(ChessBoardCli chessBoard, boolean color, int row, int column) {
        super(chessBoard, color, row, column);
        this.name = "pawn";
        this.points = 1;
    }

    @Override
    public ArrayList<String> getValidMoves() {
        validMoves.clear();
        int forwardDirection = this.isSilver() ? 1 : -1;
        int newRow = this.row + forwardDirection;
        int newColumn = this.column;

        if (newRow >= 0 && newRow < 8 && newColumn >= 0 && newColumn < 8 &&
                chessBoard.getChessSquare(newRow, newColumn).isEmpty()) {
            validMoves.add(ChessBoardCli.getPositionString(newRow, newColumn));
        }

        int[] captureOffsets = {-1, 1};
        for (int offset : captureOffsets) {
            newRow = this.row + forwardDirection;
            newColumn = this.column + offset;
            if (newRow >= 0 && newRow < 8 && newColumn >= 0 && newColumn < 8 &&
                    !chessBoard.getChessSquare(newRow, newColumn).isEmpty() &&
                    chessBoard.getChessSquare(newRow, newColumn).getChessPiece().isGold() == this.isSilver()) {
                validMoves.add(ChessBoardCli.getPositionString(newRow, newColumn));
            }
        }

        return validMoves;
    }
}
