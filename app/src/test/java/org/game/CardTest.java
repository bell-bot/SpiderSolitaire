package org.game;

import org.junit.jupiter.api.Test;

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

    @Test void testIsPartialSuit_WithValidSuit_returnsTrue() {
        Card card = new Card(Suits.HEART, Ranks.TEN);
        Card otherCard = new Card(Suits.HEART, Ranks.JACK);

        boolean actualIsPartialSuit = card.isPartialSuit(otherCard);

        assertTrue(actualIsPartialSuit);
    }

    @Test void testIsPartialSuit_WithInvalidSuit_returnsFalse() {
        Card card = new Card(Suits.HEART, Ranks.TEN);
        Card otherCard = new Card(Suits.HEART, Ranks.QUEEN);

        boolean actualIsPartialSuit = card.isPartialSuit(otherCard);

        assertFalse(actualIsPartialSuit);
    }

}
