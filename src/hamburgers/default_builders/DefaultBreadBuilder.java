package hamburgers.default_builders;

import hamburgers.components.ComponentSize;
import hamburgers.components.bread.Bread;
import hamburgers.components.bread.BreadPlacement;
import hamburgers.components.bread.BreadType;

public class DefaultBreadBuilder implements DefaultBuilder<Bread>, MakesBread<DefaultBreadBuilder, BreadPlacement> {
    private BreadType type;
    private ComponentSize size;
    private BreadPlacement placement;
    private boolean isCrustRemoved = false;
    private boolean isSesameRemoved = false;

    public DefaultBreadBuilder withType(BreadType type) {
        this.type = type;
        return this;
    }

    @Override
    public DefaultBreadBuilder withSize(ComponentSize size) {
        this.size = size;
        return this;
    }

    @Override
    public DefaultBreadBuilder withPlacement(BreadPlacement placement) {
        this.placement = placement;
        return this;
    }

    @Override
    public DefaultBreadBuilder removeCrust() {
        isCrustRemoved = true;
        return this;
    }

    @Override
    public DefaultBreadBuilder removeSesame() {
        isSesameRemoved = true;
        return this;
    }

    @Override
    public Bread build() {
        Bread b = new Bread(size, type, placement);
        if (isCrustRemoved)
            b.removeCrust();
        if (isSesameRemoved)
            b.removeSesame();
        return b;
    }
}
