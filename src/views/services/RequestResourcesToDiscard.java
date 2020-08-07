package views.services;

import models.ResourcesSet;
import views.graphics.SettlersFrame;
import views.harvest_stage.DiscardResourcesDialog;

public class RequestResourcesToDiscard {
    public static ResourcesSet call(SettlersFrame frame) {
        DiscardResourcesDialog dialog = new DiscardResourcesDialog(frame);
        if (dialog.isSheepFlag()) return (new ResourcesSet(0, 0, 1, 0, 0));
        else return (new ResourcesSet(5, 4, 3, 2, 1));
    }
}
