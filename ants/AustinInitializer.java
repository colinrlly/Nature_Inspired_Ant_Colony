package ants;

public class AustinInitializer implements Initializer
{
    @Override
    public void initializePopulation(Problem p, PheromoneMatrix matrix, int starting_value)
    {
        int num_cities = p.get_num_cities();
        for(int i = 0; i < num_cities; i++)
        {
            for(int j = 0; j < num_cities; j++)
            {
                matrix.m[i][j] = starting_value;
            }
        }
    }
}
