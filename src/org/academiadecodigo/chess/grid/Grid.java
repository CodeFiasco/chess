package org.academiadecodigo.chess.grid;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.chess.gui.Square;
import org.academiadecodigo.chess.movable.piece.Piece;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Grid {

    private Piece[][] pieces;
    private Square[][] cells;

    public Grid() {
        pieces = new Piece[8][8];
        cells = new Square[8][8];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Square(i, j, (i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
            }
        }
    }
}
