package messerli.directed_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DirectedGraph extends T {

    private List<Edge> edgeList;
    private List<T> allNodeList;

    public DirectedGraph() {
        allNodeList = new ArrayList<>();
        edgeList = new ArrayList<>();
    }

    public boolean checkNode(T t) {
        return allNodeList.stream().anyMatch(element -> element.equals(t));
    }

    public boolean checkNodeListIn(T t) {
        return t.getNodeListIn().stream().anyMatch(element -> element.equals(t));
    }

    public boolean checkNodeListOut(T t) {
        return t.getNodeListOut().stream().anyMatch(element -> element.equals(t));
    }

    public void addNodeToAllList(T t) {
        if (!checkNode(t)) {
            allNodeList.add(t);
        }
    }

    public void addEdge(Edge e) {
        addNodeToAllList(e.getVertex());
        addNodeToAllList(e.getDestination());

        if (!checkIfEdgeExists(e)) {
            e.getVertex().addNodeToNodeListOut(e);
            e.getDestination().addNodeToNodeListIn(e);
            edgeList.add(e);
        }
    }


    public List<T> getAllNodeList() {
        return this.allNodeList;
    }

    public boolean checkIfEdgeExists(Edge e) {
        return edgeList.stream().anyMatch(element -> element.equals(e));
    }

    public List<T> rankList() {
        return allNodeList.stream().sorted().collect(Collectors.toList());
    }

    public void printRankList() {
        rankList().stream().forEach(element -> System.out.printf("Vertex: " + element.getInt() +
                "    Page Rank value:   %.5f\n" ,element.getPageRankValue()));
    }

}
