package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.chess.Position.Position;
import org.academiadecodigo.chess.grid.Grid;

import java.util.LinkedList;
import java.util.List;

public class Knight extends Piece {

    public Knight(Grid grid, Player player, int col, int row) {
        super(grid, player, PieceType.KNIGHT, col, row);
    }

    @Override
    public Position[] possibleMoves() {

        List<Position> moves = new LinkedList<>();

        // TOP
        if (pos.getRow() - 2 >= 0) {
            // LEFT
            if (pos.getCol() - 1 >= 0) {
                moves.add(new Position(pos.getCol() - 1, pos.getRow() - 2));
            }

            if (pos.getCol() + 1 < Constants.BOARD_SIZE) {
                moves.add(new Position(pos.getCol() + 1, pos.getRow() - 2));
            }
        }

        // RIGHT
        if (pos.getCol() + 2 < Constants.BOARD_SIZE) {
            // TOP
            if (pos.getRow() - 1 >= 0) {
                moves.add(new Position(pos.getCol() + 2, pos.getRow() - 1));
            }

            // BOTTOM
            if (pos.getRow() + 1 < Constants.BOARD_SIZE) {
                moves.add(new Position(pos.getCol() + 2, pos.getRow() + 1));
            }
        }

        // BOTTOM
        if (pos.getRow() + 2 < Constants.BOARD_SIZE) {
            // LEFT
            if (pos.getCol() - 1 >= 0) {
                moves.add(new Position(pos.getCol() - 1, pos.getRow() + 2));
            }

            if (pos.getCol() + 1 < Constants.BOARD_SIZE) {
                moves.add(new Position(pos.getCol() + 1, pos.getRow() + 2));
            }
        }

        // LEFT
        if (pos.getCol() - 2 >= 0) {
            // TOP
            if (pos.getRow() - 1 >= 0) {
                moves.add(new Position(pos.getCol() - 2, pos.getRow() - 1));
            }

            // BOTTOM
            if (pos.getRow() + 1 < Constants.BOARD_SIZE) {
                moves.add(new Position(pos.getCol() - 2, pos.getRow() + 1));
            }
        }

        return moves.toArray(new Position[0]);
    }
}
