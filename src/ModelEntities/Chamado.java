/**
 *
 * @author Ariana e Stéfanie
 */
package ModelEntities;

import java.util.Date;

public class Chamado {
    private long idChamado;
    private String tituloChamado;
    private String descChamado;
    private Date data;
    private Usuario usuario;
    
    private int idCategoriaChamado;
    private int idSubcategoriaChamado;
    private int idNivelUrgencia;
    private int idStatusChamado;
    
    public Chamado() {

    }

    public Chamado(long idChamado, String tituloChamado, String descChamado, Date data,
    Usuario usuario, int idCategoriaChamado, int idSubcategoriaChamado, int idNivelUrgencia, int idStatusChamado) {
        this.idChamado = idChamado;
        this.tituloChamado = tituloChamado;
        this.descChamado = descChamado;
        this.data = data;
        this.usuario = usuario;
        
        this.idCategoriaChamado = idCategoriaChamado;
        this.idSubcategoriaChamado = idSubcategoriaChamado;
        this.idNivelUrgencia = idNivelUrgencia;
        this.idStatusChamado = idStatusChamado;
    }

    public long getidChamado() {
        return idChamado;
    }

    public void setidChamado(int id) {
        this.idChamado = id;
    }

    public String gettituloChamado() {
        return tituloChamado;
    }

    public void settituloChamado(String tituloChamado) {
        this.tituloChamado = tituloChamado;
    }

    public String getdescChamado() {
        return descChamado;
    }

    public void setdescChamado(String descChamado) {
        this.descChamado = descChamado;
    }

    public Date getdata() {
        return data;
    }

    public void setdata(Date data) {
        this.data = data;
    }

     public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /* ******************************* */

    public int getIdCategoriaChamado() {
        return idCategoriaChamado;
    }

    public void setIdCategoriaChamado(int idCategoriaChamado) {
        this.idCategoriaChamado = idCategoriaChamado;
    }

    public int getIdSubcategoriaChamado() {
        return idSubcategoriaChamado;
    }

    public void setIdSubcategoriaChamado(int idSubcategoriaChamado) {
        this.idSubcategoriaChamado = idSubcategoriaChamado;
    }

    public int getIdNivelUrgencia() {
        return idNivelUrgencia;
    }

    public void setIdNivelUrgencia(int idNivelUrgencia) {
        this.idNivelUrgencia = idNivelUrgencia;
    }

    public int getIdStatusChamado() {
        return idStatusChamado;
    }

    public void setIdStatusChamado(int idStatusChamado) {
        this.idStatusChamado = idStatusChamado;
    }

    /* ******************************** */
    @Override
    public String toString() {
        return "Chamado{" + "ID CHAMADO = " + idChamado + ", TITULO = " + tituloChamado + ", DESCRIÇÃO = " + descChamado + ", DATA = " + data + /*", USUARIO = " + usuario + 
                ", CATEGORIA = " + idCategoriaChamado + ", SUBCATEGORIA = " + idSubcategoriaChamado + 
                ", NÍVEL DE URGENCIA =  " + idNivelUrgencia + ", STATUS CHAMADO = " +idStatusChamado + */'}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = (int) (53 * hash + this.idChamado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chamado other = (Chamado) obj;
        if (this.idChamado != other.idChamado) {
            return false;
        }
        return true;
    }

    public void setIdStatusChamado(String josualdo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}

