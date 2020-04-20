package entities;

import java.util.ArrayList;

public class StockWallet {

    private ArrayList<Stocks> list;

    private double totalValue;
    private int totalQuantity;
    private double totalFinancialResult;
    private int numberOfCompanies;

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public StockWallet(ArrayList<Stocks> list) {
        this.list = list;
        int totalQuantity = 0;
        double totalFinancialResult = 0.0;
        double totalValue = 0.0;
        for (Stocks stock : list){
            totalQuantity += stock.getQuantity();
            totalFinancialResult += stock.getFinancialResult();
            totalValue += stock.getTotalValue();
        }
        this.totalQuantity = totalQuantity;
        this.totalFinancialResult = totalFinancialResult;
        this.totalValue = totalValue;
        this.numberOfCompanies = list.size();
    }

    @Override
    public String toString() {
        return "-------------------------------------" + "\r\n" +
                "Stock Wallet Information: " + "\r\n" +
                "Number of Companies: " + numberOfCompanies + "\r\n" +
                "Total Quantity of Stocks: $" + totalQuantity + "\r\n" +
                "Total Value: " + totalValue + "\r\n" +
                "Total Financial Result: $" + totalFinancialResult + "\r\n" +
                "-------------------------------------";

    }
}
