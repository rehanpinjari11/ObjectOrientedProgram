import java.util.ArrayList;
import java.util.Scanner;

class Stock {

    String stockName;
    int numberOfShares;
    double sharePrice;

    public Stock(String stockName, int numberOfShares, double sharePrice)
    {
        this.stockName = stockName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public double calculateStockValue()
    {
        return numberOfShares * sharePrice;
    }

}

class StockPortfolio{

    ArrayList<Stock> stocks;

    public StockPortfolio()
    {
        stocks = new ArrayList<>();
    }

    void addStock(Stock stock)
    {
        stocks.add(stock);
    }

    double calculateTotalPortfolioValue()
    {
        double totalValue = 0;

        for (Stock stocks : stocks)
        {
            totalValue += stocks.calculateStockValue();
        }

        return totalValue;
    }

    void printStockReport()
    {
        System.out.println("Stock Report:");
        System.out.printf("%-15s %-15s %-15s %-15s%n", "Stock Name", "Number of Shares", "Share Price", "Stock Value");
        System.out.println("------------------------------------------------------------");
        for (Stock stock : stocks)
        {
            System.out.printf("%-15s %-15d  %-15.2f %-15.2f%n",
                    stock.stockName, stock.numberOfShares, stock.sharePrice, stock.calculateStockValue());
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("Total Portfolio Value: %.2f%n", calculateTotalPortfolioValue());
    }
}



public class StockAccountManagement {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        StockPortfolio stockPortfolio = new StockPortfolio();

        System.out.print("Enter the number of stocks: ");
        int numberOfStocks = scanner.nextInt();

        for (int i = 0; i < numberOfStocks; i++)
        {
            System.out.println("\nEnter details for Stock " + (i + 1));

            System.out.println("Enter Stock Name: ");
            scanner.nextLine();
            String stockName = scanner.nextLine();

            System.out.println("Enter Number of Shares: ");
            int numberOfShares = scanner.nextInt();

            System.out.println("Enter Share Price: ");
            double sharePrice = scanner.nextDouble();

            Stock stock = new Stock(stockName, numberOfShares, sharePrice);
            stockPortfolio.addStock(stock);
        }

        stockPortfolio.printStockReport();

    }
}
