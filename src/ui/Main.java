package ui;

import hamburgers.Hamburger;
import hamburgers.components.ComponentSize;

public class Main {
    public static void main(String[] args) {
       Hamburger hamburger = Hamburger.getBuilder()
                .addRyeBread().then()
                .addCheeseSauce().then()
                .addBeefBurger().then()
                .addTomato().then()
                .addCucumber().then()
                .withSize(ComponentSize.SMALL)
                .withoutSesame()
                .addRyeBread().then()
                .build();
        hamburger.print(System.out);
        new Interaction().menu();
    }
}
