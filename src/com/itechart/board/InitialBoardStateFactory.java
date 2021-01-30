package com.itechart.board;

import com.itechart.figure.Color;
import com.itechart.figure.Figure;
import com.itechart.figure.FigureTypes;
import com.itechart.square.Square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitialBoardStateFactory {

    public Map<Integer, List<Square>> getBoardContainer() {
        Map<Integer, List<Square>> board = new HashMap<>();

        addEdgeRow(board, 1, Color.WHITE);
        addPawnRow(board, 2, Color.WHITE);
        addEmptyRow(board, 3);
        addEmptyRow(board, 4);
        addEmptyRow(board, 5);
        addEmptyRow(board, 6);
        addPawnRow(board, 7, Color.BLACK);
        addEdgeRow(board, 8, Color.BLACK);

        return board;
    }

    private void addEdgeRow(Map<Integer, List<Square>> board, int rowNumber, Color color) {

        List<Square> row = new ArrayList<>(8);
        row.add(0, new Square(new Figure(color, FigureTypes.ROOK)));
        row.add(1, new Square(new Figure(color, FigureTypes.KNIGHT)));
        row.add(2, new Square(new Figure(color, FigureTypes.BISHOP)));
        row.add(3, new Square(new Figure(color, FigureTypes.QUEEN)));
        row.add(4, new Square(new Figure(color, FigureTypes.KING)));
        row.add(5, new Square(new Figure(color, FigureTypes.BISHOP)));
        row.add(6, new Square(new Figure(color, FigureTypes.KNIGHT)));
        row.add(7, new Square(new Figure(color, FigureTypes.ROOK)));
        board.put(rowNumber, row);
    }

    private void addPawnRow(Map<Integer, List<Square>> board, int rowNumber, Color color) {
        List<Square> row = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            row.add(i, new Square(new Figure(color, FigureTypes.PAWN)));
        }
        board.put(rowNumber, row);
    }

    private void addEmptyRow(Map<Integer, List<Square>> board, int rowNumber) {
        List<Square> row = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            row.add(i, new Square());
        }
        board.put(rowNumber, row);
    }
}
