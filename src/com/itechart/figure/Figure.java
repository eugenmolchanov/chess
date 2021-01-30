package com.itechart.figure;

import com.itechart.movement.executor.FigureMoveExecutor;
import com.itechart.movement.type.Move;

import java.util.List;
import java.util.Objects;

public class Figure {

    private Color color;
    private FigureTypes figureType;

    public Figure(Color color, FigureTypes figureType) {
        Objects.requireNonNull(color);
        Objects.requireNonNull(figureType);
        this.color = color;
        this.figureType = figureType;
    }

    public Color getColor() {
        return color;
    }

    public FigureTypes getFigureType() {
        return figureType;
    }

    public List<List<Move>> getMoveTypes() {
        return figureType.getMoveTypes();
    }

    public FigureMoveExecutor getFigureMoveExecutor() {
        return figureType.getFigureMoveExecutor();
    }
}
