package ants;

public class Main {
    private static int num_ants = 200;
    private static int num_cities = 150;
    private static double pheromone_weight = 1;
    private static double heuristic_weight = 0;
    private static double greedy_param = 0f;
    private static float evaporation_param = .93f;
    private static float intesification_param = .005f;
    private static String data_path = "data/03maximum.tsp";


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

        /*
        //find best
        for (int x = 0; x < 4; x++) {
            runIteration(problem, numRuns);
        }
        */

        //long start = System.nanoTime();
        //problem.setHeuristic_weight(4);
        //

        for (int x = 0; x < 9   ; x++) {
            problem.setIntesification_param(0.05f);
            for (int y = 0; y < 8; y++) {
                runIteration(problem, numRuns);
                problem.setIntesification_param(problem.getIntesification_param() + 0.025f);
            }
            problem.setEvaporation_param(problem.getEvaporation_param()+0.012f);
            //if (problem.getHeuristic_weight() < 2.1)
            //problem.setGreedy_param(problem.getGreedy_param()+0.1f);
           // else
             //   problem.setHeuristic_weight(problem.getHeuristic_weight()+1f);
            /*
            switch(x){
                case 0:
                    problem.setHeuristic_weight(20);
                    break;
                case 1:
                    problem.setHeuristic_weight(1);
                    break;
                case 2:
                    problem.setHeuristic_weight(2);
                    break;
                case 3:
                    problem.setHeuristic_weight(4);
                    break;
            }
            */


        }

        //
        //problem.setIntesification_param(0.05f);
        //runIteration(problem,numRuns);

        //runIteration(problem, numRuns);
        //System.out.println((System.nanoTime()-start)/1000000000.0);


    }

    public static void runIteration(Problem problem, int numRuns){
        int [] distances = new int [numRuns];

        long start;
        for(;numRuns > 0; numRuns--) {
            start = System.nanoTime();
            PheromoneMatrix pheromones = new PheromoneMatrix(problem);
            Initializer initializer = new Initializor();
            SolutionGenerator solutionGenerator = new Generator();
            Evaporator evaporator = new Evaporater();
            Intensifier intensifier = new Intensifior();

            int terminationCount = 45;
            boolean termination = false;
            int count = 0;
            int bestDistance = 0;
            int maxCount = 75;
            int previousDistance = 0;
            initializer.initializePopulation(problem, pheromones, 1f);
            do {
                int[][] solutions = solutionGenerator.generateSolutions(problem, pheromones);
                evaporator.evaporate(problem, pheromones);
                bestDistance = intensifier.Intensify(problem, solutions, pheromones);
                //System.out.println(bestDistance);


                //termination condition checking
                if (previousDistance > bestDistance) {
                    count++;
                    if (count == maxCount)
                        termination = true;
                }
                else{
                    previousDistance = bestDistance;
                }
                /*
                terminationCount--;
                if (terminationCount == 0)
                    termination = true;
                    */
            } while (!termination);


            //System.out.println((System.nanoTime()-start)/1000000000.0);
            distances[numRuns-1] = bestDistance;
            System.out.println(bestDistance);
            //printPheremones(pheromones);
        }
        //display info
        int total = 0;
        for (int x: distances)
            total += x;
        System.out.println(total/distances.length);
        System.out.println("\n\n\n");


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