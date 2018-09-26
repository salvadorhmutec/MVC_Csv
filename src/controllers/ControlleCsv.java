/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelCsv;
import views.ViewCsv;

/**
 *
 * @author Zeo
 */
public class ControlleCsv {

    ModelCsv modelCsv;
    ViewCsv viewCsv;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewCsv.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewCsv.jbtn_guardar) {
                jbtn_guardar_actionPerformed();
            } else if (e.getSource() == viewCsv.jbtn_nuevo) {
                jbtn_nuevo_actionPerformed();
            } else if (e.getSource() == viewCsv.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewCsv.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewCsv.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            }
        }

    };

    private void jbtn_anterior_actionPerformed() {
        modelCsv.movePrevious();
        viewCsv.jtf_nombre.setText(modelCsv.getNombre());
        viewCsv.jtf_email.setText(modelCsv.getEmail());
    }

    private void jbtn_guardar_actionPerformed() {
        modelCsv.setNombre(viewCsv.jtf_nombre.getText());
        modelCsv.setEmail(viewCsv.jtf_email.getText());
        modelCsv.guardarArchivo();
        modelCsv.leerArchivo();
        jbtn_primero_actionPerformed();
    }

    private void jbtn_nuevo_actionPerformed() {
        viewCsv.jtf_nombre.setText("");
        viewCsv.jtf_email.setText("");
    }

    private void jbtn_primero_actionPerformed() {
        modelCsv.moveFirst();
        getValues();
    }

    private void jbtn_siguiente_actionPerformed() {
        modelCsv.moveNext();
        getValues();
    }

    private void jbtn_ultimo_actionPerformed() {
        modelCsv.moveLast();
        getValues();
    }
    
    private void getValues(){
        viewCsv.jtf_nombre.setText(modelCsv.getNombre());
        viewCsv.jtf_email.setText(modelCsv.getEmail());
    }

    public ControlleCsv(ModelCsv modelCsv, ViewCsv viewCsv) {
        this.modelCsv = modelCsv;
        this.viewCsv = viewCsv;
        setActionListener();
        initComponents();
        modelCsv.leerArchivo();
        jbtn_primero_actionPerformed();
    }

    private void setActionListener() {
        viewCsv.jbtn_anterior.addActionListener(actionListener);
        viewCsv.jbtn_guardar.addActionListener(actionListener);
        viewCsv.jbtn_nuevo.addActionListener(actionListener);
        viewCsv.jbtn_primero.addActionListener(actionListener);
        viewCsv.jbtn_siguiente.addActionListener(actionListener);
        viewCsv.jbtn_ultimo.addActionListener(actionListener);
    }

    private void initComponents() {
        viewCsv.setTitle("CSV v 0.3");
        viewCsv.setLocationRelativeTo(null);
        viewCsv.setVisible(true); 
    }
}
