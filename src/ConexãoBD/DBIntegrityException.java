/**
 *
 * @author Ariana e Stéfanie
 */
package ConexãoBD;

public class DBIntegrityException extends RuntimeException{

    public DBIntegrityException(String msg) {
        super(msg);
    }
}