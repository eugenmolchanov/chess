package com.itechart.square;

import java.util.Objects;

public class SquareId {

    private char file;
    private int rank;

    public SquareId(char file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    public char getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareId squareId = (SquareId) o;
        return file == squareId.file &&
                rank == squareId.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    @Override
    public String toString() {
        return "SquareId{" + file + rank + "}";
    }
}
