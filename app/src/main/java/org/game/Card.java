package org.game;

import java.io.PrintWriter;

public class Card {
    private final Suits suit;
    private final Ranks rank;
    private Boolean isHidden;
    private final String playingCardBack = "[xxx]";
    private final PrintWriter printWriter = new PrintWriter(System.out, true);

    public Card(Suits suit, Ranks rank, Boolean isHidden) {
        this.suit = suit;
        this.rank = rank;
        this.isHidden = isHidden;
    }

    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
        this.isHidden = false;
    }

    public Ranks getRank() {
        return rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public boolean canBeMovedToCard(Card otherCard) {
        return otherCard.getRank().ordinal()-this.rank.ordinal() == 1;
    }

    public String getCardString() {
        if (this.isHidden) {
            return this.playingCardBack;
        }

        return String.format("[%s%s]", this.rank.getSymbol(), this.suit.getSymbol());
    }

    public void printCard() {
        printWriter.println(this.getCardString());
    }
}
