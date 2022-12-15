package lesson24;

public class GeneralDAO<T> {

    @SuppressWarnings("undchecked")
    private final T[] arrays = (T[]) new Object[5];

    public T save(T t) {
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == null) {
                arrays[i] = t;
                return t;
            }
        }
        return null;
    }

    public T[] getAll() {

        return arrays;
    }
}
