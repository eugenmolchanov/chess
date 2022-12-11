package com.itechart.chessgame.movement.executor;

import com.itechart.chessgame.figure.Figure;
import com.itechart.chessgame.movement.type.Move;
import com.itechart.chessgame.square.Square;
import com.itechart.chessgame.square.SquareId;
import com.itechart.chessgame.util.TriFunction;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public interface MoveExecutorDto {

    List<Move> getMoves();

    SquareId getSquareId();

    Figure getFigure();

    TriFunction<SquareId, Move, Figure, Optional<SquareId>> getNextMoveSquareId();

    Function<SquareId, Square> getSquareById();

    Supplier<Integer> getNextPlayerMove();
}
