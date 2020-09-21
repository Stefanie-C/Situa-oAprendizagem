/**
 *
 * @author Ariana e Stéfanie
 */

package DAO;

import ModelEntities.Usuario;
import java.util.List;

public interface UsuarioDAO {
    
    void insert(Usuario obj);
    
    void update(Usuario obj);
    
    void deleteByIdUser(int idUsuario);
    
    Usuario findByIdUser(int idUsuario);
    
    List<Usuario> findAll();    
}