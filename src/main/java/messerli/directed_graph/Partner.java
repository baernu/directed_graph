package messerli.directed_graph;

public class Partner {
    DirectedGraph dg = new DirectedGraph();
    PageRank pageRank = new PageRank(dg);
    T t = new T();



    public static void main(String[] args) {
        Partner partner = new Partner();
        T t1 = new T(1);
        T t2 = new T(2);
        T t3 = new T(3);
        T t4 = new T(4);
        T t5 = new T(5);
        T t6 = new T(6);
        T t7 = new T(7);
       

        partner.dg.addEdge(new Edge(t1, t6));
        partner.dg.addEdge(new Edge(t1, t5));
        partner.dg.addEdge(new Edge(t1, t4));
        partner.dg.addEdge(new Edge(t2, t6));
        partner.dg.addEdge(new Edge(t2, t7));
        partner.dg.addEdge(new Edge(t3, t6));
        partner.dg.addEdge(new Edge(t3, t4));
        partner.dg.addEdge(new Edge(t4, t1));
        partner.dg.addEdge(new Edge(t4, t3));
        partner.dg.addEdge(new Edge(t5, t1));
        partner.dg.addEdge(new Edge(t5, t2));
        partner.dg.addEdge(new Edge(t5, t3));
        partner.dg.addEdge(new Edge(t6, t2));
        partner.dg.addEdge(new Edge(t7, t1));
        partner.dg.addEdge(new Edge(t7, t2));
      

        partner.pageRank.doPageRank();



        System.out.println();
        partner.dg.getAllNodeList().stream().sorted().forEach(e -> {
            System.out.printf("Teilnehmer/in: " + e.getInt() + "    Page Rank value  :   %.2f", e.getPageRankValue());
            e.getNodeListIn().stream().forEach(e1 -> System.out.print("    likes von : " + e1.getInt() ));
            System.out.println();
        });

    }
}
