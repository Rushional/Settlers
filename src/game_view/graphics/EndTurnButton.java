package game_view.graphics;

import javax.swing.*;
import java.awt.event.ActionListener;

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
