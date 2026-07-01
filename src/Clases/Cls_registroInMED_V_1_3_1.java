/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Cls_registroInMED_V_1_3_1 implements int_GBE_CMI_V1_3_1 {

    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    FileWriter escribir;
    PrintWriter linea;

    private String InMED_idInterno;
    private String InMED_nombComer;
    private String InMED_prinAct;
    private String InMED_lab;
    private String InMED_present;
    private String InMED_unitDosis;
    private LocalDate InMED_fechaIngreso;
    private LocalDate InMED_fechaVence;
    private String InMed_loteInt;
    private String InMed_loteFab;
    private Double InMed_cant;
    private Random aleatorio = new Random();

    public Cls_registroInMED_V_1_3_1() {
    }

    public Cls_registroInMED_V_1_3_1(String InMED_nombComer, String InMED_prinAct, String InMED_lab, String InMED_present, String InMED_unitDosis, LocalDate InMED_fechaIngreso, LocalDate InMED_fechaVence, String InMed_loteInt, String InMed_loteFab, Double InMed_cant) {
        int idUnico = aleatorio.nextInt(9999) + 10000;

        this.InMED_idInterno = "MED_" + idUnico;
        this.InMED_nombComer = InMED_nombComer;
        this.InMED_prinAct = InMED_prinAct;
        this.InMED_lab = InMED_lab;
        this.InMED_present = InMED_present;
        this.InMED_unitDosis = InMED_unitDosis;
        this.InMED_fechaIngreso = InMED_fechaIngreso;
        this.InMED_fechaVence = InMED_fechaVence;
        this.InMed_loteInt = InMed_loteInt;
        this.InMed_loteFab = InMed_loteFab;
        this.InMed_cant = InMed_cant;
    }

    public Cls_registroInMED_V_1_3_1(String InMED_idInterno, String InMED_nombComer, String InMED_prinAct, String InMED_lab, String InMED_present, String InMED_unitDosis, LocalDate InMED_fechaIngreso, LocalDate InMED_fechaVence, String InMed_loteInt, String InMed_loteFab, Double InMed_cant) {
        this.InMED_idInterno = InMED_idInterno;
        this.InMED_nombComer = InMED_nombComer;
        this.InMED_prinAct = InMED_prinAct;
        this.InMED_lab = InMED_lab;
        this.InMED_present = InMED_present;
        this.InMED_unitDosis = InMED_unitDosis;
        this.InMED_fechaIngreso = InMED_fechaIngreso;
        this.InMED_fechaVence = InMED_fechaVence;
        this.InMed_loteInt = InMed_loteInt;
        this.InMed_loteFab = InMed_loteFab;
        this.InMed_cant = InMed_cant;
    }

    //Getters
    public String getInMED_idInterno() {
        return InMED_idInterno;
    }

    public String getInMED_nombComer() {
        return InMED_nombComer;
    }

    public String getInMED_prinAct() {
        return InMED_prinAct;
    }

    public String getInMED_lab() {
        return InMED_lab;
    }

    public String getInMED_present() {
        return InMED_present;
    }

    public String getInMED_unitDosis() {
        return InMED_unitDosis;
    }

    public LocalDate getInMED_fechaIngreso() {
        return InMED_fechaIngreso;
    }

    public LocalDate getInMED_fechaVence() {
        return InMED_fechaVence;
    }

    public String getInMed_loteInt() {
        return InMed_loteInt;
    }

    public String getInMed_loteFab() {
        return InMed_loteFab;
    }

    public Double getInMed_cant() {
        return InMed_cant;
    }

    //Setters
    public void setInMED_idInterno(String InMED_idInterno) {
        this.InMED_idInterno = InMED_idInterno;
    }

    public void setInMED_nombComer(String InMED_nombComer) {
        this.InMED_nombComer = InMED_nombComer;
    }

    public void setInMED_prinAct(String InMED_prinAct) {
        this.InMED_prinAct = InMED_prinAct;
    }

    public void setInMED_lab(String InMED_lab) {
        this.InMED_lab = InMED_lab;
    }

    public void setInMED_present(String InMED_present) {
        this.InMED_present = InMED_present;
    }

    public void setInMED_unitDosis(String InMED_unitDosis) {
        this.InMED_unitDosis = InMED_unitDosis;
    }

    public void setInMED_fechaIngreso(LocalDate InMED_fechaIngreso) {
        this.InMED_fechaIngreso = InMED_fechaIngreso;
    }

    public void setInMED_fechaVence(LocalDate InMED_fechaVence) {
        this.InMED_fechaVence = InMED_fechaVence;
    }

    public void setInMed_loteInt(String InMed_loteInt) {
        this.InMed_loteInt = InMed_loteInt;
    }

    public void setInMed_loteFab(String InMed_loteFab) {
        this.InMed_loteFab = InMed_loteFab;
    }

    public void setInMed_cant(Double InMed_cant) {
        this.InMed_cant = InMed_cant;
    }

    @Override
    public boolean mtd_guardar() {
        boolean ban = false;

        String nombreSugerido = this.getInMED_idInterno() + ".txt";
        seleccionado.setSelectedFile(new java.io.File(nombreSugerido));

        if (seleccionado.showDialog(null, "Guardar Archivo .txt") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();

            if (!archivo.getName().endsWith(".txt")) {
                archivo = new java.io.File(archivo.getParentFile(), archivo.getName() + ".txt");
            }
            if (archivo.exists()) {
                archivo.delete();
            }
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);

                linea.println("ID Interno : " + this.getInMED_idInterno());
                linea.println("Nombre Comercial : " + this.getInMED_nombComer());
                linea.println("Principio Activo : " + this.getInMED_prinAct());
                linea.println("Laboratorio : " + this.getInMED_lab());
                linea.println("Presentación : " + this.getInMED_present());
                linea.println("Unidades/Dosis : " + this.getInMED_unitDosis());
                linea.println("Fecha de Ingreso : " + this.getInMED_fechaIngreso());
                linea.println("Fecha de Vencimiento : " + this.getInMED_fechaVence());
                linea.println("Lote Interno : " + this.getInMed_loteInt());
                linea.println("Lote de Fabricante : " + this.getInMed_loteFab());
                linea.println("Stock : " + this.getInMed_cant());

                ban = true;
                JOptionPane.showMessageDialog(null, "Archivo guardado correctamente");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
                ban = false;
            } finally {
                try {
                    if (linea != null) {
                        linea.close();
                    }
                    if (escribir != null) {
                        escribir.close();
                    }
                } catch (IOException e) {
                    System.err.println("Error al cerrar los flujos: " + e.getMessage());
                }
            }
        }
        return ban;
    }

    @Override
    public boolean mtd_buscar() {
        boolean ban = true;
        try {
            if (seleccionado.showDialog(null, "Abrir Archivo .txt") == JFileChooser.APPROVE_OPTION) {
                archivo = seleccionado.getSelectedFile();
                FileReader reader = new FileReader(archivo);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.split(":", 2);
                    if (parts.length < 2) {
                        continue;
                    }

                    String etiqueta = parts[0].trim();
                    String valor = parts[1].trim();

                    if (etiqueta.equals("ID Interno")) {
                        this.setInMED_idInterno(valor);
                    } else if (etiqueta.equals("Nombre Comercial")) {
                        this.setInMED_nombComer(valor);
                    } else if (etiqueta.equals("Principio Activo")) {
                        this.setInMED_prinAct(valor);
                    } else if (etiqueta.equals("Laboratorio")) { 
                        this.setInMED_lab(valor);
                    } else if (etiqueta.equals("Presentación")) {
                        this.setInMED_present(valor);
                    } else if (etiqueta.equals("Unidades/Dosis")) { 
                        this.setInMED_unitDosis(valor);
                    } else if (etiqueta.equals("Fecha de Ingreso")) {
                        this.setInMED_fechaIngreso(java.time.LocalDate.parse(valor));
                    } else if (etiqueta.equals("Fecha de Vencimiento")) {
                        this.setInMED_fechaVence(java.time.LocalDate.parse(valor));
                    } else if (etiqueta.equals("Lote Interno")) {
                        this.setInMed_loteInt(valor);
                    } else if (etiqueta.equals("Lote de Fabricante")) {
                        this.setInMed_loteFab(valor);
                    } else if (etiqueta.equals("Stock")) {
                        this.setInMed_cant(Double.parseDouble(valor));
                    }
                }
                reader.close();
            } else {
                ban = false;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el Archivo");
            ban = false;
        } catch (java.time.format.DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto en el archivo. Use AAAA-MM-DD.");
            ban = false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor de Stock no es un número válido.");
            ban = false;
        }
        return ban;
    }

    @Override
    public boolean mtd_eliminar() {
        boolean ban = false;
        if (seleccionado.showDialog(null, "Eliminar Archivo .txt") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            if (archivo.exists()) {
                archivo.delete();
                ban = true;
                JOptionPane.showMessageDialog(null, "El Archivo se elimino correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "El Archivo no Existe");
                ban = false;
            }
        } else {
            ban = false;
        }
        return ban;
    }
}
