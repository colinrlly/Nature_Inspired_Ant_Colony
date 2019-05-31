package ants;

public class Problem {
    private int num_ants;
    private int num_cities;
    private float evaporation_param;
    private float intensification_param;
    private int pheromone_weight;
    private int heuristic_weight;
    private int greedy_param;
    private int[][] distance_matrix;

    public Problem(
        int num_ants,
        int num_cities,
        float evaporation_param,
        float intensification_param,
        int pheromone_weight,
        int heuristic_weight,
        int greedy_param,
        int[][] distance_matrix) {

            this.num_ants = num_ants;
            this.num_cities = num_cities;
            this.evaporation_param = evaporation_param;
            this.intensification_param = intensification_param;
            this.pheromone_weight = pheromone_weight;
            this.heuristic_weight = heuristic_weight;
            this.greedy_param = greedy_param;
            this.distance_matrix = distance_matrix;
        }

    /****** ACCESSORS ******/
    public int get_num_cities() {
        return this.num_cities;
    }

    public int getNum_ants()
    {
        return this.num_ants;
    }

    public float getEvaporation_param()
    {
        return this.evaporation_param;
    }

    public float getIntensification_param()
    {
        return this.intensification_param;
    }

    public int[][] getDistance_matrix()
    {
        return this.distance_matrix;
    }

    /******* TO STRING *******/
    public String toString() {
        String s = "";

        s += "Problem:\n";
        s += this.num_ants + " - num_ants\n";
        s += this.num_cities + " - num_cities\n";
        s += this.evaporation_param + " - evaporation_param\n";
        s += this.intensification_param + " - intensification_param\n";
        s += this.pheromone_weight + " - pheromone_weight\n";
        s += this.heuristic_weight + " - heuristic_weight\n";
        s += this.greedy_param + " - greedy_param\n";

        return s;
    }
}
