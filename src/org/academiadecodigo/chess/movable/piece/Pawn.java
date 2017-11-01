package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.chess.Position.Position;
import org.academiadecodigo.chess.grid.Grid;

import java.util.LinkedList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Grid grid, Player player, int col, int row) {
        super(grid, player, PieceType.PAWN, col, row);
    }

    @Override
    public Position[] possibleMoves() {
        List<Position> moves = new LinkedList<>();
        int factor = getPlayer() == Player.WHITE ? 1 : -1;

        if (pos.getRow() + factor >= 0 && pos.getRow() + factor < Constants.BOARD_SIZE) {
            // TOP / BOTTOM
            moves.add(new Position(pos.getCol(), pos.getRow() + factor));

            // LEFT enemy
            if (pos.getCol() > 0 && grid.getPieceAt(pos.getCol() + 1, pos.getRow() + factor) != null && grid.getPieceAt(pos.getCol() - 1, pos.getRow() + factor).getPlayer() != getPlayer()) {
                moves.add(new Position(pos.getCol() - 1, pos.getRow() + factor));
            }

            // RIGHT enemy
            if (pos.getCol() + 1 < Constants.BOARD_SIZE - 1 && grid.getPieceAt(pos.getCol() + 1, pos.getRow() + factor) != null && grid.getPieceAt(pos.getCol() + 1, pos.getRow() + factor).getPlayer() != getPlayer()) {
                moves.add(new Position(pos.getCol() + 1, pos.getRow() + factor));
            }
        }

        return moves.toArray(new Position[0]);
    }
}
