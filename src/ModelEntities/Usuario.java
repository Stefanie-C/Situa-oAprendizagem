/**
 *
 * @author Ariana e Stéfanie
 */
package ModelEntities;


public class Usuario {
     private int iduser;
    private String login;
    
    public Usuario (){
        
    } 

    public Usuario(int iduser, String login) {
        this.iduser = iduser;
        this.login = login;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    

    @Override
    public String toString() {
        return "usuario{" + "idUsuario=" + iduser + ", login=" + login + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.iduser;
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
        final Usuario other = (Usuario) obj;
        if (this.iduser != other.iduser) {
            return false;
        }
        return true;
    }
    
    
    
}

