package com.mycompany.projetolpooe2_joaoarthur;

import com.mycompany.projetolpooe2_joaoarthur.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjetoLPOOE2_JoaoArthur {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoLPOOE2_JoaoArthur");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Adicionar Usuários
            Usuario usuario1 = new Usuario("Nome 1", "123.456.789-00", "usuario1@example.com");
            em.persist(usuario1);

            Usuario usuario2 = new Usuario("Nome 2", "987.654.321-00", "usuario2@example.com");
            em.persist(usuario2);

            // Adicionar Funcionários
            Funcionario funcionario1 = new Funcionario("Funcionario 1", "111.222.333-00", "funcionario1@example.com");
            funcionario1.setCargo("Bibliotecário");
            em.persist(funcionario1);

            Funcionario funcionario2 = new Funcionario("Funcionario 2", "444.555.666-00", "funcionario2@example.com");
            funcionario2.setCargo("Auxiliar");
            em.persist(funcionario2);

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
            emprestimo1.setLivrosEmprestados(new HashSet<>(Set.of(livro1, livro2)));
            em.persist(emprestimo1);

            Emprestimo emprestimo2 = new Emprestimo();
            emprestimo2.setFuncionario(funcionario2);
            emprestimo2.setDataEmprestimo(LocalDate.now().minusDays(10));
            emprestimo2.setDataDevolucao(LocalDate.now().plusDays(4));
            emprestimo2.setLivrosEmprestados(new HashSet<>(Set.of(livro3)));
            em.persist(emprestimo2);

            // Remoção de Funcionário e seus Relacionamentos
            /*Long idFuncionario = 4L;
            Funcionario funcionario = em.find(Funcionario.class, idFuncionario);

            if (funcionario != null) {
                // Remover avaliações relacionadas ao funcionário
                List<Avaliacao> avaliacoes = em.createQuery(
                        "SELECT a FROM Avaliacao a WHERE a.funcionario.idPessoa = :idFuncionario", Avaliacao.class)
                        .setParameter("idFuncionario", idFuncionario)
                        .getResultList();

                for (Avaliacao avaliacao : avaliacoes) {
                    em.remove(avaliacao);
                }

                // Remover empréstimos relacionados ao funcionário
                List<Emprestimo> emprestimos = em.createQuery(
                        "SELECT e FROM Emprestimo e WHERE e.funcionario.idPessoa = :idFuncionario", Emprestimo.class)
                        .setParameter("idFuncionario", idFuncionario)
                        .getResultList();

                for (Emprestimo emprestimo : emprestimos) {
                    Set<Livro> livrosEmprestados = emprestimo.getLivrosEmprestados();
                    if (livrosEmprestados != null) {
                        livrosEmprestados.clear();
                    }
                    em.remove(emprestimo);
                }

                // Remover o funcionário
                em.remove(funcionario);
                System.out.println("Funcionário com ID " + idFuncionario + " e seus registros relacionados foram deletados.");
            } else {
                System.out.println("Funcionário com ID " + idFuncionario + " não encontrado.");
            }*/

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
