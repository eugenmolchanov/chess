package com.itechart.figure;

public enum Color {

    WHITE("1"), BLACK("2");

    private String playerNumber;

    Color(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }
}
