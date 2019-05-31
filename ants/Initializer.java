package ants;

public interface Initializer {

    public void initializePopulation(Problem problem, PheromoneMatrix pheromone_matrix, int starting_value);
}