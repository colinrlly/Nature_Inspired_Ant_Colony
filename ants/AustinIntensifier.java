package ants;

public class AustinIntensifier implements Intensifier
{
    @Override
    public void Intensify(Problem p, int[][] solutions, PheromoneMatrix pheromone_matrix)
    {
        int num_cities = p.get_num_cities();
        int num_ants = p.getNum_ants();
        int[][] distance_matrix = p.getDistance_matrix();
        float intensification_param = p.getIntensification_param();
        int[] solution_cost = new int[num_ants];

        //find the costs of the solution
        for(int i = 0; i < num_ants; i++)
        {
            for(int j = 1; j < num_cities; j++)
            {
                int last_city = solutions[i][j - 1];
                int cur_city = solutions[i][j];
                solution_cost[i] += distance_matrix[last_city][cur_city];
            }
        }

        //find the best solution
        int best = 0;
        for(int i = 0; i < num_ants; i++)
        {
            if (solution_cost[i] < solution_cost[best])
            {
                best = i;
            }
        }

        //intensify the best solution
        for(int i = 1; i < num_cities; i++)
        {
            pheromone_matrix.m[solutions[best][i - 1]][solutions[best][i]] += intensification_param;
        }
    }
}
