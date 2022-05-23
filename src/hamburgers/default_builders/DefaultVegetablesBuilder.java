package hamburgers.default_builders;

import hamburgers.components.ComponentSize;
import hamburgers.components.vegetables.Vegetables;
import hamburgers.components.vegetables.VegetablesType;

public class DefaultVegetablesBuilder implements DefaultBuilder<Vegetables> {
    private VegetablesType type;
    private ComponentSize size;

    private int extra;

    public DefaultVegetablesBuilder withType(VegetablesType type) {
        this.type = type;
        return this;
    }

    public DefaultVegetablesBuilder withSize(ComponentSize size) {
        this.size = size;
        return this;
    }

    public DefaultVegetablesBuilder addExtra(int value){
        this.extra += value;
        return this;
    }

    public DefaultVegetablesBuilder removeExtra(int value){
        this.extra -= value;
        return this;
    }

    @Override
    public Vegetables build() {
        Vegetables v = new Vegetables(size, type);
        v.addExtra(extra);
        return v;
    }
}
