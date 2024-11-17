package com.ds_intelligence_arm.for_tasks; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.ds_intelligence_arm.storage.model.auto_am_DataRecord;
import com.ds_intelligence_arm.utils.SortingAlgorithms;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DataRecordSorting {

    public static List<auto_am_DataRecord> readDataRecordsFromJson(String filePath) {
        List<auto_am_DataRecord> dataRecords = new ArrayList<>();
        Gson gson = new Gson();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Define the type for a List of auto_am_DataRecord
            Type listType = new TypeToken<List<auto_am_DataRecord>>() {}.getType();

            // Deserialize JSON to List<auto_am_DataRecord>
            dataRecords = gson.fromJson(reader, listType);

        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
        }

        return dataRecords;
    }

    public static void main(String[] args) {
        // Path to the JSON file
        String filePath = "src/resources/auto_am.json";

        // Read the data records from the JSON file
        List<auto_am_DataRecord> records = readDataRecordsFromJson(filePath);
        auto_am_DataRecord[] records_array= records.toArray(new auto_am_DataRecord[0]);

        // Use the bubble sorting algorithm defined in SortingAlgorithms to sort the record_array_based on price_in_AMD.
        records_array = SortingAlgorithms.auto_am_bubble_sort(records_array);
        // Use the insertion sorting algorithm defined in SortingAlgorithms to sort the record_array_based on price_in_AMD.

        // Use the selection sorting algorithm defined in SortingAlgorithms to sort the record_array_based on price_in_AMD.

        // Print each record after sorting
        for (auto_am_DataRecord record : records_array) {
            double[] prices = SortingAlgorithms.checkAndAssignPrices(
                record.getPriceInUSD(), 
                record.getPriceInAMD()
            );
            
            System.out.println("URL: " + record.getUrl());
            System.out.println("Title: " + record.getTitle());
            System.out.println("Description: " + record.getDescription());
            System.out.println("Price in USD: $" + String.format("%.0f", prices[0]));
            System.out.println("Price in AMD: ֏" + String.format("%.0f", prices[1]));
            System.out.println("-----\n");
        }
    }
}
