package org.game;

public class StackNode {
    private final Card card;
    private StackNode nextNode;

    public StackNode(Card card) {
        this.card = card;
    }

    public StackNode(Card card, StackNode nextNode) {
        this.card = card;
        this.nextNode = nextNode;
    }

    public void setNextNode(StackNode nextNode) {
        this.nextNode = nextNode;
    }

    public boolean hasNext() {
        return (this.nextNode != null);
    }

    public StackNode unsetNextNode() {
        StackNode removedNode = this.nextNode;
        this.nextNode = null;

        return removedNode;
    }

    public StackNode getNextNode() {
        return this.nextNode;
    }

    public Card getCard() {
        return this.card;
    }
}
