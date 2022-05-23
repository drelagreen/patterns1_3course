package hamburgers.components.burger;

import hamburgers.components.Component;
import hamburgers.components.ComponentSize;

public class Burger extends Component {
    private final ComponentSize size;
    private final BurgerType type;

    public Burger(ComponentSize size, BurgerType type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public double getCalories() {
        return type.getCalories() * size.getMultiplier();
    }

    @Override
    public ComponentSize getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Котлета" + " " +
                size.name() + " " +
                type.getName() + " " + super.toString();
    }
}
