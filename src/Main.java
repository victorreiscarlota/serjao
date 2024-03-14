
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {

        Dataset dataset = new Dataset(null);
        dataset.loadDataFromCSV("C:\\Users\\bolad\\meuJeitoNinja\\lab-modular\\projetoTest\\src\\feliz.csv");

        List<Double> hoursOfSleep = new ArrayList<>();
        List<Double> calories = new ArrayList<>();
     

        for (String[] dataPoint : dataset.getDataPoints()) {
     
            if (isNumeric(dataPoint[0]) && isNumeric(dataPoint[1])) {
                double calorie = Double.parseDouble(dataPoint[0].replace(",", ".")); 
                double hourOfSleep = Double.parseDouble(dataPoint[1].replace(",", ".")); 
                calories.add(calorie);
                hoursOfSleep.add(hourOfSleep);
            }
        }

        int k = 3; 
        Knn knn = new Knn(hoursOfSleep, calories, k);

       
        double newHoursOfSleep = 7.5; 
        double newCalories = 2000;
        String happiness = knn.classify(newHoursOfSleep, newCalories);
        System.out.println("O estado de felicidade para as horas de sono " + newHoursOfSleep +
                " e calorias " + newCalories + " é: " + happiness);
    }
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
