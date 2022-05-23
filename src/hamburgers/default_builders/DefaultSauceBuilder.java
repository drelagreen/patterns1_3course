package hamburgers.default_builders;

import hamburgers.components.ComponentSize;
import hamburgers.components.sauce.Sauce;
import hamburgers.components.sauce.SauceType;

public class DefaultSauceBuilder implements DefaultBuilder<Sauce> {
    private SauceType type;
    private ComponentSize size;
    private int extra = 0;

    public DefaultSauceBuilder withType(SauceType type) {
        this.type = type;
        return this;
    }

    public DefaultSauceBuilder withSize(ComponentSize size) {
        this.size = size;
        return this;
    }

    public DefaultSauceBuilder addExtra(int value) {
        extra += value;
        return this;
    }

    public DefaultSauceBuilder removeExtra(int value) {
        extra -= value;
        return this;
    }

    @Override
    public Sauce build() {
        Sauce s = new Sauce(size, type);
        s.addExtra(extra);
        return s;
    }
}
