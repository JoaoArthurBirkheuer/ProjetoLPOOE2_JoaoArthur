/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.projetolpooe2_joaoarthur.view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class StarRating extends javax.swing.JPanel {

    public int getStar() {
        return star;
    }
    
    public void setStar(int star) {
        this.star = star;
        if(star==1){
            star1ActionPerformed(null);
        }else if(star==2){
            star2ActionPerformed(null);
        }else if(star==3){
            star3ActionPerformed(null);            
        }else if(star==4){
            star4ActionPerformed(null);
        }else if(star==5){
            star5ActionPerformed(null);
        }else if(star==6){
            star6ActionPerformed(null);
        }else if(star==7){
            star7ActionPerformed(null);
        }else if(star==8){
            star8ActionPerformed(null);
        }else if(star==9){
            star9ActionPerformed(null);
        }else if(star==10){
            star10ActionPerformed(null);
        }
    }
    
    private List<EventStarRating> events=new ArrayList<>();
    private int star;
    
    public StarRating() {
        initComponents();
        init();
    }

    private void init() {
        setOpaque(false);
        setBackground(new Color(204,204,204));
        setForeground(new Color(238,236,0));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        star1 = new com.mycompany.projetolpooe2_joaoarthur.model.Star();
        star2 = new com.mycompany.projetolpooe2_joaoarthur.model.Star();
        star3 = new com.mycompany.projetolpooe2_joaoarthur.model.Star();
        star4 = new com.mycompany.projetolpooe2_joaoarthur.model.Star();
        star5 = new com.mycompany.projetolpooe2_joaoarthur.model.Star();
        star6 = new com.mycompany.projetolpooe2_joaoarthur.model.Star();
        star7 = new com.mycompany.projetolpooe2_joaoarthur.model.Star();
        star8 = new com.mycompany.projetolpooe2_joaoarthur.model.Star();
        star9 = new com.mycompany.projetolpooe2_joaoarthur.model.Star();
        star10 = new com.mycompany.projetolpooe2_joaoarthur.model.Star();

        setLayout(new java.awt.GridLayout(1, 5));

        star1.setText("star1");
        star1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star1ActionPerformed(evt);
            }
        });
        add(star1);

        star2.setText("star1");
        star2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star2ActionPerformed(evt);
            }
        });
        add(star2);

        star3.setText("star1");
        star3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star3ActionPerformed(evt);
            }
        });
        add(star3);

        star4.setText("star1");
        star4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star4ActionPerformed(evt);
            }
        });
        add(star4);

        star5.setText("star1");
        star5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star5ActionPerformed(evt);
            }
        });
        add(star5);

        star6.setText("star1");
        star6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star6ActionPerformed(evt);
            }
        });
        add(star6);

        star7.setText("star1");
        star7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star7ActionPerformed(evt);
            }
        });
        add(star7);

        star8.setText("star1");
        star8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star8ActionPerformed(evt);
            }
        });
        add(star8);

        star9.setText("star1");
        star9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star9ActionPerformed(evt);
            }
        });
        add(star9);

        star10.setText("star1");
        star10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                star10ActionPerformed(evt);
            }
        });
        add(star10);
    }// </editor-fold>//GEN-END:initComponents

    private void star1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star1ActionPerformed
        star1.setSelected(true);
        star2.setSelected(false);
        star3.setSelected(false);
        star4.setSelected(false);
        star5.setSelected(false);
        star6.setSelected(false);
        star7.setSelected(false);
        star8.setSelected(false);
        star9.setSelected(false);
        star10.setSelected(false);
        star = 1;
        runEvent();
    }//GEN-LAST:event_star1ActionPerformed

    private void star2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star2ActionPerformed
        star1.setSelected(true);
        star2.setSelected(true);
        star3.setSelected(false);
        star4.setSelected(false);
        star5.setSelected(false);
        star6.setSelected(false);
        star7.setSelected(false);
        star8.setSelected(false);
        star9.setSelected(false);
        star10.setSelected(false);
        star = 2;
        runEvent();
    }//GEN-LAST:event_star2ActionPerformed

    private void star3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star3ActionPerformed
        star1.setSelected(true);
        star2.setSelected(true);
        star3.setSelected(true);
        star4.setSelected(false);
        star5.setSelected(false);
        star6.setSelected(false);
        star7.setSelected(false);
        star8.setSelected(false);
        star9.setSelected(false);
        star10.setSelected(false);
        star = 3;
        runEvent();
    }//GEN-LAST:event_star3ActionPerformed

    private void star4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star4ActionPerformed
        star1.setSelected(true);
        star2.setSelected(true);
        star3.setSelected(true);
        star4.setSelected(true);
        star5.setSelected(false);
        star6.setSelected(false);
        star7.setSelected(false);
        star8.setSelected(false);
        star9.setSelected(false);
        star10.setSelected(false);
        star = 4;
        runEvent();
    }//GEN-LAST:event_star4ActionPerformed

    private void star5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star5ActionPerformed
        star1.setSelected(true);
        star2.setSelected(true);
        star3.setSelected(true);
        star4.setSelected(true);
        star5.setSelected(true);
        star6.setSelected(false);
        star7.setSelected(false);
        star8.setSelected(false);
        star9.setSelected(false);
        star10.setSelected(false);
        star = 5;
        runEvent();
    }//GEN-LAST:event_star5ActionPerformed

    private void star6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star6ActionPerformed
        star1.setSelected(true);
        star2.setSelected(true);
        star3.setSelected(true);
        star4.setSelected(true);
        star5.setSelected(true);
        star6.setSelected(true);
        star7.setSelected(false);
        star8.setSelected(false);
        star9.setSelected(false);
        star10.setSelected(false);
        star = 6;
        runEvent();
    }//GEN-LAST:event_star6ActionPerformed

    private void star7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star7ActionPerformed
        star1.setSelected(true);
        star2.setSelected(true);
        star3.setSelected(true);
        star4.setSelected(true);
        star5.setSelected(true);
        star6.setSelected(true);
        star7.setSelected(true);
        star8.setSelected(false);
        star9.setSelected(false);
        star10.setSelected(false);
        star = 7;
        runEvent();
    }//GEN-LAST:event_star7ActionPerformed

    private void star8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star8ActionPerformed
        star1.setSelected(true);
        star2.setSelected(true);
        star3.setSelected(true);
        star4.setSelected(true);
        star5.setSelected(true);
        star6.setSelected(true);
        star7.setSelected(true);
        star8.setSelected(true);
        star9.setSelected(false);
        star10.setSelected(false);
        star = 8;
        runEvent();
    }//GEN-LAST:event_star8ActionPerformed

    private void star9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star9ActionPerformed
        star1.setSelected(true);
        star2.setSelected(true);
        star3.setSelected(true);
        star4.setSelected(true);
        star5.setSelected(true);
        star6.setSelected(true);
        star7.setSelected(true);
        star8.setSelected(true);
        star9.setSelected(true);
        star10.setSelected(false);
        star = 9;
        runEvent();
    }//GEN-LAST:event_star9ActionPerformed

    private void star10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_star10ActionPerformed
        star1.setSelected(true);
        star2.setSelected(true);
        star3.setSelected(true);
        star4.setSelected(true);
        star5.setSelected(true);
        star6.setSelected(true);
        star7.setSelected(true);
        star8.setSelected(true);
        star9.setSelected(true);
        star10.setSelected(true);
        star = 10;
        runEvent();
    }//GEN-LAST:event_star10ActionPerformed

    
    @Override
    public void setBackground(Color color){
        super.setBackground(color);
        for(Component com:getComponents()) {
            com.setBackground(color);
        }
    }
    
    @Override
    public void setForeground(Color color) {
        super.setForeground(color);
        for(Component com:getComponents()) {
            com.setForeground(color);
        }
    }
    
    public void addEventStarRating(EventStarRating event){
        events.add(event);
    }
    
    public void runEvent(){
        for(EventStarRating event:events){
            event.selected(star);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.projetolpooe2_joaoarthur.model.Star star1;
    private com.mycompany.projetolpooe2_joaoarthur.model.Star star10;
    private com.mycompany.projetolpooe2_joaoarthur.model.Star star2;
    private com.mycompany.projetolpooe2_joaoarthur.model.Star star3;
    private com.mycompany.projetolpooe2_joaoarthur.model.Star star4;
    private com.mycompany.projetolpooe2_joaoarthur.model.Star star5;
    private com.mycompany.projetolpooe2_joaoarthur.model.Star star6;
    private com.mycompany.projetolpooe2_joaoarthur.model.Star star7;
    private com.mycompany.projetolpooe2_joaoarthur.model.Star star8;
    private com.mycompany.projetolpooe2_joaoarthur.model.Star star9;
    // End of variables declaration//GEN-END:variables
}
