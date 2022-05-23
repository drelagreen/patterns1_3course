package hamburgers.default_builders;

import hamburgers.components.ComponentSize;
import hamburgers.components.burger.Burger;
import hamburgers.components.burger.BurgerType;

public class DefaultBurgerBuilder implements DefaultBuilder<Burger> {
    private BurgerType type;
    private ComponentSize size;

    public DefaultBurgerBuilder withType(BurgerType type){
        this.type = type;
        return this;
    }

    public DefaultBurgerBuilder withSize(ComponentSize size){
        this.size = size;
        return this;
    }

    @Override
    public Burger build() {
        return new Burger(size, type);
    }
}
