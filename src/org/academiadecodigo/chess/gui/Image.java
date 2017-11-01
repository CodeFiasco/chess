package org.academiadecodigo.chess.gui;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Image {

    private Picture picture;

    public Image(String file, int col, int row) {
        picture = new Picture(Constants.PADDING + Constants.CELL_PADDING, Constants.PADDING + Constants.CELL_PADDING, file);
        picture.draw();
        translate(col, row);
    }

    public void translate(int cols, int rows) {
        picture.translate(Constants.CELL_SIZE * cols, Constants.CELL_SIZE * rows);
    }
}
