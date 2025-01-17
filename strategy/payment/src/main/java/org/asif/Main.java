package org.asif;

import org.asif.order.Order;
import org.asif.strategies.PayByCreditCard;
import org.asif.strategies.PayByPayPal;
import org.asif.strategies.PayStrategy;
import org.asif.util.DummyData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public final class Main {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final Order ORDER = new Order();
    private static PayStrategy strategy;

    private Main() {
        throw new UnsupportedOperationException("Main class cannot be instantiated");
    }

    public static void main(String[] args) throws IOException {
        // Initialize all mock data
        DummyData.init();

        while (ORDER.isClosed()) {
            int cost;

            String continueChoice;
            do {
                System.out.print("""
                        Please, select a product:
                        1 - Motherboard
                        2 - CPU
                        3 - HDD
                        4 - Memory
                        """);
                int choice = Integer.parseInt(READER.readLine());
                cost = DummyData.getProducts().get(choice);
                System.out.print("Count: ");
                int count = Integer.parseInt(READER.readLine());
                ORDER.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = READER.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (Objects.isNull(strategy)) {
                System.out.println("""
                        Please, select a payment method:
                        1 - PayPal
                        2 - Credit Card""");
                String paymentMethod = READER.readLine();

                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }
            }

            if (ORDER.isClosed()) {
                ORDER.processOrder(strategy);
            }

            System.out.print("Pay " + ORDER.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = READER.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                if (strategy.pay(ORDER.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                ORDER.setClosed();
            }
        }
    }
}
