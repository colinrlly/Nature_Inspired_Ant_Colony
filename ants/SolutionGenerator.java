package ants;

public interface SolutionGenerator {

    public int[][] generateSolutions(Problem problem, PheromoneMatrix pheromone_matrix);
}
