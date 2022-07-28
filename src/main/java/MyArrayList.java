import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;

public class MyArrayList<E> implements MyList<E> {
    private int size = 0;
    private int capacity = 0;
    private final int CAPACITY = 16;
    private Object[] array;

    public MyArrayList() {
        capacity = CAPACITY;
        array = new Object[capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    private void increaseCapacity() {
        capacity = capacity * 2;
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
            array[i] = null;
        }
        array = newArray;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        if (size >= capacity) {
            increaseCapacity();
        }
        array[size++] = e;
        return true;
    }

    @Override
    public void addIndex(int index, E element) {
        if (index < 0) {
            return;
        }
        if (size + 1 >= capacity) {
            increaseCapacity();
        }
        if (index > size) {
            index = size;
        }
        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    @Override
    public boolean addAll(List<E> myList) {
        if (myList == null) {
            return false;
        }
        if (myList.isEmpty()) {
            return false;
        }
        for (E o : myList) {
            add(o);
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;

    }

    @Override
    public E get(int index) {
        if ((index < size) && (index >= 0)) {
            return (E) array[index];
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        if ((index < size) && (index >= 0)) {
            E oldElement = (E) array[index];
            array[index] = element;
        }
        return (E) array[index];
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(array[i])) {
                    return i;
                }

            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void toLeft(int number) {
        size--;
        if (size <= 0) {
            return;
        }
        if (number <= size) {
            for (int i = number; i < size; i++) {
                array[number] = array[number + 1];
            }
            array[size] = null;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < size; i++) {
            if ((o == null) && (array[i] == null)) {
                break;
            }
            if (array[i] != null && (array[i].equals(o))) {
                break;
            }
            j = i;
        }
        if (j < size) {
            toLeft(j);
            return true;
        }
        return false;
    }

    @Override
    public E remove(int index) {
        E e = null;
        if ((index < size) && (index >= 0)) {
            e = get(index);
            toLeft(index);
        }
        return e;

    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        for (int i = 0;  i < size; i++) {
            array[i] = operator.apply((E) array[i]);
        }

    }


}
