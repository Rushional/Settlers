package views;

import views.building_view.BuildingView;
import views.graphics.ViewIntention;
import java.util.concurrent.CountDownLatch;

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
        var latch = new CountDownLatch(1);
        buildingView.waitForIntention(latch, this);
        controlView.waitForIntention(latch, this);
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return intention;
    }

    public void setIntention(ViewIntention intention) {
        this.intention = intention;
        controlView.removeEndTurnListener();
    }
}
