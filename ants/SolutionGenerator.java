package ants;

public interface SolutionGenerator {

    public int[][] generateSolutions(Problem p, PheromoneMatrix matrix);
}
