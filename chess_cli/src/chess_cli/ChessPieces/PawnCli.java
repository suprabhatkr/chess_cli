package chess_cli.ChessPieces;

import chess_cli.ChessBoardCli;
import java.util.ArrayList;

public class PawnCli extends ChessPieceCli {
    public PawnCli(ChessBoardCli chessBoard, boolean color, int row, int column) {
        super(chessBoard, color, row, column);
        this.name = "pawn";
    }

    @Override
    public ArrayList<PositionCli> getValidMoves() {
        ArrayList<PositionCli> validMoves = new ArrayList<PositionCli>();
        int forwardDirection = this.isSilver() ? -1 : 1;
        int newRow = this.position.getRow() + forwardDirection;
        int newColumn = this.position.getColumn();

        if (newRow >= 0 && newRow < 8 && newColumn >= 0 && newColumn < 8 &&
                chessBoard.getChessSquare(newRow, newColumn).isEmpty()) {
            validMoves.add(new PositionCli(newRow, newColumn));
        }

        // Add capturing moves
        int[] captureOffsets = {-1, 1};
        for (int offset : captureOffsets) {
            newRow = this.position.getRow() + forwardDirection;
            newColumn = this.position.getColumn() + offset;
            if (newRow >= 0 && newRow < 8 && newColumn >= 0 && newColumn < 8 &&
                    !chessBoard.getChessSquare(newRow, newColumn).isEmpty() &&
                    chessBoard.getChessSquare(newRow, newColumn).getChessPiece().isGold() != this.isSilver()) {
                validMoves.add(new PositionCli(newRow, newColumn));
            }
        }

        return validMoves;
    }
}
