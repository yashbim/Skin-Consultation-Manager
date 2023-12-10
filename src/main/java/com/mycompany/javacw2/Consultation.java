/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacw2;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class Consultation {
    
    Doctor doctor;
    Patient patient;
    byte[] text;
    Date appDate;
    public Consultation(Doctor consulDoc,Patient PatientDoc, byte[] text, Date date) {
        this.doctor = consulDoc;
        this.patient = PatientDoc;
        this.text = text;
        this.appDate = date;
        
        
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public byte[] getBiytes() {
        return text;
    }

 


}

