package messerli.directed_graph;

public class PageRank extends T {
    private final DirectedGraph dirg;
    private double d = 0.85;

    public PageRank(DirectedGraph dirg) {
        this.dirg = dirg;
    }


    /**
     * Methode compute for a node the sum of the page ranks from all the linked edges
     * and set for the node the new page rank value
     * @param t is the parameter for the specific node
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
     * Methode sets for each node the page rank value
     */
    public void SetPageRankForAllNodes() {
        for (T vertice: dirg.getAllNodeList()) {
            SetComputePageRankForNode(vertice);
        }
    }

    /**
     * Methode makes n^2 recursive calls and sets for all nodes the new computed page rank value
     */
    public void doPageRank() {
        int n = (int) Math.pow(dirg.getAllNodeList().size(), 2);
        while (n > 0) {
            SetPageRankForAllNodes();
            n--;
        }
    }
}
