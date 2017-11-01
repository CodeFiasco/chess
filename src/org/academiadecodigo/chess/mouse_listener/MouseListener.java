package org.academiadecodigo.chess.mouse_listener;

import org.academiadecodigo.chess.grid.Grid;
import org.academiadecodigo.chess.unit_converter.UnitConverter;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseListener implements MouseHandler {

    private Mouse mouse;
    private Grid grid;

    public MouseListener(Grid grid) {
        this.grid = grid;

        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        grid.click(UnitConverter.xToCol((int) mouseEvent.getX()), UnitConverter.yToRow((int) mouseEvent.getY()));
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
