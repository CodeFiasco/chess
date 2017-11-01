package org.academiadecodigo.chess.grid;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.chess.Position.Position;
import org.academiadecodigo.chess.gui.Square;
import org.academiadecodigo.chess.movable.piece.*;
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
                cells[i][j] = new Square(i, j, (i + j) % 2 == 0 ? Color.WHITE : Color.BLACK);
            }
        }

        pieces[0][1] = new Bishop(Player.WHITE,0, 1);
        pieces[1][1] = new Bishop(Player.BLACK,1, 1);
        pieces[0][0] = new Queen(Player.WHITE,0, 0);
        pieces[1][0] = new Queen(Player.BLACK,1, 0);
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

        cells[col][row].changeColor(Constants.SELECTED_PIECE);

        selectedPiece = pieces[col][row];
        possibleMoves = selectedPiece.possibleMoves();

        for (Position p : possibleMoves) {
            cells[p.getCol()][p.getRow()].changeColor(Constants.POSSIBLE_MOVE);
        }
    }

    private void movePiece(int col, int row) {

        cells[selectedPiece.getPos().getCol()][selectedPiece.getPos().getRow()].reset();

        for (Position p : possibleMoves) {
            cells[p.getCol()][p.getRow()].reset();

            if (col == p.getCol() && row == p.getRow()) {
                pieces[selectedPiece.getPos().getCol()][selectedPiece.getPos().getRow()] = null;
                selectedPiece.move(col, row);
                pieces[col][row] = selectedPiece;
            }
        }

        selectedPiece = null;
    }
}
