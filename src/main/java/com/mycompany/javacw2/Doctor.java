/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacw2;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @
 * author ACER
 */
public class Doctor extends Person{
    String specialisation;
    int lNum;
    Date t1;
    Date t2;
    Date t3;
    
    ArrayList<Date> dateList = new ArrayList();
    
    
    public Doctor(String dfName, String dsName, String ddoBirth, int dphoneNumber, String dSpecialisation,  Date time1,Date time2, Date time3, int dlNum){
        super(dfName, dsName, ddoBirth, dphoneNumber);
        this.specialisation=dSpecialisation;
        this.t1 = time1;
        this.t2 = time2;
        this.t3 = time3;
        this.dateList.add(time1);
        this.dateList.add(time2);
        this.dateList.add(time3);
        this.lNum = dlNum;
        
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
    
    public String getSpec(){
        return specialisation;
    }

    public Date getT1() {
        return t1;
    }

    public Date getT2() {
        return t2;
    }

    public Date getT3() {
        return t3;
    }
    
    
    
    public int getLNum(){
        return lNum;
    }
    
    
    
}
