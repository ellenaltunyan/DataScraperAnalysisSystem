
package com.ds_intelligence_arm.analysis;

import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {
    public void generateReport(String data) {
        try (FileWriter writer = new FileWriter("report.csv")) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
