/**
 *
 * @author Ariana e Stéfanie
 */

package DAO;

import java.util.List;
import ModelEntities.Chamado;
import ModelEntities.Usuario;


 public interface ChamadoDAO {

    void insert(Chamado obj);

    void update(Chamado obj);

    void deleteById(int idChamado);

    Chamado findById(int idChamado);
    
    List<Chamado> findByUser(Usuario user);

}

