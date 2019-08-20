import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PercolationTest {
    Percolation pl = new Percolation();

    @org.junit.jupiter.api.Test
    void ground() {
        int n = 50;
        double p = 0.4;
        int i = 0;
        int j = 0;
        int[][] ground = new int[50][50];
        for (i = 0; i < 50; i++) {
            for (j = 0; j < 50; j++) {
                if (Math.random() <= 0.4) {
                    ground[i][j] = 1;
                } else {
                    ground[i][j] = 0;
                }
            }
        }
        Assertions.assertEquals(50, 0.4);
    }

    @org.junit.jupiter.api.Test
    void seep() {
        int[][] ground = {  {1, 0, 0, 0, 1, 0, 1, 0, 0, 1},
                            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                            {0, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                            {1, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                            {0, 0, 1, 0, 0, 0, 1, 0, 1, 1},
                            {1, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                            {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0}  };
        pl.seep(ground, 0);
        int[][] expect = { {1, 2, 2, 2, 1, 2, 1, 2, 2, 1},
                            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                            {0, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                            {1, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                            {0, 0, 1, 0, 0, 0, 1, 0, 1, 1},
                            {1, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                            {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0}  };
        Assertions.assertArrayEquals(expect, ground);
    }

    @Test
    public void percolateTest() {
        int[][] ground1 = { {1, 1, 0, 0, 1, 0, 1, 0, 0, 1},
                            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                            {0, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                            {1, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                            {0, 0, 1, 0, 0, 0, 1, 0, 1, 1},
                            {1, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                            {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0}  };
        Assertions.assertTrue(pl.percolate(ground1));

        int[][] ground2 = { {1, 1, 0, 0, 1, 0, 1, 0, 0, 1},
                            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                            {0, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                            {1, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                            {0, 0, 1, 0, 0, 1, 1, 0, 1, 1},
                            {1, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                            {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                            {0, 0, 1, 0, 0, 0, 0, 0, 1, 0}  };
        Assertions.assertFalse(pl.percolate(ground2));
    }
}

