/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import models.ModelCsv;
import views.ViewCsv;
import controllers.ControlleCsv;

/**
 *
 * @author Zeo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModelCsv modelCsv = new ModelCsv();
        ViewCsv viewCsv = new ViewCsv();
        ControlleCsv controlleCsv = new ControlleCsv(modelCsv, viewCsv);
    }
    
}
