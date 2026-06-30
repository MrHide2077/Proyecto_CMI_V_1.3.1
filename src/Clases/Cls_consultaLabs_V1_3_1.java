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
public class Cls_consultaLabs_V1_3_1{
    public static void mtd_cargarDatosA_Modelo(DefaultTableModel modeloDefault) {
        modeloDefault.setRowCount(0);
        File carpeta = new File("C:/Users/diego/OneDrive/Desktop/Ucato/Base de Datos CMI/Laboratorios");

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();

            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile() && archivo.getName().endsWith(".txt")) {
                        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

                            String linea;
                            String idInterno = "", rucRegistrosat = "", nombcomer = "", nombcontact = "";
                            String numcontact = "", email = "", sucursalDir = "";

                            while ((linea = br.readLine()) != null) {
                                if (linea.startsWith("ID Interno : ")) {
                                    idInterno = linea.split(":")[1].trim();
                                } else if (linea.startsWith("RUC/Registro Sanitario : ")) {
                                    rucRegistrosat = linea.split(":")[1].trim();
                                } else if (linea.startsWith("Nombre Comercial : ")) {
                                    nombcomer = linea.split(":")[1].trim();
                                } else if (linea.startsWith("Contacto Principal : ")) {
                                    nombcontact = linea.split(":")[1].trim();
                                } else if (linea.startsWith("Número de Contacto : ")) {
                                    numcontact = linea.split(":")[1].trim();
                                } else if (linea.startsWith("E-Mail : ")) {
                                    email = linea.split(":")[1].trim();
                                } else if (linea.startsWith("Sucursal : ")) {
                                    sucursalDir = linea.split(":")[1].trim();
                                } 
                            }

                            modeloDefault.addRow(new Object[]{
                                idInterno, rucRegistrosat, nombcomer, nombcontact, numcontact,
                                email, sucursalDir
                            });

                        } catch (Exception e) {
                            System.out.println("Error en archivo " + archivo.getName() + ": " + e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
