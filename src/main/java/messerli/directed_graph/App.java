package messerli.directed_graph;

public class App {
    DirectedGraph dg = new DirectedGraph();
    T t = new T();

    public static void main(String[] args) {
        App app = new App();
        T t1 = new T(1);
        T t2 = new T(2);
        T t3 = new T(3);
        T t4 = new T(4);
        T t5 = new T(5);
        T t6 = new T(6);

        app.dg.addEdge(t1, t3);
        app.dg.addEdge(t1, t5);
        app.dg.addEdge(t1, t6);
        app.dg.addEdge(t2, t1);
        app.dg.addEdge(t2, t4);
        app.dg.addEdge(t5, t6);
        app.dg.addEdge(t6, t2);
        app.dg.addEdge(t6, t3);
        app.dg.addEdge(t6, t4);

        app.dg.printRankList();
    }
}
