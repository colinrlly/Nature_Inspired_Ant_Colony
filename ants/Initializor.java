package ants;

public class Initializor implements Initializer{

    @Override
    public void initializePopulation(Problem problem, PheromoneMatrix pheromone_matrix, float starting_value) {
        float pheremones[][] = pheromone_matrix.getM();
        for (int x = 0; x < pheremones.length; x++)
            for (int y = 0; y < pheremones[0].length; y++)
                pheremones[x][y] = starting_value;
        pheromone_matrix.setM(pheremones);
    }
}
