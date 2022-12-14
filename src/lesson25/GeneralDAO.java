package lesson25;


public class GeneralDAO<T extends IdEntity> {

    @SuppressWarnings("undchecked")

    public final T[] arrays = (T[]) new IdEntity[10];


    private void print(Order order) {
        System.out.println("order is: " + order.toString());
    }

    public void validate(T t) throws Exception {
        if (t.getId() <= 0) {
            throw new Exception("id can`t be negative");
        }
    }

    public <K> void validate(K k) {

        if (k.equals(100)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }


    public T save(T t) throws Exception {

        checkId(t);
        freeUsers();

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == null) {
                arrays[i] = t;
                return t;
            }
        }
        throw new Exception("error: writing to the array is not possible ");
    }


    public T[] getAll() {

        return arrays;
    }


    public boolean checkId(T t) throws Exception {

        for (T object : arrays) {
            if (object != null && object.getId() == t.getId()) {
                throw new Exception("error : with the same ID cannot be stored in an array. ");
            }
        }
        return true;
    }

    public boolean freeUsers() throws Exception {

        for (T object : arrays) {
            if (object == null) {
                return true;
            }
        }
        throw new Exception("error: not freely ");
    }

}
