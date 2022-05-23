package hamburgers.default_builders;

import hamburgers.components.Component;
import hamburgers.components.ComponentSize;

public interface DefaultBuilder<T extends Component> {
    T build();
    DefaultBuilder<T> withSize(ComponentSize size);
}
