/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author ruben
 */

public class MatchObjeto {

    private int id;

    // IDs (uso interno / banco)
    private int idObjetoPerdido;
    private int idObjetoEncontrado;

    // Dados para exibição na tela
    private String nomeObjetoPerdido;
    private String nomeObjetoEncontrado;
    private String categoria;
    private String local;

    private double score;
    private String statusMatch;

    // ===== GETTERS E SETTERS =====

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdObjetoPerdido() {
        return idObjetoPerdido;
    }

    public void setIdObjetoPerdido(int idObjetoPerdido) {
        this.idObjetoPerdido = idObjetoPerdido;
    }

    public int getIdObjetoEncontrado() {
        return idObjetoEncontrado;
    }

    public void setIdObjetoEncontrado(int idObjetoEncontrado) {
        this.idObjetoEncontrado = idObjetoEncontrado;
    }

    public String getNomeObjetoPerdido() {
        return nomeObjetoPerdido;
    }

    public void setNomeObjetoPerdido(String nomeObjetoPerdido) {
        this.nomeObjetoPerdido = nomeObjetoPerdido;
    }

    public String getNomeObjetoEncontrado() {
        return nomeObjetoEncontrado;
    }

    public void setNomeObjetoEncontrado(String nomeObjetoEncontrado) {
        this.nomeObjetoEncontrado = nomeObjetoEncontrado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getStatusMatch() {
        return statusMatch;
    }

    public void setStatusMatch(String statusMatch) {
        this.statusMatch = statusMatch;
    }
}
