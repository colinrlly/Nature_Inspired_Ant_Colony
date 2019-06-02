package ants;

import java.util.ArrayList;
import java.util.Random;

public class Generator implements SolutionGenerator{

    @Override
    public int[][] generateSolutions(Problem problem, PheromoneMatrix pheromone_matrix){
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        Random r = new Random();


        for (int ant = 0; ant < problem.getNum_ants(); ++ant) {
            ArrayList<Integer> solution = new ArrayList<>();
            ArrayList<Integer> cities = new ArrayList<>();
            for (int i = 1; i < problem.get_num_cities(); ++i) {
                cities.add(i);
            }
            solution.add(0);

            float[][] pheromones = pheromone_matrix.getM();
            int previous = 0;
            while(cities.size()>0){
                float probabilities[] = new float[cities.size()];
                float totalPher = 0f;
                int p = previous;
                for (int c: cities){
                    totalPher += pheromones[previous][c];
                }

                float prob = 0;
                for (int destination = 0; destination < cities.size(); ++destination) {
                    if (destination == 0) {
                        probabilities[destination] = pheromones[previous][cities.get(destination)] / totalPher;
                        prob += probabilities[destination];
                    } else {
                        probabilities[destination] = probabilities[destination - 1] + pheromones[previous][cities.get(destination)] / totalPher;
                        prob += probabilities[destination];
                    }
                }

                //System.out.println(prob);
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
            }
        }

        return solutions2;
    }

}
