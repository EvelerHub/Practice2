package ua.nure.manko.Practice2;

import java.util.Iterator;

/**
 * Created by Eveler on 20.05.2015.
 */
public class MyListImpl implements MyList, ListIterable {
    private Object[] container;
    private int size;
    private int capacity;

    public MyListImpl() {
        size = 0;
        capacity = 10;
        container = new Object[capacity];
    }

    private Object[] reallocation(Object[] container) {
        int newCapacity = container.length * 3 / 2;
        Object[] newContainer = new Object[newCapacity];
        System.arraycopy(container, 0, newContainer, 0, container.length);

        return newContainer;
    }

    private void fastRemove(int index) {
        System.arraycopy(container, index + 1, container, index, size - index - 1);
        container[size--] = null;
    }

    @Override
    public void add(Object e) {
        if (capacity < size - 1) {
            container[size++] = e;
        } else {
            container = reallocation(container);
            container[size++] = e;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            container[i] = null;
        }
        size = 0;

        System.gc(); //GC run;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (container.equals(o)) {
                fastRemove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        return container;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (container.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        int count = 0;
        for (int i = 0; i < c.size(); i++) {
            if (contains(c.toArray()[i])) {
                count++;
            }
        }
        return count == c.size();
    }

    @Override
    public String toString() {
        String stringOunt = "[";
        for (int i = 0; i < size; i++) {
            stringOunt += (i != 0 ? " " : "") + container[i];
        }
        stringOunt += "]";

        return stringOunt;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        protected boolean flag = true;
        protected int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Object next() {
            flag = false;
            return container[current++];
        }

        @Override
        public void remove() {
            if (flag) {
                throw new IllegalStateException();
            } else {
                fastRemove(current);
            }
            flag = true;
        }

    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public Object previous() {
            flag = false;
            return container[current--];
        }

        @Override
        public void set(Object e) {
            if (flag) {
                throw new IllegalStateException();
            }
            container[current] = e;
            flag = true;
        }

    }


}
