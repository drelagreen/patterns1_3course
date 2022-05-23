package hamburgers.components.bread;

public enum BreadPlacement {
    TOP(1.5, "Верхняя"),
    MIDDLE(1, "Средняя"),
    BOTTOM(1.2, "Нижняя");

    BreadPlacement(double gramMultiplier, String name) {
        this.gramMultiplier = gramMultiplier;
        this.name = name;
    }

    private final double gramMultiplier;
    private final String name;

    public double getGramMultiplier() {
        return gramMultiplier;
    }

    public String getName() {
        return name;
    }
}
