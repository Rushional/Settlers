package views.graphics;

import javax.swing.*;

class EndTurnButton extends JButton {
    private EndTurnListener listener;

    EndTurnButton() {
        super("End turn");
    }

    void addEndTurnListener(EndTurnListener listener) {
        super.addActionListener(listener);
        this.listener = listener;
    }

    void removeEndTurnListener() {
        super.removeActionListener(listener);
    }

    EndTurnListener getListener() {
        return listener;
    }
}
