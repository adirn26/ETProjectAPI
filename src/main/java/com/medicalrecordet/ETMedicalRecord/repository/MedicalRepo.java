package com.medicalrecordet.ETMedicalRecord.repository;

import com.medicalrecordet.ETMedicalRecord.model.MedicalRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicalRepo extends MongoRepository<MedicalRecord, Integer> {
}
