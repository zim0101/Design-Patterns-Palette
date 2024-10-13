package org.asif.factories;

import org.asif.buttons.Button;
import org.asif.buttons.LinuxButton;
import org.asif.checkboxes.Checkbox;
import org.asif.checkboxes.LinuxCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class LinuxFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LinuxCheckbox();
    }
}
