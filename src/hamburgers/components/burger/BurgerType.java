package hamburgers.components.burger;

public enum BurgerType{
    CHICKEN(143, "куриная"), PORK(280, "свинная"), BEEF(200, "говяжья");

    BurgerType(double calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    private final double calories;
    private final String name;

    public double getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }
}
