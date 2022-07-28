import java.util.List;
import java.util.function.UnaryOperator;


public interface MyList<E> {
    int size();
    boolean add (E e);
    void addIndex(int index, E element);
    boolean addAll (List<E> myList);
    void clear();
    E get(int index);
    E set (int index, E element);
    int indexOf (E element);
    boolean isEmpty();
    boolean remove (Object o);
    E remove (int index );
    void replaceAll(UnaryOperator<E> operator);
}
