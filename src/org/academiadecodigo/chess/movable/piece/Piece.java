package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Position.Position;
import org.academiadecodigo.chess.movable.Movable;

public abstract class Piece implements Movable {

    protected Position pos;
    private PieceType type;

    public Piece(PieceType type, int col, int row) {
        this.pos = new Position(col, row);
        this.type = type;
    }

    public abstract Position[] possibleMoves();

    public Position getPos() {
        return pos;
    }

    public PieceType getType() {
        return type;
    }
}
