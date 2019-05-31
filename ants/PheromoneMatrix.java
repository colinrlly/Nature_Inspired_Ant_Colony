package ants;

import java.util.Arrays;

public class PheromoneMatrix {
    private float[][] m;

    public PheromoneMatrix(Problem problem) {
        this.m = new float[problem.get_num_cities()][problem.get_num_cities()];
    }
    
    public float getVal(int i, int j) {
      return m[i][j];
    }

    public void setVal(int i, int j, float val) {
      m[i][j] = val;
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
