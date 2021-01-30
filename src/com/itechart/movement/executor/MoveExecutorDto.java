package com.itechart.movement.executor;

import com.itechart.figure.Figure;
import com.itechart.movement.type.Move;
import com.itechart.square.Square;
import com.itechart.square.SquareId;
import com.itechart.util.TriFunction;

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
