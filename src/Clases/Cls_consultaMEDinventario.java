/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class Cls_consultaMEDinventario {

    public static void mtd_cargarDatosA_Modelo(DefaultTableModel modeloDefault) {
        modeloDefault.setRowCount(0);
        
        // Carpeta origen de los archivos de texto
        File carpeta = new File("C:/Users/diego/OneDrive/Desktop/Ucato/Base de Datos CMI/Inventarios/Muestras Médicas");

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();

            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile() && archivo.getName().endsWith(".txt")) {
                        
                        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

                            String linea;
                            String idInterno = "", nombComer = "", princAct = "", lab = "";
                            String present = "", unitDosis = "", fechaIngre = "", fechaVence = "";
                            String loteInt = "", loteFab = "", stock = "";

                            while ((linea = br.readLine()) != null) {
                                // Separamos por el primer par de dos puntos
                                String[] parts = linea.split(":", 2);
                                if (parts.length < 2) {
                                    continue;
                                }

                                String etiqueta = parts[0].trim();
                                String valor = parts[1].trim();

                                // CORRECCIÓN DEFINITIVA: Filtro flexible con .contains()
                                if (etiqueta.contains("ID Interno")) {
                                    idInterno = valor;
                                } else if (etiqueta.contains("Nombre Comercial")) {
                                    nombComer = valor;
                                } else if (etiqueta.contains("Principio Activo")) {
                                    princAct = valor;
                                } else if (etiqueta.contains("Laboratorio")) {
                                    lab = valor;
                                } else if (etiqueta.contains("Presentación")) {
                                    present = valor;
                                } else if (etiqueta.contains("Unidades/Dosis")) {
                                    unitDosis = valor;
                                } else if (etiqueta.contains("Fecha de Ingreso")) {
                                    fechaIngre = valor;
                                } else if (etiqueta.contains("Fecha de Vencimiento")) {
                                    fechaVence = valor;
                                } else if (etiqueta.contains("Lote Interno")) {
                                    loteInt = valor;
                                } else if (etiqueta.contains("Lote de Fabricante")) {
                                    loteFab = valor;
                                } else if (etiqueta.contains("Stock")) {
                                    stock = valor;
                                }
                            }

                            // Agregamos la fila al modelo de la JTable
                            modeloDefault.addRow(new Object[]{
                                idInterno, nombComer, princAct, lab, present,
                                unitDosis, fechaIngre, fechaVence, loteInt, loteFab,
                                stock
                            });

                        } catch (Exception e) {
                            System.out.println("Error procesando archivo " + archivo.getName() + ": " + e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
