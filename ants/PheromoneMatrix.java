package ants;

import java.util.Arrays;

public class PheromoneMatrix
{
    public int[][] m;

    public PheromoneMatrix(Problem problem)
    {
        int num_cities = problem.get_num_cities();
        this.m = new int[num_cities][num_cities];
    }

    /****** TO STRING ******/
    public String toString()
    {
        String s = "";

        for (int i = 0; i < this.m.length; i++)
        {
            s += Arrays.toString(m[i]) + "\n";
        }

        return s;
    }
}
