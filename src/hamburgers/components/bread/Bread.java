package hamburgers.components.bread;

import hamburgers.components.Component;
import hamburgers.components.ComponentSize;

public class Bread extends Component {
    public static final double BREAD_DEFAULT_GRAMS = 40;
    public static final double CRUST_DEFAULT_GRAMS = 4;
    public static final double SESAME_DEFAULT_GRAMS = 4;

    private final ComponentSize size;
    private final BreadType type;
    private final BreadPlacement placement;
    private boolean isCrustRemoved;
    private boolean isSesameRemoved;

    public Bread(ComponentSize size, BreadType type, BreadPlacement placement) {
        this.size = size;
        this.type = type;
        this.placement = placement;
    }

    public void removeCrust() {
        isCrustRemoved = true;
    }

    public void removeSesame() {
        isSesameRemoved = true;
    }

    @Override
    public ComponentSize getSize() {
        return size;
    }

    @Override
    public double getCalories() {
        return placement.getGramMultiplier() * (type.getCaloriesPer100Gram() + (
                BREAD_DEFAULT_GRAMS
                        + (isCrustRemoved ? -CRUST_DEFAULT_GRAMS : 0)
                        + (isSesameRemoved ? -SESAME_DEFAULT_GRAMS : 0)
        ));
    }

    @Override
    public String toString() {
        return "Булка " +
                size.name() + " " +
                (isCrustRemoved ? "БЕЗ КОРКИ" : "") + " " +
                (isSesameRemoved ? "БЕЗ КУНЖУТА" : "") + " " +
                type.getName() + " " +
                placement.getName() + " " + super.toString();
    }
}
