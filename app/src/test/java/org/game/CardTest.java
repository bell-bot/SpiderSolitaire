package org.game;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;


public class CardTest {

    @Test void testCanBeMovedToCard_withValidSequence_returnsTrue() {
        Card moveToCard = new Card(Suits.DIAMOND, Ranks.EIGHT);
        Card cardToBeMoved = new Card(Suits.CLUB, Ranks.SEVEN);

        assertTrue(cardToBeMoved.canBeMovedToCard(moveToCard));
    }

    @Test void testCanBeMovedToCard_withInvalidSequence_returnsFalse() {
        Card moveToCard = new Card(Suits.DIAMOND, Ranks.SEVEN);
        Card cardToBeMoved = new Card(Suits.CLUB, Ranks.EIGHT);

        assertFalse(cardToBeMoved.canBeMovedToCard(moveToCard));
    }

    @Test void testFlipTopCard_withTopCardIsHidden_setsCardToUnhidden() {
        CardStack cardStack = givenCardStack();

        assertTrue(cardStack.getCards().peek().getIsHidden());

        cardStack.flipTopCard();

        assertFalse(cardStack.getCards().peek().getIsHidden());
    }

    @Test void testGetCardString_withUnhiddenCard_returnsCorrectString() {
        Card card = new Card(Suits.HEART, Ranks.TEN);
        String expectedString = "[10♥]";
        String actualString = card.getCardString();

        assertEquals(expectedString, actualString);
    }

    @Test void testGetCardString_withHiddenCard_returnsCorrectString() {
        Card card = new Card(Suits.HEART, Ranks.TEN, true);
        String expectedString = "[xxx]";
        String actualString = card.getCardString();

        assertEquals(expectedString, actualString);
    }

    private CardStack givenCardStack() {
        Card aceSpade = new Card(Suits.SPADE, Ranks.ACE, true);
        Card kingDiamond = new Card(Suits.DIAMOND, Ranks.KING, true);
        Card kingSpade = new Card(Suits.SPADE, Ranks.KING, false);
        return new CardStack(new LinkedList<Card>(Arrays.asList(aceSpade, kingDiamond, kingSpade)));
    }
}
