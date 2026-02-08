/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Saintzada
 */
import dominio.MatchObjeto;
import dominio.Objeto;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ObjetoDAO {

public List<Objeto> buscarTodos() {

    List<Objeto> lista = new ArrayList<>();

    String sql =
        "SELECT id_objeto, tipo_registro, nome_objeto, " +
        "categoria, status, data_ocorrencia, local, matricula_usuario " +
        "FROM objetos";

    try (Connection con = Conexao.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Objeto o = new Objeto();
            o.setId(rs.getInt("id_objeto"));
            o.setTipoRegistro(rs.getString("tipo_registro"));
            o.setNomeObjeto(rs.getString("nome_objeto"));
            o.setCategoria(rs.getString("categoria"));
            o.setStatus(rs.getString("status"));
            o.setDataOcorrencia(rs.getString("data_ocorrencia"));
            o.setLocal(rs.getString("local"));
            o.setMatriculaUsuario(rs.getString("matricula_usuario"));

            lista.add(o);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao buscar objetos: " + e.getMessage());
    }

    return lista;
}

    
    
public void salvar(Objeto obj) throws Exception {

    String sql = "INSERT INTO objetos "
               + "(tipo_registro, nome_objeto, descricao, categoria, data_ocorrencia, local, status, matricula_usuario) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        conn = Conexao.getConnection();
        stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        stmt.setString(1, obj.getTipoRegistro());
        stmt.setString(2, obj.getNomeObjeto());
        stmt.setString(3, obj.getDescricao());
        stmt.setString(4, obj.getCategoria());
        stmt.setString(5, obj.getDataOcorrencia());
        stmt.setString(6, obj.getLocal());
        stmt.setString(7, obj.getStatus());
        stmt.setString(8, obj.getMatriculaUsuario());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            obj.setId(rs.getInt(1));
        }

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao salvar objeto", e);
    } finally {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    public List<Objeto> buscarPorTipo(String tipo) {

    List<Objeto> lista = new ArrayList<>();

    String sql = "SELECT * FROM objetos WHERE tipo_registro = ?";

    try (Connection con = Conexao.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, tipo);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Objeto o = new Objeto();
            o.setId(rs.getInt("id_objeto"));
            o.setTipoRegistro(rs.getString("tipo_registro"));
            o.setNomeObjeto(rs.getString("nome_objeto"));
            o.setCategoria(rs.getString("categoria"));
            o.setStatus(rs.getString("status"));
            o.setDataOcorrencia(rs.getString("data_ocorrencia"));
            o.setLocal(rs.getString("local"));
            o.setMatriculaUsuario(rs.getString("matricula_usuario"));

            lista.add(o);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

    
    public void gerarMatch(Objeto novo) {

    String tipoComparar = novo.getTipoRegistro().equals("Perdido")
            ? "Encontrado" : "Perdido";

    List<Objeto> lista = buscarPorTipo(tipoComparar);

    MatchObjetoDAO matchDAO = new MatchObjetoDAO();

    for (Objeto o : lista) {

        double score = 0;

        if (novo.getCategoria().equals(o.getCategoria())) score += 0.4;
        if (novo.getNomeObjeto().equals(o.getNomeObjeto())) score += 0.4;
        if (novo.getLocal().equals(o.getLocal())) score += 0.2;

        if (score >= 0.6) {
            MatchObjeto m = new MatchObjeto();
            m.setIdObjetoPerdido(
                novo.getTipoRegistro().equals("Perdido") ? novo.getId() : o.getId()
            );
            m.setIdObjetoEncontrado(
                novo.getTipoRegistro().equals("Encontrado") ? novo.getId() : o.getId()
            );
            m.setScore(score);
            m.setStatusMatch("Sugerido");

            matchDAO.salvar(m);
        }
    }
}
}



