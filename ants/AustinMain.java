package ants;

import java.util.Arrays;

public class AustinMain
{
    //all parameters for the problem are stored here
    private static int num_ants = 10;
    private static int num_cities = 10;
    private static float evaporation_param = .1f;
    private static float intensification_param = .1f;
    private static int pheromone_weight = 2;
    private static int heuristic_weight = 2;
    private static int greedy_param = 2;
    private static int starting_value = 1;
    private static int cycles = 100;
    private static int[][] distance_matrix = new int[num_cities][num_cities];

    public static void main(String[] args)
    {
        //create the problem
        Problem problem = new Problem(
                num_ants,
                num_cities,
                evaporation_param,
                intensification_param,
                pheromone_weight,
                heuristic_weight,
                greedy_param,
                distance_matrix);

        PheromoneMatrix pheromones = new PheromoneMatrix(problem);

        //initialize the values
        AustinInitializer Init = new AustinInitializer();
        Init.initializePopulation(problem, pheromones, starting_value);

        //create the instances for the main loop
        AustinSolutionGenerator gen = new AustinSolutionGenerator();
        AustinEvaporator evap = new AustinEvaporator();
        AustinIntensifier inten = new AustinIntensifier();
        int[][] cur_solutions;

        //main loop
        for(int i = 0; i < cycles; i++)
        {
            cur_solutions = gen.generateSolutions(problem, pheromones);
            evap.evaporate(problem, pheromones);
            inten.Intensify(problem, cur_solutions, pheromones);
        }

        //print out the final pheromone matrix
        String s = "";
        for (int i = 0; i < pheromones.m.length; i++)
        {
            s += Arrays.toString(pheromones.m[i]) + "\n";
        }
        System.out.println(s);
    }
}
