package ants;

public class Main {
    private static int num_ants = 10;
    private static int num_cities = 150;
    private static int pheromone_weight = 2;
    private static int heuristic_weight = 2;
    private static int greedy_param = 2;
    private static float evaporation_param = .1f;
    private static float intesification_param = .1f;
    private static String data_path = "data/01manhattan.tsp";

    public static void main(String[] args) {
        Problem problem = new Problem(
            num_ants,
            num_cities,
            pheromone_weight,
            heuristic_weight,
            greedy_param,
            evaporation_param,
            intesification_param,
            data_path);

        // PheromoneMatrix pheromones = new PheromoneMatrix(problem);
        // Initializer initializer = new Initializer(problem, pheromones);
        // SolutionGenerator solutionGenerator = new SolutionGenerator(problem, pheromones);
        // Evaporator evaporator = new Evaporator(problem, pheromones);
        // Intensifier intensifier = new Intensifier(problem, pheromones);
    }
}