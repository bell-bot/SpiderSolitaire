package org.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardStackTest {

    @Test void testCardStack_createsCorrectStack() {
        CardStack cardStack = givenCardStack();
        Card expectedTopCard = new Card(Suits.SPADE, Ranks.KING);
        Card expectedBottomCard = new Card(Suits.SPADE, Ranks.ACE);
        Card actualTopCard = cardStack.peek().getCard();
        Card actualBottomCard = cardStack.getBottomCard().getCard();

        thenCardsEqual(expectedTopCard, actualTopCard);
        thenCardsEqual(expectedBottomCard, actualBottomCard);
    }

    @Test void testCardStack_withSingleCard_createsCorrectStack() {
        Card aceSpade = new Card(Suits.SPADE, Ranks.ACE);
        CardStack cardStack = new CardStack(aceSpade);
        Card actualTopCard = cardStack.peek().getCard();
        Card actualBottomCard = cardStack.getBottomCard().getCard();

        thenCardsEqual(aceSpade, actualTopCard);
        thenCardsEqual(aceSpade, actualBottomCard);
    }

    @Test void testPush_createsCorrectStack() {
     CardStack cardStack = givenCardStack();
     Card expectedBottomCard = new Card(Suits.SPADE, Ranks.ACE);
     Card expectedTopCard = new Card(Suits.CLUB, Ranks.TEN);

     cardStack.push(expectedTopCard);

     Card actualTopCard = cardStack.peek().getCard();
     Card actualBottomCard = cardStack.getBottomCard().getCard();

     thenCardsEqual(expectedTopCard, actualTopCard);
     thenCardsEqual(expectedBottomCard, actualBottomCard);
    }

    @Test void testPush_withEmptyStack_createsCorrectStack() {
        CardStack cardStack = new CardStack();
        Card newCard = new Card(Suits.CLUB, Ranks.TEN);
        StackNode newStackNode = new StackNode(newCard);

        cardStack.push(newStackNode);

        Card actualTopCard = cardStack.peek().getCard();
        Card actualBottomCard = cardStack.getBottomCard().getCard();

        thenCardsEqual(newCard, actualTopCard);
        thenCardsEqual(newCard, actualBottomCard);
    }

    @Test void testPush_withMultipleNewCards_createsCorrectStack() {
        CardStack cardStack = givenCardStack();
        Card newCard1 = new Card(Suits.CLUB, Ranks.TEN);
        Card newCard2 = new Card(Suits.SPADE, Ranks.TEN);
        Card expectedTopCard = new Card(Suits.DIAMOND, Ranks.QUEEN);
        Card expectedBottomCard = new Card(Suits.SPADE, Ranks.ACE);

        cardStack.push(newCard1, newCard2, expectedTopCard);

        Card actualTopCard = cardStack.peek().getCard();
        Card actualBottomCard = cardStack.getBottomCard().getCard();

        thenCardsEqual(expectedTopCard, actualTopCard);
        thenCardsEqual(expectedBottomCard, actualBottomCard);

    }

    @Test void testPush_withStack_createdCorrectStack() {
        CardStack cardStack1 = givenCardStack();

        Card expectedBottomCard = new Card(Suits.SPADE, Ranks.ACE);

        Card card1 = new Card(Suits.HEART, Ranks.QUEEN);
        Card expectedTopCard = new Card(Suits.HEART, Ranks.ACE);
        CardStack cardStack2 = new CardStack(
                card1,
                expectedTopCard
        );

        cardStack1.push(cardStack2);
        Card actualBottomCard = cardStack1.getBottomCard().getCard();
        Card actualTopCard = cardStack1.peek().getCard();

        thenCardsEqual(expectedBottomCard, actualBottomCard);
        thenCardsEqual(expectedTopCard, actualTopCard);
    }

    private CardStack givenCardStack() {
        Card aceSpade = new Card(Suits.SPADE, Ranks.ACE);
        Card kingDiamond = new Card(Suits.DIAMOND, Ranks.KING );
        Card kingSpade = new Card(Suits.SPADE, Ranks.KING);

        return new CardStack(aceSpade, kingDiamond, kingSpade);
    }

    private void thenCardsEqual(Card expectedCard, Card actualCard) {
        assertEquals(expectedCard.getSuit(), actualCard.getSuit());
        assertEquals(expectedCard.getRank(), actualCard.getRank());
    }
}
