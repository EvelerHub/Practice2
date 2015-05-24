package ua.nure.manko.Practice2;

import java.util.Iterator;

/**
 * Created by Eveler on 20.05.2015.
 */
public class Test {

    public static void main(String[] args) {


        MyListImpl con = new MyListImpl();
        for (int i = 0; i < 100; i++) {
            con.add(i);
        }
        System.out.println(con + "\n");

        for (Object o : con) {
            System.out.print(o + " ");
        }
        System.out.println("\n");

        Iterator<Object> it = con.iterator();
        it.next();
        it.remove();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n");

        Iterator<Object> it2 = con.listIterator();
        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }

    }
}
