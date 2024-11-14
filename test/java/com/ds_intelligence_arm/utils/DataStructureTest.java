import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class DataStructureTest {

    private static final Gson gson = new Gson();

    @Test
    public void testDataStructures() {
        // Load JSON file from resources
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("scraped_data.json");
        assert inputStream != null : "JSON file not found in resources directory";

        // Define the Type for List<DataRecord>
        Type listType = new TypeToken<List<DataRecord>>() {}.getType();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            // Parse JSON data into a list of DataRecord objects
            List<DataRecord> dataRecords = gson.fromJson(reader, listType);

            // Test with CustomQueue
            CustomQueue<DataRecord> queue = new CustomQueue<>();
            for (DataRecord record : dataRecords) {
                queue.enqueue(record);
            }
            System.out.println("Queue contents:");
            while (!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }

            // Test with CustomStack
            CustomStack<DataRecord> stack = new CustomStack<>();
            for (DataRecord record : dataRecords) {
                stack.push(record);
            }
            System.out.println("Stack contents:");
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }

            // Test with CustomLinkedList
            CustomLinkedList<DataRecord> linkedList = new CustomLinkedList<>();
            for (DataRecord record : dataRecords) {
                linkedList.add(record);
            }
            System.out.println("Linked List contents:");
            linkedList.printList();

        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Error reading or processing data: " + e.getMessage();
        }
    }
}
