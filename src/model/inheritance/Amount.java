package model.inheritance;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * An Amount class that inherits from BigDecimal. Demonstrates adaptation using inheritance.
 */
public class Amount extends BigDecimal {
	/**
	 * Creates a new Amount from a string.
	 */
	public Amount(String amount) {
		super(amount);
	}

	/**
	 * Creates a new Amount from a BigDecimal.
	 */
	public Amount(BigDecimal amount) {
		super(amount.toString());
	}

	/**
	 * Adds another Amount and returns a new Amount, rounded to 2 decimals. 
	 * This method demonstrates a potential problematic design choice of using inheritance for adaptation. 
	 * It overrides the add method of BigDecimal, which can lead to confusion and unexpected behavior.
	 */
	public Amount add(Amount other) {
		BigDecimal result = super.add(other);
		return new Amount(result.setScale(2, RoundingMode.HALF_UP));
	}

	/**
	 * Returns a string representation with SEK currency.
	 */
	@Override
	public String toString() {
		return super.toString() + " SEK";
	}

	public static void main(String[] args) {
		/* Regular usage. */
		Amount amount1 = new Amount("100.456");
		Amount amount2 = new Amount("50.123");

		/* It may not be expected that add() rounds the results into two decimals. */
		Amount sum = amount1.add(amount2);

		System.out.println("Amount 1: " + amount1);
		System.out.println("Amount 2: " + amount2);
		System.out.println("Sum (rounded to 2 decimals): " + sum);

		Amount amount3 = new Amount(new BigDecimal("20.999"));
		System.out.println("Amount 3: " + amount3);

		/*
		 * BigDecimal methods are inherited from BigDecimal, and is used directly on an Amount instance.
		 */
		BigDecimal multiplied = amount1.multiply(amount2);
		System.out.println("Multiplication (BigDecimal): " + multiplied);
	}
}
