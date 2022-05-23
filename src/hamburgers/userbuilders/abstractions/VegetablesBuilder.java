package hamburgers.userbuilders.abstractions;

public interface VegetablesBuilder<T> extends BuilderWithParent<T> {
    VegetablesBuilder<T> more(int count);
    VegetablesBuilder<T> less(int count);
}
