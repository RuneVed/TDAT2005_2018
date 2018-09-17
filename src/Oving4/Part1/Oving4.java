package Oving4.Part1;

import static javax.swing.JOptionPane.*;

public class Oving4 {

    public static void main(String[] args){

        // Preparing the lists
        DoubleLinkedList list1 = new DoubleLinkedList();
        DoubleLinkedList list2 = new DoubleLinkedList();
        DoubleLinkedList result = new DoubleLinkedList();

        // Client that allows the user to enter two numbers


        long firstNumber= Long.parseLong(showInputDialog("Enter the first number: "));
        long secondNumber = Long.parseLong(showInputDialog("Enter the second number: "));
        int menuchoice = Integer.parseInt(showInputDialog("Choose 0 for add and 1 for subtraction"));
        long temp = 0;

        if(firstNumber<secondNumber){
            temp = secondNumber;
            secondNumber = firstNumber;
            firstNumber = temp;
        }
        list1.NumbertoDoublyLinkedList(firstNumber);
        list1.printList(list1.getHead());
        list2.NumbertoDoublyLinkedList(secondNumber);
        list1.printList(list2.getHead());


       if (menuchoice == 0){
           result.addition(list1.tail,list2.tail);
           result.printList(result.getHead());
       }else if (menuchoice ==1){
           result.subtractLists(list1.tail,list2.tail);
           if (temp!=0) System.out.println("Negative");
           result.printList(result.getHead());
       }



    }
}
