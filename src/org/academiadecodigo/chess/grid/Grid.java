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

        createPieces();
    }

    private void createPieces() {
        // Pawns
        for (int i = 0; i < pieces.length; i++) {
            pieces[i][1] = new Pawn(this, Player.BLACK, i, 1);
            pieces[i][6] = new Pawn(this, Player.WHITE, i, 6);
        }

        // Rooks
        pieces[0][0] = new Rook(this, Player.BLACK, 0, 0);
        pieces[7][0] = new Rook(this, Player.BLACK, 7, 0);
        pieces[0][7] = new Rook(this, Player.WHITE, 0, 7);
        pieces[7][7] = new Rook(this, Player.WHITE, 7, 7);

        // Knights
        pieces[1][0] = new Knight(this, Player.BLACK, 1, 0);
        pieces[6][0] = new Knight(this, Player.BLACK, 6, 0);
        pieces[1][7] = new Knight(this, Player.WHITE, 1, 7);
        pieces[6][7] = new Knight(this, Player.WHITE, 6, 7);

        // Bishops
        pieces[2][0] = new Bishop(this, Player.BLACK, 2, 0);
        pieces[5][0] = new Bishop(this, Player.BLACK, 5, 0);
        pieces[2][7] = new Bishop(this, Player.WHITE, 2, 7);
        pieces[5][7] = new Bishop(this, Player.WHITE, 5, 7);

        // Queens
        pieces[4][0] = new Queen(this, Player.BLACK, 4, 0);
        pieces[4][7] = new Queen(this, Player.WHITE, 4, 7);

        // Kings
        pieces[3][0] = new King(this, Player.BLACK, 3, 0);
        pieces[3][7] = new King(this, Player.WHITE, 3, 7);
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

                if (pieces[col][row] != null) {
                    pieces[col][row].kill();
                }

                pieces[col][row] = selectedPiece;
            }
        }

        selectedPiece = null;
    }

    public boolean isFriendly(Player player, int col, int row) {

        if (col < 0 || col >= Constants.BOARD_SIZE || row < 0 || row >= Constants.BOARD_SIZE || pieces[col][row] == null) {
            return false;
        }

        return pieces[col][row].getPlayer() == player;
    }

    public boolean isOccupied(int col, int row) {
        return pieces[col][row] != null;
    }
}
