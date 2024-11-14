
package com.ds_intelligence_arm.storage.service;

import com.ds_intelligence_arm.storage.model.DataRecord;
import com.ds_intelligence_arm.storage.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    @Autowired
    private DataRepository dataRepository;

    public void saveData(List<DataRecord> dataRecords) {
        dataRepository.saveAll(dataRecords);
    }
}
