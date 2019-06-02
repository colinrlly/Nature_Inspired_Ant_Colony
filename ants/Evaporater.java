package ants;

public class Evaporater implements Evaporator {


    @Override
    public void evaporate(Problem problem, PheromoneMatrix pheramone_matrix) {
        float[][] pheramones = pheramone_matrix.getM();
        for (int x = 0; x < pheramones.length; x++)
            for (int y = 0; y < pheramones[0].length; y++){
                pheramones[x][y] *= problem.getEvaporation_param();
            }
        pheramone_matrix.setM(pheramones);
    }
}
