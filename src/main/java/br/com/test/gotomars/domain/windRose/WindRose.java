package br.com.test.gotomars.domain.windRose;

import br.com.test.gotomars.domain.enums.Directions;

public class WindRose {

    private Directions nextNode;
    private Directions previousNode;
    private Directions currentNode;

    public WindRose(Directions nextNode, Directions previusNode, Directions currentNode) {
        this.nextNode = nextNode;
        this.previousNode = previusNode;
        this.currentNode = currentNode;
    }

    public Directions getNextNode() {
        return nextNode;
    }

    public void setNextNode(Directions nextNode) {
        this.nextNode = nextNode;
    }

    public Directions getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Directions previousNode) {
        this.previousNode = previousNode;
    }

    public Directions getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Directions currentNode) {
        this.currentNode = currentNode;
    }
}
