package Deque.StockLedger;

/**
 * Represents an individual stock purchase transaction.
 *
 * <p>
 * This class encapsulates the price at which the stock was purchased and
 * the number of shares bought. It provides methods to get the purchase
 * price, the number of shares, and to decrease the number of shares.
 * </p>
 */

public class StockPurchase {
    private double price;
    private int shares;

    /**
     * Constructs a new StockPurchase instance.
     *
     * @param price  The purchase price of the stock.
     * @param shares The number of shares purchased.
     */
    public StockPurchase(double price, int shares) {
        this.price = price;
        this.shares = shares;
    }

    /**
     * Returns the purchase price of the stock.
     *
     * @return The purchase price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the number of shares purchased.
     *
     * @return The number of shares.
     */
    public int getShares() {
        return shares;
    }

    /**
     * Decreases the number of shares by a specified amount.
     *
     * <p>
     * If the specified amount exceeds the current number of shares,
     * an IllegalArgumentException is thrown.
     * </p>
     *
     * @param amount The number of shares to decrease.
     * @throws IllegalArgumentException If the decrease amount is greater than available shares.
     */
    public void decreaseShares(int amount) {
        if (amount > shares) {
            throw new IllegalArgumentException("Cannot decrease more shares than available");
        }
        shares -= amount;
    }
}

