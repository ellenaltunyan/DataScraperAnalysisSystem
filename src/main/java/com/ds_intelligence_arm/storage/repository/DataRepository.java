
package com.ds_intelligence_arm.storage.repository;

import com.ds_intelligence_arm.storage.model.DataRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<DataRecord, Long> {
}
