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
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Cls_registroLaboratorios_V1_3_1 implements int_GBE_CMI_V1_3_1 {

    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    FileWriter escribir;
    PrintWriter linea;

    //Datos laboratorios
    private String lb_idInterno;
    private String lb_ruc;
    private String lb_nombreComercal;
    private String lb_contactoPrincipal;
    private String lb_numContactoPrinci;
    private String lb_correo;
    private String lb_sucursal;

    private Random aleatorio = new Random();

    public Cls_registroLaboratorios_V1_3_1() {
    }

    public Cls_registroLaboratorios_V1_3_1(String lb_ruc, String lb_nombreComercal, String lb_contactoPrincipal, String lb_numContactoPrinci, String lb_correo, String lb_sucursal) {
        int idUnico = aleatorio.nextInt(9999) + 10000;

        this.lb_idInterno = "lb_" + idUnico;
        this.lb_ruc = lb_ruc;
        this.lb_nombreComercal = lb_nombreComercal;
        this.lb_contactoPrincipal = lb_contactoPrincipal;
        this.lb_numContactoPrinci = lb_numContactoPrinci;
        this.lb_correo = lb_correo;
        this.lb_sucursal = lb_sucursal;
    }

    public Cls_registroLaboratorios_V1_3_1(String lb_idInterno, String lb_ruc, String lb_nombreComercal, String lb_contactoPrincipal, String lb_numContactoPrinci, String lb_correo, String lb_sucursal) {
        this.lb_idInterno = lb_idInterno;
        this.lb_ruc = lb_ruc;
        this.lb_nombreComercal = lb_nombreComercal;
        this.lb_contactoPrincipal = lb_contactoPrincipal;
        this.lb_numContactoPrinci = lb_numContactoPrinci;
        this.lb_correo = lb_correo;
        this.lb_sucursal = lb_sucursal;
    }

    public String getLb_idInterno() {
        return lb_idInterno;
    }

    public String getLb_ruc() {
        return lb_ruc;
    }

    public String getLb_nombreComercal() {
        return lb_nombreComercal;
    }

    public String getLb_contactoPrincipal() {
        return lb_contactoPrincipal;
    }

    public String getLb_numContactoPrinci() {
        return lb_numContactoPrinci;
    }

    public String getLb_correo() {
        return lb_correo;
    }

    public String getLb_sucursal() {
        return lb_sucursal;
    }

    public Random getAleatorio() {
        return aleatorio;
    }

    public void setLb_idInterno(String lb_idInterno) {
        this.lb_idInterno = lb_idInterno;
    }

    public void setLb_ruc(String lb_ruc) {
        this.lb_ruc = lb_ruc;
    }

    public void setLb_nombreComercal(String lb_nombreComercal) {
        this.lb_nombreComercal = lb_nombreComercal;
    }

    public void setLb_contactoPrincipal(String lb_contactoPrincipal) {
        this.lb_contactoPrincipal = lb_contactoPrincipal;
    }

    public void setLb_numContactoPrinci(String lb_numContactoPrinci) {
        this.lb_numContactoPrinci = lb_numContactoPrinci;
    }

    public void setLb_correo(String lb_correo) {
        this.lb_correo = lb_correo;
    }

    public void setLb_sucursal(String lb_sucursal) {
        this.lb_sucursal = lb_sucursal;
    }

    public void setAleatorio(Random aleatorio) {
        this.aleatorio = aleatorio;
    }

    @Override
    public boolean mtd_guardar() {
        boolean ban = false;

        String nombreSugerido = this.getLb_idInterno() + ".txt";
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

                linea.println("ID Interno : " + this.getLb_idInterno());
                linea.println("RUC/Registro Sanitario : " + this.getLb_ruc());
                linea.println("Nombre Comercial : " + this.getLb_nombreComercal());
                linea.println("Contacto Principal : " + this.getLb_contactoPrincipal());
                linea.println("Número de Contacto : " + this.getLb_numContactoPrinci());
                linea.println("E-Mail : " + this.getLb_correo());
                linea.println("Sucursal : " + this.getLb_sucursal());

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
                    String[] parts = line.split(":");
                    if (parts.length < 2) {
                        continue; // Evita errores si la línea está vacía
                    }
                    // Limpiamos los espacios extras de la etiqueta y del valor
                    String etiqueta = parts[0].trim();
                    String valor = parts[1].trim();

                    if (etiqueta.equals("ID Interno")) {
                        this.setLb_idInterno(valor);
                    } else if (etiqueta.equals("RUC/Registro Sanitario")) {
                        this.setLb_ruc(valor);
                    } else if (etiqueta.equals("Nombre Comercial")) {
                        this.setLb_nombreComercal(valor);
                    } else if (etiqueta.equals("Contacto Principal")) {
                        this.setLb_contactoPrincipal(valor); // ✨ CORREGIDO: Ya no sobrescribe el nombre comercial
                    } else if (etiqueta.equals("Número de Contacto") || etiqueta.equals("Número de Contacto Prinicipal")) {
                        this.setLb_numContactoPrinci(valor); // ✨ CORREGIDO: Acepta ambas variaciones por si acaso
                    } else if (etiqueta.equals("E-Mail")) {
                        this.setLb_correo(valor);
                    } else if (etiqueta.equals("Sucursal")) {
                        this.setLb_sucursal(valor);
                    }
                }
                reader.close();
            } else {
                ban = false;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al leer el Archivo");
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
