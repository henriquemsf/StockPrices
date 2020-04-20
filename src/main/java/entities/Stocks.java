package entities;

public class Stocks {

    private Integer quantity;
    private String ticker;
    private double buyPrice;
    private double currentPrice;
    private double totalValue;
    private double financialResult;

    public Stocks(Integer quantity, String ticker, double buyPrice){
        this.quantity = quantity;
        this.ticker = ticker;
        this.buyPrice = buyPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
        this.totalValue = this.currentPrice * this.quantity;
        this.financialResult = (this.currentPrice * this.quantity) - (this.buyPrice * this.quantity);
    }

    public String getTicker() {
        return ticker;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getFinancialResult() {
        return financialResult;
    }

    public void setFinancialResult(double financialResult) {
        this.financialResult = financialResult;
    }

    @Override
    public String toString() {

        return "Company: " + ticker + "\r\n" +
                "Quantity: " + quantity + "\r\n" +
                "Buy Price: $" + buyPrice + "\r\n" +
                "Current Price: $" + currentPrice + "\r\n" +
                "Total Value: $" + totalValue + "\r\n" +
                "Financial Result: $" + financialResult + "\r\n" +
                "-------------------------------------";
    }
}
