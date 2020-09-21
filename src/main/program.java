/**
 *
 * @author Ariana e Stéfanie
 */

package main;

import DAO.ChamadoDAO;
import DAO.DaoFactory;
import ModelEntities.Chamado;
import ModelEntities.Usuario;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("*** CHAMADO POR ID ***");
        ChamadoDAO ChamadoDao = DaoFactory.createChamadoDao();
        Chamado Chamado = ChamadoDao.findById(3);
        System.out.println(Chamado);

        System.out.println("*** CHAMADO POR USUÁRIO ***");
        Usuario user = new Usuario(4, null);
        List<Chamado> lista = ChamadoDao.findByUser(user);
        for (Chamado obj : lista) {
            System.out.println(obj);
        }

        System.out.println("*** CHAMADOS E USUÁRIOS ***");
        lista = ChamadoDao.findAll();
        for (Chamado obj : lista) {
            System.out.println(obj);
        }

        System.out.println("INSERIR DADOS NA TABELA CHAMADO");
        Chamado NovoChamado = new Chamado(0, "TesteInsert", "TESTANDO INSERT", new Date(), user);
        ChamadoDao.insert(NovoChamado);
        System.out.println("Chamado Aberto! Novo Protocolo: " + NovoChamado.getidchamado());

        System.out.println("ATUALIZAR CHAMADO");
        Chamado = ChamadoDao.findById(3);
        Chamado.settituloChamado("TesteUpdate");
        ChamadoDao.update(Chamado);
        System.out.println("Chamado atualizado com sucesso!");

        System.out.println("APAGAR CHAMADO");
        System.out.println("Digite o ID do chamado para deletar: ");
        int idChamado = sc.nextInt();
        ChamadoDao.deleteById(idChamado);
        System.out.println("Deletado!");
        
    }

}

