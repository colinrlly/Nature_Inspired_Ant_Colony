package ants;

public interface Initializer {

    public void initializePopulation(Problem problem, PheromoneMatrix pheromone_matrix, float starting_value);
}