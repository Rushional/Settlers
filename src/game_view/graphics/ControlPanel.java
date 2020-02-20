package game_view.graphics;

import javax.swing.*;
import java.awt.*;

//shouldn't be public, it was done to test the listener
public class ControlPanel extends JPanel {
    private EndTurnButton button;

    ControlPanel() {
        super();
        setBackground(new Color(116, 255, 207));
        setPreferredSize(new Dimension(300, 700));
        setLayout(new GridBagLayout());
        button = new EndTurnButton();
        //For some reason it doesn't work
        //button.setSize(80,80);
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.weightx = 1;
        buttonConstraints.weighty = 1;
        buttonConstraints.anchor = GridBagConstraints.PAGE_END;
        buttonConstraints.insets = new Insets(0,0,100,0);
        add(button, buttonConstraints);
        var endTurnListener = new EndTurnListener("End turn button pressed!");
        button.addEndTurnListener(endTurnListener);
    }

    public void removeEndTurnListener() {
        button.removeEndTurnListener();
    }

    public void addEndTurnListener(EndTurnListener listener) {
        button.addEndTurnListener(listener);
    }
}
