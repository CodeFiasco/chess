package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.chess.Position.Position;
import org.academiadecodigo.chess.grid.Grid;

import java.util.LinkedList;
import java.util.List;

public class Queen extends Piece {

    public Queen(Grid grid, Player player, int col, int row) {
        super(grid, player, PieceType.QUEEN, col, row);
    }

    @Override
    public Position[] possibleMoves() {
        List<Position> moves = new LinkedList<>();
        boolean top = true, right = true, bottom = true, left = true;
        boolean topLeft = true, topRight = true, botLeft = true, botRight = true;

        for (int i = 1; i < Constants.BOARD_SIZE; i++) {

            // TOP
            if (pos.getRow() - i >= 0) {
                // LEFT
                if (topLeft && pos.getCol() - i >= 0) {
                    if (grid.isOccupied(pos.getCol() - i, pos.getRow() - i)) {
                        topLeft = false;

                        if (!grid.isFriendly(getPlayer(), pos.getCol() - i, pos.getRow() - i)) {
                            moves.add(new Position(pos.getCol() - i, pos.getRow() - i));
                        }
                    } else {

                        moves.add(new Position(pos.getCol() - i, pos.getRow() - i));
                    }
                }

                // MIDDLE
                if (top) {
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
                if (topRight && pos.getCol() + i < Constants.BOARD_SIZE) {
                    if (grid.isOccupied(pos.getCol() + i, pos.getRow() - i)) {
                        topRight = false;

                        if (!grid.isFriendly(getPlayer(), pos.getCol() + i, pos.getRow() - i)) {
                            moves.add(new Position(pos.getCol() + i, pos.getRow() - i));
                        }
                    } else {

                        moves.add(new Position(pos.getCol() + i, pos.getRow() - i));
                    }
                }
            }

            // LEFT
            if (left && pos.getCol() - i >= 0) {
                if (grid.isOccupied(pos.getCol() - i, pos.getRow())) {
                    left = false;

                    if (!grid.isFriendly(getPlayer(), pos.getCol() - i, pos.getRow())) {
                        moves.add(new Position(pos.getCol() - i, pos.getRow()));
                    }
                } else {

                    moves.add(new Position(pos.getCol() - i, pos.getRow()));
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
            if (pos.getRow() + i < Constants.BOARD_SIZE) {
                // LEFT
                if (botLeft && pos.getCol() - i >= 0) {
                    if (grid.isOccupied(pos.getCol() - i, pos.getRow() + i)) {
                        botLeft = false;

                        if (!grid.isFriendly(getPlayer(), pos.getCol() - i, pos.getRow() + i)) {
                            moves.add(new Position(pos.getCol() - i, pos.getRow() + i));
                        }
                    } else {

                        moves.add(new Position(pos.getCol() - i, pos.getRow() + i));
                    }

                }

                // MIDDLE
                if (bottom) {
                    if (grid.isOccupied(pos.getCol(), pos.getRow() + i)) {
                        bottom = false;

                        if (!grid.isFriendly(getPlayer(), pos.getCol(), pos.getRow() + i)) {
                            moves.add(new Position(pos.getCol(), pos.getRow() + i));
                        }
                    } else {
                        moves.add(new Position(pos.getCol(), pos.getRow() + i));
                    }
                }

                // RIGHT
                if (botRight && pos.getCol() + i < Constants.BOARD_SIZE) {
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
        }

        return moves.toArray(new Position[0]);
    }
}
