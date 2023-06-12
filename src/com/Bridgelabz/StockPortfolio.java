package com.Bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockPortfolio {
    private List<Stock> stocks;
    public StockPortfolio() {
            stocks = new ArrayList<>();
        }
        public void addStock(Stock stock) {
            stocks.add(stock);
        }
        public double calculateTotalValue() {
            double totalValue = 0;
            for (Stock stock : stocks) {
                totalValue += stock.calculateValue();
            }
            return totalValue;
        }
        public void printStockReport() {
            System.out.println("Stock Report:");
            System.out.println("-----------------------------------");
            for (Stock stock : stocks) {
                System.out.println("Stock Name: " + stock.getName());
                System.out.println("Number of Shares: " + stock.getNumberOfShares());
                System.out.println("Share Price: $" + stock.getSharePrice());
                System.out.println("Stock Value: $" + stock.calculateValue());
                System.out.println("-----------------------------------");
            }
            System.out.println("Total Portfolio Value: $" + calculateTotalValue());
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio stockPortfolio = new StockPortfolio();

        System.out.print("Enter the number of stocks: ");
        int numStocks = scanner.nextInt();

        for (int i = 1; i <= numStocks; i++) {
            System.out.println("Enter details for Stock " + i + ":");
            System.out.print("Stock Name: ");
            String name = scanner.next();
            System.out.print("Number of Shares: ");
            int numberOfShares = scanner.nextInt();
            System.out.print("Share Price: $");
            double sharePrice = scanner.nextDouble();

           Stock stock = new Stock(name, numberOfShares, sharePrice);
            stockPortfolio.addStock(stock);
            System.out.println();
        }

        stockPortfolio.printStockReport();
    }
}
