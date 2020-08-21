package views.inputs.listeners;

import javax.swing.event.MouseInputAdapter;

public abstract class MapListener extends MouseInputAdapter {
    Object monitor;

    public MapListener(Object monitor) {
        super();
        this.monitor = monitor;
    }
}
