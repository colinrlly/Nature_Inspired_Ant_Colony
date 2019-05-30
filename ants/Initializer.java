package ants;

public interface Initializer {

    public void initializePopulation(Problem p, PheromoneMatrix matrix, int starting_value);
}