/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zeo
 */
public class ModelCsv {

    private String nombre;
    private String email;
    private final List data = new ArrayList<>();
    private String path = "C:\\archivos\\datos.csv";
    private int i;
    private int size;

    /**
     * Get the value of path
     * @return the value of path
     */
    private String getPath() {
        return path;
    }

    /**
     * Set the value of path
     * @param path new value of path
     */
    private void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the value of nombre
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get the value of email
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    public void leerArchivo() {
        readFile(path);
    }

    public int guardarArchivo() {
        if (path != null) {
            writeFile(path, nombre + "," + email);
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Lee un archivo de texto y guarda cada renglon en una lista
     *
     * @param path Indica la ubicación o ruta del archivo.
     */
    private void readFile(String path) {
        try {
            data.clear();
            size = 0;
            String row;
            FileReader file = new FileReader(path);
            try (BufferedReader bufferedReader = new BufferedReader(file)) {
                while ((row = bufferedReader.readLine()) != null) {
                    data.add(row);
                    size++;
                }
            }
        } catch (FileNotFoundException err) {
            System.err.println("File not found: " + err.getMessage());
        } catch (IOException err) {
            System.err.println("Error on I/O operation:  " + err.getMessage());
        } catch (NullPointerException err) {
            System.err.println("NullPointer:  " + err.getMessage());
        }
    }

    /**
     * Abre o Crea un archivo de texto y agrega una fila al final del contenido.
     *
     * @param path Indica la ubicación o ruta del archivo.
     * @param row Texto que se dedesa guardar en un archivo
     */
    private void writeFile(String path, String row) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(row);
                printWriter.flush();
                printWriter.close();
            }
        } catch (FileNotFoundException err) {
            System.err.println("File not found: " + err.getMessage());
        } catch (IOException err) {
            System.err.println("Error on I/O operation: " + err.getMessage());
        }
    }

    /**
     * Toma el texto en la posicion indicada, y separa el nombre y el email.
     * @param i Posicion del registro a leer
     */
    private void getData(int i) {
        String row[];
        row = String.valueOf(data.get(i)).split(",");
        nombre = row[0];
        email = row[1];
    }

    /**
     * Establece la posicion del registro en 0 y llama al metodo getData
     * para separar los valores de nombre y email.
     */
    public void moveFirst() {
        i = 0;
        getData(i);
    }
     /**
     * Incrementa en 1 la posicion del registro y llama al metodo getData
     * para separar los valores de nombre y email.
     */
    public void moveNext(){
        if(i+1<size)
            i++;
        getData(i);
    }
    
    /**
     * Decrementa en 1 la posicion del registro y llama al metodo getData
     * para separar los valores de nombre y email.
     */
    public void movePrevious() {
        if (i > 0) 
            i--;
        getData(i);
    }

    /**
     * Establece  la posicion del registro en 1 antes del tamaño de la lista,
     * y llama al metodo getData para separar los valores de nombre y email.
     */
    public void moveLast() {
        i = size - 1;
        getData(i);
    }
}
