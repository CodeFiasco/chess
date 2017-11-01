package org.academiadecodigo.chess.grid;

import org.academiadecodigo.chess.Position.Position;
import org.academiadecodigo.chess.gui.Square;
import org.academiadecodigo.chess.movable.piece.King;
import org.academiadecodigo.chess.movable.piece.Piece;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Grid {

    private Piece[][] pieces;
    private Piece selectedPiece;

    private Square[][] cells;

    private Position[] possibleMoves;

    public Grid() {
        pieces = new Piece[8][8];
        cells = new Square[8][8];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Square(i, j, (i + j) % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY);
            }
        }

        pieces[0][0] = new King();
    }

    public void click(int col, int row) {

        if (selectedPiece == null) {
            selectPiece(col, row);
            return;
        }

        movePiece(col, row);
    }

    private void selectPiece(int col, int row) {

        if (col >= cells.length || row >= cells[0].length || pieces[col][row] == null) {
            return;
        }

        cells[col][row].changeColor(Color.GREEN);

        selectedPiece = pieces[col][row];
        possibleMoves = selectedPiece.possibleMoves();

        for (Position p : possibleMoves) {
            cells[p.getCol()][p.getRow()].changeColor(Color.BLUE);
        }
    }

    private void movePiece(int col, int row) {

        cells[selectedPiece.getPos().getCol()][selectedPiece.getPos().getRow()].reset();

        for (Position p : possibleMoves) {
            cells[p.getCol()][p.getRow()].reset();

            if (col == p.getCol() && row == p.getRow()) {
                selectedPiece.move(col, row);
                pieces[selectedPiece.getPos().getCol()][selectedPiece.getPos().getRow()] = null;
                pieces[col][row] = selectedPiece;
            }
        }

        selectedPiece = null;
    }
}
