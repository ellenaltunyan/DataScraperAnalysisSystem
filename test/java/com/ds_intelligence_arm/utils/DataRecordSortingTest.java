import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

public class DataRecordSortingTest {

    private static final Gson gson = new Gson();

    @Test
    public void testSortDataRecordsByPrice() {
        // Load JSON file from resources
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("scraped_data.json");
        assert inputStream != null : "JSON file not found in resources directory";

        // Define the Type for List<DataRecord>
        Type listType = new TypeToken<List<DataRecord>>() {}.getType();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            // Parse JSON data into a list of DataRecord objects
            List<DataRecord> dataRecords = gson.fromJson(reader, listType);

            // Sort the list based on price_in_AMD using bubble sort
            System.out.println("Bubble Sort:");
            SortingAlgorithms.bubbleSort(dataRecords, Comparator.comparingInt(DataRecord::getPrice_in_AMD));
            dataRecords.forEach(System.out::println);

            // Sort the list based on price_in_AMD using insertion sort
            System.out.println("Insertion Sort:");
            SortingAlgorithms.insertionSort(dataRecords, Comparator.comparingInt(DataRecord::getPrice_in_AMD));
            dataRecords.forEach(System.out::println);

            // Sort the list based on price_in_AMD using selection sort
            System.out.println("Selection Sort:");
            SortingAlgorithms.selectionSort(dataRecords, Comparator.comparingInt(DataRecord::getPrice_in_AMD));
            dataRecords.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Error reading or sorting data: " + e.getMessage();
        }
    }
}
