package hamburgers.components.sauce;

import hamburgers.components.Component;
import hamburgers.components.ComponentSize;

public class Sauce extends Component {
    public static final int DEFAULT_AMOUNT = 5;

    private final SauceType type;
    private final ComponentSize size;

    private int extra;

    public Sauce(ComponentSize size, SauceType type) {
        this.type = type;
        this.size = size;
    }

    @Override
    public double getCalories() {
        return type.getCalories() * getCount();
    }

    @Override
    public ComponentSize getSize() {
        return size;
    }

    public double getCount() {
        return Math.max(DEFAULT_AMOUNT * size.getMultiplier() + extra, 0);
    }

    public void addExtra(int value) {
        extra += value;
    }

    public String getMeasure() {
        return "гр.";
    }

    @Override
    public String toString() {
        return "Соус " +
                type.getName() + " " +
                (getCount() == 0 ? "НЕ КЛАСТЬ" : getCount() + getMeasure()) + " " +
                size + " " + super.toString();
    }
}
