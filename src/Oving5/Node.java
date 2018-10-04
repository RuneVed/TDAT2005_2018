package Oving5;

/*
 * Code is from the book "Algoritmer og datastrukturer" by Helge Hafting and Mildrid Ljosland
 *
 * Rune Vedøy September 2018
 */

public class Node {
    long element;
    String name;
    protected Node next;
    Node previous;

    // Creating node
    public Node(long element, Node next, Node previous){
        this.element = element;
        this.next = next;
        this.previous= previous;
    }
    public Node(String name, Node next, Node previous){
        this.name=name;
        this.next=next;
        this.previous=previous;
    }

    public long findElement(){
        return element;
    }

   public Node findNext(){
        return next;
    }

    public Node findPrevious(){
        return previous;
    }

}
