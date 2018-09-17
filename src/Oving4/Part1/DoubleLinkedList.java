package Oving4.Part1;

/*
* Addition based on https://www.geeksforgeeks.org/?p=15194
* Rest of the code is based on the book "Algoritmer og datastrukturer" by Helge Hafting and Mildrid Ljosland
*
* Rune Vedøy September 2018
*/

import static javax.swing.JOptionPane.showInputDialog;

public class DoubleLinkedList {
    private Node head;
     Node tail;
    private int nrOfElements = 0;

    public int getNrOfElements() {
        return nrOfElements;
    }

    public Node getHead() {
        return head;
    }

    // Inserting a new value at the end of the list
    public void insertAtTheEnd(long value){
        Node newNode = new Node(value,null,tail);
        if (tail != null){
            tail.next= newNode;
        }else {
            head = newNode;
        }
        tail = newNode;
        ++nrOfElements;
    }

    // Inserting a new value at the start of the list
    public void addFirst(long value){
        Node tmp = new Node(value, head, null);
        if(head != null) head.previous = tmp;
        head = tmp;
        if(tail == null) tail = tmp;
        nrOfElements++;
    }

    // Take in the number entered by the user as a long, convert to string and loop through
    public Node NumbertoDoublyLinkedList(long number){
        String numberAsString = Long.toString(number);
        String[] numberArray = numberAsString.split("");

        for (int i = 0 ; i<numberArray.length;i++){
            insertAtTheEnd(Long.parseLong(numberArray[i]));
        }
        return head;
    }

   public void printList(Node head) {
        while (head != null) {
            System.out.print(head.element + " ");
            head = head.next;
        }
        System.out.println("");
    }

    // Addition
    public Node addition(Node first, Node second){
        long sum; // storing the resulting sum of the value in the nodes
        int carry = 0; // if the addition is more than 9

        while(first != null || second != null){
            // Adding the two nodes
            long firstTemp, secondTemp;
            if (first != null){
                firstTemp=first.findElement();
            }else{
                firstTemp = 0;
            }
            if (second != null){
                secondTemp=second.findElement();
            }else{
                secondTemp = 0;
            }
            sum = carry + firstTemp+secondTemp;

            // Setting carry to 1 or zero depending om the sum
            if (sum>=10){
                carry=1;
            }else{
                carry=0;
            }

            // updating sum if greater than 10
            sum = sum%10;
            addFirst(sum);

            // Move the pointers to the next set of nodes
            if (first!=null) first =first.previous;
            if (second!=null) second=second.previous;
        }

        if (carry!=0) addFirst(carry);
        return head;
    }

    public Node subtractLists(Node first, Node second){
        long sum; // storing the resulting sum of the value in the nodes
        int carry = 0; // if one needs to "loan"

        while(first != null || second != null) {

            // Subtraction - taking into account negative answers
            long firstTemp, secondTemp;
            if (first != null){
                firstTemp=first.findElement();
            }else{
                firstTemp = 0;
            }
            if (second != null){
                secondTemp=second.findElement();
            }else{
                secondTemp = 0;
            }

            // Taking into account loaning from the "next" node
            if (firstTemp<secondTemp && (first!=null)){
                sum = (firstTemp+10) -secondTemp+carry; // Loaning 10 from preceding number

                carry =-1;
            }else{
                sum= firstTemp-secondTemp + carry;
                if (sum<0 && first!=null){
                    sum+=10;
                    carry = -1;
                }else carry=0;

            }
           // if (first.previous ==null && firstTemp<secondTemp) sum=sum*-1;

            // Adding sum to the result list
            addFirst(sum);

            if (first!=null) {
                first =first.previous;
            }
            if (second!=null) {
                second=second.previous;
            }
        }
        if( head.findElement() == 0){
            head = head.next;
        }

        return head;
    }

}

class test{
    public static void main(String[] args){
        // Preparing the lists
        DoubleLinkedList list1 = new DoubleLinkedList();
        DoubleLinkedList list2 = new DoubleLinkedList();
        DoubleLinkedList result = new DoubleLinkedList();

        // Client that allows the user to enter two numbers

        long firstNumber= 355;
        long secondNumber = 9991;

        if(firstNumber<secondNumber){
            long temp = secondNumber;
            secondNumber = firstNumber;
            firstNumber = temp;
        }

        list1.NumbertoDoublyLinkedList(firstNumber);
        list1.printList(list1.getHead());
        list2.NumbertoDoublyLinkedList(secondNumber);
        list1.printList(list2.getHead());



        result.addition(list1.tail,list2.tail);
        result.printList(result.getHead());

    }
}