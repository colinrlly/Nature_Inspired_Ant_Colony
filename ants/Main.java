package ants;

public class Main {
    private static int num_ants = 10;
    private static int num_cities = 10;
    private static float evaporation_param = .1f;
    private static float intesification_param = .1f;
    private static int pheromone_weight = 2;
    private static int heuristic_weight = 2;
    private static int greedy_param = 2;
    private static int starting_value = 1;
    private static int cycles = 100;
    private static int[][] distance_matrix = new int[num_cities][num_cities];

    public static void main(String[] args) {
        Problem problem = new Problem(
            num_ants,
            num_cities,
            evaporation_param,
            intesification_param,
            pheromone_weight,
            heuristic_weight,
            greedy_param,
                distance_matrix);

        PheromoneMatrix pheromones = new PheromoneMatrix(problem);

        System.out.println(pheromones);
    }
}
