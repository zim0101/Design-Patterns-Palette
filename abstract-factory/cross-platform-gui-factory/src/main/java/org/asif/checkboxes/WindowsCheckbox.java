package org.asif.checkboxes;

/**
 * All products families have the same varieties (macOS/Windows).
 * <p>
 * This is another variant of a checkbox.
 */
public class WindowsCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("You have created WindowsCheckbox.");
    }
}
