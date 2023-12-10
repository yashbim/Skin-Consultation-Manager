/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacw2;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author ACER
 */
public class ViewConsultations extends JFrame {
    
    public ViewConsultations() {
        this.setSize(1200,500);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setTitle("View Consultations");
        
        ViewConsultationsModel ViewConMod = new ViewConsultationsModel(ConsultationMenu.consultArr);
        JTable jtable = new JTable( ViewConMod);
        
        JScrollPane scrollPane = new JScrollPane(jtable);//setting scrollpane
        scrollPane.setViewportView(jtable);
        this.add(scrollPane);
        this.setVisible(true);
        
        this.setVisible(true);
    }
    
}
