package hamburgers.userbuilders.implementation;

import hamburgers.default_builders.DefaultSauceBuilder;
import hamburgers.userbuilders.abstractions.HamburgerBuilder;
import hamburgers.userbuilders.abstractions.SauceBuilder;

public class SauceBuilderImpl implements SauceBuilder<HamburgerBuilder> {
    private final DefaultSauceBuilder builder = new DefaultSauceBuilder();
    private final HamburgerBuilder parent;

    SauceBuilderImpl(HamburgerBuilder parent){
        this.parent = parent;
    }

    DefaultSauceBuilder getDefaultBuilder(){
        return builder;
    }

    @Override
    public HamburgerBuilder then() {
        return parent;
    }

    @Override
    public SauceBuilder<HamburgerBuilder> more(int grams) {
        builder.addExtra(grams);
        return this;
    }

    @Override
    public SauceBuilder<HamburgerBuilder> less(int grams) {
        builder.removeExtra(grams);
        return this;
    }
}
