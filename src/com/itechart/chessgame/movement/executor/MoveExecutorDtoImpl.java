package com.itechart.chessgame.movement.executor;

import com.itechart.chessgame.figure.Figure;
import com.itechart.chessgame.square.Square;
import com.itechart.chessgame.square.SquareId;
import com.itechart.chessgame.movement.type.Move;
import com.itechart.chessgame.util.TriFunction;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class MoveExecutorDtoImpl implements MoveExecutorDto {

    private List<Move> moves;
    private SquareId squareId;
    private Figure figure;
    private TriFunction<SquareId, Move, Figure, Optional<SquareId>> nextMoveSquareId;
    private Function<SquareId, Square> squareById;
    private Supplier<Integer> nextPlayerMove;

    private MoveExecutorDtoImpl(
            List<Move> moves,
            SquareId squareId,
            Figure figure,
            TriFunction<SquareId, Move, Figure, Optional<SquareId>> nextMoveSquareId,
            Function<SquareId, Square> squareById,
            Supplier<Integer> nextPlayerMove
    ) {
        this.moves = moves;
        this.squareId = squareId;
        this.figure = figure;
        this.nextMoveSquareId = nextMoveSquareId;
        this.squareById = squareById;
        this.nextPlayerMove = nextPlayerMove;
    }

    public static class MoveExecutorBuilder {

        private List<Move> moves;
        private SquareId squareId;
        private Figure figure;
        private TriFunction<SquareId, Move, Figure, Optional<SquareId>> nextMoveSquareId;
        private Function<SquareId, Square> squareById;
        private Supplier<Integer> nextPlayerMove;

        public MoveExecutorBuilder(
                TriFunction<SquareId, Move, Figure, Optional<SquareId>> nextMoveSquareId,
                Function<SquareId, Square> squareById,
                Supplier<Integer> nextPlayerMove
        ) {
            this.nextMoveSquareId = nextMoveSquareId;
            this.squareById = squareById;
            this.nextPlayerMove = nextPlayerMove;
        }

        public MoveExecutorBuilder withMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public MoveExecutorBuilder withSquareId(SquareId squareId) {
            this.squareId = squareId;
            return this;
        }

        public MoveExecutorBuilder withFigure(Figure figure) {
            this.figure = figure;
            return this;
        }

        public MoveExecutorDtoImpl build() {
            return new MoveExecutorDtoImpl(moves, squareId, figure, nextMoveSquareId, squareById, nextPlayerMove);
        }
    }

    @Override
    public List<Move> getMoves() {
        return moves;
    }

    @Override
    public SquareId getSquareId() {
        return squareId;
    }

    @Override
    public Figure getFigure() {
        return figure;
    }

    @Override
    public TriFunction<SquareId, Move, Figure, Optional<SquareId>> getNextMoveSquareId() {
        return nextMoveSquareId;
    }

    @Override
    public Function<SquareId, Square> getSquareById() {
        return squareById;
    }

    @Override
    public Supplier<Integer> getNextPlayerMove() {
        return nextPlayerMove;
    }
}
