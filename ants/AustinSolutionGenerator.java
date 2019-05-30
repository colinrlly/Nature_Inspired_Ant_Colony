package ants;

import java.util.ArrayList;
import java.util.Random;

public class AustinSolutionGenerator implements SolutionGenerator
{
    @Override
    public int[][] generateSolutions(Problem p, PheromoneMatrix matrix)
    {
        Random r = new Random();

        int num_ants = p.getNum_ants();
        int num_cities = p.get_num_cities();
        int[][] out = new int[num_ants][num_cities];

        //each ant goes through the path
        for(int i = 0; i < num_ants; i++)
        {
            //start each path at position 0
            int current_city = 0;
            ArrayList<Integer> current_solution = new ArrayList<>();

            //the ant goes through each city
            for(int j = 0; j < num_cities; j++)
            {
                //sum the fitnesses from the current city to those not in the solution
                float city_total_fitness = sumNew(matrix.m[current_city], current_solution);

                //pick a random number between 0 and sum of fitnesses
                float choice = r.nextFloat();
                choice *= city_total_fitness;

                //find which city it goes to
                int chosen = 0;
                float cur_fitness = 0;
                for(int k = 0; k < num_cities; k++)
                {
                    //if city isn't in solution, increment
                    if(isNew(matrix.m[current_city][k], current_solution))
                    {
                        cur_fitness += matrix.m[current_city][k];

                        //if on the city selected, select it
                        if(cur_fitness >= choice)
                        {
                            chosen = k;
                            break;
                        }
                    }
                }

                //add that city to the solution
                current_solution.add(chosen);
            }

            //add the solution to the output
            for(int j = 0; j < num_cities; j++)
            {
                out[i][j] = current_solution.get(j);
            }
        }

        return out;
    }

    private boolean isNew(int cur_city, ArrayList<Integer> current_solution)
    {
        boolean out = false;
        int j = 0;
        for(; j < current_solution.size(); j++)
        {
            if(cur_city == current_solution.get(j))
            {
                break;
            }
        }
        //made it through without breaking, therefore not in solution
        if(j == current_solution.size())
        {
            out = true;
        }
        return out;
    }

    private float sumNew(int[] possible, ArrayList<Integer> current_solution)
    {
        float out = 0;
        for(int i = 0; i < possible.length; i++)
        {
            if(isNew(possible[i], current_solution))
            {
                out += possible[i];
            }
        }
        return out;
    }
}
