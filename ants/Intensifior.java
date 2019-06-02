package ants;

public class Intensifior implements Intensifier{
    @Override
    public int Intensify(Problem problem, int[][] solutions, PheromoneMatrix pheromone_matrix) {
        float intensificationConstant = problem.getIntesification_param();

        //find best solution
        int bestDistance = getDistance(solutions[0], problem.getDistance_matrix());
        int[] bestSolution = solutions[0];

        for (int x = 1; x < solutions.length; x++){
            int d = getDistance(solutions[x], problem.getDistance_matrix());
            if(d < bestDistance){
                bestDistance = d;
                bestSolution = solutions[x];
            }
        }

        float[][] pheromones = pheromone_matrix.getM();
        int start = 0;
        for (int city : bestSolution) {
            pheromones[start][city] += intensificationConstant;
            pheromones[city][start] += intensificationConstant;
            start = city;
        }
        pheromone_matrix.setM(pheromones);

        return bestDistance;
    }


    private int getDistance(int[] solution, int[][] distances) {
        int distance = 0;
        int start = 0;
        for (int city : solution) {
            distance += distances[start][city];
            //System.out.println(distance);
            start = city;
        }
        return distance;
    }
}
