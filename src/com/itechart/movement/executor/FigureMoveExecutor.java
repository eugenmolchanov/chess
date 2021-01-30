package com.itechart.movement.executor;

import com.itechart.figure.Color;
import com.itechart.figure.Figure;
import com.itechart.movement.type.HitOnlyMove;
import com.itechart.movement.type.Move;
import com.itechart.movement.type.MoveOnlyMove;
import com.itechart.square.SquareId;
import java.util.Set;

public interface FigureMoveExecutor {

    Set<SquareId> executeMove(MoveExecutorDto moveExecutorDto);

    default boolean isMoveOnlyMove(Move move) {
        return move instanceof MoveOnlyMove;
    }

    default boolean isHitOnlyMove(Move move) {
        return move instanceof HitOnlyMove;
    }

    default boolean isGoingToHitOwnFigure(int nextPlayerMove, Figure figureToHit) {
        return nextPlayerMove == 1 && figureToHit.getColor() == Color.WHITE ||
                nextPlayerMove == 2 && figureToHit.getColor() == Color.BLACK;
    }
}
