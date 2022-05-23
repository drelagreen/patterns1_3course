package hamburgers.userbuilders.implementation;

import hamburgers.default_builders.DefaultBreadBuilder;
import hamburgers.userbuilders.abstractions.BreadBuilder;
import hamburgers.userbuilders.abstractions.HamburgerBuilder;

public class BreadBuilderImpl implements BreadBuilder<HamburgerBuilder> {
    private final DefaultBreadBuilder builder = new DefaultBreadBuilder();
    private final HamburgerBuilder parent;

    BreadBuilderImpl(HamburgerBuilder parent){
        this.parent = parent;
    }

    DefaultBreadBuilder getDefaultBuilder(){
        return builder;
    }

    @Override
    public HamburgerBuilder then() {
        return parent;
    }
}
