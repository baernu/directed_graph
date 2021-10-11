package messerli.directed_graph;

/**
 * class which implement the algorithm for the Page Rank value
 */
public class PageRank extends T {
    private final DirectedGraph dirg;
    private double d = 0.85;

    public PageRank(DirectedGraph dirg) {
        this.dirg = dirg;
    }


    /**
     * Method compute for a Node the sum of the Page Ranks from all the linked Edges
     * and set for the Node the new Page Rank value.
     * @param t: The Node t is the parameter for the specific Node
     */
    public void SetComputePageRankForNode(T t) {
        double sumPageRank = 0;
        for (T vertice : t.getNodeListIn()) {
            sumPageRank += (vertice.getPageRankValue())/(vertice.getNodeListOut().size());
        }
        if (t.getNodeListIn().size() != 0) {
            t.setPageRankValue((1-d)/(dirg.getAllNodeList().size()) + d*sumPageRank);
        } else {
            t.setPageRankValue((1-d)/(dirg.getAllNodeList().size()));
        }
    }

    /**
     * Method sets for each Node the Page Rank value
     */
    public void SetPageRankForAllNodes() {
        for (T vertice: dirg.getAllNodeList()) {
            SetComputePageRankForNode(vertice);
        }
    }

    /**
     * Method makes n^2 recursive calls and sets for all Nodes the new computed Page Rank value
     */
    public void doPageRank() {
        int n = (int) Math.pow(dirg.getAllNodeList().size(), 2);
        while (n > 0) {
            SetPageRankForAllNodes();
            n--;
        }
    }
}
