package ua.nure.manko.Practice2;

/**
 * Created by Eveler on 20.05.2015.
 */
public interface MyList extends Iterable<Object> {
    void add(Object e); // добавить элемент в контейнер
    void clear(); // очистить контейнер
    boolean remove(Object o); // удалить элемент из контейнера
    Object[] toArray(); // вернуть массив элементов из контейнера
    int size(); // вернуть количество элементов в контейнере
    boolean contains(Object o); // проверить, содержится ли элемент в контейнере (с помощью equals)
    boolean containsAll(MyList c); // проверить, содержит ли контейнер все элементы из контейнера c
}