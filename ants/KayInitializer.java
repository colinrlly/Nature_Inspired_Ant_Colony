package ants;

public class KayInitializer implements Initializer {

  public void initializePopulation(Problem problem, PheromoneMatrix pheromone_matrix, float starting_value) {
    for (int i = 0; i < problem.get_num_cities(); ++i) {
      for (int j = 0; j < problem.get_num_cities(); ++j) {
        if (i != j) { 
          pheromone_matrix.setVal(i, j, starting_value); 
        }
      }
    }
  }
}
