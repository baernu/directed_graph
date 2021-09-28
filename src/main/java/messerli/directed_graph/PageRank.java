package messerli.directed_graph;

public class PageRank extends T {
    private final DirectedGraph dirg;
    private double d = 0.81;

    public PageRank(DirectedGraph dirg) {
        this.dirg = dirg;
    }



    public void SetComputePageRankForNode(T t) {
        double sumPageRank = 0;
        for (T vertice : t.getNodeListIn()) {
            sumPageRank += vertice.getPageRankValue();
        }
        if (t.getNodeListIn().size() != 0) {
            t.setPageRankValue((1-d)/(dirg.getAllNodeList().size()) + d*sumPageRank/(t.getNodeListIn().size()));
        } else {
            t.setPageRankValue((1-d)/(dirg.getAllNodeList().size()));
        }

        
    }
    
    public void SetPageRankForAllNodes() {
        for (T vertice: dirg.getAllNodeList()) {
            SetComputePageRankForNode(vertice);
        }
    }





}
