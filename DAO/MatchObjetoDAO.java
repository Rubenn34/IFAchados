/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dominio.MatchObjeto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatchObjetoDAO {

    // ===== SALVAR MATCH =====
    public void salvar(MatchObjeto match) {

        String sql = """
            INSERT INTO match_objeto
            (id_objeto_perdido, id_objeto_encontrado, score, status_match)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, match.getIdObjetoPerdido());
            ps.setInt(2, match.getIdObjetoEncontrado());
            ps.setDouble(3, match.getScore());
            ps.setString(4, match.getStatusMatch());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar match: " + e.getMessage());
        }
    }

    // ===== BUSCAR TODOS OS MATCHES =====
    public List<MatchObjeto> buscarTodos() {

        List<MatchObjeto> lista = new ArrayList<>();

        String sql = """
            SELECT 
                m.id_match,
                op.nome_objeto AS objeto_perdido,
                oe.nome_objeto AS objeto_encontrado,
                op.categoria,
                op.local,
                m.score,
                m.status_match
            FROM match_objeto m
            JOIN objetos op ON m.id_objeto_perdido = op.id_objeto
            JOIN objetos oe ON m.id_objeto_encontrado = oe.id_objeto
            ORDER BY m.score DESC
        """;

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MatchObjeto m = new MatchObjeto();

                m.setId(rs.getInt("id_match"));
                m.setNomeObjetoPerdido(rs.getString("objeto_perdido"));
                m.setNomeObjetoEncontrado(rs.getString("objeto_encontrado"));
                m.setCategoria(rs.getString("categoria"));
                m.setLocal(rs.getString("local"));
                m.setScore(rs.getDouble("score"));
                m.setStatusMatch(rs.getString("status_match"));

                lista.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar matches: " + e.getMessage());
        }

        return lista;
    }

    // ===== ATUALIZAR STATUS =====
    public void atualizarStatus(int idMatch, String novoStatus) {

        String sql = """
            UPDATE match_objeto
            SET status_match = ?
            WHERE id_match = ?
        """;

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, novoStatus);
            ps.setInt(2, idMatch);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar status do match: " + e.getMessage());
        }
    }
}
