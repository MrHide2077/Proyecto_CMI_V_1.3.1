/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class Cls_ConsultaIngresosMes extends Cls_emitirFactura_CMI_V_1_3_1 implements int_GBE_CMI_V1_3_1 {

    private ArrayList<Cls_emitirFactura_CMI_V_1_3_1> listaFacturasFiltro;
    private double CIM_totalFacturado;
    private double CIM_totalRecaudado;

    public Cls_ConsultaIngresosMes() {
        super();
        this.listaFacturasFiltro = new java.util.ArrayList<>();
        this.CIM_totalFacturado = 0.0;
        this.CIM_totalRecaudado = 0.0;
    }

    public ArrayList<Cls_emitirFactura_CMI_V_1_3_1> getListaFacturasFiltro() {
        return listaFacturasFiltro;
    }

    public double getCIM_totalFacturado() {
        return CIM_totalFacturado;
    }

    public double getCIM_totalRecaudado() {
        return CIM_totalRecaudado;
    }

    public void mtd_cargarYFiltrarFacturas(String rutaCarpeta, String mesSeleccionado, String anioSeleccionado) {
        this.listaFacturasFiltro.clear();
        this.CIM_totalFacturado = 0.0;
        this.CIM_totalRecaudado = 0.0;

        String mesNumero = mesSeleccionado.trim();
        switch (mesNumero) {
            case "Enero":
                mesNumero = "/01/";
                break;
            case "Febrero":
                mesNumero = "/02/";
                break;
            case "Marzo":
                mesNumero = "/03/";
                break;
            case "Abril":
                mesNumero = "/04/";
                break;
            case "Mayo":
                mesNumero = "/05/";
                break;
            case "Junio":
                mesNumero = "/06/";
                break;
            case "Julio":
                mesNumero = "/07/";
                break;
            case "Agosto":
                mesNumero = "/08/";
                break;
            case "Septiembre":
                mesNumero = "/09/";
                break;
            case "Octubre":
                mesNumero = "/10/";
                break;
            case "Noviembre":
                mesNumero = "/11/";
                break;
            case "Diciembre":
                mesNumero = "/12/";
                break;
        }

        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        File[] archivosEncontrados = carpeta.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

        if (archivosEncontrados == null || archivosEncontrados.length == 0) {
            return;
        }

        for (File archivoFactura : archivosEncontrados) {
            Cls_emitirFactura_CMI_V_1_3_1 temporal = mtd_leerDatosFactura(archivoFactura);

            if (temporal != null && temporal.getFac_fechaEmision() != null) {
                String fecha = temporal.getFac_fechaEmision();

                if ((fecha.contains(mesSeleccionado.trim()) || fecha.contains(mesNumero)) && fecha.contains(anioSeleccionado.trim())) {
                    this.listaFacturasFiltro.add(temporal);
                    this.CIM_totalFacturado += temporal.getFac_total();
                    this.CIM_totalRecaudado += temporal.getFac_total();
                }
            }
        }
    }

    private Cls_emitirFactura_CMI_V_1_3_1 mtd_leerDatosFactura(File file) {
        Cls_emitirFactura_CMI_V_1_3_1 f = new Cls_emitirFactura_CMI_V_1_3_1();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length < 2) {
                    continue;
                }

                String etiqueta = parts[0].trim();
                String valor = parts[1].trim();

                switch (etiqueta) {
                    case "N.Factura":
                        f.setFac_idInterno(valor);
                        break;
                    case "Apellidos":
                        f.setPcs_apellidos(valor);
                        break;
                    case "Nombres":
                        f.setPcs_nombres(valor);
                        break;
                    case "CI/Pasaporte":
                        f.setPcs_CiPasaporte(valor);
                        break;
                    case "Fecha de Emisión":
                        f.setFac_fechaEmision(valor);
                        break;
                    case "Servicios":
                        f.setFac_nomServ(valor);
                        break;
                    case "TOTAL A PAGAR":
                        String limpio = valor.replace("$", "").trim();
                        double totalFactura = Double.parseDouble(limpio);

                        f.setFac_total(totalFactura);
                        f.setFac_desc(0.00);
                        f.setFac_total(totalFactura);
                        break;
                }
            }
            return f;
        } catch (IOException | NumberFormatException ex) {
            return null;
        }
    }

    
    public void mtd_actualizarTabla(DefaultTableModel modeloTabla) {
        modeloTabla.setRowCount(0); // Limpiar filas previas
        for (Cls_emitirFactura_CMI_V_1_3_1 f : listaFacturasFiltro) {
            modeloTabla.addRow(new Object[]{
                f.getFac_idInterno(),
                f.getFac_fechaEmision(),
                f.getPcs_CiPasaporte(),
                f.getPcs_apellidos() + " " + f.getPcs_nombres(),
                "$ " + String.format("%.2f", f.getFac_total())
            });
        }
    }

    
    public boolean mtd_eliminarFacturaAdmin(String rutaCarpeta, String idFactura, String claveIngresada) {
        if (!claveIngresada.equals("2903")) {
            JOptionPane.showMessageDialog(null, "Acceso Denegado: Contraseña de administrador incorrecta.", "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        File carpeta = new File(rutaCarpeta);
        File[] archivos = carpeta.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

        if (archivos != null) {
            for (File f : archivos) {
                if (f.getName().contains(idFactura) || mtd_verificarIdArchivo(f, idFactura)) {
                    if (f.delete()) {
                        JOptionPane.showMessageDialog(null, "Factura " + idFactura + " eliminada correctamente del registro físico.");
                        return true;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el archivo físico de la factura seleccionada.", "Error", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    
    private boolean mtd_verificarIdArchivo(File f, String idFactura) {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("N.Factura") && line.contains(idFactura)) {
                    return true;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
}
