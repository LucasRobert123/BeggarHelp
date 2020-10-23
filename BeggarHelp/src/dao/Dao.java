package dao;

import java.util.List;

public interface Dao<T> {
   T get(int id);
   
   List<T> getAll();
   
   void save(T instance);
   
   void update(T instance);
   void delete(T instance);
}
