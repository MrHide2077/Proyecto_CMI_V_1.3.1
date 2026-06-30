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
public class Cls_registroPacientesV_3_1 implements int_GBE_CMI_V1_3_1 {

    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    FileWriter escribir;
    PrintWriter linea;

    private String pcs_idInterno;
    private String pcs_CiPasaporte;
    private String pcs_apellidos;
    private String pcs_nombres;
    private String pcs_genero;
    private String pcs_fechaNacimiento;
    private String pcs_telefono;
    private String pcs_correo;
    private String pcs_observa;
    private String pcs_tipoPaciente;
    private Random aleatorio = new Random();

    public Cls_registroPacientesV_3_1() {
    }

    public Cls_registroPacientesV_3_1(String pcs_CiPasaporte, String pcs_apellidos, String pcs_nombres, String pcs_genero, String pcs_fechaNacimiento, String pcs_telefono, String pcs_correo, String pcs_observa, String pcs_tipoPaciente) {
        int idUnico = aleatorio.nextInt(9999) + 10000;

        this.pcs_idInterno = "Pcs_" + idUnico;
        this.pcs_CiPasaporte = pcs_CiPasaporte;
        this.pcs_apellidos = pcs_apellidos;
        this.pcs_nombres = pcs_nombres;
        this.pcs_genero = pcs_genero;
        this.pcs_fechaNacimiento = pcs_fechaNacimiento;
        this.pcs_telefono = pcs_telefono;
        this.pcs_correo = pcs_correo;
        this.pcs_observa = pcs_observa;
        this.pcs_tipoPaciente = pcs_tipoPaciente;
    }

    public Cls_registroPacientesV_3_1(String pcs_idInterno, String pcs_CiPasaporte, String pcs_apellidos, String pcs_nombres, String pcs_genero, String pcs_fechaNacimiento, String pcs_telefono, String pcs_correo, String pcs_observa, String pcs_tipoPaciente) {
        this.pcs_idInterno = pcs_idInterno;
        this.pcs_CiPasaporte = pcs_CiPasaporte;
        this.pcs_apellidos = pcs_apellidos;
        this.pcs_nombres = pcs_nombres;
        this.pcs_genero = pcs_genero;
        this.pcs_fechaNacimiento = pcs_fechaNacimiento;
        this.pcs_telefono = pcs_telefono;
        this.pcs_correo = pcs_correo;
        this.pcs_observa = pcs_observa;
        this.pcs_tipoPaciente = pcs_tipoPaciente;
    }

    //Getters
    public Random getAleatorio() {
        return aleatorio;
    }

    public String getPcs_idInterno() {
        return pcs_idInterno;
    }

    public String getPcs_CiPasaporte() {
        return pcs_CiPasaporte;
    }

    public String getPcs_apellidos() {
        return pcs_apellidos;
    }

    public String getPcs_nombres() {
        return pcs_nombres;
    }

    public String getPcs_genero() {
        return pcs_genero;
    }

    public String getPcs_fechaNacimiento() {
        return pcs_fechaNacimiento;
    }

    public String getPcs_telefono() {
        return pcs_telefono;
    }

    public String getPcs_correo() {
        return pcs_correo;
    }

    public String getPcs_observa() {
        return pcs_observa;
    }

    public String getPcs_tipoPaciente() {
        return pcs_tipoPaciente;
    }

    //Setters
    public void setPcs_idInterno(String pcs_idInterno) {
        this.pcs_idInterno = pcs_idInterno;
    }

    public void setPcs_CiPasaporte(String pcs_CiPasaporte) {
        this.pcs_CiPasaporte = pcs_CiPasaporte;
    }

    public void setPcs_apellidos(String pcs_apellidos) {
        this.pcs_apellidos = pcs_apellidos;
    }

    public void setPcs_nombres(String pcs_nombres) {
        this.pcs_nombres = pcs_nombres;
    }

    public void setPcs_genero(String pcs_genero) {
        this.pcs_genero = pcs_genero;
    }

    public void setPcs_fechaNacimiento(String pcs_fechaNacimiento) {
        this.pcs_fechaNacimiento = pcs_fechaNacimiento;
    }

    public void setPcs_telefono(String pcs_telefono) {
        this.pcs_telefono = pcs_telefono;
    }

    public void setPcs_correo(String pcs_correo) {
        this.pcs_correo = pcs_correo;
    }

    public void setPcs_observa(String pcs_observa) {
        this.pcs_observa = pcs_observa;
    }

    public void setPcs_tipoPaciente(String pcs_tipoPaciente) {
        this.pcs_tipoPaciente = pcs_tipoPaciente;
    }

    public void setAleatorio(Random aleatorio) {
        this.aleatorio = aleatorio;
    }

    @Override
    public boolean mtd_guardar() {
        boolean ban = false;

        String nombreSugerido = this.getPcs_idInterno() + ".txt";
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

                linea.println("ID Interno : " + this.getPcs_idInterno());
                linea.println("Cédula/Pasaporte : " + this.getPcs_CiPasaporte());
                linea.println("Apellidos : " + this.getPcs_apellidos());
                linea.println("Nombres : " + this.getPcs_nombres());
                linea.println("Género : " + this.getPcs_genero());
                linea.println("Fecha de Nacimiento : " + this.getPcs_fechaNacimiento());
                linea.println("Teléfono : " + this.getPcs_telefono());
                linea.println("E-Mail : " + this.getPcs_correo());
                linea.println("Observaciones : " + this.getPcs_observa());
                linea.println("Tipo de Paciente : " + this.getPcs_tipoPaciente());

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
                    if (parts[0].trim().equals("ID Interno")) {
                        this.setPcs_idInterno(parts[1]);
                    } else if (parts[0].trim().equals("Cédula/Pasaporte")) {
                        this.setPcs_CiPasaporte(parts[1]);
                    } else if (parts[0].trim().equals("Apellidos")) {
                        this.setPcs_apellidos(parts[1]);
                    } else if (parts[0].trim().equals("Nombres")) {
                        this.setPcs_nombres(parts[1]);
                    } else if (parts[0].trim().equals("Fecha de Nacimiento")) {
                        this.setPcs_fechaNacimiento(parts[1]);
                    } else if (parts[0].trim().equals("Género")) {
                        this.setPcs_genero(parts[1]);
                    } else if (parts[0].trim().equals("Teléfono")) {
                        this.setPcs_telefono(parts[1]);
                    } else if (parts[0].trim().equals("E-Mail")) {
                        this.setPcs_correo(parts[1]);
                    } else if (parts[0].trim().equals("Observaciones")) {
                        this.setPcs_observa(parts[1]);
                    } else if (parts[0].trim().equals("Tipo de Paciente")) {
                        this.setPcs_tipoPaciente(parts[1]);
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
