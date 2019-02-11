/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.ConnectionFactory;
import model.bean.socio;

/**
 *
 * @author aluno
 */
public class SocioDAO_1 {

    public void inserir(socio soc) {
        
        Connection connection = null;
        try {
      
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO socio (idSocio, nome, datanasc, cpf, rgp, cei, nit, endereco, rg) VALUES (?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, soc.getIdSocio());
            pstmt.setString(2, soc.getNome() );
            pstmt.setString(3, soc.getDatanasc());
            pstmt.setString(4, soc.getCpf());
            pstmt.setString(5, soc.getRgp());
            pstmt.setString(6, soc.getCei());
            pstmt.setString(7, soc.getNit());
            pstmt.setString(8, soc.getEndereco());
            pstmt.setString(9, soc.getRg());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Socio inserido.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }

    public void alterar(socio soc) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement("UPDATE socio set rg=?,nome=?,datanasc=?,cpf=?,rgp=?,cei=?,nit=?,endereco=? where idSocio=?");
            pstmt.setString(1, soc.getRg());
            pstmt.setString(2, soc.getNome());
            pstmt.setString(3, soc.getDatanasc());
            pstmt.setString(4, soc.getCpf());
            pstmt.setString(5, soc.getRgp());
            pstmt.setString(6, soc.getCei());
            pstmt.setString(7, soc.getNit());
            pstmt.setString(8, soc.getEndereco());
            
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Socio alterado.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }

    public void deletar(socio soc) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();

            PreparedStatement pstmt = connection
                    .prepareStatement("DELETE FROM Socio WHERE idSocio=?");
            pstmt.setInt(1, soc.getIdSocio());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Socio removido!");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu!");
            e.printStackTrace();
        }
    }

    public socio buscar(int nome) {
        Connection connection = null;
        socio soc = new socio();
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM Socio where nome = ?");
            pstmt.setInt(1, nome);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                soc.setIdSocio(rs.getInt(1));
                soc.setNome(rs.getString("nome"));
                soc.setDatanasc(rs.getString("data de nascimento"));
                soc.setCpf(rs.getString("cpf"));
                soc.setRgp(rs.getString("rgp"));
                soc.setCei(rs.getString("cei"));
                soc.setNit(rs.getString("nit"));
                soc.setEndereco(rs.getString("endereco"));
                soc.setRg(rs.getString("rg"));
                
            }
            connection.close();
            return soc;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<socio> listar() {

        Connection connection = null;
        List<socio> socios = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Socio");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                socio soc = new socio();
                soc.setIdSocio(rs.getInt("idSocio"));
                soc.setNome(rs.getString("nome"));
                soc.setDatanasc(rs.getString("datanasc"));
                soc.setCpf(rs.getString("cpf"));
                soc.setRgp(rs.getString("rgp"));
                soc.setCei(rs.getString("cei"));
                soc.setNit(rs.getString("nit"));
                soc.setEndereco(rs.getString("endereco"));
                soc.setRg(rs.getString("rg"));
                
                
                socios.add(soc);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return socios;
    }
}