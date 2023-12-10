/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacw2; 


/**
 *
 * @author ACER
 */
public class Patient extends Person{
    int idNum;
    public Patient(String pfName, String psName, String pdoBirth, int pphoneNumber, int idNum){
        super(pfName,psName,pdoBirth,pphoneNumber);
        this.idNum=idNum;
        
        
    }
    
    public String getFName(){
        return super.fName;
    }
    
    public String getSName(){
        return super.sName;
    }
    
    public String getDOB(){
        return super.doBirth;
    }
    
    public int getPhoneNumber(){
        return super.phoneNumber;
    }
    
    public int getIDNum(){
        return idNum;
    }
    
}
