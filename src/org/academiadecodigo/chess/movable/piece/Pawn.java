package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.chess.Position.Position;

import java.util.LinkedList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Player player, int col, int row) {
        super(player, PieceType.PAWN, col, row);
    }

    @Override
    public Position[] possibleMoves() {
        List<Position> moves = new LinkedList<>();
        int factor = getPlayer() == Player.WHITE ? 1 : -1;

        if (pos.getRow() + factor >= 0 && pos.getRow() + factor < Constants.BOARD_SIZE) {
            moves.add(new Position(pos.getCol(), pos.getRow() + factor));
        }

        return moves.toArray(new Position[0]);
    }
}
