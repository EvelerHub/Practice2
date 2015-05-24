package ua.nure.manko.Practice2;

import java.util.Iterator;

/**
 * Created by Eveler on 20.05.2015.
 */
interface ListIterator extends Iterator<Object> { // java.util.Iterator
    boolean hasPrevious(); // проверяет, есть ли предыдущий элемент для выборки previous
    Object previous(); // возвращает предыдущий элемент
    void set(Object e); // заменяет элемент, который на предыдущем шаге был возвращен next/previous на данный элемент
    void remove(); // удаляет элемент, который на предыдущем шаге был возвращен next/previous
}
