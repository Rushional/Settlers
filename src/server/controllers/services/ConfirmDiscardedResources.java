package server.controllers.services;

import server.models.ResourcesSet;

// The intended purpose of this class was to check if the discarded resources are correct
// E.g that player hasn't discarded too many or too few
public class ConfirmDiscardedResources {
    public void call(
            ResourcesSet playersInitialRes, int discardedBricks, int discardedWood, int discardedSheep,
            int discardedWheat, int discardedOre) {
        if (playersInitialRes.getTotalAmount()/2 ==
                discardedBricks + discardedWood + discardedSheep + discardedWheat + discardedOre) {
            var discardedResources = new ResourcesSet(discardedBricks, discardedWood, discardedSheep, discardedWheat, discardedOre);
//            DiscardResourcesDialog.this.dispose();
        }
    }
}
