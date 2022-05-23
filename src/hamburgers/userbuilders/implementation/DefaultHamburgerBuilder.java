package hamburgers.userbuilders.implementation;

import hamburgers.Hamburger;
import hamburgers.components.Component;
import hamburgers.components.ComponentSize;
import hamburgers.default_builders.DefaultBreadBuilder;
import hamburgers.default_builders.DefaultBuilder;
import hamburgers.default_builders.MakesBread;
import hamburgers.components.bread.BreadPlacement;
import hamburgers.components.bread.BreadType;
import hamburgers.components.burger.BurgerType;
import hamburgers.components.sauce.SauceType;
import hamburgers.userbuilders.abstractions.BreadBuilder;
import hamburgers.userbuilders.abstractions.BurgerBuilder;
import hamburgers.userbuilders.abstractions.HamburgerBuilder;
import hamburgers.userbuilders.abstractions.SauceBuilder;
import hamburgers.userbuilders.abstractions.VegetablesBuilder;
import hamburgers.components.vegetables.VegetablesType;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class DefaultHamburgerBuilder implements HamburgerBuilder {
    private final ArrayList<DefaultBuilder<? extends Component>> notBuiltComponents = new ArrayList<>();
    private final ArrayList<MakesBread<?, BreadPlacement>> notBuiltBread = new ArrayList<>();
    private ComponentSize size = ComponentSize.MEDIUM;
    private boolean isCrustRemoved = false;
    private boolean isSesameRemoved = false;
    private boolean isTopBreadPlaced = false;

    @Override
    public SauceBuilder<HamburgerBuilder> addCheeseSauce() {
        var bi = setupSauceBuilder();
        bi.getDefaultBuilder().withType(SauceType.CHEESE);
        notBuiltComponents.add(bi.getDefaultBuilder());
        return bi;
    }

    @Override
    public SauceBuilder<HamburgerBuilder> addSalsaSauce() {
        var bi = setupSauceBuilder();
        bi.getDefaultBuilder().withType(SauceType.SALSA);
        notBuiltComponents.add(bi.getDefaultBuilder());
        return bi;
    }

    @Override
    public SauceBuilder<HamburgerBuilder> addSweetAndSourSauce() {
        var bi = setupSauceBuilder();
        bi.getDefaultBuilder().withType(SauceType.SWEET_AND_SOUR);
        notBuiltComponents.add(bi.getDefaultBuilder());
        return bi;
    }

    @Override
    public VegetablesBuilder<HamburgerBuilder> addTomato() {
        var bi = setupVegetablesBuilder();
        bi.getDefaultBuilder().withType(VegetablesType.TOMATO);
        notBuiltComponents.add(bi.getDefaultBuilder());
        return bi;
    }

    @Override
    public VegetablesBuilder<HamburgerBuilder> addCucumber() {
        var bi = setupVegetablesBuilder();
        bi.getDefaultBuilder().withType(VegetablesType.CUCUMBER);
        notBuiltComponents.add(bi.getDefaultBuilder());
        return bi;
    }

    @Override
    public BurgerBuilder<HamburgerBuilder> addBeefBurger() {
        var bi = setupBurgerBuilder();
        bi.getDefaultBuilder().withType(BurgerType.BEEF);
        notBuiltComponents.add(bi.getDefaultBuilder());
        return bi;
    }

    @Override
    public BurgerBuilder<HamburgerBuilder> addPorkBurger() {
        var bi = setupBurgerBuilder();
        bi.getDefaultBuilder().withType(BurgerType.PORK);
        notBuiltComponents.add(bi.getDefaultBuilder());
        return bi;
    }

    @Override
    public BurgerBuilder<HamburgerBuilder> addChickenBurger() {
        var bi = setupBurgerBuilder();
        bi.getDefaultBuilder().withType(BurgerType.CHICKEN);
        notBuiltComponents.add(bi.getDefaultBuilder());
        return bi;
    }

    @Override
    public BreadBuilder<HamburgerBuilder> addRyeBread() {
        var bi = setupBreadBuilder();
        bi.getDefaultBuilder().withType(BreadType.RYE);
        notBuiltComponents.add(bi.getDefaultBuilder());
        notBuiltBread.add(bi.getDefaultBuilder());
        isTopBreadPlaced = true;
        return bi;
    }

    @Override
    public BreadBuilder<HamburgerBuilder> addWhiteBread() {
        var bi = setupBreadBuilder();
        bi.getDefaultBuilder().withType(BreadType.WHITE);
        notBuiltComponents.add(bi.getDefaultBuilder());
        notBuiltBread.add(bi.getDefaultBuilder());
        isTopBreadPlaced = true;
        return bi;
    }

    @Override
    public HamburgerBuilder withoutCrust() {
        isCrustRemoved = true;
        notBuiltBread.forEach(MakesBread::removeCrust);
        return this;
    }

    @Override
    public HamburgerBuilder withoutSesame() {
        isSesameRemoved = true;
        notBuiltBread.forEach(MakesBread::removeSesame);
        return this;
    }

    @Override
    public HamburgerBuilder withSize(ComponentSize size) {
        notBuiltComponents.forEach((builder) -> builder.withSize(size));
        this.size = size;
        return this;
    }

    @Override
    public Hamburger build() {
        AtomicReference<Double> calories = new AtomicReference<>((double) 0);
        if (notBuiltBread.size() >= 2 &&
                notBuiltComponents.size() >= 2 &&
                notBuiltComponents.get(notBuiltComponents.size() - 1) instanceof DefaultBreadBuilder) {
            notBuiltBread.get(notBuiltBread.size() - 1).withPlacement(BreadPlacement.BOTTOM);
        }

        var components = notBuiltComponents.stream()
                .map(DefaultBuilder::build)
                .peek(component -> calories.updateAndGet(v -> (v + component.getCalories())))
                .collect(Collectors.toList());

        return new Hamburger(components, calories.get());
    }

    private SauceBuilderImpl setupSauceBuilder() {
        var bi = new SauceBuilderImpl(this);
        bi.getDefaultBuilder()
                .withSize(size);
        return bi;
    }

    private BreadBuilderImpl setupBreadBuilder() {
        var bi = new BreadBuilderImpl(this);
        bi.getDefaultBuilder()
                .withPlacement(isTopBreadPlaced ? BreadPlacement.MIDDLE : BreadPlacement.TOP)
                .withSize(size);

        if (isSesameRemoved) {
            bi.getDefaultBuilder().removeSesame();
        }

        if (isCrustRemoved) {
            bi.getDefaultBuilder().removeCrust();
        }

        return bi;
    }

    private VegetablesBuilderImpl setupVegetablesBuilder() {
        var bi = new VegetablesBuilderImpl(this);
        bi.getDefaultBuilder()
                .withSize(size);
        return bi;
    }

    private BurgerBuilderImpl setupBurgerBuilder() {
        var bi = new BurgerBuilderImpl(this);
        bi.getDefaultBuilder()
                .withSize(size);
        return bi;
    }
}
