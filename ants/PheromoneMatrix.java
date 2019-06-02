package ants;

import java.util.Arrays;

public class PheromoneMatrix {
    private float[][] m;

    public PheromoneMatrix(Problem problem) {
        this.m = new float[problem.get_num_cities()][problem.get_num_cities()];
    }

    /****** TO STRING ******/
    public String toString() {
        String s = "";

        for (int i = 0; i < this.m.length; i++) {
            s += Arrays.toString(m[i]) + "\n";
        }

        return s;
    }

    public float[][] getM() {
        return m;
    }

    public void setM(float[][]x){
        m = x;
    }
}
