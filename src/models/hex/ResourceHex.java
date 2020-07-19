package models.hex;

import models.ResourceType;

public class ResourceHex extends ValuedHex {
    private ResourceType resourceType;

    public ResourceHex(int diceValue,  ResourceType type) {
        super(diceValue);
        this.resourceType = type;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }
}
