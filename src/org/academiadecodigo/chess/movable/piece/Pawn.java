package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.chess.Position.Position;
import org.academiadecodigo.chess.grid.Grid;

import java.util.LinkedList;
import java.util.List;

public class Pawn extends Piece {

    private boolean firstMove;

    public Pawn(Grid grid, Player player, int col, int row) {
        super(grid, player, PieceType.PAWN, col, row);

        firstMove = true;
    }

    @Override
    public Position[] possibleMoves() {
        List<Position> moves = new LinkedList<>();
        int factor = getPlayer() == Player.WHITE ? -1 : 1;

        if (pos.getRow() + factor >= 0 && pos.getRow() + factor < Constants.BOARD_SIZE) {
            // TOP / BOTTOM
            if (!grid.isOccupied(pos.getCol(), pos.getRow() + factor)) {
                moves.add(new Position(pos.getCol(), pos.getRow() + factor));
            }

            // LEFT enemy
            if (pos.getCol() > 0 && grid.isOccupied(pos.getCol() - 1, pos.getRow() + factor) && !grid.isFriendly(getPlayer(), pos.getCol() - 1, pos.getRow() + factor)) {
                moves.add(new Position(pos.getCol() - 1, pos.getRow() + factor));
            }

            // RIGHT enemy
            if (pos.getCol() + 1 < Constants.BOARD_SIZE && grid.isOccupied( pos.getCol() + 1, pos.getRow() + factor) && !grid.isFriendly(getPlayer(), pos.getCol() + 1, pos.getRow() + factor)) {
                moves.add(new Position(pos.getCol() + 1, pos.getRow() + factor));
            }

            // First move double jump
            if (firstMove && !grid.isOccupied(pos.getCol(), pos.getRow() + factor) && !grid.isOccupied(pos.getCol(), pos.getRow() + 2 * factor)) {
                moves.add(new Position(pos.getCol(), pos.getRow() + 2 * factor));
            }
        }

        return moves.toArray(new Position[0]);
    }

    @Override
    public void move(int col, int row) {
        firstMove = false;
        super.move(col, row);
    }
}
