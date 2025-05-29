import java.util.ArrayList;

public interface IRepository<T> {
    T post(T t);

    void delete(int i);

    void put(T t);

    T getById(int i);

    ArrayList<T> getAll();
}
