package Deque.StockLedger;
/**
 * Represents an entry in the stock ledger.
 */
public class LedgerEntry {

    private String stockSymbol;
    private int totalShares;
    private double averagePricePerShare;

    /**
     * Constructor to create a LedgerEntry.
     *
     * @param stockSymbol The stock's symbol.
     * @param totalShares The total number of shares.
     * @param averagePricePerShare The average price per share.
     */
    public LedgerEntry(String stockSymbol, int totalShares, double averagePricePerShare) {
        this.stockSymbol = stockSymbol;
        this.totalShares = totalShares;
        this.averagePricePerShare = averagePricePerShare;
    }

    /**
     * Gets the stock's symbol.
     *
     * @return The stock's symbol.
     */
    public String getStockSymbol() {
        return stockSymbol;
    }

    /**
     * Gets the total number of shares.
     *
     * @return The total number of shares.
     */
    public int getTotalShares() {
        return totalShares;
    }

    /**
     * Sets the total number of shares.
     *
     * @param totalShares The new total number of shares.
     */
    public void setTotalShares(int totalShares) {
        this.totalShares = totalShares;
    }

    /**
     * Gets the average price per share.
     *
     * @return The average price per share.
     */
    public double getAveragePricePerShare() {
        return averagePricePerShare;
    }

    /**
     * Sets the average price per share.
     *
     * @param averagePricePerShare The new average price per share.
     */
    public void setAveragePricePerShare(double averagePricePerShare) {
        this.averagePricePerShare = averagePricePerShare;
    }

    @Override
    public String toString() {
        return stockSymbol + ": " + averagePricePerShare + " (" + totalShares + " shares)";
    }
}

