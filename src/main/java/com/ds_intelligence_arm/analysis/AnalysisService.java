
package com.ds_intelligence_arm.analysis;

import com.ds_intelligence_arm.storage.model.DataRecord;
import com.ds_intelligence_arm.storage.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisService {
    @Autowired
    private DataRepository dataRepository;

    public void performAnalysis() {
        List<DataRecord> data = dataRepository.findAll();
        // Perform analysis logic here
    }
}
