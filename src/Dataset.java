import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;




public class Dataset {
    private List<String[]> dataPoints;
    private int length;

    public List<String[]> getDataPoints() {
        return dataPoints;
    }

    public int getLength() {
        return length;
    }

    public Dataset(String string) {
        dataPoints = new ArrayList<>();
        length = 0;
    }

    public void loadDataFromCSV(String filename) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filename));
            List<String[]> dataList = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                dataList.add(values);
            }
            dataPoints = dataList;
            length = dataPoints.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}