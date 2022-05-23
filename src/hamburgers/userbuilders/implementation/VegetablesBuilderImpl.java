package hamburgers.userbuilders.implementation;

import hamburgers.userbuilders.abstractions.HamburgerBuilder;
import hamburgers.userbuilders.abstractions.VegetablesBuilder;
import hamburgers.default_builders.DefaultVegetablesBuilder;

public class VegetablesBuilderImpl implements VegetablesBuilder<HamburgerBuilder> {
    private final DefaultVegetablesBuilder builder = new DefaultVegetablesBuilder();
    private final HamburgerBuilder parent;

    VegetablesBuilderImpl(HamburgerBuilder parent){
        this.parent = parent;
    }

    DefaultVegetablesBuilder getDefaultBuilder(){
        return builder;
    }

    @Override
    public HamburgerBuilder then() {
        return parent;
    }

    @Override
    public VegetablesBuilder<HamburgerBuilder> more(int count) {
        builder.addExtra(count);
        return this;
    }

    @Override
    public VegetablesBuilder<HamburgerBuilder> less(int count) {
        builder.removeExtra(count);
        return this;
    }
}
