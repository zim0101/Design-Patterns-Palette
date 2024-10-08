package org.asif.strategies;

import org.asif.data.DummyCreditCards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete strategy. Implements credit card payment method.
 */
public class PayByCreditCard implements PayStrategy {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String cardNumber;
    Map<String, Object> card1Details = new HashMap<>();
    private boolean cardIsPresent;

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Enter the card number: ");
            cardNumber = reader.readLine();
            System.out.print("Enter the card expiration date 'mm/yy': ");
            String expiryDate = reader.readLine();
            System.out.print("Enter the CVV code: ");
            String cvv = reader.readLine();
            System.out.print("Enter the pin number: ");
            String pin = reader.readLine();
            card1Details.put("expiryDate", expiryDate);
            card1Details.put("cvv", cvv);
            card1Details.put("pin", pin);
            if (verify()) {
                System.out.println("Data verification has been successful.");
            } else {
                System.out.println("Wrong email or password.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean verify() {
        setSignedIn(card1Details.equals(DummyCreditCards.CREDIT_CARD.get(cardNumber)));
        return cardIsPresent;
    }

    private void setSignedIn(boolean cardIsPresent) {
        this.cardIsPresent = cardIsPresent;
    }

    /**
     * After card validation we can charge customer's credit card.
     */
    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent) {
            System.out.println("Paying " + paymentAmount + " using Credit Card.");
            return true;
        } else {
            return false;
        }
    }
}
