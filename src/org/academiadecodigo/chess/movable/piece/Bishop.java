package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.chess.Position.Position;

import java.util.LinkedList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(int col, int row) {
        super(PieceType.BISHOP, col, row);
    }

    @Override
    public Position[] possibleMoves() {
        List<Position> moves = new LinkedList<>();

        for (int i = 1; i < Constants.BOARD_SIZE; i++) {
            // TOP LEFT
            if (pos.getCol() - i >= 0 && pos.getRow() - i >= 0) {
                moves.add(new Position(pos.getCol() - i, pos.getRow() - i));
            }

            // TOP RIGHT
            if (pos.getCol() + i < Constants.BOARD_SIZE && pos.getRow() - i >= 0) {
                moves.add(new Position(pos.getCol() + i, pos.getRow() - i));
            }

            // BOTTOM LEFT
            if (pos.getCol() - i >= 0 && pos.getRow() + i < Constants.BOARD_SIZE) {
                moves.add(new Position(pos.getCol() - i, pos.getRow() + i));
            }

            // BOTTOM RIGHT
            if (pos.getCol() + i < Constants.BOARD_SIZE && pos.getRow() + i < Constants.BOARD_SIZE) {
                moves.add(new Position(pos.getCol() + i, pos.getRow() + i));
            }
        }

        return moves.toArray(new Position[0]);
    }
}
