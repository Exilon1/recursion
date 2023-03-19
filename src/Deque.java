import jdk.jshell.spi.ExecutionControl;

public class Deque<T> {

    public T popFront() {
        throw new UnsupportedOperationException();
    }

    public int count(Deque<T> deque) {
        T item = deque.popFront();

        if (item == null) {
            return 0;
        }

        return 1 + deque.count(this);
    }
}
