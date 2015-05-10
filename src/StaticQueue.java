import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by 40218 on 5/9/15.
 */
public class StaticQueue<T> implements Iterator<T> {
    private T[] s;
    private int size, last, first;
    static final int DEF = 10;
    private int C = 0;

    public StaticQueue() {
        s = (T[]) new Object[DEF];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void resize(int max) {
        if (max >= size) {
            T[] temp = (T[]) new Object[max];
            for (int i = 0; i < size; i++) {
                temp[i] = s[(first + i) % s.length];
            }
            s = temp;
            first = 0;
            last = size;
        }
    }

    public boolean isFull() {
        return size == s.length;
    }

    public void enqueue(T t) {
        if (isFull())
            resize(2 * size);
        s[(last++)] = t;
        if (last == s.length)
            last = 0;
        size++;
    }

    public T dequeue() {
        if (isEmpty())
            return null;
        T t = s[first];
        s[first] = null;
        size--;
        first++;
        if (isFull())
            first = 0;
        if (size > 0 && size == s.length / 4)
            resize(s.length / 2);
        return t;
    }

    public int getFirst() {
        return first;
    }

    @Override
    public boolean hasNext() {
        return C < size;
    }

    @Override
    public T next() {
        if (!hasNext())
            return null;
        T t = s[(C + first) % s.length];
        C++;
        return t;
    }



     public String toString(){
         return Arrays.toString(s);
     }

    public static void main(String[] args) {
        StaticQueue<String> yayyy = new StaticQueue<String>();
        System.out.println(yayyy.getSize());
        System.out.println(yayyy.dequeue());
        yayyy.enqueue("Hi");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi1");
        System.out.println(yayyy.toString());
        System.out.println(yayyy.dequeue());
        System.out.println(yayyy.toString());
        System.out.println(yayyy.dequeue());
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi2");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi3");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi4");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi5");
        System.out.println(yayyy.dequeue());
        System.out.println(yayyy.dequeue());
        System.out.println(yayyy.dequeue());
        yayyy.enqueue("Hi6");
        yayyy.enqueue("Hi7");
        yayyy.enqueue("Hi8");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi9");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi10!!!");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi11");
        yayyy.enqueue("Hi12");
        System.out.println(yayyy.dequeue());
        System.out.println(yayyy.toString());
        System.out.println(yayyy.dequeue());
        System.out.println(yayyy.toString());
        System.out.println(yayyy.dequeue());
        System.out.println(yayyy.toString());
        System.out.println(yayyy.dequeue());
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi13");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi14");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi15");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi16");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi17");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi18");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi19");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi20");
        System.out.println(yayyy.getSize());
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi20!");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi20!!");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi20!!!");
        System.out.println(yayyy.toString());
        System.out.println(yayyy.dequeue());
        System.out.println(yayyy.toString());
        System.out.println(yayyy.dequeue());
        System.out.println(yayyy.toString());
        System.out.println(yayyy.dequeue());
        System.out.println(yayyy.toString());
        System.out.println(yayyy.dequeue());
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi20!!!!");
        System.out.println(yayyy.toString());
        yayyy.enqueue("Hi20!!!!!");


        while(!yayyy.isEmpty()) {
            System.out.println(yayyy.dequeue());
        }
    }
}
