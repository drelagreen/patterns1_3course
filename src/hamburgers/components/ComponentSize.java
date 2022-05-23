package hamburgers.components;

public enum ComponentSize{
    SMALL(1), MEDIUM(2), BIG(3), LARGE(4), EXTRA_LARGE(5), LONG(3), EXTRA_LONG(4);

    ComponentSize(double gramMultiplier){
        this.gramMultiplier = gramMultiplier;
    }

    private final double gramMultiplier;

    public double getMultiplier() {
        return gramMultiplier;
    }
}
