import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Intro2CS, 2026A, this is a very
 */
class MapTest {
    /**
     */
    private int[][] _map_3_3 = {{0,1,0}, {1,0,1}, {0,1,0}};
    private int[][] defint ={{0}};
    private Map defmap = new Map(defint);
    private Map2D _m0=defmap, _m1=defmap, _m3_3;
    @BeforeEach
    public void setuo() {
        _m3_3 = new Map(_map_3_3);

    }
    @Test
    @Timeout(value = 1, unit = SECONDS)
    void init() {
        int[][] bigarr = new int [500][500];
        _m1.init(bigarr);
        assertEquals(bigarr.length, _m1.getWidth());
        assertEquals(bigarr[0].length, _m1.getHeight());
        Pixel2D p1 = new Index2D(3,2);
        _m1.fill(p1,1, true);
    }

    @Test
    void testInit() {
        _m0.init(_map_3_3);
        _m1.init(_map_3_3);
        assertEquals(_m0, _m1);
    }
    @Test
    void testEquals() {
        assertEquals(_m0,_m1);
        _m0.init(_map_3_3);
        _m1.init(_map_3_3);
        assertEquals(_m0,_m1);
    }
    @Test
    void testGetWidth() {
        int a=0;
        a= _m3_3.getWidth();
        assertEquals(a,3);

    }
    @Test
    void testGetHeight() {
        int a=0;
        a= _m3_3.getHeight();
        assertEquals(a,3);
    }
    @Test
    void testSetPixel() {
        Index2D idx = new Index2D(3,2);
        int[][] bigarr = new int [500][500];
        _m0.init(bigarr);
        _m0.setPixel(idx,8);
        assertEquals(_m0.getMap()[3][2], _m0.getPixel(3,2));
    }
    @Test
    void testFill() {
        int[][] bigarr ={{1,1,2,2,2,1,0,0},{1,1,1,1,2,1,1,0},{2,2,2,1,1,0,0,0},{0,0,0,2,2,1,1,1}};
        _m0.init(bigarr);
        _m1.init(bigarr);
        _m1.fill(new Index2D(2,1),0,true);
        Pixel2D[] m1 =_m1.shortestPath(new Index2D(0,0),new Index2D(7,2),2,true);
        Pixel2D[] m0 = _m0.shortestPath(new Index2D(0,0),new Index2D(7,2),2,true);
        for(int i=0;i<m0.length;i++)
        {
            assertEquals(m0[i],m1[i]);
        }

    }
    @Test
    void testMul() {
        Map m = new Map(2, 2, 3);
        m.mul(2);
        assertEquals(6, m.getPixel(1, 1));
    }
    @Test
    void testDrawRect() {
        Map m = new Map(5, 5, 0);
        m.drawRect(new Index2D(1, 1), new Index2D(3, 3), 7);
        assertEquals(7, m.getPixel(2, 2));
        assertEquals(0, m.getPixel(0, 0));
    }
    @Test
    void testFill2() {
        Map m = new Map(3, 3, 1);
        m.setPixel(1, 1, 2);
        m.fill(new Index2D(0, 0), 9, false);
        assertEquals(9, m.getPixel(0, 0));
        assertEquals(2, m.getPixel(1, 1));
    }
    @Test
    void testShortestPathSimple() {
        Map m = new Map(3, 3, 0);
        Pixel2D[] path = m.shortestPath(
                new Index2D(0, 0),
                new Index2D(2, 2),
                -1,
                false
        );
        assertNotNull(path);
        assertEquals(new Index2D(0, 0), path[0]);
        assertEquals(new Index2D(2, 2), path[path.length - 1]);
    }
    @Test
    void testShortestPathBlocked() {
        Map m = new Map(3, 3, 0);
        m.setPixel(1, 0, 9);
        m.setPixel(1, 1, 9);
        m.setPixel(1, 2, 9);

        Pixel2D[] path = m.shortestPath(
                new Index2D(0, 0),
                new Index2D(2, 2),
                9,
                false
        );
        assertNull(path);
    }
    @Test
    void testAllDistance() {
        Map m = new Map(3, 3, 0);
        Map2D d = m.allDistance(new Index2D(0, 0), -1, false);

        assertEquals(0, d.getPixel(0, 0));
        assertEquals(2, d.getPixel(1, 1));
        assertEquals(4, d.getPixel(2, 2));
    }

}