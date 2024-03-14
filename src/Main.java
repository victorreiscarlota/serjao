import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Carregar dados do arquivo CSV
        System.out.println("2323");
        Dataset dataset = new Dataset("C:\\Users\\bolad\\meuJeitoNinja\\lab-modular\\projetoTest\\src\\feliz.csv");
        System.out.println("assas" + dataset);
        dataset.loadDataFromCSV("C:\\Users\\bolad\\meuJeitoNinja\\lab-modular\\projetoTest\\src\\feliz.csv");

        // Extrair horas de sono e calorias dos dados carregados
        List<Double> hoursOfSleep = new ArrayList<>();
        List<Double> calories = new ArrayList<>();
        System.out.println("ksks" + dataset.getDataPoints());
        for (String[] dataPoint : dataset.getDataPoints()) {
            System.out.println("22ks" + dataPoint[0]);
            double hourOfSleep = Double.parseDouble(dataPoint[0]);
            // Índice da coluna de horas de sono no CSV
            double calorie = Double.parseDouble(dataPoint[0]); // Índice da coluna de calorias no CSV
            hoursOfSleep.add(hourOfSleep);
            calories.add(calorie);
        }

        // Criar instância do algoritmo KNN
        int k = 3; // Valor de K
        Knn knn = new Knn(hoursOfSleep, calories, k);

        // Exemplo de classificação de um novo ponto
        double newHoursOfSleep = 7.5; // Horas de sono do novo ponto
        double newCalories = 2000; // Calorias do novo ponto
        String happiness = knn.classify(newHoursOfSleep, newCalories);
        System.out.println("O estado de felicidade para as horas de sono " + newHoursOfSleep +
                " e calorias " + newCalories + " é: " + happiness);
    }
}
