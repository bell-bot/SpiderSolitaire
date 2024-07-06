package org.game;

public enum Suits {
    DIAMOND("♦"),
    CLUB("♣"),
    HEART("♥"),
    SPADE("♠");

    private final String symbol;

    Suits(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
