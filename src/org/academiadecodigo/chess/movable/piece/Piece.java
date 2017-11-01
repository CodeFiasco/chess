package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Position.Position;
import org.academiadecodigo.chess.movable.Movable;

public class Piece implements Movable {

    private Position pos;
    private PieceType type;

    public Piece(PieceType type, int col, int row) {
        this.pos = new Position(col, row);
        this.type = type;
    }

    @Override
    public void move() {

    }
}
