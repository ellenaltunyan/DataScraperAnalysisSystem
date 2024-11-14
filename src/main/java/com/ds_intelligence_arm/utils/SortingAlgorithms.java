
package com.ds_intelligence_arm.utils;

import java.util.Arrays;
import com.ds_intelligence_arm.storage.model.auto_am_DataRecord;

public class SortingAlgorithms {
 /* Implement the bubble, insertion, selection sort which will
  sort descending the array objects based on the price_in_amd. */

    public static auto_am_DataRecord[] auto_am_bubble_sort(auto_am_DataRecord[] my_array){
        int my_array_length = my_array.length;
        for (int i=0; i<my_array_length-1; i++){
            for(int j=0; j<my_array_length-1; j++){
                String current = my_array[j].getPriceInAMD();
                String next = my_array[j+1].getPriceInAMD();
                double cur_price = 0;
                double next_price = 0;
                if (current.equals("")) {
                    cur_price = 0;
                } else {
                    current = current.replace(" ", "").replace("$", "").replace("֏", "");
                    cur_price = Double.parseDouble(current);
                }
                if (next.equals("")) {
                    next_price = 0;
                } else {
                    next = next.replace(" ", "").replace("$", "").replace("֏", "");
                    next_price = Double.parseDouble(next);
                }
                if(cur_price > next_price){
                    auto_am_DataRecord temp = my_array[j];
                    my_array[j]  =  my_array[j+1];
                    my_array[j+1] = temp;
                }
            }
        }

        return my_array;

    }
}
