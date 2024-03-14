import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knn {

    private List<Double> hoursOfSleep;
    private List<Double> calories;
    private int k;

    public Knn(List<Double> hoursOfSleep, List<Double> calories, int k) {
        this.hoursOfSleep = hoursOfSleep;
        this.calories = calories;
        this.k = k;
    }

    public String classify(double newHoursOfSleep, double newCalories) {
        List<Neighbor> neighbors = getNearestNeighbors(newHoursOfSleep, newCalories);
        int happyCount = 0;
        int unhappyCount = 0;

        for (Neighbor neighbor : neighbors) {
            
            if (neighbor.getState().equals("Feliz")) {
                happyCount++;
            } else {
                unhappyCount++;
            }
        }

        return happyCount > unhappyCount ? "Feliz" : "Infeliz";
    }

    private List<Neighbor> getNearestNeighbors(double newHoursOfSleep, double newCalories) {
        List<Neighbor> neighbors = new ArrayList<>();

        for (int i = 0; i < hoursOfSleep.size(); i++) {
            double distance = calculateDistance(newHoursOfSleep, newCalories, hoursOfSleep.get(i), calories.get(i));
            neighbors.add(new Neighbor(distance));
        }

       
        Collections.sort(neighbors, (a, b) -> Double.compare(a.getDistance(), b.getDistance()));

        
        return neighbors.subList(0, k);
    }

    private double calculateDistance(double x1, double y1, double x2, double y2) {
        double distance = 0.0;
        distance += Math.abs(x1 - x2) / 10.0;
        distance += Math.abs(y1 - y2) / 3000.0;
        return distance;
    }

    private class Neighbor {
        private double distance;

        public Neighbor(double distance) {
            this.distance = distance;
        }

        public double getDistance() {
            return distance;
        }

        private String getState() {
            if (distance < 0.5) {
                return "Feliz";
            } else {
                return "Infeliz";
            }
        }
    }
}
