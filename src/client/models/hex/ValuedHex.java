package client.models.hex;

public abstract class ValuedHex extends Hex {
    private int diceValue;

    ValuedHex(int diceValue) {
        super();
        this.diceValue = diceValue;
    }

    public int getDiceValue() {
        return diceValue;
    }
}
