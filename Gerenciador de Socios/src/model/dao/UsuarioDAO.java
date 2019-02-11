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
import model.bean.usuario;

/**
 *
 * @author joaog
 */
public class UsuarioDAO {

    public boolean checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;

    }
    public void inserir(usuario user) {
        
        Connection connection = null;
        try {
      
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO usuario (login, senha) VALUES (?,?)");
      
            pstmt.setString(1, user.getLogin() );
            pstmt.setString(2, user.getSenha());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Usuario inserido.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }

    public void alterar(usuario user) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection
                    .prepareStatement("UPDATE usuario set login=?,senha=? where idSocio=?");
            pstmt.setString(1, user.getLogin());
            pstmt.setString(2, user.getSenha());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Usuario alterado.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }

    public void deletaruser(usuario user) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();

            PreparedStatement pstmt = connection
                    .prepareStatement("DELETE FROM usuario WHERE IdUsuario=?");
            pstmt.setInt(1, user.getIdUsuario());
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "usuario removido.");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum erro ocorreu.");
            e.printStackTrace();
        }
    }

    public usuario buscar(int idUsuario) {
        Connection connection = null;
        usuario user = new usuario();
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT * FROM usuario where idUsuario = ?");
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user.setIdUsuario(rs.getInt(1));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                
            }
            connection.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<usuario> listar() {

        Connection connection = null;
        List<usuario> usuarios = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                usuario user = new usuario();
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                
                
                
                usuarios.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return usuarios;
    }
}
