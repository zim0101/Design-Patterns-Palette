package org.asif.factories;

import org.asif.buttons.Button;
import org.asif.buttons.WindowsButton;
import org.asif.checkboxes.Checkbox;
import org.asif.checkboxes.WindowsCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
