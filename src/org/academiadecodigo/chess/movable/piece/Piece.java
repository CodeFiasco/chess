package org.academiadecodigo.chess.movable.piece;

import org.academiadecodigo.chess.Position.Position;
import org.academiadecodigo.chess.grid.Grid;
import org.academiadecodigo.chess.gui.Image;
import org.academiadecodigo.chess.movable.Movable;

public abstract class Piece implements Movable {

    protected Position pos;
    private Image representation;
    private Player player;
    protected Grid grid;

    public Piece(Grid grid, Player player, PieceType type, int col, int row) {
        this.grid = grid;
        this.player = player;
        this.pos = new Position(col, row);

        representation = new Image(player.getFilePath() + type.getFilePath(), col, row);
    }

    public abstract Position[] possibleMoves();

    @Override
    public void move(int col, int row) {
        representation.translate(col - pos.getCol(), row - pos.getRow());

        pos.setCol(col);
        pos.setRow(row);
    }

    public void kill() {
        representation.delete();
    }

    public Position getPos() {
        return pos;
    }

    public Player getPlayer() {
        return player;
    }
}
