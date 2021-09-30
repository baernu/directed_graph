package messerli.directed_graph;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Unit test for directed Graph: compute the page rank for all nodes.
 */
public class AppTest {
    static T t1, t2, t3, t4, t5, t6;
    static DirectedGraph dirg;
    static Edge edge;
    static PageRank pageRank;

    @BeforeAll
    static public void installation() {
        dirg = new DirectedGraph();
        AppTest.t1 = new T(1);
        AppTest.t2 = new T(2);
        AppTest.t3 = new T(3);
        AppTest.t4 = new T(4);
        AppTest.t5 = new T(5);
        AppTest.t6 = new T(6);

        AppTest.dirg.addEdge(new Edge(t1, t3));
        AppTest.dirg.addEdge(new Edge(t1, t5));
        AppTest.dirg.addEdge(new Edge(t1, t6));
        AppTest.dirg.addEdge(new Edge(t2, t1));
        AppTest.dirg.addEdge(new Edge(t2, t4));
        AppTest.dirg.addEdge(new Edge(t5, t6));
        AppTest.dirg.addEdge(new Edge(t6, t2));
        AppTest.dirg.addEdge(new Edge(t6, t3));
        AppTest.dirg.addEdge(new Edge(t6, t4));

        AppTest.pageRank = new PageRank(dirg);
    }

    /**
     * Test if adding to allNodeList is correct
     */
    @Test
    public void testAllNodeList() {
        assertEquals(AppTest.dirg.getAllNodeList().size(), 6);
        AppTest.dirg.addNodeToAllList(new T(7));
        assertEquals(AppTest.dirg.getAllNodeList().size(), 7);
    }

    /**
     * Test if the position of the node is correct
     */
    @Test
    public void testT() {

        assertEquals(t1.getInt(), 1);
        T t15 = new T(15);
        assertEquals(t15.getInt(), 15);
    }

    /**
     * Test if the allNodeListCheck is correct
     */
    @Test
    public void testCheckNode() {
        T t14 = new T(14);
        AppTest.dirg.addNodeToAllList(t14);
        assertTrue(AppTest.dirg.checkNode(t14));

    }

    /**
     * Test if the addEdge is correct and also the checkIfEdgeExists
     */
    @Test
    public void testAddEdge() {
        T t12 = new T(12);
        T t13 = new T(13);
        AppTest.edge = new Edge(t12, t13);

        assertFalse(AppTest.dirg.checkIfEdgeExists(AppTest.edge));
        assertFalse(AppTest.edge.getDestination().checkListNodeIn(AppTest.edge));
        assertFalse(AppTest.edge.getVertex().checkListNodeOut(AppTest.edge));

        AppTest.dirg.addEdge(AppTest.edge);
        assertTrue(AppTest.dirg.checkIfEdgeExists(AppTest.edge));

        assertTrue(AppTest.dirg.checkNode(t12));
        assertTrue(AppTest.dirg.checkNode(t13));

        assertTrue(AppTest.edge.getDestination().checkListNodeIn(AppTest.edge));
        assertTrue(AppTest.edge.getVertex().checkListNodeOut(AppTest.edge));

    }

    /**
     * Test if the page rank algorithm reacte on a modification
     */
    @Test
    public void testPageRank() {
        AppTest.pageRank.doPageRank();
        T tx = AppTest.dirg.rankList().get(5);
        double d1 = tx.getPageRankValue();
        T ty = AppTest.dirg.rankList().get(3);
        AppTest.dirg.addEdge(new Edge(ty, tx));
        AppTest.pageRank.doPageRank();
        double d2 = tx.getPageRankValue();
        assertTrue(d1 < d2);
    }
}
