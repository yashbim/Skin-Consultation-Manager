/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacw2;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 *
 * @author ACER
 */



public class DoctorTableModel extends AbstractTableModel{
    //creating array with column names
    private String[] columnNames = {"First Name","Second Name","Date of Birth","Mobile Number","Specialisation","License Number"};
    private ArrayList<Doctor> list;
    public DoctorTableModel(ArrayList<Doctor> personList){
        list = WestminsterSkinConsultationManager.arr;

        }
        public int getRowCount() {
            return list.size();
        }
        public int getColumnCount() {
            return columnNames.length;
        }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0) {
            temp = list.get(rowIndex).getFName();
            }
        else if (columnIndex == 1) {
            temp = list.get(rowIndex).getSName();
            }
        else if (columnIndex == 2) {
            temp = list.get(rowIndex).getDOB();
            }
        else if (columnIndex == 3) {
            temp = list.get(rowIndex).getPhoneNumber();
            }
        else if (columnIndex == 4) {
            temp = list.get(rowIndex).getSpec();
            }
        else if(columnIndex == 5) {
            temp = list.get(rowIndex).getLNum();
            }
        
        return temp;
}
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
}