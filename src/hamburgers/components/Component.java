package hamburgers.components;

import java.io.Serializable;

public abstract class Component implements Serializable, HasCalories, HasSize {
    @Override
    public String toString() {
        return "| калорийность - " + getCalories() + " ккал";
    }
}
