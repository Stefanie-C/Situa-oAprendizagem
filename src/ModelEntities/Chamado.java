/**
 *
 * @author Ariana e Stéfanie
 */
package ModelEntities;

import java.util.Date;

public class Chamado {
    private long idchamado;
    private String tituloChamado;
    private String descChamado;
    private Date data;
    private Usuario usuario;
   
    
    public Chamado() {

    }

    public Chamado(long idhamado, String tituloChamado, String descChamado, Date data, Usuario usuario) {
        this.idchamado = idchamado;
        this.tituloChamado = tituloChamado;
        this.descChamado = descChamado;
        this.data = data;
        this.usuario = usuario;
       
    }

    public long getidchamado() {
        return idchamado;
    }

    public void setidchamado(int id) {
        this.idchamado = id;
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

    @Override
    public String toString() {
        return "Chamado{" + "idchamado=" + idchamado + ", tituloChamado=" + tituloChamado + ", descChamado=" + descChamado + ", data=" + data + ", usuario=" + usuario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = (int) (53 * hash + this.idchamado);
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
        if (this.idchamado != other.idchamado) {
            return false;
        }
        return true;
    }
    
    

}

