package org.academiadecodigo.chess.gui;

import org.academiadecodigo.chess.Constants;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Square {

    private Rectangle representation;

    public Square(int col, int row, Color color) {
        representation = new Rectangle(Constants.PADDING + col * Constants.CELL_SIZE, Constants.PADDING + row * Constants.CELL_SIZE, Constants.CELL_SIZE, Constants.CELL_SIZE);
        representation.setColor(color);
        representation.fill();
    }
}
