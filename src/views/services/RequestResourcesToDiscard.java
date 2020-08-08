package views.services;

import models.ResourcesSet;
import views.graphics.SettlersFrame;
import views.harvest_stage.DiscardResourcesDialog;

public class RequestResourcesToDiscard {
    public static ResourcesSet call(SettlersFrame frame, ResourcesSet playersResources) {
        DiscardResourcesDialog dialog = new DiscardResourcesDialog(frame, playersResources);
        return dialog.getDiscardedResources();
    }
}
