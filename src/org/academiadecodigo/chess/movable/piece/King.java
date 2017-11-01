package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.chess.Position.Position;

import java.util.LinkedList;
import java.util.List;

public class King extends Piece {

    public King() {
        super(PieceType.KING, 0, 0);
    }

    @Override
    public Position[] possibleMoves() {
        List<Position> moves = new LinkedList<>();

        // Top Row
        if (pos.getRow() > 0) {
            if (pos.getCol() > 0) {
                moves.add(new Position(pos.getCol() - 1, pos.getRow() - 1));
            }

            moves.add(new Position(pos.getCol(), pos.getRow() - 1));

            if (pos.getCol() < Constants.BOARD_SIZE - 1) {
                moves.add(new Position(pos.getCol() + 1, pos.getRow() - 1));
            }
        }

        // Middle Row
        if (pos.getCol() > 0) {
            moves.add(new Position(pos.getCol() - 1, pos.getRow()));
        }

        if (pos.getCol() < Constants.BOARD_SIZE - 1) {
            moves.add(new Position(pos.getCol() + 1, pos.getRow()));
        }

        // Bottom Row
        if (pos.getRow() < Constants.BOARD_SIZE - 1) {
            if (pos.getCol() > 0) {
                moves.add(new Position(pos.getCol() - 1, pos.getRow() + 1));
            }

            moves.add(new Position(pos.getCol(), pos.getRow() + 1));

            if (pos.getCol() < Constants.BOARD_SIZE - 1) {
                moves.add(new Position(pos.getCol() + 1, pos.getRow() + 1));
            }
        }

        return moves.toArray(new Position[0]);
    }
}
