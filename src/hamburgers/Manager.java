package hamburgers;

import hamburgers.userbuilders.abstractions.HamburgerBuilder;

public class Manager {
    private HamburgerBuilder builder;

    public void setBuilder(HamburgerBuilder builder){
        this.builder = builder;
    }

    public Hamburger getHamburger(){
        return builder.build();
    }
}
