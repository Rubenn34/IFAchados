/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import dominio.Usuario;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author Saintzada
 */
public class UsuarioDAO {

    public Usuario autenticar(String matricula, String senha) {

    String sql = "SELECT * FROM usuario WHERE matricula=? AND senha=?";

    try (Connection con = Conexao.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, matricula);
        ps.setString(2, senha);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Usuario u = new Usuario();
            u.setMatricula(rs.getString("matricula"));
            u.setNome(rs.getString("nome"));
            return u;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}

 
 public void salvar(Usuario u) {

        String sql = "INSERT INTO usuario (matricula, nome, email, senha, tipo) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getMatricula());
            ps.setString(2, u.getNome());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getSenha());
            ps.setString(5, u.getTipo());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

      


