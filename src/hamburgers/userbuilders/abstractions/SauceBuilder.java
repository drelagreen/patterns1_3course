package hamburgers.userbuilders.abstractions;

public interface SauceBuilder<T> extends BuilderWithParent<T> {
    SauceBuilder<T> more(int grams);
    SauceBuilder<T> less(int grams);
}
