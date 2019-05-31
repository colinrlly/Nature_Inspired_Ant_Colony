package ants;

public class DistanceMatrix {
    private int num_cities;
    private String data_path;

    public DistanceMatrix(Problem problem) {
        this.num_cities = problem.get_num_cities();

        System.out.println(this.num_cities);
    }
}
