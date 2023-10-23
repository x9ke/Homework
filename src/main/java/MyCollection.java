import java.util.Collection;

public interface MyCollection<E> {

    void add(int index, E element);
    void addAll(Collection<? extends E> collection);
    void clear();
    E get(int index);
    boolean isEmpty();
    void remove(int index);
    boolean remove(Object o);

    int size();
}
