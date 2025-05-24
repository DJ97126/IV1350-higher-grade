package observer;

import model.Amount;

/**
 * Abstract base class for total revenue observers implementing the Template Method pattern.
 * This class defines the skeleton of the algorithm for handling total revenue updates,
 * while letting subclasses override specific steps.
 */
public abstract class AbstractTotalRevenueObserver implements TotalRevenueObserver {
    protected Amount totalRevenue;

    /**
     * Constructor for the abstract observer.
     */
    public AbstractTotalRevenueObserver() {
        this.totalRevenue = new Amount();
    }

    /**
     * Template method that defines the algorithm for handling total revenue updates.
     * This method cannot be overridden by subclasses.
     *
     * @param saleAmount The amount from the current sale.
     */
    @Override
    public final void updateTotalRevenue(Amount saleAmount) {
        calculateTotalIncome(saleAmount);
        showTotalIncome();
    }

    private void calculateTotalIncome(Amount saleAmount) {
        totalRevenue = totalRevenue.add(saleAmount);
    }

    private void showTotalIncome() {
        try {
            doShowTotalIncome();
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    /**
     * Hook method that subclasses must implement to show the total income.
     * This is where the actual display logic should be implemented.
     *
     * @throws Exception if there is an error during the display process.
     */
    protected abstract void doShowTotalIncome() throws Exception;

    /**
     * Hook method that subclasses must implement to handle any errors
     * that occur during the display process.
     *
     * @param e The exception that occurred.
     */
    protected abstract void handleErrors(Exception e);
}