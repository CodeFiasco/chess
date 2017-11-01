package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.chess.Position.Position;
import org.academiadecodigo.chess.grid.Grid;

import java.util.LinkedList;
import java.util.List;

public class Rook extends Piece {

    public Rook(Grid grid, Player player, int col, int row) {
        super(grid, player, PieceType.ROOK, col, row);
    }

    @Override
    public Position[] possibleMoves() {
        List<Position> moves = new LinkedList<>();
        boolean top = true, right = true, bottom = true, left = true;

        for (int i = 1; i < Constants.BOARD_SIZE; i++) {
            //TOP
            if (top && pos.getRow() - i >= 0) {

                if (grid.isOccupied(pos.getCol(), pos.getRow() - i)) {
                    top = false;

                    if (!grid.isFriendly(getPlayer(), pos.getCol(), pos.getRow() - i)) {
                        moves.add(new Position(pos.getCol(), pos.getRow() - i));
                    }
                } else {

                    moves.add(new Position(pos.getCol(), pos.getRow() - i));
                }
            }

            // RIGHT
            if (right && pos.getCol() + i < Constants.BOARD_SIZE) {

                if (grid.isOccupied(pos.getCol() + i, pos.getRow())) {

                    right = false;

                    if (!grid.isFriendly(getPlayer(), pos.getCol() + i, pos.getRow())) {
                        moves.add(new Position(pos.getCol() + i, pos.getRow()));
                    }
                } else {

                    moves.add(new Position(pos.getCol() + i, pos.getRow()));
                }
            }

            // BOTTOM
            if (bottom && pos.getRow() + i < Constants.BOARD_SIZE) {

                if (grid.isOccupied(pos.getCol(), pos.getRow() + i)) {
                    bottom = false;

                    if (grid.isFriendly(getPlayer(), pos.getCol(), pos.getRow() + i)) {
                        moves.add(new Position(pos.getCol(), pos.getRow() + i));
                    }
                } else {

                    moves.add(new Position(pos.getCol(), pos.getRow() + i));
                }
            }

            // LEFT
            if (left && pos.getCol() - i >= 0) {

                if (grid.isOccupied(pos.getCol() - i, pos.getRow())) {
                    left = false;

                    if (grid.isFriendly(getPlayer(), pos.getCol() - i, pos.getRow())) {
                        moves.add(new Position(pos.getCol() - i, pos.getRow()));
                    }
                } else {

                    moves.add(new Position(pos.getCol() - i, pos.getRow()));
                }
            }
        }

        return moves.toArray(new Position[0]);
    }
}
