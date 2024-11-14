package com.ds_intelligence_arm.scraper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class auto_am_scraper {
    
    private static final Gson gson = new Gson();
    String resourcePath = Paths.get(System.getProperty("user.dir"), "src", "resources", "auto_am.json").toString();

    // public static void main(String[] args) throws InterruptedException {
    //     List<Map<String, String>> scrapedDataList = new ArrayList<>();

    //     // Scrape and accumulate data in the list
    //     for (int i = 3078914; i > 3078900; i--) {
    //         Thread.sleep(5000);
    //         Map<String, String> data = scrapeData(i);
    //         if (data != null) {
    //             scrapedDataList.add(data);
    //         }
    //     }

    //     // Save the entire list to the JSON file
    //     saveDataList(scrapedDataList);

    //     // Read and print data from the JSON file
    //     readData();
    // }

    // Method to scrape data and return it as a map
    private static Map<String, String> scrapeData(int id) {
        try {
            String url = String.format("https://www.auto.am/offer/%s", id);
            System.out.println("Scraping URL: " + url);
            Document doc = Jsoup.connect(url).userAgent("Mozilla").get();

            // Prepare the data to be saved as JSON
            Map<String, String> scrapedData = new HashMap<>();
            scrapedData.put("url", url);
            scrapedData.put("html", doc.outerHtml());
            return scrapedData;

        } catch (IOException e) {
            System.out.println("Error scraping data: " + e.getMessage());
            return null;
        }
    }

    // Method to save the list of scraped data to a JSON file
    private static void saveDataList(List<Map<String, String>> dataList) {
        String resourcePath = Paths.get(System.getProperty("user.dir"), "src", "resources", "auto_am.json").toString();

        try (FileWriter writer = new FileWriter(resourcePath)) {
            // Write the list as a JSON array to the file
            gson.toJson(dataList, writer);
            System.out.println("Data saved to " + resourcePath);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

// Method to read data from the JSON file and print each entry
private static void readData() {
    String resourcePath = Paths.get(System.getProperty("user.dir"), "src", "resources", "auto_am.json").toString();

    try (BufferedReader reader = new BufferedReader(new FileReader(resourcePath))) {
        // Correct usage of TypeToken for a List of Maps
        List<Map<String, String>> dataList = gson.fromJson(reader, new TypeToken<List<Map<String, String>>>() {}.getType());

        for (Map<String, String> data : dataList) {
            System.out.println("URL: " + data.get("url"));
            System.out.println("HTML: " + data.get("html").substring(0, 100) + "..."); // Print a snippet of HTML
            System.out.println("-----");
        }
    } catch (IOException e) {
        System.out.println("Error reading data: " + e.getMessage());
    }
}
}
