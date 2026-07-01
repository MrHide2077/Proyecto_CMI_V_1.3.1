/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author diego
 */
public class Cls_consultaPacientes_V_1_3_1 {

    public static void mtd_cargarDatosA_Modelo(DefaultTableModel modeloDefault) {
        modeloDefault.setRowCount(0);
        File carpeta = new File("C:/Users/diego/OneDrive/Desktop/Ucato/Base de Datos CMI/Pacientes");

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();

            if (archivos != null) {
                for (File archivo : archivos) {
                    if (archivo.isFile() && archivo.getName().endsWith(".txt")) {
                        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

                            String linea;
                            String idInterno = "", ciPasaporte = "", apellidos = "", nombres = "";
                            String genero = "", fechaNacimiento = "", telefono = "", correo = "";
                            String observa = "", tipoPaciente = "";

                            while ((linea = br.readLine()) != null) {
                                if (linea.startsWith("ID Interno :")) {
                                    idInterno = linea.split(":")[1].trim();
                                } else if (linea.startsWith("Cédula/Pasaporte :")) {
                                    ciPasaporte = linea.split(":")[1].trim();
                                } else if (linea.startsWith("Apellidos :")) {
                                    apellidos = linea.split(":")[1].trim();
                                } else if (linea.startsWith("Nombres :")) {
                                    nombres = linea.split(":")[1].trim();
                                } else if (linea.startsWith("Género :")) {
                                    genero = linea.split(":")[1].trim();
                                } else if (linea.startsWith("Fecha de Nacimiento :")) {
                                    fechaNacimiento = linea.split(":")[1].trim();
                                } else if (linea.startsWith("Teléfono :")) {
                                    telefono = linea.split(":")[1].trim();
                                } else if (linea.startsWith("E-Mail :")) {
                                    correo = linea.split(":")[1].trim();
                                } else if (linea.startsWith("Observaciones :")) {
                                    observa = linea.split(":")[1].trim();
                                } else if (linea.startsWith("Tipo de Paciente :")) {
                                    tipoPaciente = linea.split(":")[1].trim();
                                }
                            }

                            modeloDefault.addRow(new Object[]{
                                idInterno, ciPasaporte, apellidos, nombres, genero,
                                fechaNacimiento, telefono, correo, observa, tipoPaciente
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
