package org.game;

public class CardStack {
    private StackNode topCard;
    private StackNode bottomCard;

    public CardStack(Card ...cards) {
        this.push(cards);
    }

    public StackNode peek() {
        return this.topCard;
    }

    public void push(StackNode node) {
        this.setBottomCardIfNull(node);

        node.setNextNode(this.topCard);
        this.topCard = node;
    }

    public void push(StackNode ...nodes) {
        StackNode nextNode = this.topCard;
        for (StackNode node: nodes) {
            this.setBottomCardIfNull(node);

            nextNode = node;
        }

        topCard = nextNode;
    }

    public void push(Card ...cards) {
        StackNode nextNode = this.topCard;
        for (Card card: cards) {
            nextNode = new StackNode(card, nextNode);

            this.setBottomCardIfNull(nextNode);
        }

        topCard = nextNode;
    }

    public void push(CardStack cardStack) {
        cardStack.bottomCard.setNextNode(this.topCard);

        this.topCard = cardStack.topCard;
    }

    public StackNode pop() {
        StackNode newTopCard = this.topCard.unsetNextNode();

        StackNode previousTopCard = this.topCard;

        this.topCard = newTopCard;

        return previousTopCard;
    }

    public StackNode getBottomCard() {
        return this.bottomCard;
    }

    public boolean isValidStack() {
        StackNode currentNode = this.topCard;
        while(currentNode.hasNext()) {
            Card currentCard = currentNode.getCard();
            Card nextCard = currentNode.getNextNode().getCard();
            if(!currentCard.isPartialSuit(nextCard)) {
                return false;
            }
            currentNode = currentNode.getNextNode();
        }

        return true;
    }

    private void setBottomCardIfNull(StackNode node) {
        if (this.bottomCard == null) {
            this.bottomCard = node;
        }
    }

}
