/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacw2;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/*
 *
 * @author ACER
 */
public class DoctorTable extends JFrame{
    public DoctorTable(){//creating table
        this.setSize(1200,500);//setting size
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//setting close function
        this.setTitle("Doctor's Table");//setting title
        
        DoctorTableModel docTabMod = new DoctorTableModel(WestminsterSkinConsultationManager.arr);
        JTable jTable = new JTable(docTabMod);
        
        JScrollPane scrollPane = new JScrollPane(jTable);//setting scrollpane
        scrollPane.setViewportView(jTable);
        this.add(scrollPane);
        this.setVisible(true);
        
        JButton addConsul = new JButton();
        //addConsul.setSize(50, 50);
        addConsul.addActionListener(e->{
            ConsultationMenu consult = new ConsultationMenu();
        });//call back function
        
        this.add(addConsul,BorderLayout.SOUTH);
    }
}


