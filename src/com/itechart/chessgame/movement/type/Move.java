package com.itechart.chessgame.movement.type;

public abstract class Move {

    private int xDelta;
    private int yDelta;

    public Move(int xDelta, int yDelta) {
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }

    public int getxDelta() {
        return xDelta;
    }

    public int getyDelta() {
        return yDelta;
    }
}
