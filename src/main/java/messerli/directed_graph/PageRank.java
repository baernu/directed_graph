package messerli.directed_graph;

public class PageRank extends T {
    private final DirectedGraph dirg;
    private double d = 0.82;

    public PageRank(DirectedGraph dirg) {
        this.dirg = dirg;
    }



    public void SetComputePageRankForNode(T t) {
        double sumPageRank = 1.0;
        for (T vertice : t.getList()) {
            sumPageRank += vertice.getPageRankValue();
        }
        if (t.getList().size() != 0) {
            t.setPageRankValue((1-d)/(dirg.getAllNodeList().size()) + d*sumPageRank/(t.getList().size()));
        } else {
            t.setPageRankValue((1-d)/(dirg.getAllNodeList().size()) + d*sumPageRank/1);
        }

        
    }
    
    public void SetPageRankForAllNodes() {
        for (T vertice: dirg.getAllNodeList()) {
            SetComputePageRankForNode(vertice);
        }
    }





}
