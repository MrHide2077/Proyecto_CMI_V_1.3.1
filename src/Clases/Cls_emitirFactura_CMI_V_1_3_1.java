/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
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
public class Cls_emitirFactura_CMI_V_1_3_1 extends Cls_registroPacientesV_3_1 implements int_GBE_CMI_V1_3_1{
    //Cabecera
    private String fac_idInterno;
    private String fac_fechaEmision;
    private double fac_subt;
    private double fac_desc;
    private double fac_total;
    //Detalles
    private String fact_numServ;
    private String fac_nomServ;
    private String fac_cantServ;
    private double fac_precioServ;
    
    private Random registroAleatorio = new Random();

    public Cls_emitirFactura_CMI_V_1_3_1() {
        super();
    }

    public Cls_emitirFactura_CMI_V_1_3_1(String fac_idInterno, String fac_fechaEmision, double fac_desc, String fact_numServ, String fac_nomServ, String fac_cantServ, double fac_precioServ, String pcs_numIden, String pcs_apellidos, String pcs_nombres, String pcs_fechaNacimiento, String pcs_genero, String pcs_contacto, String pcs_correo, String pcs_observaciones, String pcs_tipoPaciente) {
        super(pcs_numIden, pcs_apellidos, pcs_nombres, pcs_fechaNacimiento, pcs_genero, pcs_contacto, pcs_correo, pcs_observaciones, pcs_tipoPaciente);
        int identificador = registroAleatorio.nextInt(90000) + 10000;
        
        this.fac_idInterno = "Fct_"+identificador;
        this.fac_fechaEmision = fac_fechaEmision;
        this.fac_desc = fac_desc;
        this.fact_numServ = fact_numServ;
        this.fac_nomServ = fac_nomServ;
        this.fac_cantServ = fac_cantServ;
        this.fac_precioServ = fac_precioServ;
    }

    public Cls_emitirFactura_CMI_V_1_3_1(String fac_nomServ, String fac_cantServ, double fac_precioServ) {
        super(); 
        this.fac_nomServ = fac_nomServ;
        this.fac_cantServ = fac_cantServ;
        this.fac_precioServ = fac_precioServ;
    }
    
    //Getters cabecera y detalles
    public String getFac_idInterno() {return fac_idInterno;}
    public String getFac_fechaEmision() {return fac_fechaEmision;}
    public double getFac_subt() {
        try{
            int cantidad=Integer.parseInt(this.fac_cantServ.trim());
            this.fac_subt=cantidad*this.fac_precioServ;
        }catch(NumberFormatException e){
            this.fac_subt=0;
        }
        return this.fac_subt;
    }
    public double getFac_desc() {return fac_desc;}
    public double getFac_total() {
        if (this.fac_total > 0) {
            return this.fac_total;
        }
        this.fac_total = getFac_subt() - this.fac_desc;
        return this.fac_total;
    }
    public String getFact_numServ() {return fact_numServ;}
    public String getFac_nomServ() {return fac_nomServ;}
    public String getFac_cantServ() {return fac_cantServ;}
    public double getFac_precioServ() {return fac_precioServ;}
    
    //Setters cabecera y detalles
    public void setFac_idInterno(String fac_idInterno) {this.fac_idInterno = fac_idInterno;}
    public void setFac_fechaEmision(String fac_fechaEmision) {this.fac_fechaEmision = fac_fechaEmision;}
    public void setFac_desc(double fac_desc) {this.fac_desc = fac_desc;}
    public void setFact_numServ(String fact_numServ) {this.fact_numServ = fact_numServ;}
    public void setFac_nomServ(String fac_nomServ) {this.fac_nomServ = fac_nomServ;}
    public void setFac_cantServ(String fac_cantServ) {this.fac_cantServ = fac_cantServ;}
    public void setFac_precioServ(double fac_precioServ) {this.fac_precioServ = fac_precioServ;}
    public void setFac_total(double fac_total) {this.fac_total = fac_total;}

    
    @Override
public boolean mtd_guardar() {
    boolean ban = false;
    if (seleccionado.showDialog(null, "Guardar Archivo .txt") == JFileChooser.APPROVE_OPTION) {
        archivo = seleccionado.getSelectedFile();
        
        // ✨ OPTIMIZACIÓN: Si el archivo no termina en .txt se lo agrega automáticamente
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

            linea.println("==========================================================");
            linea.println("                CENTRO MÉDICO INTEGRAL (CMI)              ");
            linea.println("         Dirección: Vargas Machuca, Cuenca, Ecuador       ");
            linea.println("          Telf: 098 780 6534  /  +593 98 780 6534         ");
            linea.println("==========================================================");
            linea.println("                FACTURA / COMPROBANTE DE PAGO             ");
            linea.println("==========================================================");
            linea.println(" N.Factura      : " + this.getFac_idInterno());
            linea.println(" Fecha de Emisión: " + this.getFac_fechaEmision());
            linea.println("==========================================================");
            linea.println(" DATOS DEL PACIENTE / CLIENTE                             ");
            linea.println("----------------------------------------------------------");
            linea.println(" Nombres        : " + this.getPcs_nombres());
            linea.println(" Apellidos      : " + this.getPcs_apellidos());
            linea.println(" CI/Pasaporte   : " + this.getPcs_CiPasaporte());
            linea.println("----------------------------------------------------------");
            linea.println(" DETALLE DE SERVICIOS ADQUIRIDOS                          ");
            linea.println("----------------------------------------------------------");
            linea.println(" Servicios      : " + this.getFac_nomServ()); 
            linea.println("----------------------------------------------------------");
            linea.println(" TOTAL A PAGAR  : $" + this.getFac_total());
            linea.println("==========================================================");
            linea.println(" Horarios de Atención CMI:                                ");
            linea.println(" Lun - Vie: 8 AM - 7 PM  |  Sáb: 8 AM - 12 PM             ");
            linea.println("----------------------------------------------------------");
            linea.println("       Powered by Bio_InGen - Mr Hyde Industries          ");
            linea.println("==========================================================");

            linea.close();
            escribir.close();
            ban = true;

            JOptionPane.showMessageDialog(null, "Archivo guardado correctamente");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
            ban = false;
        }
    } else {
        ban = false;
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
                
                if (parts.length < 2) continue; 
                
                String etiqueta = parts[0].trim();
                String valor = parts[1].trim();
                
                if (etiqueta.equals("N.Factura")) {
                    this.setFac_idInterno(valor);
                } else if (etiqueta.equals("Apellidos")) {
                    this.setPcs_apellidos(valor);
                } else if (etiqueta.equals("Nombres")) {
                    this.setPcs_nombres(valor);
                } else if (etiqueta.equals("Cédula/Pasaporte")) {
                    this.setPcs_CiPasaporte(valor);
                } else if (etiqueta.equals("Fecha de Emision")) {
                    this.setFac_fechaEmision(valor);
                } else if (etiqueta.equals("Servicios")) {
                    this.setFac_nomServ(valor);
                } else if (etiqueta.equals("Total")) {
                    this.setFac_total(Double.parseDouble(valor));
                } 
            }
            reader.close();
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
