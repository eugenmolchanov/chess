package com.itechart.chessgame.movement.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoveTypeFactory {

    public static List<List<Move>> rookMoves() {
        List<List<Move>> moves = new ArrayList<>();

        List<Move> moves1 = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Move move = new BasicMove(i, 0);
            moves1.add(move);
        }
        moves.add(moves1);

        List<Move> moves2 = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Move move = new BasicMove(-i, 0);
            moves2.add(move);
        }
        moves.add(moves2);

        List<Move> moves3 = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Move move = new BasicMove(0, i);
            moves3.add(move);
        }
        moves.add(moves3);

        List<Move> moves4 = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Move move = new BasicMove(0, -i);
            moves4.add(move);
        }
        moves.add(moves4);

        return moves;
    }

    public static List<List<Move>> knightMoves() {
        List<List<Move>> moves = new ArrayList<>();

        moves.add(Collections.singletonList(new BasicMove(2, 1)));
        moves.add(Collections.singletonList(new BasicMove(1, 2)));

        moves.add(Collections.singletonList(new BasicMove(2, -1)));
        moves.add(Collections.singletonList(new BasicMove(1, -2)));

        moves.add(Collections.singletonList(new BasicMove(-2, 1)));
        moves.add(Collections.singletonList(new BasicMove(-1, 2)));

        moves.add(Collections.singletonList(new BasicMove(-2, -1)));
        moves.add(Collections.singletonList(new BasicMove(-1, -2)));
        return moves;
    }

    public static List<List<Move>> bishopMoves() {
        List<List<Move>> moves = new ArrayList<>();
        List<Move> moves1 = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Move move = new BasicMove(i, i);
            moves1.add(move);
        }
        moves.add(moves1);

        List<Move> moves2 = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Move move = new BasicMove(-i, i);
            moves2.add(move);
        }
        moves.add(moves2);

        List<Move> moves3 = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Move move = new BasicMove(i, -i);
            moves3.add(move);
        }
        moves.add(moves3);

        List<Move> moves4 = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Move move = new BasicMove(-i, -i);
            moves4.add(move);
        }
        moves.add(moves4);

        return moves;
    }

    public static List<List<Move>> queenMoves() {
        List<List<Move>> queenMoves = new ArrayList<>(rookMoves());
        queenMoves.addAll(bishopMoves());
        return queenMoves;
    }

    public static List<List<Move>> kingMoves() {
        List<List<Move>> moves = new ArrayList<>();

        moves.add(Collections.singletonList(new BasicMove(1, 0)));
        moves.add(Collections.singletonList(new BasicMove(-1, 0)));
        moves.add(Collections.singletonList(new BasicMove(0, 1)));
        moves.add(Collections.singletonList(new BasicMove(0, -1)));

        moves.add(Collections.singletonList(new BasicMove(1, 1)));
        moves.add(Collections.singletonList(new BasicMove(1, -1)));
        moves.add(Collections.singletonList(new BasicMove(-1, 1)));
        moves.add(Collections.singletonList(new BasicMove(-1, -1)));

        return moves;
    }

    public static List<List<Move>> pawnMoves() {
        List<List<Move>> moves = new ArrayList<>();

        List<Move> moves1 = new ArrayList<>();
        moves1.add(new MoveOnlyMove(0, 1));
        moves1.add(new MoveOnlyMove(0, 2));
        moves.add(moves1);

        moves.add(Collections.singletonList(new HitOnlyMove(1, 1)));
        moves.add(Collections.singletonList(new HitOnlyMove(-1, 1)));

        return moves;
    }
}
