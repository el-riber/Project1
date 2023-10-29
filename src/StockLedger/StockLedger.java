package Deque.StockLedger;

import Deque.Deque.LinkedDeque;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a ledger to manage stock purchases.
 */
public class StockLedger {
    private final ArrayList<LinkedDeque<StockPurchase>> ledger;
    private final ArrayList<String> stockSymbols;

    /**
     * Constructs an empty StockLedger.
     */
    public StockLedger() {
        this.ledger = new ArrayList<>();
        this.stockSymbols = new ArrayList<>();
    }

    /**
     * Finds the deque associated with a given stock symbol.
     * If no deque exists for the stock symbol, a new one is created.
     *
     * @param stockSymbol Symbol of the stock.
     * @return Deque associated with the stock symbol.
     */
    private LinkedDeque<StockPurchase> findDeque(String stockSymbol) {
        int index = stockSymbols.indexOf(stockSymbol);
        if (index == -1) {
            stockSymbols.add(stockSymbol);
            LinkedDeque<StockPurchase> newDeque = new LinkedDeque<>();
            ledger.add(newDeque);
            return newDeque;
        }
        return ledger.get(index);
    }
    /**
     * Records a purchase of a certain number of shares of a stock at a given price.
     *
     * @param stockSymbol Symbol of the stock being bought.
     * @param price       Price at which the stock is bought.
     * @param shares      Number of shares bought.
     */
    public void buy(String stockSymbol, double price, int shares) {
        LinkedDeque<StockPurchase> deque = findDeque(stockSymbol);
        deque.addToBack(new StockPurchase(price, shares));
    }
    /**
     * Records a sale of a certain number of shares of a stock at a given price.
     * Shares are sold in the order they were bought (FIFO).
     *
     * @param stockSymbol Symbol of the stock being sold.
     * @param price       Price at which the stock is sold.
     * @param shares      Number of shares sold.
     */
    public void sell(String stockSymbol, double price, int shares) {
        LinkedDeque<StockPurchase> deque = findDeque(stockSymbol);
        while (shares > 0 && !deque.isEmpty()) {
            StockPurchase purchase = deque.getFront();
            if (purchase.getShares() <= shares) {
                shares -= purchase.getShares();
                deque.removeFront(); // Here we remove the front once its shares are exhausted
            } else {
                purchase.decreaseShares(shares);
                shares = 0;
            }
        }
    }
    /**
     * Displays the ledger entries for all stocks.
     */
    public void displayLedger() {
        System.out.println("---- Stock Ledger ----");
        for (int i = 0; i < stockSymbols.size(); i++) {
            System.out.print(stockSymbols.get(i) + ": ");
            Iterator<StockPurchase> it = ledger.get(i).iterator();
            while (it.hasNext()) {
                StockPurchase purchase = it.next();
                System.out.print(purchase.getPrice() + " (" + purchase.getShares() + " shares)");
                if (it.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}

