/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacw2;

import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class ViewConsultationsModel  extends AbstractTableModel{
    public String[] columnNames = {"First Name","Second Name","Date of Birth","Doctor Name","License Number", "Consultation Date Time","Text","Price"};
    public static ArrayList<Consultation> consuldatalist;
    
    public ViewConsultationsModel (ArrayList<Consultation> consulList){

        consuldatalist = ConsultationMenu.consultArr;
    }
    public int getRowCount() {
        return consuldatalist.size();
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    
    
    //@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0) {
            temp = consuldatalist.get(rowIndex).getPatient().getFName();
            }
        else if (columnIndex == 1) {
            temp = consuldatalist.get(rowIndex).getPatient().getSName();
            }
        else if (columnIndex == 2) {
            temp = consuldatalist.get(rowIndex).getPatient().getDOB();
            }
        else if (columnIndex == 3) {
            temp = consuldatalist.get(rowIndex).getDoctor().getFName();
            }
        else if (columnIndex == 4) {
            temp = consuldatalist.get(rowIndex).getDoctor().getLNum();
            }
        else if(columnIndex == 5) {
            temp = consuldatalist.get(rowIndex).appDate;
            }
        else if(columnIndex == 6) {
            
          //  String temp1 = consuldatalist.get(rowIndex).getText();
            
            try {


                // Creating byte array to store string
                byte[] text = consuldatalist.get(rowIndex).getBiytes();

                // Decrypting text
                ConsultationMenu.desCipher.init(Cipher.DECRYPT_MODE, ConsultationMenu. myDesKey);
                byte[] textDecrypted = ConsultationMenu.desCipher.doFinal(text);

                // Converting decrypted byte array to string
                String s = new String(text);
                temp = s;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            
            }
        
        else if(columnIndex == 6) {
            temp = "$15";
        }
        
        return temp;
}
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
