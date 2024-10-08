package org.asif.strategies;

import org.asif.data.DummyPayPalCredentials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Concrete strategy. Implements PayPal payment method.
 */
public class PayByPayPal implements PayStrategy {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    /**
     * Save customer data for future shopping attempts.
     */
    @Override
    public boolean pay(int pamentAmount) {
        if (signedIn) {
            System.out.println("Paying " + pamentAmount + " using PayPal.");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Collect customer's data.
     */
    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                System.out.print("Enter the user's email: ");
                email = reader.readLine();
                System.out.print("Enter the password: ");
                password = reader.readLine();
                if (verify()) {
                    System.out.println("Data verification has been successful.");
                } else {
                    System.out.println("Wrong email or password.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean verify() {
        setSignedIn(email.equals(DummyPayPalCredentials.CREDENTIALS.get(password)));
        return signedIn;
    }
    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
