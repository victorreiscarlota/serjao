public class Main {

    public static void main(String[] args) {
        // Replace "data.csv" with the actual path to your CSV file
        Dataset dataset = new Dataset("data.csv");
        dataset.loadDataFromCSV();

        // Set the number of neighbors (k)
        int k = 3;

        Knn knn = new Knn(dataset, k);

        // Sample data point (replace with actual values)
        DataPoint newPoint = new DataPoint(7, 2000);

        String happiness = knn.classify(newPoint);
        System.out.println("Predicted Happiness: " + happiness);
    }
}