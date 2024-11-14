import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataRecordTest {


    private static final Gson gson = new Gson();

    @Test
    public void testReadDataRecordsFromJson() {
        // Load JSON file from resources
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("");
        assertNotNull(inputStream, "JSON file not found in resources directory");

        // Define the Type for List<Map<String, String>>
        Type listType = new TypeToken<List<Map<String, String>>>() {}.getType();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            // Parse JSON data into a list of maps
            List<Map<String, String>> dataList = gson.fromJson(reader, listType);
            
            for (Map<String, String> data : dataList) {
                // Create DataRecord object for each entry
                String url = data.get("url");
                String html = data.get("html");
                auto_am_DataRecord record = new auto_am_DataRecord(url, html);

                // Assert that the DataRecord object was created
                assertNotNull(record, "Failed to create DataRecord object");

                // Print the DataRecord object
                System.out.println(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Error reading or parsing JSON file: " + e.getMessage();
        }
    }
}
