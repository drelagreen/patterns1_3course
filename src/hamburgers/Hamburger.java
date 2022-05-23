package hamburgers;

import hamburgers.components.Component;
import hamburgers.userbuilders.abstractions.HamburgerBuilder;
import hamburgers.userbuilders.implementation.DefaultHamburgerBuilder;

import java.io.PrintStream;
import java.util.List;

public record Hamburger(List<? extends Component> components, double calories) {
    public static HamburgerBuilder getBuilder() {
        return new DefaultHamburgerBuilder();
    }

    public void print(PrintStream printStream) {
        printStream.println("Бургер (" + calories + ") ккал");
        components.forEach((component -> {
            printStream.println(component.toString());
        }));
        printStream.print('\n');
    }
}
