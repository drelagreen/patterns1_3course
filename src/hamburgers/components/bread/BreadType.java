package hamburgers.components.bread;

public enum BreadType {
    WHITE(265, "белая"),
    RYE(259, "ржаная");

    BreadType(double caloriesPer100Gram, String name){
        this.caloriesPer100Gram = caloriesPer100Gram;
        this.name = name;
    }

    private final double caloriesPer100Gram;
    private final String name;

    public double getCaloriesPer100Gram() {
        return caloriesPer100Gram;
    }

    public String getName() {
        return name;
    }
}
