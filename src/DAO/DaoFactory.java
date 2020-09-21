/**
 *
 * @author Ariana e Stéfanie
 */

package DAO;

import ConexãoBD.ConexaoBanco;
import ModelDaoImpl.ChamadoDaoJDBC;

public class DaoFactory {
    public static ChamadoDAO createChamadoDao(){
      return new ChamadoDaoJDBC(ConexaoBanco.getConnection());
  }  
}
