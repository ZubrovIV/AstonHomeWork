import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void add() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(3);
        myArrayList.add(2);
        myArrayList.add(1);
        myArrayList.add(4);
        int a = myArrayList.size();
        assertEquals(a, 4);
        int b = myArrayList.get(1);
        assertEquals(b, 2);
    }

    @Test
    void addIndex() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(3);
        myArrayList.add(3);
        myArrayList.add(3);
        myArrayList.add(3);
        myArrayList.addIndex(2, 6);
        int index = myArrayList.get(2);
        assertEquals(index, 6);
        int size = myArrayList.size();
        assertEquals(size, 5);
    }

    @Test
    void addAll() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addAll(Arrays.asList(1, 2, 3));
        int size = myArrayList.size();
        assertEquals(size, 3);
        assertEquals(myArrayList.get(2), 3);
    }

    @Test
    void clear() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addAll(Arrays.asList(1, 2, 3));
        myArrayList.clear();
        assertEquals(myArrayList.size(), 0);
        assertNull(myArrayList.get(1));

    }

    @Test
    void get() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addAll(Arrays.asList(1, 2, 3));
        assertEquals(myArrayList.get(0), 1);
    }

    @Test
    void set() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addAll(Arrays.asList(1, 2, 3));
        myArrayList.set(1, 9);
        assertEquals(myArrayList.get(1), 9);
        assertEquals(myArrayList.size(), 3);

    }

    @Test
    void indexOf() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addAll(Arrays.asList(5, 7, 10));
        assertEquals(myArrayList.indexOf(10), 2);
    }

    @Test
    void isEmpty() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addAll(Arrays.asList(5, 7, 10));
        assertFalse(myArrayList.isEmpty());
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
        assertTrue(myArrayList1.isEmpty());
    }

    @Test
    void remove() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.addAll(Arrays.asList("one", "two", "three"));
        myArrayList.remove("one");
        assertEquals(myArrayList.size(), 2);
        assertEquals(myArrayList.get(0), "two");

    }

    @Test
    void testRemove() {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.addAll(Arrays.asList("one", "two", "three"));
        myArrayList.remove(1);
        assertEquals(myArrayList.size(), 2);
        assertEquals(myArrayList.get(1), "three");
    }

    @Test
    void replaceAll() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.addAll(Arrays.asList(5, 7, 10));
        myArrayList.replaceAll(x -> x * 2);
        assertEquals(myArrayList.size(), 3);
        assertEquals(myArrayList.get(0), 10);
        assertEquals(myArrayList.get(2), 20);

    }

    @Test
    void size() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(2);
        myArrayList.add(4);
        int size = myArrayList.size();
        int a = 2;
        assertEquals(a, size);

    }
}
