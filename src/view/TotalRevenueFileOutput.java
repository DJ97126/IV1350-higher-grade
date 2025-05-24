package view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import observer.AbstractTotalRevenueObserver;

/**
 * Observer that prints the total revenue to a file.
 */
public class TotalRevenueFileOutput extends AbstractTotalRevenueObserver {
    private static final String REVENUE_FILE_NAME = "total_revenue.log";
    private PrintWriter revenueFile;

	/**
	 * Constructor for the class, creates a new file writer and prints the total revenue to the file
	 */
    public TotalRevenueFileOutput() {
        super();
        try {
            revenueFile = new PrintWriter(new FileWriter(REVENUE_FILE_NAME, true), true);
        } catch (IOException e) {
            System.out.println("Could not create revenue log file.");
            e.printStackTrace();
        }
    }

	/**
	 * Prints the total revenue to the file
	 * 
	 * @throws Exception if cannot write to file
	 */
    @Override
    protected void doShowTotalIncome() throws Exception {
        String logMessage = "%s, Total Revenue: %s SEK".formatted(createTime(), totalRevenue.colonized());
        revenueFile.println(logMessage);
    }

	/**
	 * Handles errors when writing to the revenue log file
	 * 
	 * @param e the exception that occurred
	 */
    @Override
    protected void handleErrors(Exception e) {
        System.err.println("Error writing to revenue log file: " + e.getMessage());
    }

    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
