package ants;

import java.util.Arrays;

public class PheromoneMatrix {
    private int[][] m;

    public PheromoneMatrix(Problem problem) {
        this.m = new int[problem.get_num_cities()][problem.get_num_cities()];
    }

    /****** TO STRING ******/
    public String toString() {
        String s = "";

        for (int i = 0; i < this.m.length; i++) {
            s += Arrays.toString(m[i]) + "\n";
        }

        return s;
    }
}
