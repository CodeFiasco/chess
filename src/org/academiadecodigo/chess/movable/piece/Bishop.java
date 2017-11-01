package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.chess.Position.Position;
import org.academiadecodigo.chess.grid.Grid;

import java.util.LinkedList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(Grid grid, Player player, int col, int row) {
        super(grid, player, PieceType.BISHOP, col, row);
    }

    @Override
    public Position[] possibleMoves() {
        List<Position> moves = new LinkedList<>();
        boolean topLeft = true, topRight = true, botLeft = true, botRight = true;

        for (int i = 1; i < Constants.BOARD_SIZE; i++) {
            // TOP LEFT
            if (topLeft && pos.getCol() - i >= 0 && pos.getRow() - i >= 0) {
                if (grid.isOccupied(pos.getCol() - i, pos.getRow() - i)) {
                    topLeft = false;

                    if (!grid.isFriendly(getPlayer(), pos.getCol() - i, pos.getRow() - i)) {
                        moves.add(new Position(pos.getCol() - i, pos.getRow() - i));
                    }
                } else {

                    moves.add(new Position(pos.getCol() - i, pos.getRow() - i));
                }
            }

            // TOP RIGHT
            if (topRight && pos.getCol() + i < Constants.BOARD_SIZE && pos.getRow() - i >= 0) {
                if (grid.isOccupied(pos.getCol() + i, pos.getRow() - i)) {
                    topRight = false;

                    if (!grid.isFriendly(getPlayer(), pos.getCol() + i, pos.getRow() - i)) {
                        moves.add(new Position(pos.getCol() + i, pos.getRow() - i));
                    }
                } else {

                    moves.add(new Position(pos.getCol() + i, pos.getRow() - i));
                }
            }

            // BOTTOM LEFT
            if (botLeft && pos.getCol() - i >= 0 && pos.getRow() + i < Constants.BOARD_SIZE) {
                if (grid.isOccupied(pos.getCol() - i, pos.getRow() + i)) {
                    botLeft = false;

                    if (!grid.isFriendly(getPlayer(), pos.getCol() - i, pos.getRow() + i)) {
                        moves.add(new Position(pos.getCol() - i, pos.getRow() + i));
                    }
                } else {

                    moves.add(new Position(pos.getCol() - i, pos.getRow() + i));
                }
            }

            // BOTTOM RIGHT
            if (botRight && pos.getCol() + i < Constants.BOARD_SIZE && pos.getRow() + i < Constants.BOARD_SIZE) {
                if (grid.isOccupied(pos.getCol() + i, pos.getRow() + i)) {
                    botRight = false;

                    if (!grid.isFriendly(getPlayer(), pos.getCol() + i, pos.getRow() + i)) {
                        moves.add(new Position(pos.getCol() + i, pos.getRow() + i));
                    }
                } else {

                    moves.add(new Position(pos.getCol() + i, pos.getRow() + i));
                }
            }
        }

        return moves.toArray(new Position[0]);
    }
}
