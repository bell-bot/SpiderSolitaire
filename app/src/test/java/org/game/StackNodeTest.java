package org.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StackNodeTest {
    @Test
    void testUnsetNextNode_whenNextNodeExists_returnsCorrectNode() {
        Card card = new Card(Suits.HEART, Ranks.TEN);
        StackNode nextNode = new StackNode(card);
        StackNode currentNode = new StackNode(card, nextNode);

        StackNode actualNextNode = currentNode.unsetNextNode();

        assertEquals(nextNode, actualNextNode);
    }

    @Test
    void testUnsetNextNode_whenNextNodeDoesNotExist_returnsCorrectNode() {
        Card card = new Card(Suits.HEART, Ranks.TEN);
        StackNode currentNode = new StackNode(card);

        StackNode actualNextNode = currentNode.unsetNextNode();

        assertNull(actualNextNode);
    }
}
