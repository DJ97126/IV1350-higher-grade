package model.composition;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * An Amount class that adapts BigDecimal using composition. Demonstrates adaptation using composition.
 * This class is very similar to the original Amount implementation, but only done for more clear demonstration.
 */
public class Amount {
	private final BigDecimal amount;

	/**
	 * Creates a new Amount from a string.
	 * 
	 * @param amount The amount as a string, which will be converted to BigDecimal.
	 */
	public Amount(String amount) {
		this.amount = new BigDecimal(amount);
	}

	/**
	 * Creates a new Amount from a BigDecimal.
	 * 
	 * @param amount The amount as a BigDecimal.
	 */
	public Amount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * Adds another Amount and returns a new Amount, rounded to 2 decimals.
	 * 
	 * @param other The other Amount to add.
	 * @return A new Amount representing the sum, rounded to 2 decimal places.
	 */
	public Amount add(Amount other) {
		BigDecimal result = this.amount.add(other.amount);
		return new Amount(result.setScale(2, RoundingMode.HALF_UP));
	}

	/**
	 * Returns a string representation in SEK.
	 * 
	 * @return A string representation of the amount in SEK.
	 */
	@Override
	public String toString() {
		return amount.toString() + " SEK";
	}

	public static void main(String[] args) {
		Amount amount1 = new Amount("10.456");
		Amount amount2 = new Amount("5.123");
		Amount sum = amount1.add(amount2);

		System.out.println("Amount 1: " + amount1);
		System.out.println("Amount 2: " + amount2);
		System.out.println("Sum (rounded to 2 decimals): " + sum);

		Amount amount3 = new Amount(new BigDecimal("20.999"));
		System.out.println("Amount 3: " + amount3);
	}
}
