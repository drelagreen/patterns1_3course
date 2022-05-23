package hamburgers.userbuilders.implementation;

import hamburgers.default_builders.DefaultBurgerBuilder;
import hamburgers.userbuilders.abstractions.BurgerBuilder;
import hamburgers.userbuilders.abstractions.HamburgerBuilder;

public class BurgerBuilderImpl implements BurgerBuilder<HamburgerBuilder> {
    private final DefaultBurgerBuilder builder = new DefaultBurgerBuilder();
    private final HamburgerBuilder parent;

    BurgerBuilderImpl(HamburgerBuilder parent){
        this.parent = parent;
    }

    DefaultBurgerBuilder getDefaultBuilder(){
        return builder;
    }

    @Override
    public HamburgerBuilder then() {
        return parent;
    }
}
