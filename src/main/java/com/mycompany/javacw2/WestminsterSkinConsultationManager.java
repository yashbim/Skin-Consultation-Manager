/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.sound.midi.Soundbank;
import javax.swing.text.html.CSS;

/**
 *
 * @author ACER
 */
public class WestminsterSkinConsultationManager implements SkinConsultationManager{
     static Scanner myScanner = new Scanner(System.in);
     static ArrayList<Doctor> arr = new ArrayList<>();
     public static int docCount=0;

    public static void main(String[] args) {
         
        System.out.println("Welcome to Westminster Skin Consultation Center");
        boolean redo=true;
        //Option input
        
        while (redo=true){
            System.out.println("Add a doctor         :      1");
            System.out.println("Delete a doctor      :      2");
            System.out.println("Print doctor list    :      3");
            System.out.println("Save doctor list     :      4");
            System.out.println("Sort doctor list     :      5");
            System.out.println("Open UI              :      6");
            System.out.println("Recall saved doctors :      7");
            System.out.println("Exit the program     :      8 \n ----------------");
            System.out.println("Enter your option : ");

            int option=myScanner.nextInt();
            //switch case to select option
            switch (option) {
                    case 1 -> {
                        //case option to add a doctor.
                        System.out.println("Add a doctor : ");
                        if(docCount<9){
                            addDoctor(arr);
                        } else{
                            System.out.println("Maximum number of doctors ");
                        }
                    }

                    case 2 -> { 
                        //case option to delete a doctor.
                        System.out.println("Delete a doctor : ");
                        delDoctor(arr);
                    }

                    case 3 -> {
                        //case option to print the list of doctors.
                        System.out.println("Print doctor list : ");
                        printDoctor(arr);
                    }

                    case 4 -> {//case option to save the list of doctors.
                        System.out.println("Save doctor list : ");
                        saveDoctor(arr);
                    }
                    
                    case 5 -> {//case option to sort the list of doctors.
                        System.out.println("Sort doctor list : ");
                        sortDoctor(arr);
                    }
                    
                    case 6 -> {//case option to open UI.
                        System.out.println("Open UI : ");
                        DoctorTable dTable = new DoctorTable();
                    }
                    
                    case 7 -> {//case option to recall saved data
                        System.out.println("Open saved data : ");
                        loadDoctors(arr);
                    }
                        
                    case 8 -> {
                        //case option to exit the program
                        System.out.println("Exiting the program...");
                        redo=false;
                        return;
                    }
                    default -> System.out.println("Invalid entry");
                }
             //default set to catch invalid entries.
             
            }
        }
        public static void addDoctor(ArrayList<Doctor> arr) {
            //Input doctor details
            System.out.println("Enter first name");
            String firstName = myScanner.next();  //Input doctors first name.
            System.out.println("Enter surname name");
            String secondName = myScanner.next();  //Input doctors surname name.
            System.out.println("Enter date of birth");
            String dob = myScanner.next();  //Input doctors date of birth.
            System.out.println("Enter mobile number");
            int mobnum = myScanner.nextInt();  //Input doctors mobile number.
            System.out.println("Enter specialisation");
            String spec = myScanner.next();  //Input doctors specialisation.
            System.out.println("Enter time (1) Format - dd-MM-yyyy;HH:mm :    ");
            String t1 = myScanner.next();  //Input doctors available time.
            Date time1 = validateDate(t1);
            System.out.println("Enter time (2) Format - dd-MM-yyyy;HH:mm :    ");
            String t2 = myScanner.next();  //Input doctors available time.
            System.out.println("Enter time (3) Format - dd-MM-yyyy;HH:mm :    ");
            Date time2 = validateDate(t2);
            String t3 = myScanner.next();  //Input doctors available time.
            Date time3 = validateDate(t3);
            
            if (time1 == null | time2==null | time3 == null){
                System.out.println("Invalid date format");
                return;
            }
            
            
            int x = 0;
            System.out.println("Enter license number");
            int licnum = myScanner.nextInt();  //Input doctors license number.
            for (Doctor d:arr){
                if (d.getLNum()==licnum){
                    System.out.println("Incorrect license number.");
                    x=1;              
                } 
            }
            if(x==0){
                arr.add(new Doctor(firstName,secondName,dob,mobnum,spec,time1,time2,time3,licnum));//adding data to arraylist
                docCount++;
            }else{
                return;
            }
        }
        
        public static void delDoctor(ArrayList<Doctor>arr){
            //entering neccessary doctor details.
            System.out.println("You have chosen : Delete a doctor (2)");
            System.out.println("Enter the doctor's Licsence Number : ");
            int delDocNum = myScanner.nextInt(); //input license number of doctor to be removed from list
            
            //removing the doctor.
            for (int i=0; i<arr.size();i++){
                if(arr.get(i).getLNum()==delDocNum){
                    System.out.println("Deleting Dr. "+arr.get(i).getFName()+" "+arr.get(i).getSName());
                    arr.remove(i);
                    docCount--;
                    break;
                } else {
                    //process for incorrect data entered
                    System.out.println("Matching license number not found.");
                    break;
                }
            }
        }
        
        public static void printDoctor(ArrayList<Doctor> arr) {
            System.out.println("List of Doctors \n ------------");
            if (arr.isEmpty()){ System.out.println("No doctors entered."); } else {
                //printing doctor list.
                for (Doctor d:arr){
                    
                    
                    System.out.println("First Name      : " +d.getFName());
                    System.out.println("Second Name     : " +d.getSName());
                    System.out.println("Date of Birth   : " +d.getDOB());
                    System.out.println("Phone Numer     : " +d.getPhoneNumber());
                    System.out.println("Specification   : " +d.getSpec());
                    System.out.println("Time 1          : "+ d.getT1());
                    System.out.println("Time 2          : "+ d.getT2());
                    System.out.println("Time 3          : "+ d.getT3());
                    System.out.println("License Number  : " +d.getLNum()+"\n");
                }
            }
        }
        
        public static void saveDoctor(ArrayList<Doctor> arr) {
            //saving doctors to text file
            try {
                
                
                FileWriter myWriter = new FileWriter("doctordata.txt");
                for (int i = 0; i < arr.size(); i++) {
                    Doctor doctor = (Doctor) arr.get(i);
                    myWriter.write(doctor.getFName()+","+doctor.getSName()+","+doctor.getDOB()+","+doctor.getPhoneNumber()+","+doctor.getSpec()+","+doctor.getT1()+","+doctor.getT2()+","+doctor.getT3()+","+doctor.getLNum());
                    myWriter.write("\n");
                }
                myWriter.close();
                System.out.println("Data stored successfully");
            } catch (IOException e) {
                System.out.println("An error occurred");
            }
        }
        
        public static void loadDoctors(ArrayList<Doctor> arr) {
            try{
                File myObj = new File("doctordata.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                    myReader.close();
            }catch (IOException e){
                System.out.println("An error Occured");
            }
        }
        
        
            
        public static void sortDoctor(ArrayList<Doctor> arr){
            System.out.println("Sorting Doctor List....");
            arr.sort((check1,check2)->check1.getSName().compareToIgnoreCase(check2.getSName()));
        }
        public static Date validateDate(String patavdateInput ){
                
            Date date = null;
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy;HH:mm");

            try {
                date = format.parse(patavdateInput);
            } catch (Exception ex) {
                System.out.println("Error date validation ");
                return null;
            }
            return date;
        }
}
    

