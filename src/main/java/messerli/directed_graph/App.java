package messerli.directed_graph;

public class App {
    DirectedGraph dg = new DirectedGraph();
    PageRank pageRank = new PageRank(dg);
    T t = new T();

    public static void main(String[] args) {
        App app = new App();
        T t1 = new T(1);
        T t2 = new T(2);
        T t3 = new T(3);
        T t4 = new T(4);
        T t5 = new T(5);
        T t6 = new T(6);
        T t7 = new T(7);
        T t8 = new T(8);
        T t9 = new T(9);

        app.dg.addEdge(t1, t3);
        app.dg.addEdge(t1, t5);
        app.dg.addEdge(t1, t6);
        app.dg.addEdge(t2, t1);
        app.dg.addEdge(t2, t4);
        app.dg.addEdge(t5, t6);
        app.dg.addEdge(t6, t2);
        app.dg.addEdge(t6, t3);
        app.dg.addEdge(t6, t4);
        app.dg.addEdge(t1, t9);
        app.dg.addEdge(t9, t8);
        app.dg.addEdge(t8, t5);
        app.dg.addEdge(t3, t8);
        app.dg.addEdge(t3, t2);
        app.dg.addEdge(t2, t7);
        app.dg.addEdge(t4, t7);
        app.dg.addEdge(t7, t3);
        app.dg.addEdge(t8, t7);

        int n = app.dg.getAllNodeList().size();
        while (n >= 0) {
            app.pageRank.SetPageRankForAllNodes();
            n--;
        }


        app.dg.printRankList();
        app.dg.getAllNodeList().stream().forEach(e-> System.out.println(e.getInt()));
        app.dg.getAllNodeList().stream().forEach(e -> {
            e.getNodeListIn().stream().forEach(e1 -> System.out.print(e1.getInt() + " " + e1.getPageRankValue() + " "));
            System.out.println();
        });

    }
}
