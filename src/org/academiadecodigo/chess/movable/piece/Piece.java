package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Position.Position;
import org.academiadecodigo.chess.gui.Image;
import org.academiadecodigo.chess.movable.Movable;

public abstract class Piece implements Movable {

    protected Position pos;
    private PieceType type;
    private Image representation;

    public Piece(PieceType type, int col, int row) {
        this.pos = new Position(col, row);
        this.type = type;

        representation = new Image(type.getFilePath(), col, row);
    }

    public abstract Position[] possibleMoves();

    @Override
    public void move(int col, int row) {
        representation.translate(col - pos.getCol(), row - pos.getRow());

        pos.setCol(col);
        pos.setRow(row);
    }

    public Position getPos() {
        return pos;
    }
}
