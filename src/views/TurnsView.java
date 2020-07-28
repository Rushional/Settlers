package views;

import views.building_view.BuildingView;
import views.graphics.ViewIntention;

public class TurnsView {
    private BuildingView buildingView;
    private ControlView controlView;
    private ViewIntention intention;

    TurnsView(BuildingView buildingView, ControlView controlView) {
        this.buildingView = buildingView;
        this.controlView = controlView;
    }

    public ViewIntention requestIntention() {
        intention = null;
        var monitor = new Object();
        buildingView.waitForIntention(monitor, this);
        controlView.waitForIntention(monitor, this);
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
//        Here I could turn off building and endTurn listeners, but the game works as it is now
//        You can send multiple intentions very fast, but the game will only process one.
//        And then turnsController will request another almost immediately
//        But in that window you can change the viewIntention field, but I don't think it matters
//        So I think this is fine *flames blazing all around*
        return intention;
    }

    public void setIntention(ViewIntention intention) {
        this.intention = intention;
        controlView.removeEndTurnListener();
    }
}
