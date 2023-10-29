package Deque.StockLedger;

/**
 * Demonstrates the functionalities of the StockLedger class.
 *
 * <p>
 * This main method initializes a StockLedger and simulates a series of stock
 * purchase and sale operations. After each operation, the current state
 * of the ledger is displayed to the standard output.
 * </p>
 */


public class Main {

    /**
     * Entry point of the program.
     *
     * @param args Command-line arguments (not used).
     */

    public static void main(String[] args) {
        StockLedger ledger = new StockLedger();

        // Buy 20 shares of AAPL at $45
        ledger.buy("AAPL", 45.0, 20);

        // Buy 20 shares of AAPL at $75
        ledger.buy("AAPL", 75.0, 20);

        // Buy 20 shares of MSFT at $95
        ledger.buy("MSFT", 95.0, 20);

        // Display the ledger
        ledger.displayLedger();

        // Sell 30 shares of AAPL
        ledger.sell("AAPL", 65.0, 30);

        // Display the ledger
        ledger.displayLedger();

        // Sell 10 shares of AAPL
        ledger.sell("AAPL", 65.0, 10);

        // Display the ledger
        ledger.displayLedger();

        // Buy 100 shares of AAPL at $20
        ledger.buy("AAPL", 20.0, 100);

        // Buy 20 shares of AAPL at $24
        ledger.buy("AAPL", 24.0, 20);

        // Buy 200 shares of TSLA at $36
        ledger.buy("TSLA", 36.0, 200);

        // Display the ledger
        ledger.displayLedger();

        // Sell 10 shares of AAPL
        ledger.sell("AAPL", 65.0, 10);

        // Display the ledger
        ledger.displayLedger();

        // Sell 150 shares of TSLA
        ledger.sell("TSLA", 30.0, 150);

        // Display the ledger
        ledger.displayLedger();

        // Buy 5 shares of MSFT at $60
        ledger.buy("MSFT", 60.0, 5);

        // Buy 5 shares of MSFT at $70
        ledger.buy("MSFT", 70.0, 5);

        // Display the ledger
        ledger.displayLedger();

        // Sell 4 shares of MSFT
        ledger.sell("MSFT", 30.0, 4);

        // Display the ledger
        ledger.displayLedger();

        // Sell 2 shares of MSFT
        ledger.sell("MSFT", 30.0, 2);

        // Display the ledger
        ledger.displayLedger();
    }
}
