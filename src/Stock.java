
import java.util.Date;

public class Stock {

    private int stocks[];

    public int[] fillTable(int amountOfNumbers){
        stocks= new int[amountOfNumbers];
        final int MIN= -10;
        final int MAX = 10;

        for (int i = 0; i<amountOfNumbers ; i++){
            stocks[i] = MIN + (int)(Math.random()*((MAX-MIN) +1));
        }
        return stocks;
    }

    public int[] mostProfitable(int[] stockChange){
        int buyDay=0;
        int sellingDay=1;
        int profit = 0;
        int difference =0;

        for (int i = 0; i<stockChange.length; i++){
            if (i<8){
                difference= stockChange[i] +stockChange[i+1];
            }
            for (int j= i+2; j<stockChange.length; j++){
                if (profit<difference){
                    buyDay=i;
                    sellingDay=j;
                    profit=difference;
                }
                difference=difference+stockChange[j];
            }
        }
        int[] bestProfit={buyDay,sellingDay,profit};
        return bestProfit;
    }


}

class testData{
    public static void main(String[] args){
        Stock stock = new Stock();

        // Checking the output data
/*        int table[] = stock.fillTable(5);
        int iterations = table.length;

        int[] oppg= {-1,3,-9,2,2,-1,2,-1,-5};

        // Testing formula
        int[] profit = stock.mostProfitable(oppg);
        for (int i =0; i<3 ;i++){
            System.out.println(profit[i]);
        }*/
        int[] profit;
        int table[] = stock.fillTable(10000);
        Date start = new Date();
        int runder = 0;
        double tid;
        Date slutt;
        do {
            profit = stock.mostProfitable(table);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)(slutt.getTime()-start.getTime()) / runder;
        System.out.println("Millisekund pr. runde:" + tid);
        System.out.println("Buying day: " +profit[0]+", Selling day: "+ profit[1]+" og profit: "+ profit[2]);


    }
}
