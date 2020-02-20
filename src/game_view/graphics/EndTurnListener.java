package game_view.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndTurnListener implements ActionListener {
    private String message;

    public EndTurnListener(String message) {
        super();
        this.message = message;
    }

    public void actionPerformed(ActionEvent e) {
//        System.out.println("End turn button pressed!");
        System.out.println(message);
    }
}
