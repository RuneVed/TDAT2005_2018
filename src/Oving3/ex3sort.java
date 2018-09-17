package Oving3;
/*
 * Code is from the book "Algoritmer og datastrukturer" by Helge Hafting and Mildrid Ljosland
 *
 * Rune Vedøy September 2018
 */

import java.util.Date;

public class ex3sort {

    private int tbl[];
    public int[] fillTable(int amountOfNumbers){
        tbl= new int[amountOfNumbers];
        final int MIN= 0;
        final int MAX = 100000;

        for (int i = 0; i<amountOfNumbers ; i++){
            tbl[i] = MIN + (int)(Math.random()*((MAX-MIN) +1));
        }
        return tbl;
    }

    public boolean checkIfSorted(int[] table){
        for (int i = 0; i<table.length-1;i++){
            if (table[i]>table[i+1]){
                return false;
            }
        }
        return true;
    }

    private static int split(int[]tabell, int left, int right){
        int iLeft =left;
        int iRight=right-1;
        int median = median3sort(tabell,left,right);
        int divide = tabell[median];
        bytt(tabell,median,right-1);
        while (true){
            while (tabell[++iLeft]<divide);
            while (tabell[--iRight]>divide);
            if (iLeft>=iRight)break;
            bytt(tabell,iLeft,iRight);
        }
        bytt(tabell,iLeft,right-1);
        return iLeft;
    }

    // Sorting 3 numbers to find their median.
    private static int median3sort(int[] tabell, int left, int right){
        int median = (left+right)/2;
        if (tabell[left]>tabell[median]){
            bytt(tabell,left,median);
        }
        if (tabell[median]>tabell[right]){
            bytt(tabell,median,right);
            if (tabell[left]>tabell[median]) bytt(tabell,left,median);
        }
        return median;
    }

    public static void bytt(int[] tabell, int i, int j){
        int k = tabell[j];
        tabell[j] = tabell[i];
        tabell[i] = k;
    }

    public static void quicksort(int[]tabell, int left, int right){
        if (right -left > 2){
            int divideposition= split(tabell,left,right);
            quicksort(tabell,left,divideposition-1);
            quicksort(tabell,divideposition+1,right);
        }else{
            median3sort(tabell,left,right);
        }
    }

    static void sort(int[] arr, int lowIndex, int highIndex) {

        if(highIndex <= lowIndex) {
            return;
        }

        if(arr[lowIndex] > arr[highIndex]) {
            swap(arr, lowIndex, highIndex);
        }

        int pivot1 = arr[lowIndex];
        int pivot2 = arr[highIndex];

        int lt = lowIndex + 1;
        int gt = highIndex - 1;
        int i = lowIndex + 1;

        while(i <= gt) {
            if(arr[i] < pivot1) {
                swap(arr, i, lt);
                lt++;
                i++;
            } else if(arr[i] > pivot2) {
                swap(arr, i, gt);
                gt--;
            } else {
                i++;
            }
        }

        swap(arr, lowIndex, lt-1);
        swap(arr, gt+1, highIndex);

        lt--;
        gt++;

        sort(arr, lowIndex, lt-1);
        sort(arr, lt+1, gt-1);
        sort(arr, gt+1, highIndex);

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}

class testEx3{
    public static void main(String args[]){
        ex3sort sort = new ex3sort();
        int amountOfNumbers = 20000;
        int table1[] = sort.fillTable(amountOfNumbers);
        int table2[] = sort.fillTable(amountOfNumbers);

        // Random numbers

        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;
        do {
            sort.quicksort(table1,0,amountOfNumbers-1);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)(slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. round random table" + tid);

        System.out.println("Is it sorted : " +sort.checkIfSorted(table1));
        System.out.println("Is it sorted : " +sort.checkIfSorted(table2) +"\n");


        // Duplicate numbers

        int amountOfNumbersDuplicate = 20000;
        int tableDuplicate[] = new int[amountOfNumbersDuplicate];
        for (int i = 1; i<tableDuplicate.length; i++){
            tableDuplicate[0] =1;
            if (tableDuplicate[i-1]==1){
                tableDuplicate[i]=2;
            }else tableDuplicate[i] =1;

        }

        start = new Date();
        runder = 0;
        do {
            sort.quicksort(tableDuplicate,0,amountOfNumbersDuplicate-1);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)(slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. round duplicate:" + tid);

        int tableDuplicate2[] = new int[amountOfNumbersDuplicate];
        for (int i = 1; i<tableDuplicate2.length; i++){
            tableDuplicate2[0] =1;
            if (tableDuplicate2[i-1]==1){
                tableDuplicate2[i]=2;
            }else tableDuplicate2[i] =1;

        }

        start = new Date();
        runder = 0;
        do {
            sort.sort(tableDuplicate2,0,amountOfNumbersDuplicate-1);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)(slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. round duplicate:" + tid);

        System.out.println("Is it sorted : " +sort.checkIfSorted(tableDuplicate));
        System.out.println("Is it sorted : " +sort.checkIfSorted(tableDuplicate2) +"\n");

        // Sorted array
        int amountSorted = 20000;
        int[] sortedTable = new int[amountSorted];
        for (int i =0; i<sortedTable.length; i++){
            sortedTable[i]=i;
        }


        start = new Date();
        runder = 0;
        do {
            sort.quicksort(sortedTable,0,amountSorted-1);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)(slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. round duplicate:" + tid);


        int[] sortedTable2 = new int[amountSorted];
        for (int i =0; i<sortedTable2.length; i++){
            sortedTable2[i]=i;
        }


        start = new Date();
        runder = 0;
        do {
            sort.sort(sortedTable2,0,amountSorted-1);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)(slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. round duplicate:" + tid);

        System.out.println("Is it sorted : " +sort.checkIfSorted(sortedTable));
        System.out.println("Is it sorted : " +sort.checkIfSorted(sortedTable2) +"\n");
    }
}
