package Oving5;

import Oving4.Part1.DoubleLinkedList;
/*
 * Creating hashtables,
 * One handles collisions with linked lists, the other use double hashing
 * Using linked lists methods from Oving4.
 *
 * The method isPrime is from https://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
 *
 * Rune Vedøy Fall 2018
 */

public class HashTable {
    // TODO: VEKTING???
    private Node head;
    private Node tail;
    private int totalAmountOfCrashes;

    public int getTotalAmountOfCrashes(){
        return totalAmountOfCrashes;
    }

    public Node getHead(){
        return head;
    }

    public boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    //Find if a person is in the course or not
    public boolean isInCourse(String name, DoubleLinkedList[] listToSearch){
        int nameToInt = stringToInt(name);
        int hashed = Hash.divhash(nameToInt,listToSearch.length);

        if (listToSearch[hashed]== null){
            return false;
        }

        return true;
    }

    // Printing out on doublylinked list
    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.element + " ");
            head = head.next;
        }
        System.out.println("");
    }

    // Converting a string to an Int
    public int stringToInt(String string){
        String toBeConverted = string;
        int toBeHashed = 0;
        int unicode;

        for (int i =0; i<toBeConverted.length(); i++){
            char a = toBeConverted.charAt(i);
            unicode = (int) a;
            toBeHashed+=unicode*(i+1);
        }

        return toBeHashed;
    }

    private int tbl[];
    public int[] fillTable(int amountOfNumbers){
        tbl= new int[amountOfNumbers];
        final int MIN= 1;
        final int MAX = 100000000;

        for (int i = 0; i<amountOfNumbers ; i++){
            int range = (MAX - MIN) + 1;
            tbl[i] = (int)(Math.random() * range) + MIN;

        }
        return tbl;
    }

    // Part 1 - hashtable with linked lists to handle collisions
    public DoubleLinkedList[] createHashTableNode(String[] stringTable){
        DoubleLinkedList[] hashTable = new DoubleLinkedList[(stringTable.length*120)/100]; // creating 10% overhead

        for (int i = 0; i<stringTable.length; i++){
            int toInt = stringToInt(stringTable[i]);
            int position= Hash.divhash(toInt,hashTable.length);

            if (hashTable[position] == null){
                hashTable[position]= new DoubleLinkedList();
                hashTable[position].insertAtTheEnd(stringTable[i]);
            }else {
                hashTable[position].insertAtTheEnd(stringTable[i]);
                totalAmountOfCrashes++;
                System.out.println("Crash!: "+stringTable[i] +", and " +hashTable[position].getHead().findName() );
            }
        }
        System.out.println("The average crash per person: " + stringTable.length/(double)totalAmountOfCrashes);
        System.out.println("The loadfactor is: " + stringTable.length/(double)hashTable.length);
        return hashTable;
    }

    // Part 2 - Double hashing

    public int probe(int key2 , int pos, int size){
        int position;
        position = (pos+key2)%size;
        return position;
    }

    public int[] hashForWholeNumbers(int[] inputArray){
        int length= (inputArray.length*120)/100;
        int[] hashTable;
        int position;
        int amountOfCrashes=0;

        // New table that has a prime length
        if (isPrime(length)) {
            hashTable = new int[length];
        }else{
            while (!(isPrime(length))){
                length+=1;
            }
            hashTable = new int[length];
        }

        for (int i = 0; i<inputArray.length; i++){
            position= Hash.divhash(inputArray[i],hashTable.length);

            if (hashTable[position] == 0){
                hashTable[position] = inputArray[i];
            }else {
                int doubleHash = Hash.doublehashPrime(position,length);
                while (hashTable[position]!=0){
                    position = probe(doubleHash,position,length);
                    amountOfCrashes++;

                }
                hashTable[position] = inputArray[i];
            }
        }

        System.out.println("Crashes: "+amountOfCrashes);
        return hashTable;
    }



}

/*
                }else{
                    position = Hash.doubleHashPower2x(inputArray[i],hashTable.length);
                    hashTable[position] = inputArray[i];
                }
 */