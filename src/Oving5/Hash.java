package Oving5;
import Oving4.Part1.Node;

/*
*Hashfunctions taken from the book "Algoritmer og datastrukturer" by Helge Hafting and Mildrid Ljosland
*
* Rune Vedøy Spring 2018
 */

public class Hash {
    static int A = 1327217885;

    public static int divhash(int key ,int size ){
        return key%size;
    }

    // x is defined: size of table= 2^x
    public static int multiplicationHash(int key, int x){
        return key*A>>(31-x);
    }

    //Double hash method 1 - if table length = prime
    public static int doublehashPrime(int key, int size){

        return(key%(size-1))+1;
    }

    // Double hash method 2 - if table length
    public static int doubleHashPower2x(int key, int size){
        return (2*key+1)%size;
    }
}
