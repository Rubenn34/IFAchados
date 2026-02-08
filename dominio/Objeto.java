/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Saintzada
 */
public class Objeto {


    private int id;
    private String tipoRegistro;
    private String nomeObjeto;
    private String descricao;
    private String categoria;
    private String dataOcorrencia;
    private String local;
    private String status;
    private String matriculaUsuario;

    public Objeto() {}

  
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipoRegistro() { return tipoRegistro; }
    public void setTipoRegistro(String tipoRegistro) { this.tipoRegistro = tipoRegistro; }

    public String getNomeObjeto() { return nomeObjeto; }
    public void setNomeObjeto(String nomeObjeto) { this.nomeObjeto = nomeObjeto; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDataOcorrencia() { return dataOcorrencia; }
    public void setDataOcorrencia(String dataOcorrencia) { this.dataOcorrencia = dataOcorrencia; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMatriculaUsuario() { return matriculaUsuario; }
    public void setMatriculaUsuario(String matriculaUsuario) {
        this.matriculaUsuario = matriculaUsuario;
    }
}
   

