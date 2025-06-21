package srpingudemy.cruddemo.dao;

public interface StudentDAO<T> {
    void save(T student);
}
