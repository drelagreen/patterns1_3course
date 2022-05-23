package hamburgers.components.vegetables;

import hamburgers.components.Component;
import hamburgers.components.ComponentSize;

public class Vegetables extends Component {
    public static final int DEFAULT_AMOUNT = 1;

    private final VegetablesType type;
    private final ComponentSize size;

    private int extra = 0;

    public Vegetables(ComponentSize size, VegetablesType type) {
        this.type = type;
        this.size = size;
    }

    public double getCount() {
        return Math.max(DEFAULT_AMOUNT * size.getMultiplier() + extra, 0);
    }

    public void addExtra(int value) {
        extra += value;
    }

    public String getMeasure() {
        return "шт.";
    }

    public double getCalories() {
        return type.getCalories() * getCount();
    }

    @Override
    public String toString() {
        return type.getName() + " " +
                (getCount() > 0 ? getCount() + getMeasure() : "НЕ КЛАСТЬ") + " " + super.toString();
    }

    @Override
    public ComponentSize getSize() {
        return null;
    }
}
