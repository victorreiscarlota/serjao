import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testIsNumeric() {
        // Teste quando a string é numérica
        String numericString = "123.45";
        boolean resultNumeric = Main.isNumeric(numericString);
        assertEquals(true, resultNumeric);

        // Teste quando a string não é numérica
        String nonNumericString = "abc";
        boolean resultNonNumeric = Main.isNumeric(nonNumericString);
        assertEquals(false, resultNonNumeric);
    }

    @Test
    public void testClassification() {
        // Criar um conjunto de dados fictício
        String[][] testData = {
                {"2700", "2.5", "Infeliz"},
                {"2000", "1.5", "Infeliz"},
                {"2500", "5.5", "Feliz"},
                {"2600", "6.3", "Feliz"},
                {"500", "2", "Infeliz"},
                {"300", "6.5", "Infeliz"},
                {"1000", "8", "Feliz"},
                {"1600", "8.7", "Feliz"},
                {"1800", "4.6", "Infeliz"},
                {"700", "10", "Feliz"}
        };

        Dataset dataset = new Dataset(null);
        dataset.setDataPoints(testData);

        List<Double> hoursOfSleep = new ArrayList<>();
        List<Double> calories = new ArrayList<>();

        for (String[] dataPoint : dataset.getDataPoints()) {
            if (Main.isNumeric(dataPoint[0]) && Main.isNumeric(dataPoint[1])) {
                double calorie = Double.parseDouble(dataPoint[0].replace(",", "."));
                double hourOfSleep = Double.parseDouble(dataPoint[1].replace(",", "."));
                calories.add(calorie);
                hoursOfSleep.add(hourOfSleep);
            }
        }

        int k = 3;
        Knn knn = new Knn(hoursOfSleep, calories, k);

        // Teste de classificação
        double newHoursOfSleep = 7.5;
        double newCalories = 2000;
        String happiness = knn.classify(newHoursOfSleep, newCalories);
        assertEquals("Feliz", happiness);
    }
}
