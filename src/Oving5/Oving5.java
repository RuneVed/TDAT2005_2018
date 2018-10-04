package Oving5;

import Oving4.Part1.DoubleLinkedList;

import java.util.Date;
import java.util.HashMap;

import static javax.swing.JOptionPane.*;

/*
* Simple testclient for exercise 5
*
* Rune Vedøy Fall 2018
 */
public class Oving5 {
    public static void main(String[] args){

        HashTable hashTable = new HashTable();

        String[] arrayOfNames= {"Almås Annabelle Solem", "Andersson William", "Andersson Vegard",
                "Andresen Sebastian Martin", "Aune Jostein Johansen", "Axell Christian", "Daniel Larsen",
                "Bakhmadov Magomed Khatujevitsj", "Braathen Mathias", "Bui Aria Thuy Dung", "Bø Halvor Fladsrud",
                "Christiansen Herman", "Dahl Magnus", "Dalseth Christian Mathias", "Debik Karol Jerzy",
                "Elvemo Sebastian Aanesland", "Fossland Ole-Henrik", "Frantzen Odd-Erik", "Fridheim Marius",
                "Fylling Johan-Henrik", "Garmann Ingelin", "Gram Hans-Jeiger", "Habeeb Khaled Mohammad",
                "Halvarsson Kevin Mentzoni", "Haugum Terje", "Helgeland Kevin Andre", "Hestnes Håkon Dalen",
                "Hjelle Sara", "Holt Eyvind Nikolai", "Hynne Sigurd", "Iversen Anders Hallem",
                "Jacobsen Sigurd Løite", "Jacobsen William Chakroun", "Johansen Aleksander",
                "Johansen Kristaver Birkeland", "Johansen Eivind Alfsvåg", "Kampenhå y Kristian", "Knutsen Yair Day",
                "Knutsen Mathias", "Koteng Markus Thomassen", "Kristoffersen Jonas", "Larsen Knut Johan",
                "Larsen Albert Ohrem", "Larsson, Øivind Haugerø", "Lervik Eivind Hestnes",
                "Li Jingyi", "Lilleeng Simon", "Martinsen Magnus Revheim", "Martinsen Herman Ryen", "Mediå Fredrik",
                "Mellemseter Michael", "Midttun Jonathan", "Moan Martin Andreas", "Monsen Fredrik",
                "Nicolausson Sander", "Nordseth Morten Nyang", "Nygård Marius", "Nystuen Ådne",
                "Opsahl Elisabeth Marie", "Paulshus Sindre Haugland", "Rad Saadat Ilia", "Ramberg Håvard Hammer",
                "Roll Erling", "Rondestvedt Trond Jacob", "Rø stgård Kim Richard", "Sandnes Martin",
                "Siiri Anette Olli", "Skaug Oscar Tideman Borgerud", "Stavseng Ådne Eide", "Strand Snorre Kristoffer",
                "Strømhylden Ben Oscar", "Sundøy Erlend", "Søther Ane", "Sørlie Lars", "Teiler-Johnsen Mari",
                "Tengs Simen Sølevik", "Thomassen Sindre", "Thorkildsen Patrick", "Timdal Eivind Rui", "Tokvam Balder",
                "Tran Quan Nguyen", "Tverfjell Julie Isabelle Malmedal", "Ullah Mona", "Valen Ruben Solvang",
                "Valstadsve Øyvind", "Vatle Jan-Marius", "Vedøy Rune", "Vesterlid Ørjan Bostad",
                "Wangensteen Kim Anners", "Wichstrøm Brage", "Worren Magne", "Østtveit Bjørnar", "Øverland Sveinung",
                "Øvsthus Vebjørn Hansen", "Ådnanes Stian", "Aasvestad Jørgen"};

        String[] testarray ={"god","dog"};

        //PART 1 - Hashing using linked lists to handle collisions
        DoubleLinkedList[] test1 = hashTable.createHashTableNode(arrayOfNames);
        //test1[4].printList(test1[4].getHead());
        System.out.println("Total amount of crashes: " + hashTable.getTotalAmountOfCrashes());
        String search = showInputDialog("Write the name you want to search for");
        System.out.println("True if in course, false if not : "+hashTable.isInCourse(search, test1));


        //PART 2 - Hashing using double hashing

        // Creating a table with 5 million random numbers
        int table1[] = hashTable.fillTable(5000000);
        int[] hash;



        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;
        do {
             hash= hashTable.hashForWholeNumbers(table1);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)(slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. round random table " + tid);


        HashMap a;

        start = new Date();
        runder = 0;
        do {
            a = new HashMap<Integer,Integer>();
            for (int i : table1){
                a.put(i,i);
            }
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)(slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. round random table " + tid);


    }
}
