package org.academiadecodigo.chess.movable.piece;

public enum Player {
    BLACK("black-"),
    WHITE("white-");

    private String filePath;

    Player(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public Player getAdversary() {
        switch (this) {
            case WHITE:
                return BLACK;

            case BLACK:
                return WHITE;
        }

        System.out.println("Something went wrong!");
        return null;
    }
}
