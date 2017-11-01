package org.academiadecodigo.chess.unit_converter;

import org.academiadecodigo.chess.Constants;

public abstract class UnitConverter {

    public static int xToCol(int x) {
        return (x - Constants.PADDING) / Constants.CELL_SIZE;
    }

    public static int yToRow(int y) {
        return (y - Constants.PADDING - 25) / Constants.CELL_SIZE;
    }
}
