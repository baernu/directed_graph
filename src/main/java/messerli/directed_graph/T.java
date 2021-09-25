package messerli.directed_graph;

import java.util.ArrayList;
import java.util.List;

public class T implements Comparable<T> {
    private int position;
    private int counter = 0;
    private List<T> nodelist;

    public T() {
    };

    public T(int position) {
        this.position = position;
        this.nodelist = new ArrayList<>();
    }

    public int getInt() {
        return this.position;
    }

    public int getCount() {
        return this.counter;

    }

    @Override
    public int compareTo(T t) {
        return Integer.compare(t.getCount(), this.getCount());
    }

    public List<T> getList() {
        return this.nodelist;
    }

    public boolean checkList(T destination) {
        return nodelist.stream().anyMatch(element -> element.equals(destination));
    }

    public void addNode(T destination) {
        if (!checkList(destination)) {
            this.nodelist.add(destination);
        }

    }

    public void increase() {
        this.counter++;
    }

}
