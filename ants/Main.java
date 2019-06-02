package ants;

public class Main {
    private static int num_ants = 100;
    private static int num_cities = 150;
    private static double pheromone_weight = 0.5;
    private static double heuristic_weight = 1;
    private static int greedy_param = 2;
    private static float evaporation_param = .9f;
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


        //for average to get rid of probabilistic chance in analysis
        int numRuns = 10;

        /*
        int t = 0;
        for (int [] x: problem.getDistance_matrix()){
            for (int y: x){
                t += y;
                System.out.println(y);
            }
        }

        System.out.println(t/(149.0));
        */


        long start = System.nanoTime();
        runIteration(problem,numRuns);
        System.out.println((System.nanoTime()-start)/1000000000.0);


    }

    public static void runIteration(Problem problem, int numRuns){
        int [] distances = new int [numRuns];

        for(;numRuns > 0; numRuns--) {
            PheromoneMatrix pheromones = new PheromoneMatrix(problem);
            Initializer initializer = new Initializor();
            SolutionGenerator solutionGenerator = new Generator();
            Evaporator evaporator = new Evaporater();
            Intensifier intensifier = new Intensifior();

            int terminationCount = 35;
            boolean termination = false;
            int count = 0;
            int bestDistance = 0;
            int previousDistance = 0;
            initializer.initializePopulation(problem, pheromones, 1f);
            do {
                int[][] solutions = solutionGenerator.generateSolutions(problem, pheromones);
                evaporator.evaporate(problem, pheromones);
                bestDistance = intensifier.Intensify(problem, solutions, pheromones);
                //System.out.println(bestDistance);

                /*
                //termination condition checking
                if (previousDistance > bestSolution) {
                    count++;
                    if (count == terminationCount)
                        termination = true;
                }
                else{
                    previousDistance = bestSolution;
                }
                */
                terminationCount--;
                if (terminationCount == 0)
                    termination = true;
            } while (!termination);

            distances[numRuns-1] = bestDistance;
            System.out.println(bestDistance);
            //printPheremones(pheromones);
        }
        //display info
        int total = 0;
        for (int x: distances)
            total += x;
        System.out.println(total/distances.length);


    }

    public static void printPheremones(PheromoneMatrix ph){
        float[][]p = ph.getM();
        for (int x = 0; x < p.length; x++){
            for (int y = 0; y < p[0].length; y++){
                System.out.print(p[x][y] + ", ");
                //if(p[x][y] > 0.25)
                    //System.out.println("Higher  x:" + x + ",y: " + y + ",   value:" + p[x][y]);
            }
            //System.out.println();
        }
    }
}