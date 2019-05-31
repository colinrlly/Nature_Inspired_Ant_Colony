package ants;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class KaySolutionGenerator implements SolutionGenerator {

  public int[][] generateSolutions(Problem problem, PheromoneMatrix pheromone_matrix) {
    int num_ants = problem.get_num_ants();
    int num_cities = problem.get_num_cities();
    int[][] solutions = int[num_ants][num_cities];

    for (int ant = 0; ant < numAnts; ++ant) {
      int[] solution = int[num_cities];
      ArrayList<Integer> cities = new ArrayList<>();
      for (int i = 0; i < num_cities; ++i) {
        cities.add(i);
      }

      int city = 0;
      while (cities.size() > 1) {
        cities.remove(city);
        float probabilities[] = new float[cities.size()];
        for (int destination = 0; destination < cities.size(); ++destination) {
          if (destination == 0) {
            probabilities[destination] = Math.pow(pheromones[city][cities.get(destination)], problem.get_pheromone_weight()) / (cities.size() * Math.pow(problem.get_distance(cities.get(destination), city), problem.get_heuristic_weight()));
          } else {
            probabilities[destination] = probabilities[destination - 1] + Math.pow(pheromones[city][cities.get(destination)], problem.get_pheromone_weight()) / (cities.size() * Math.pow(problem.get_distance(cities.get(destination), city), problem.get_heuristic_weight()));
          }
          float selection = r.nextFloat();
          for (int i = 0; i < probabilities.length; ++i) {
            if (selection <= probabilities[i]) {
              solution[] = cities.get(i);
              city = cities.get(i);
              break;
            }
          }
        }
      }
      solutions[ant] = solution;
    }
  }
}
