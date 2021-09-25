package messerli.directed_graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    static T t1, t2, t3, t4, t5, t6;
    static DirectedGraph dirg;

    @Before
    public void installation() {
        dirg = new DirectedGraph();
        AppTest.t1 = new T(1);
        AppTest.t2 = new T(2);
        AppTest.t3 = new T(3);
        AppTest.t4 = new T(4);
        AppTest.t5 = new T(5);
        AppTest.t6 = new T(6);

        AppTest.dirg.addEdge(t1, t3);
        AppTest.dirg.addEdge(t1, t5);
        AppTest.dirg.addEdge(t1, t6);
        AppTest.dirg.addEdge(t2, t1);
        AppTest.dirg.addEdge(t2, t4);
        AppTest.dirg.addEdge(t5, t6);
        AppTest.dirg.addEdge(t6, t2);
        AppTest.dirg.addEdge(t6, t3);
        AppTest.dirg.addEdge(t6, t4);
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testT() {

        assertEquals(t1.getInt(), 1);
        assertEquals(t1.getCount(), 1);
    }
}
