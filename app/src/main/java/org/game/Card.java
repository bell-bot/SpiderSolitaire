package org.game;

public class Card {
    private final Suits suit;
    private final Ranks rank;
    private Boolean isHidden;
    private final String playingCardBack = "xx";

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

    public String toCardSymbol() {
        return String.format("[%s%s]", this.rank.getSymbol(), this.suit.getSymbol());
    }

    public void printCard() {
        System.out.print(this.toCardSymbol());
    }
}
