/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author aluno
 */
public class socio {
    private int idSocio;
private String nome;
private String cpf;
private String endereco;
private String cei;
private String rgp;
private String datanasc;
private String nit;
private String rg;

public socio() {
    
}

    public socio(int idSocio, String nome, String cpf, String endereco, String cei, String rgp, String datanasc, String nit, String rg) {
        this.idSocio = idSocio;
        this.nome = nome;
        this.cpf = cpf;
        this.cei = cei;
        this.datanasc = datanasc;
        this.endereco = endereco;
        this.nit = nit;
        this.rg = rg;
        this.rgp = rgp;
        
        
                }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCei() {
        return cei;
    }

    public void setCei(String cei) {
        this.cei = cei;
    }

    public String getRgp() {
        return rgp;
    }

    public void setRgp(String rgp) {
        this.rgp = rgp;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return  nome ;
    }

    public void getDatanasc(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
