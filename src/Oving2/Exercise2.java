package Oving2;

import java.util.Date;

public class Exercise2 {

    //Oppgave 2.1-1
    public double powerRecursion(int power, double x){
        if (power<=0){
            return 1;
        }
        return powerRecursion(power-1,x)*x;
    }

    // Oppgave 2.2-3

    public double powerRecursion2(int power, double x){
        if (power<=0){
            return 1;
        }else if (power%2==0){
            return powerRecursion2(power/2,x*x);
        }else{
            return powerRecursion2((power-1)/2,x*x)*x;
        }

    }

}

class testOving2{
    public static void main(String[] args){
        Exercise2 test = new Exercise2();
        // Oppgave 2.1-1, 2.2-3 og math.pow
        System.out.println(test.powerRecursion(2,2));
        System.out.println(test.powerRecursion2(10000,1.0001));
        System.out.println(Math.pow(1.0001,1000000));

        // Tider
        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;
        do {
            //test.powerRecursion(10000,1.0001);
            //Math.pow(10000,1.0001);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)(slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. runde:" + tid);

        // Tid oppgave 2.1-1 : ca 1,4e-4 ms (0.00014ms) for 3^50
        // Tid oppgave 2.2-3 : ca 2.2-2.4e-5 ms for 3^50
        // Tid Math.pow(): ca 6.5e-6 ms for 3^50

    }
}