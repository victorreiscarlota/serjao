import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        
        Dataset dataset = new Dataset("feliz.csv");
        dataset.loadDataFromCSV("feliz.csv");

       
        int k = 3;

        Knn knn = new Knn(dataset, k);

        
        DataPoint newPoint = new DataPoint(7, 2000);

        String happiness = knn.classify(newPoint);
        System.out.println("Predicted Happiness: " + happiness);
    }
}
