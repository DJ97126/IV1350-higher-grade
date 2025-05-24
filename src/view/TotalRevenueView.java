package view;

import observer.AbstractTotalRevenueObserver;

/**
 * Observer that prints the total revenue to the console.
 */
public class TotalRevenueView extends AbstractTotalRevenueObserver {
    /**
     * Constructor for the class
     */
    public TotalRevenueView() {
        super();
    }

    /**
	 * Prints the total revenue to the console
     */
    @Override
    protected void doShowTotalIncome() throws Exception {
        System.out.println("""
                Total Revenue: %s SEK
                """.formatted(totalRevenue.colonized()));
    }

    /**
     * Handles errors when displaying the total revenue
     * 
     * @param e the exception that occurred
     */
    @Override
    protected void handleErrors(Exception e) {
        System.err.println("Error displaying total revenue: " + e.getMessage());
    }
}