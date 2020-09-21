/**
 *
 * @author Ariana e Stéfanie
 */

package ModelDaoImpl;

import ConexãoBD.ConexaoBanco;
import ConexãoBD.DbException;
import DAO.ChamadoDAO;
import ModelEntities.Chamado;
import ModelEntities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChamadoDaoJDBC implements ChamadoDAO{
    private final Connection conn;

    public ChamadoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Chamado obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO chamado "
                    + "(tituloChamado, descChamado, data, usuario_idUsuario) "
                    + "VALUES "
                    + "(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.gettituloChamado());
            st.setString(2, obj.getdescChamado());
            st.setDate(3, new java.sql.Date(obj.getdata().getTime()));
            st.setInt(4, obj.getUsuario().getIduser());

            int linhasAfetadas = st.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setidchamado(id);
                }
                ConexaoBanco.closeResultSet(rs);
            } else {
                throw new DbException("Erro inesperado nenhuma linha foi alterada");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoBanco.closeStatement(st);
        }
    }

    @Override
    public void update(Chamado obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE chamado "
                    + "SET tituloChamado= ?, descChamado = ?, data = ? , usuario_idUsuario = ?"
                    + "WHERE idchamado = ?");

            st.setString(1, obj.gettituloChamado());
            st.setString(2, obj.getdescChamado());
            st.setDate(3, new java.sql.Date(obj.getdata().getTime()));
            st.setInt(4, obj.getUsuario().getIduser());
            st.setLong(5, obj.getidchamado());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoBanco.closeStatement(st);
        }
    }

    @Override
    public void deleteById(int idchamado) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM chamado WHERE idchamado= ?");
            st.setInt(1, idchamado);

            st.executeUpdate();

        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            ConexaoBanco.closeStatement(st);
        }
    }

    @Override
    public Chamado findById(int idchamado) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM chamado WHERE idchamado = ?");

            st.setInt(1, idchamado);
            rs = st.executeQuery();
            if (rs.next()) {

                
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoBanco.closeStatement(st);
            ConexaoBanco.closeResultSet(rs);

        }
    }

    @Override
    public List <Chamado> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT chamado.*,login as login "
                    + "FROM chamado INNER JOIN usuario "
                    + "ON chamado.idUsuario = idUsuario ");

            rs = st.executeQuery();

            List<Chamado> lista = new ArrayList<>();
            Map<Integer, Usuario> map = new HashMap<>();

            while (rs.next()) {
                Usuario user = map.get(rs.getInt("idUsuario"));

                if (user == null) {
                    user = instanciaUsuario(rs);
                    map.put(rs.getInt("idUsuario"), user);
                }

                Chamado obj = instanciaChamado(rs, user);
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoBanco.closeStatement(st);
            ConexaoBanco.closeResultSet(rs);

        }
    }

    private Usuario instanciaUsuario(ResultSet rs) throws SQLException {
        Usuario user = new Usuario();
        user.setIduser(rs.getInt("Iduser"));
        user.setLogin(rs.getString("Login"));
        return user;
    }

    private Chamado instanciaChamado(ResultSet rs, Usuario user) throws SQLException {
        Chamado obj = new Chamado();
        obj.setidchamado(rs.getInt("idchamado"));
        obj.settituloChamado(rs.getString("TituloChamado"));
        obj.setdescChamado(rs.getString("DescricaoChamado"));
        obj.setdata(rs.getDate("Data"));
        return obj;
    } 

    public List <Chamado> findByUsuario (Usuario usuario) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT Chamado.*,login as login "
                    + "FROM Chamado INNER JOIN usuario "
                    + "ON Chamado.idUsuario = idUsuario "
                    + "WHERE idUsuario = ? ");

            st.setInt(1, usuario.getIduser());

            rs = st.executeQuery();

            List<Chamado> lista = new ArrayList<>();
            Map<Integer, Usuario> map = new HashMap<>();

            while (rs.next()) {
                Usuario user = map.get(rs.getInt("idUsuario"));

                if (user == null) {
                    user = instanciaUsuario(rs);
                    map.put(rs.getInt("idUsusario"), user);
                }

                
            }
            return lista;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoBanco.closeStatement(st);
            ConexaoBanco.closeResultSet(rs);

        }
    }

    @Override
    public List<Chamado> findByUser(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

}


