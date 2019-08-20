import java.util.*;

public class Percolation {
    private int [] n = {50, 100, 200};
    private double [] prob = new double[3] ;

    public int[][] ground(int n, double p) {
        int[][] ground = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.random() <= p) {
                    ground[i][j] = 1;
                } else {
                    ground[i][j] = 0;
                }
            }
        }
        return ground;
    }

    public void seep(int[][] ground, int row) {
        if(row == ground.length-1) {
            return;
        }
        for(int j = 0; j < ground[row].length; j++){
            if(ground[row][j] == 2 && ground[row + 1][j] == 0) {
                ground[row + 1][j] = 2;
            }
        }
        for(int j = 0; j < ground[row + 1].length; j++){
            if(ground[row + 1][j] == 2){
                int i = j-1;
                while (i >= 0 && ground[row + 1][i] == 0) {
                    ground[row+1][i] = 2;
                    i--;
                }
                i = j + 1;
                while (i <= ground[0].length-1 && ground[row + 1][i] != 1){
                    ground[row + 1][i] = 2;
                    i++;
                }
                j = i + 1;
            }
        }
    }

    public boolean percolate(int[][] ground) {
        for(int row = 0; row < ground[0].length; row++){
            seep(ground, row);
        }
        for(int j = 0; j < ground[0].length; j++) {
            if(ground[ground[0].length-1][j] == 2) {
                return true;
            }
        }
        return false;
    }

    public double probability(int n, double p) {
        int[][] ground;
        double it = 1000;
        double count = 0;
        for(int i = 0; i < it; i++){
            ground = ground(n, p);
            if(percolate(ground)) {
                count++;
            }
        }
        return count/it;
    }

    public double findProbability(int n) {
        double p = 0.5;
        double delta;
        double R = probability(n, p);
        double temp;
        while(Math.abs(R - 0.5) > 0.01){
            temp = Math.pow(R - 0.5, 2);
            delta = 0.1 * (R - 0.5 > 0 ? temp:-temp);
            p = p + delta;
            while(p < 0 || p > 1) {
                delta = delta / 2;
            }
            R = probability(n, p);

        }
        return p;
    }
    public static void main(String[] args) {
        Percolation pl = new Percolation();

        for (int i = 0; i < pl.prob.length; i++) {
            pl.prob[i] = pl.findProbability(pl.n[i]);
            System.out.println("n = " + pl.n[i] + ": p = " + String.format("%.2f", pl.prob[i]));
        }
    }
}
