package org.game;

import java.util.LinkedList;

public class CardStack {
    private LinkedList<Card> cards;

    public CardStack(LinkedList<Card> cards) {
        this.cards = cards;
    }

    public LinkedList<Card> getCards() {
        return cards;
    }

    public Card getTopCard() {
        return cards.peekFirst();
    }

    public void addCard(Card card) {
        cards.push(card);
    }

    public Card removeCard() {
        return cards.pop();
    }

    public void flipTopCard() {
        Card topCard = cards.pop();
        topCard.setIsHidden(false);
        cards.push(topCard);
    }

}
