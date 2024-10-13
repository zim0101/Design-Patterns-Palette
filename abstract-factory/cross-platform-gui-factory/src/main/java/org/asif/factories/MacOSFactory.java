package org.asif.factories;

import org.asif.buttons.Button;
import org.asif.buttons.MacOSButton;
import org.asif.checkboxes.Checkbox;
import org.asif.checkboxes.MacOSCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
