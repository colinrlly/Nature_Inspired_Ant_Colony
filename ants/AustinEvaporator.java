package ants;

public class AustinEvaporator implements Evaporator
{
    @Override
    public void evaporate(Problem p, PheromoneMatrix pheromone_matrix)
    {
        int num_cities = p.get_num_cities();
        float evaporator_param = 1 - p.getEvaporation_param();

        for(int i = 0; i < num_cities; i++)
        {
            for (int j = 0; j < num_cities; j++)
            {
                pheromone_matrix.m[i][j] *= evaporator_param;
            }
        }
    }
}
