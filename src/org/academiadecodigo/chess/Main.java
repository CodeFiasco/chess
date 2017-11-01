package org.academiadecodigo.chess;

import org.academiadecodigo.chess.grid.Grid;
import org.academiadecodigo.chess.mouse_listener.MouseListener;

public class Main {

    public static void main(String[] args) {
        new MouseListener(new Grid());
    }
}
