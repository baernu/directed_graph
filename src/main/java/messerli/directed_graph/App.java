package messerli.directed_graph;

/**
 * class which shows the output of a small Page Rang Example with nine Nodes and nineteen edges.
 */
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

        app.dg.addEdge(new Edge(t1, t3));
        app.dg.addEdge(new Edge(t1, t5));
        app.dg.addEdge(new Edge(t1, t6));
        app.dg.addEdge(new Edge(t2, t1));
        app.dg.addEdge(new Edge(t2, t4));
        app.dg.addEdge(new Edge(t5, t6));
        app.dg.addEdge(new Edge(t6, t2));
        app.dg.addEdge(new Edge(t6, t3));
        app.dg.addEdge(new Edge(t6, t4));

        app.dg.addEdge(new Edge(t1, t9));
        app.dg.addEdge(new Edge(t9, t8));
        app.dg.addEdge(new Edge(t8, t5));
        app.dg.addEdge(new Edge(t3, t8));
        app.dg.addEdge(new Edge(t3, t2));
        app.dg.addEdge(new Edge(t2, t7));
        app.dg.addEdge(new Edge(t4, t7));
        app.dg.addEdge(new Edge(t7, t3));
        app.dg.addEdge(new Edge(t8, t7));
        app.dg.addEdge(new Edge(t3, t5));

        app.pageRank.doPageRank();




        app.dg.printRankList();
        System.out.println();
        app.dg.getAllNodeList().stream().sorted().forEach(e -> {
            System.out.print("Vertex: " + e.getInt() + "  ");
            e.getNodeListIn().stream().forEach(e1 -> System.out.printf("    Node-In: " +
                    e1.getInt() + "    Page Rank value:   %.5f" ,e1.getPageRankValue()));
            System.out.println();
        });

    }
}
