import javax.lang.model.element.Element;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Iterator;

public class NewArrayList<E> implements MyCollection {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;


    private int size = 0;



    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }

    public NewArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
        this.size = DEFAULT_CAPACITY;

    }

    public NewArrayList(int size) {
        elementData = new Object[this.size = size];

    }

    private boolean isFull() {
        return size == elementData.length;
    }

    @Override
    public void add(int index, Object element) {

        if (isFull()){

            elementData = resize(size);
        }

        for (int i = size - 1; i > index; i--){

            elementData[i] = elementData[i-1];

        }
        elementData[index] = element;

    }

    @Override
    public void addAll(Collection collection) {

        collection.stream().forEach(o-> add(size++,o));

    }

    @Override
    public void clear() {

        for (int i = 0; i<size-1; i++){

            elementData[i] = null;

        }

    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void remove(int index) {

        for (int i = index; i < size - 1 ; i++){

            elementData[i] = elementData[i+1];

        }
        elementData[size-1] = null;

    }

    @Override
    public boolean remove(Object o) {

       for (int i = 0 ; i < size-1; i++)

            if(elementData[i] == o ){

                remove(i);
                return true;

            }
       return false;

    }

    @Override
    public int size() {
        return size;
    }

    private Object[] resize(int sizeNew) {

        sizeNew = sizeNew * 2;

        Object[] newElementData = new Object[sizeNew];
        for (int i = 0; i < size - 1; i++) {

            newElementData[i] = elementData[i];
        }
            return newElementData;

        }




}

