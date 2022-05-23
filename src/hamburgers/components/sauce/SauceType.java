package hamburgers.components.sauce;

public enum SauceType {
    CHEESE(20, "сырный"),
    SALSA(20, "\"сальса\""),
    SWEET_AND_SOUR(20, "кисло-сладкий");

    SauceType(double calories, String name){
        this.name = name;
        this.calories = calories;
    }

    private final String name;
    private final double calories;

    public double getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }
}
