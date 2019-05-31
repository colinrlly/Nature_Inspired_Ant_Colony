package ants;

public interface SolutionGenerator {

    public boolean generateSolution(Problem problem, PheromoneMatrix pheromones);
}
