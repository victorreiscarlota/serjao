

public class knn {

    private Dataset dataset;
    private int k;

    public knn(Dataset dataset, int k) {
        this.dataset = dataset;
        this.k = k;
    }

    public String classify(DataPoint newPoint) {
        List<DataPoint> neighbors = getNearestNeighbors(newPoint);
        int happyCount = 0;
        int unhappyCount = 0;

        for (DataPoint neighbor : neighbors) {
            if (neighbor.getState().equals("Feliz")) {
                happyCount++;
            } else {
                unhappyCount++;
            }
        }

        return happyCount > unhappyCount ? "Feliz" : "Infeliz";
    }

    private List<DataPoint> getNearestNeighbors(DataPoint newPoint) {
        List<DataPoint> neighbors = new ArrayList<>();

        for (DataPoint dataPoint : dataset.getDataPoints()) {
            double distance = calculateDistance(newPoint, dataPoint);
            neighbors.add(new Neighbor(dataPoint, distance));
        }

        // Sort neighbors by distance in ascending order
        Collections.sort(neighbors, (a, b) -> Double.compare(a.getDistance(), b.getDistance()));

        // Select the k closest neighbors
        return neighbors.subList(0, k);
    }

    private double calculateDistance(DataPoint p1, DataPoint p2) {
        double distance = 0.0;
        distance += Math.abs(p1.getHoursOfSleep() - p2.getHoursOfSleep()) / 10.0;
        distance += Math.abs(p1.getCalories() - p2.getCalories()) / 3000.0;
        return distance;
    }

    private class Neighbor {
        private DataPoint dataPoint;
        private double distance;

        public Neighbor(DataPoint dataPoint, double distance) {
            this.dataPoint = dataPoint;
            this.distance = distance;
        }

        public DataPoint getDataPoint() {
            return dataPoint;
        }

        public double getDistance() {
            return distance;
        }
    }
}