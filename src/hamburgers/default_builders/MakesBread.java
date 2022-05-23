package hamburgers.default_builders;

public interface MakesBread<T, P> {
    T removeCrust();
    T removeSesame();
    T withPlacement(P p);
}
