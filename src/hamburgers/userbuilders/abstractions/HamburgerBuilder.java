package hamburgers.userbuilders.abstractions;

import hamburgers.Hamburger;
import hamburgers.components.ComponentSize;

public interface HamburgerBuilder {
    SauceBuilder<HamburgerBuilder> addCheeseSauce();
    SauceBuilder<HamburgerBuilder> addSalsaSauce();
    SauceBuilder<HamburgerBuilder> addSweetAndSourSauce();

    VegetablesBuilder<HamburgerBuilder> addTomato();
    VegetablesBuilder<HamburgerBuilder> addCucumber();

    BurgerBuilder<HamburgerBuilder> addBeefBurger();
    BurgerBuilder<HamburgerBuilder> addPorkBurger();
    BurgerBuilder<HamburgerBuilder> addChickenBurger();

    BreadBuilder<HamburgerBuilder> addRyeBread();
    BreadBuilder<HamburgerBuilder> addWhiteBread();
    HamburgerBuilder withoutCrust();
    HamburgerBuilder withoutSesame();

    HamburgerBuilder withSize(ComponentSize size);

    Hamburger build();
}
