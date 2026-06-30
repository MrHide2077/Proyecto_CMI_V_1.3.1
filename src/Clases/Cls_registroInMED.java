/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author diego
 */
public class Cls_registroInMED implements int_GBE_CMI_V1_3_1{

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
    private Random aleatorio=new Random();

    public Cls_registroInMED() {
    }

    public Cls_registroInMED(String InMED_nombComer, String InMED_prinAct, String InMED_lab, String InMED_present, String InMED_unitDosis, LocalDate InMED_fechaIngreso, LocalDate InMED_fechaVence, String InMed_loteInt, String InMed_loteFab, Double InMed_cant) {
        int idUnico=aleatorio.nextInt(9999)+10000;
        
        this.InMED_idInterno="MED_"+aleatorio;
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

    public Cls_registroInMED(String InMED_idInterno, String InMED_nombComer, String InMED_prinAct, String InMED_lab, String InMED_present, String InMED_unitDosis, LocalDate InMED_fechaIngreso, LocalDate InMED_fechaVence, String InMed_loteInt, String InMed_loteFab, Double InMed_cant) {
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean mtd_buscar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean mtd_eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
