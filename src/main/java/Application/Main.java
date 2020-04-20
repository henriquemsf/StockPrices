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

        //Inicializar uma lista de acoes, que sera usada na carteira final, e um scanner para receber inputs
        //A lista sera constituida de objetos "Stocks", e nao "Stock" - classe ja utilizada pelo Yahoo
        ArrayList<Stocks> list = new ArrayList<Stocks>();
        Scanner sc = new Scanner(System.in);

        //Receber input do usuario sobre o tamanho da sua carteira
        System.out.println("How many stocks will be added?");
        int walletSize = sc.nextInt();
        sc.nextLine();

        //Receber inputs do usuario sobre cada uma das suas acoes e adiciona-las a lista criada anteriormente
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

        //Criar um array de strings que sera usado para realizar um request para o servidor
        String[] multipleStocks = new String[walletSize];

        //Adicionar todas as acoes no array
        for(int i = 0; i < walletSize; i++){
            multipleStocks[i] = list.get(i).getTicker();
        }

        //Fazer um unico request para o Yahoo, ao inves de um para cada acao
        Map<String, Stock> singleRequest = YahooFinance.get(multipleStocks);

        //Adicionar o preco para cada uma das acoes
        for (Stocks s : list){
            Stock stock = singleRequest.get(s.getTicker());
            s.setCurrentPrice(stock.getQuote().getPrice().doubleValue());
        }

        //Criar a carteira do usuario
        StockWallet wallet = new StockWallet(list);

        //Imprimir o resumo da carteira e de cada acao
        System.out.println(wallet.toString());
        for (Stocks stock : list){
            System.out.println(stock.toString());
        }

    }
}
