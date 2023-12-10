/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacw2;

import java.lang.reflect.Constructor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

/**
 *
 * @author ACER
 */
public class ConsultationMenu extends JFrame {

    static ArrayList<Patient> parr = new ArrayList<>();
    static ArrayList<Consultation> consultArr = new ArrayList<>();
    static ArrayList<String> textencrypt = new ArrayList<String>();
    static SecretKey myDesKey;
    static  Cipher desCipher;

    byte[] textEncrypted;
    
    public ConsultationMenu() {
        this.setSize(1000, 700);//setting size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting close function
        this.setTitle("Add Consultations");//setting title
        this.setLayout(null);

        //creating labels for patient details
        JLabel fNameLabel = new JLabel("Enter first name          :   ");
        JLabel sNameLabel = new JLabel("Enter Second Name         :   ");
        JLabel dobLabel = new JLabel("Enter Date of Birth       :   ");
        JLabel mobNumLabel = new JLabel("Enter Mobile Number       :   ");
        JLabel idLabel = new JLabel("Enter ID Number           :   ");

        //creating labels for consultation details
        JLabel docLNumLabel = new JLabel("Enter the Required Doctors License Number  :    ");
        JLabel consulTextLabel = new JLabel("Enter additional details                   :    ");
        JLabel patAvTimeLabel = new JLabel("Enter Patient available time               :    ");
        JLabel patAvDateLabel = new JLabel("Enter Patient available date               :    ");

        //creating instances for the labels of patient details
        fNameLabel.setBounds(50, 100, 500, 20);
        this.add(fNameLabel);
        sNameLabel.setBounds(50, 150, 500, 20);
        this.add(sNameLabel);
        dobLabel.setBounds(50, 200, 500, 20);
        this.add(dobLabel);
        mobNumLabel.setBounds(50, 250, 500, 20);
        this.add(mobNumLabel);
        idLabel.setBounds(50, 300, 500, 20);
        this.add(idLabel);

        //creating instances for the labels of consultation details
        docLNumLabel.setBounds(80, 400, 500, 20);
        this.add(docLNumLabel);
        consulTextLabel.setBounds(80, 450, 500, 20);
        this.add(consulTextLabel);
        patAvDateLabel.setBounds(80, 600, 500, 20);
        this.add(patAvDateLabel);

        //creating input text fields for patient details
        JTextField fNameInput = new JTextField();
        JTextField sNameInput = new JTextField();
        JTextField dobInput = new JTextField();
        JTextField mobNumInput = new JTextField();
        JTextField idInput = new JTextField();

        //creating input text fields for consultation details
        JTextField docLNumInput = new JTextField();
        JTextField consulTextInput = new JTextField();
        JTextField patAvDateInput = new JTextField();

        //creating instances for the input text fields of patient details
        fNameInput.setBounds(200, 100, 500, 25);
        this.add(fNameInput);
        sNameInput.setBounds(200, 150, 500, 25);
        this.add(sNameInput);
        dobInput.setBounds(200, 200, 500, 25);
        this.add(dobInput);
        mobNumInput.setBounds(200, 250, 500, 25);
        this.add(mobNumInput);
        idInput.setBounds(200, 300, 500, 25);
        this.add(idInput);

        //creating instances for the input text fields of consultation details
        docLNumInput.setBounds(400, 400, 500, 25);
        this.add(docLNumInput);
        consulTextInput.setBounds(400, 450, 500, 75);
        this.add(consulTextInput);
        patAvDateInput.setBounds(400, 600, 500, 20);
        this.add(patAvDateInput);

        //creating labels and instances for other text areas
        JLabel patientDetailsHeading = new JLabel("Patient Details : ");
        patientDetailsHeading.setBounds(40, 40, 500, 40);
        this.add(patientDetailsHeading);
        JLabel consultationDetailsHeading = new JLabel("Consultation Details : ");
        consultationDetailsHeading.setBounds(40, 350, 500, 25);
        this.add(consultationDetailsHeading);

        //creating submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(790, 125, 100, 50);
        this.add(submitButton);
        
        JButton viewButton = new JButton("View Consultations");
        viewButton.setBounds(740, 200, 200, 50);
        this.add(viewButton);
        
        submitButton.addActionListener(e -> {
            String fnInput = fNameInput.getText().trim();
            String snInput = sNameInput.getText().trim();
            String dobirthInput = dobInput.getText().trim();
            String mobnumInput = mobNumInput.getText().trim();
            String idnumInput = idInput.getText().trim();
            String doclnumInput = docLNumInput.getText().trim();
            String consultextInput = consulTextInput.getText().trim();
            String patavdateInput = patAvDateInput.getText();
            
            //encryption of the entered consultation text
            try {
                KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
                myDesKey = keygenerator.generateKey();
 
                // Creating object of Cipher
               
                desCipher = Cipher.getInstance("DES");

                // Creating byte array to store string
                byte[] text = consultextInput.getBytes("UTF8");

                // Encrypting text
                desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
                textEncrypted = desCipher.doFinal(text);
                
                // Converting encrypted byte array to string
//                String s = new String(textEncrypted);
//                System.out.println(s);
//                
//                consultextInput = s;

            }
                catch (Exception ew) {
                    System.out.println("Exception");
            }

            Date date = null;
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy;HH:mm");

            try {
                date = format.parse(patavdateInput);
            } catch (Exception ex) {
                System.out.println("Error date validation ");
            }
            System.out.println(date);

            int mnInput;
            int idnumberInput = 0;
            int doclicnumInput = 0;
            int x = 0;

            mnInput = Integer.parseInt(mobnumInput);
            //System.out.println(mnInput);
            
            doclicnumInput = Integer.parseInt(doclnumInput);
            //System.out.println(doclicnumInput);

            //method to validate entered doctor license number    
            Doctor doc = validateDoctor(doclicnumInput, date);

            if (doc == null) {
                System.out.println("Doc is null");
                return;
            }

            idnumberInput = Integer.parseInt(idnumInput.trim());

            //patient array
            parr.add(new Patient(fnInput, snInput, dobirthInput, mnInput, idnumberInput));

            //consultation array
            consultArr.add(new Consultation(doc, parr.get(parr.size() - 1), textEncrypted, date));

            //testing arrraylist
            for (Consultation d : consultArr) {
                System.out.println("Patient Name   :" + d.getPatient().getFName());
                System.out.println("Doctor Name      : " + d.getDoctor().getFName());
                System.out.println("Doctor ID        : " + d.getDoctor().getLNum());
                System.out.println("Date   :" + d.appDate);
            }
        });
        
        viewButton.addActionListener(e -> {
            ViewConsultations viewC = new ViewConsultations();
        });
        
        this.setVisible(true);

    }

    public Doctor validateDoctor(int docLiInput, Date date) {
        for (Doctor d : WestminsterSkinConsultationManager.arr) {
            if (d.getLNum() == docLiInput) {
                System.out.println(d.getLNum());
                Doctor dd = doctorAvaiilability(d,date);
                return dd;
            }

        }
        return null;
    }
    
    public Doctor doctorAvaiilability(Doctor doc, Date date){
       int i=0;
       
        for (int f=0 ; f<doc.dateList.size();f++ ){
            if(doc.dateList.get(f).compareTo(date)==0){
                doc.dateList.remove(f);
               i=1;              
            }
                
        }
        if (i ==1){
            return doc;
        }else{
             for (Doctor d : WestminsterSkinConsultationManager.arr){
                 if (d.dateList.contains(date)){
                     return d;
                 }
             }
        }
        return null;
    }
    
}
