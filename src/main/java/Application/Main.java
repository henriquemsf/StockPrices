package Application;

import entities.StockWallet;
import entities.Stocks;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Stocks> list = new ArrayList<Stocks>();
        Scanner sc = new Scanner(System.in);

        System.out.println("How many stocks will be added?");
        int walletSize = sc.nextInt();
        sc.nextLine();

        for(int x = 0; x < walletSize; x++ ){
            System.out.println("Stock ticker #" + (x+1));
            String name = sc.nextLine().toUpperCase();
            System.out.println(name + " quantity");
            int quantity = sc.nextInt();
            System.out.println(name + " buy price");
            double buyPrice = sc.nextDouble();
            sc.nextLine();
            Stocks stock = new Stocks(quantity,name,buyPrice);
            list.add(stock);
        }

        String[] multipleStocks = new String[walletSize];

        for(int i = 0; i < walletSize; i++){
            multipleStocks[i] = list.get(i).getTicker();
        }

        Map<String, Stock> singleRequest = YahooFinance.get(multipleStocks);

        for (Stocks s : list){
            Stock stock = singleRequest.get(s.getTicker());
            s.setCurrentPrice(stock.getQuote().getPrice().doubleValue());
        }

        StockWallet wallet = new StockWallet(list);

        System.out.println(wallet.toString());

        for (Stocks stock : list){
            System.out.println(stock.toString());
        }

    }
}
