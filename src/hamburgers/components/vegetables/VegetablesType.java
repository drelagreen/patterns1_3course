package hamburgers.components.vegetables;

public enum VegetablesType {
    CUCUMBER(16, "Огурец"),
    TOMATO(20, "Томат");

    private final double calories;
    private final String name;

    VegetablesType(double calories, String name){
        this.calories = calories;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }
}
