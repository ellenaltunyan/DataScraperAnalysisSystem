package com.ds_intelligence_arm.utils;

import com.ds_intelligence_arm.storage.model.auto_am_DataRecord;

public class SortingAlgorithms {
 /* Implement the bubble, insertion, selection sort which will
  sort descending the array objects based on the price_in_amd. */

    
    public static double[] checkAndAssignPrices(String usdPrice, String amdPrice) {
        double[] result = new double[2]; // [usdPrice, amdPrice]
        
        // Handle completely empty case
        if ((usdPrice == null || usdPrice.trim().isEmpty()) && 
            (amdPrice == null || amdPrice.trim().isEmpty())) {
            return result; // returns [0.0, 0.0]
        }
        
        // If only USD price exists and it's actually USD
        if ((usdPrice != null && !usdPrice.trim().isEmpty()) && usdPrice.contains("$")) {
            result[0] = formatUSDPrice(usdPrice);
        }
        // If only USD price exists but it's actually AMD
        else if ((usdPrice != null && !usdPrice.trim().isEmpty()) && usdPrice.contains("֏")) {
            result[1] = formatAMDPrice(usdPrice);
        }
        
        // If only AMD price exists and it's actually AMD
        if ((amdPrice != null && !amdPrice.trim().isEmpty()) && amdPrice.contains("֏")) {
            result[1] = formatAMDPrice(amdPrice);
        }
        // If only AMD price exists but it's actually USD
        else if ((amdPrice != null && !amdPrice.trim().isEmpty()) && amdPrice.contains("$")) {
            result[0] = formatUSDPrice(amdPrice);
        }
        
        return result;
    }

    public static double formatUSDPrice(String priceStr) {
        String cleanPrice = priceStr
            .replace(" ", "")
            .replace("$", "")
            .replace(",", "")
            .trim();
        
        return Double.parseDouble(cleanPrice);
    }

    public static double formatAMDPrice(String priceStr) {
        String cleanPrice = priceStr
            .replace(" ", "")
            .replace("֏", "")
            .replace(",", "")
            .trim();
        
        return Double.parseDouble(cleanPrice);
    }

    public static auto_am_DataRecord[] auto_am_bubble_sort(auto_am_DataRecord[] my_array) {
        int my_array_length = my_array.length;
        for (int i = 0; i < my_array_length - 1; i++) {
            for (int j = 0; j < my_array_length - i - 1; j++) {
                double[] prices1 = checkAndAssignPrices(
                    my_array[j].getPriceInUSD(), 
                    my_array[j].getPriceInAMD()
                );
                
                double[] prices2 = checkAndAssignPrices(
                    my_array[j + 1].getPriceInUSD(), 
                    my_array[j + 1].getPriceInAMD()
                );
                
                // Compare AMD prices (prices[1])
                if (prices1[1] < prices2[1]) {
                    auto_am_DataRecord temp = my_array[j];
                    my_array[j] = my_array[j + 1];
                    my_array[j + 1] = temp;
                }
            }
        }
        return my_array;
    }
}
