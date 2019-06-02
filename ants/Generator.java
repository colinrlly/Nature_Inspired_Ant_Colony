package ants;

import java.util.ArrayList;
import java.util.Random;

public class Generator implements SolutionGenerator{

    @Override
    public int[][] generateSolutions(Problem problem, PheromoneMatrix pheromone_matrix){
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();



        for (int ant = 0; ant < problem.getNum_ants(); ++ant) {
            Random r = new Random();
            ArrayList<Integer> solution = new ArrayList<>();
            ArrayList<Integer> cities = new ArrayList<>();
            for (int i = 1; i < problem.get_num_cities(); ++i) {
                cities.add(i);
            }
            solution.add(0);

            float[][] pheromones = pheromone_matrix.getM();
            int[][] distances = problem.getDistance_matrix();
            int previous = 0;
            while(cities.size()>0){
                double probabilities[] = new double[cities.size()];
                float totalPher = 0f;
                int p = previous;
                /*
                for (int c: cities){
                    totalPher += Math.pow(pheromones[previous][c], problem.getPheromone_weight()) / Math.pow(distances[previous][c], problem.getHeuristic_weight());
                }
                */

                float prob = 0;
                for (int destination = 0; destination < cities.size(); ++destination) {
                    double numerator = Math.pow(pheromones[previous][cities.get(destination)], problem.getPheromone_weight());
                    double denom = Math.pow(distances[previous][cities.get(destination)], problem.getHeuristic_weight());
                    probabilities[destination] = numerator/denom;
                    totalPher += probabilities[destination];
                    /*
                    if (destination == 0) {
                        probabilities[destination] = Math.pow(pheromones[previous][cities.get(destination)], problem.getPheromone_weight()) /
                         (totalPher * Math.pow(distances[previous][cities.get(destination)], problem.getHeuristic_weight()));
                    } else {
                        probabilities[destination] = probabilities[destination - 1] + (Math.pow(pheromones[previous][cities.get(destination)], problem.getPheromone_weight()) /
                         (totalPher * Math.pow(distances[previous][cities.get(destination)], problem.getHeuristic_weight())));
                    }*/
                }
                probabilities[0] /= totalPher;
                for (int x = 1; x < probabilities.length; x++){
                    probabilities[x] /= totalPher;
                    probabilities[x] += probabilities[x-1];
                }
                //System.out.println(probabilities[probabilities.length-1]);

                float selection = r.nextFloat();
                for (int i = 0; i < probabilities.length; ++i) {
                    if (selection <= probabilities[i]) {
                        solution.add(cities.get(i));
                        previous = cities.get(i);
                        cities.remove(i);
                        break;
                    }

                }
            }
            solutions.add(solution);
        }


        int[][] solutions2 = new int[solutions.size()][solutions.get(0).size()];
        for(int x = 0; x < solutions.size(); x++){
            for (int y = 0; y < solutions.get(x).size(); y++){
                int z = solutions.get(x).get(y);
                solutions2[x][y] = z;
                //System.out.print(solutions2[x][y] + ", ");
            }
            //System.out.println();
        }

        return solutions2;
    }

}
