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
       
        ChamadoDAO ChamadoDao = DaoFactory.createChamadoDao();
        
        System.out.println(" ");
        System.out.println("---------- MÓDULO GERAL ----------");
        
        System.out.println(" ");
        System.out.println("*** PESQUISA DE CHAMADO POR ID ***");
        Chamado Chamado = ChamadoDao.findById(4);
        System.out.println(Chamado);

        System.out.println(" ");
        System.out.println("*** PESQUISA DE CHAMADO POR USUÁRIO ***");
        Usuario user = new Usuario(2, null);
        List <Chamado> lista = ChamadoDao.findByUser(user);
        for (Chamado obj : lista) {
            System.out.println(obj);
        }
        /*
        
        System.out.println(" ");
        System.out.println("ABRINDO UM NOVO CHAMADO");
        Chamado NovoChamado = new Chamado(0, "TesteInsert2", "TESTANDO INSERT", new Date(), user, 1, 5, 2, 2);
        ChamadoDao.insert(NovoChamado);
        System.out.println("Chamado Aberto! Novo Protocolo: " + NovoChamado.getidChamado());
        
        
        
        System.out.println(" ");
        System.out.println("---------- MÓDULO ADMINISTRADOR ----------");
        
        System.out.println(" ");
        System.out.println("ATUALIZAR UM CHAMADO");
        Chamado = ChamadoDao.findById(3);
        Chamado.settituloChamado("Teste UPDATE 21:40");
        ChamadoDao.update(Chamado);
        System.out.println("Chamado atualizado com sucesso!");
        
        
        
        
        System.out.println(" ");
        System.out.println("APAGAR CHAMADO");
        System.out.println("Digite o ID do chamado para deletar: ");
        int idChamado = sc.nextInt();
        ChamadoDao.deleteById(idChamado);
        System.out.println("Chamado Deletado!");
        */
        
        
    }

}

