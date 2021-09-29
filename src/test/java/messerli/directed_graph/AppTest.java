package messerli.directed_graph;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Unit test for simple App.
 */
public class AppTest {
    static T t1, t2, t3, t4, t5, t6, t12, t13;
    static DirectedGraph dirg;
    static Edge edge;

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
    }

    /**
     * Test if adding to allNodeList is correct
     */
    @Test
    public void testAllNodeList() {
        assertEquals(AppTest.dirg.getAllNodeList().size(), 6);
        AppTest.dirg.addNodeToAllList(new T(7));
        assertEquals(AppTest.dirg.getAllNodeList().size(), 7);

        /*assertThrows(IllegalArgumentException.class, () -> {
            AppTest.dirg.addEdge(t2, t1);
        });*/
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
        AppTest.t12 = new T(12);
        AppTest.t13 = new T(13);
        AppTest.edge = new Edge(t12, t13);

        assertFalse(AppTest.dirg.checkIfEdgeExists(AppTest.edge));
        assertFalse(AppTest.edge.getDestination().checkListNodeIn(AppTest.edge));
        assertFalse(AppTest.edge.getVertex().checkListNodeOut(AppTest.edge));

        AppTest.dirg.addEdge(AppTest.edge);
        assertTrue(AppTest.dirg.checkIfEdgeExists(AppTest.edge));

        assertTrue(AppTest.dirg.checkNode(AppTest.t12));
        assertTrue(AppTest.dirg.checkNode(AppTest.t13));

        assertTrue(AppTest.edge.getDestination().checkListNodeIn(AppTest.edge));
        assertTrue(AppTest.edge.getVertex().checkListNodeOut(AppTest.edge));

    }
}
