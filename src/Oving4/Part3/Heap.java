package Oving4.Part3;

import java.util.Arrays;
import java.util.Date;

import Oving3.ex3sort;

/*
 * Code is from the book "Algoritmer og datastrukturer" by Helge Hafting and Mildrid Ljosland
 *
 * Rune Vedøy September 2018
 */
public class Heap {
    private int tbl[];
    private int length;
    private int node[];

    public Heap(int[] node){
        this.node = node;
        length = node.length;
    }

    public int[] getNode() {
        return node;
    }

    public void heapsort(){
        createHeap();
        int l = length;
        while (length >1){
            int max = getMax();
            node[length]=max;
        }
        length =l;
    }

    public void createHeap(){
        int i = length /2;
        while (i-->0){
            fixHeap(i);
        }
    }

    public void fixHeap(int i){
        int m = (i<<1)+1; // left shift
        if (m< length){
            int h = m+1;
            if (h< length && node[h]>node[m]) m=h;
            if (node[m]>node[i]){
                change(node,i,m);
                fixHeap(m);
            }
        }
    }

    public int getMax(){
        int max = node[0];
        node[0] = node[--length];
        fixHeap(0);
        return max;
    }

    public static void change(int[] tabell, int i, int j){
        int k = tabell[j];
        tabell[j] = tabell[i];
        tabell[i] = k;
    }


    public int[] fillTable(int amountOfNumbers){
        tbl= new int[amountOfNumbers];
        final int MIN= 0;
        final int MAX = 100000;

        for (int i = 0; i<amountOfNumbers ; i++){
            tbl[i] = MIN + (int)(Math.random()*((MAX-MIN) +1));
        }
        return tbl;
    }

}

class testHeap{
    public static void main(String[] args){
        //Creating the table for heapsort
        int amountOfNumbers = 20000;
        int[] tbl= new int[amountOfNumbers];
        final int MIN= 0;
        final int MAX = 100000;

        for (int i = 0; i<amountOfNumbers ; i++){
            tbl[i] = MIN + (int)(Math.random()*((MAX-MIN) +1));
        }

        // Duplicate array
        int amountOfNumbersDuplicate = 20000;
        int tableDuplicate[] = new int[amountOfNumbersDuplicate];
        for (int i = 1; i<tableDuplicate.length; i++){
            tableDuplicate[0] =1;
            if (tableDuplicate[i-1]==1){
                tableDuplicate[i]=2;
            }else tableDuplicate[i] =1;

        }

        // Sorted array
        int amountSorted = 20000;
        int[] sortedTable = new int[amountSorted];
        for (int i =0; i<sortedTable.length; i++){
            sortedTable[i]=i;
        }



        // Creating table for quicksort
        int amountOfNumbers2 = 20000;
        int[] tbl2= new int[amountOfNumbers2];

        for (int i = 0; i<amountOfNumbers2 ; i++){
            tbl2[i] = MIN + (int)(Math.random()*((MAX-MIN) +1));
        }

        //Creating the heap
        Heap testHeap = new Heap(tbl); //Random numbers
        Heap duplicateHeap=new Heap(tableDuplicate);
        Heap sortedHeap = new Heap(sortedTable);

        //Running heapsort - random numbers
        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;
        do {
            testHeap.heapsort();
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)(slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. round random table: " + tid);

        //Running heapsort - duplicate numbers
        start = new Date();
        runder = 0;
        do {
            duplicateHeap.heapsort();
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)(slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. round duplicate:" + tid);

        //Running heapsort - sorted array
        start = new Date();
        runder = 0;
        do {
            sortedHeap.heapsort();
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)(slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. round sorted table:" + tid);

    }
}