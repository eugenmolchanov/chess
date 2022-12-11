package com.itechart.chessgame.square;

import com.itechart.chessgame.figure.Figure;

public class Square {

    private Figure figure;

    public Square() {
    }

    public Square(Figure figure) {
        this.figure = figure;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public String toString() {
        if (figure != null) {
            return figure.getColor().getPlayerNumber() + figure.getFigureType().getName();
        }

        return "---";
    }
}
