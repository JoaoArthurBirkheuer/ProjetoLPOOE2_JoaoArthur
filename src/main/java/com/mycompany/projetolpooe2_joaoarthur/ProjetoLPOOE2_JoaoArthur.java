package com.mycompany.projetolpooe2_joaoarthur;
import com.mycompany.projetolpooe2_joaoarthur.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Set;
import java.util.Scanner;

public class ProjetoLPOOE2_JoaoArthur {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoLPOOE2_JoaoArthur");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Adicionar Usuários
            Usuario usuario1 = new Usuario("Nome 1", "12345678900", "usuario1@example.com");
            em.persist(usuario1);

            Usuario usuario2 = new Usuario("Nome 2", "98765432100", "usuario2@example.com");
            em.persist(usuario2);

            // Adicionar Funcionários com o atributo cargo
            Funcionario funcionario1 = new Funcionario("Funcionario 1", "11122233300", "funcionario1@example.com");
            funcionario1.setCargo("Bibliotecário");
            em.persist(funcionario1);

            Funcionario funcionario2 = new Funcionario("Funcionario 2", "44455566600", "funcionario2@example.com");
            funcionario2.setCargo("Auxiliar");
            em.persist(funcionario2);
            
            // Inserindo outro usuário para teste
            Usuario usuario3 = new Usuario("Nome 3", "02039627022", "joao@gmail.com");
            em.persist(usuario3);

            // Adicionar Livros
            Livro livro1 = new Livro();
            livro1.setTitulo("Java Basics");
            livro1.setAutor("Autor A");
            em.persist(livro1);

            Livro livro2 = new Livro();
            livro2.setTitulo("Advanced Java");
            livro2.setAutor("Autor B");
            em.persist(livro2);

            Livro livro3 = new Livro();
            livro3.setTitulo("Java Patterns");
            livro3.setAutor("Autor C");
            em.persist(livro3);

            // Adicionar Empréstimos
            Emprestimo emprestimo1 = new Emprestimo();
            emprestimo1.setUsuario(usuario1);
            emprestimo1.setDataEmprestimo(LocalDate.now());
            emprestimo1.setDataDevolucao(LocalDate.now().plusDays(14));
            emprestimo1.setLivrosEmprestados(Set.of(livro1, livro2));
            em.persist(emprestimo1);

            Emprestimo emprestimo2 = new Emprestimo();
            emprestimo2.setFuncionario(funcionario2);
            emprestimo2.setDataEmprestimo(LocalDate.now().minusDays(10));
            emprestimo2.setDataDevolucao(LocalDate.now().plusDays(4));
            emprestimo2.setLivrosEmprestados(Set.of(livro3));
            em.persist(emprestimo2);
            
            Usuario usuario6 = em.find(Usuario.class, 6L);
            if (usuario6 == null) {
            System.out.println("Usuário com ID 6 não existe.");
            }  
            else {
            em.remove(usuario6);
            System.out.println("Usuário com ID 6 removido com sucesso.");
            }
            // Outro teste
            em.find(Usuario.class, 2L);
            if (usuario2 == null) {
            System.out.println("Usuário com ID 2 não existe.");
            } 
            else {
            em.remove(usuario2);
            System.out.println("Usuário com ID 2 removido com sucesso.");
            }
            
            Avaliacao avaliacao1 = new Avaliacao();
            Avaliacao avaliacao2 = new Avaliacao();
            Avaliacao avaliacao3 = new Avaliacao();
            
            avaliacao1.setUsuario(usuario1);
            avaliacao1.setLivro(livro3);
            avaliacao1.setNota((float) 9.5);
            avaliacao1.setDescricao("Gostei muito do livro");
            
            avaliacao2.setFuncionario(funcionario1);
            avaliacao2.setLivro(livro3);
            avaliacao2.setNota((float) 0.5);
            avaliacao2.setDescricao("Detestei o livro");
            
            avaliacao3.setFuncionario(funcionario2);
            avaliacao3.setLivro(livro2);
            avaliacao3.setNota((float) 7.5);
            avaliacao3.setDescricao("Gostei do livro");
            
            em.persist(avaliacao1);
            em.persist(avaliacao2);
            em.persist(avaliacao3);
            
            Avaliacao avaliacao2Remover = em.find(Avaliacao.class, 2); // Considerando que a ID da Avaliação 2 é 2
            if (avaliacao2Remover == null) {
            System.out.println("Avaliação com ID 2 não existe.");
            } else {
            em.remove(avaliacao2Remover);
            System.out.println("Avaliação com ID 2 removida com sucesso.");
}
            
            em.getTransaction().commit();

            System.out.println("Registros de teste adicionados com sucesso!");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                System.out.println("Problema na transação, revertendo...");
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}