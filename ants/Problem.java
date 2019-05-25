package ants;

public class Problem {
    private int num_ants;
    private int num_cities;
    private float evaporation_param;
    private float intesification_param;
    private int pheromone_weight;
    private int heuristic_weight;
    private int greedy_param;

    public Problem(
        int num_ants,
        int num_cities,
        float evaporation_param,
        float intesification_param,
        int pheromone_weight,
        int heuristic_weight,
        int greedy_param) {

            this.num_ants = num_ants;
            this.num_cities = num_cities;
            this.evaporation_param = evaporation_param;
            this.intesification_param = intesification_param;
            this.pheromone_weight = pheromone_weight;
            this.heuristic_weight = heuristic_weight;
            this.greedy_param = greedy_param;
        }

    /****** ACCESSORS ******/
    public int get_num_cities() {
        return this.num_cities;
    }

    /******* TO STRING *******/
    public String toString() {
        String s = "";

        s += "Problem:\n";
        s += this.num_ants + " - num_ants\n";
        s += this.num_cities + " - num_cities\n";
        s += this.evaporation_param + " - evaporation_param\n";
        s += this.intesification_param + " - intesification_param\n";
        s += this.pheromone_weight + " - pheromone_weight\n";
        s += this.heuristic_weight + " - heuristic_weight\n";
        s += this.greedy_param + " - greedy_param\n";

        return s;
    }
}
