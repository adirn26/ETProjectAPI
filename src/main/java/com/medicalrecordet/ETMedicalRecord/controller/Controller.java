package com.medicalrecordet.ETMedicalRecord.controller;

import com.medicalrecordet.ETMedicalRecord.model.DbSequence;
import com.medicalrecordet.ETMedicalRecord.model.MedicalRecord;
import com.medicalrecordet.ETMedicalRecord.repository.DbRepo;
import com.medicalrecordet.ETMedicalRecord.repository.MedicalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private MedicalRepo repo;

    @Autowired
    private DbRepo dbRepo;

    @PostMapping("/medicalrecord")
    public ResponseEntity<?> insertrecord(@RequestBody MedicalRecord record){
        DbSequence db = dbRepo.findById("seq").get();
        db.setSeq(db.getSeq()+1);
        dbRepo.save(db);
        record.setId(db.getSeq());
        repo.save(record);
        return new ResponseEntity<>("Patient inserted with id "+record.getId(), HttpStatus.OK);
    }

    @GetMapping("/medicalrecord/{id}")
    public ResponseEntity<?> findbyid(@PathVariable int id){
        Optional<MedicalRecord> record=repo.findById(id);
        if(record.isEmpty())
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<MedicalRecord>(record.get(), HttpStatus.OK);
    }
}
