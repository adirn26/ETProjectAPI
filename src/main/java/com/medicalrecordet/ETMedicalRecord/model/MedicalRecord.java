package com.medicalrecordet.ETMedicalRecord.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {
    @Id
    public int id;
    public String name;
    public String age;
    public String gender;
    public String email;
    public String xray;
    public String bloodtest;
    public String ctscan;
    public String diagnosis;
    public String prescription;
}
