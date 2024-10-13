package org.asif.buttons;

/**
 * All products families have the same varieties (macOS/Windows/Linux).
 * <p>
 * This is a Linux variant of a button.
 */
public class LinuxButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created LinuxButton.");
    }
}
