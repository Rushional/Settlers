package views.dialogs;

import models.ResourcesSet;
import views.frame.SettlersFrame;

public class RequestResourcesToDiscard {
    public static ResourcesSet call(SettlersFrame frame, ResourcesSet playersResources) {
        DiscardResourcesDialog dialog = new DiscardResourcesDialog(frame, playersResources);
        return dialog.getDiscardedResources();
    }
}
