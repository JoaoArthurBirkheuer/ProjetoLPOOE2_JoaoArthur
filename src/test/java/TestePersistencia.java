import com.mycompany.projetolpooe2_joaoarthur.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.Assert.*;

public class TestePersistencia {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("ProjetoLPOOE2_JoaoArthur");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    @After
    public void tearDown() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        em.close();
        emf.close();
    }

    @Test
    public void testAdicionarUsuarios() {
        Usuario usuario1 = new Usuario("Nome 1", "12345678900", "usuario1@example.com");
        em.persist(usuario1);

        Usuario usuario2 = new Usuario("Nome 2", "98765432100", "usuario2@example.com");
        em.persist(usuario2);

        em.getTransaction().commit();

        // Verifica se os usuários foram persistidos
        assertNotNull(em.find(Usuario.class, usuario1.getIdPessoa()));
        assertNotNull(em.find(Usuario.class, usuario2.getIdPessoa()));
    }

    @Test
    public void testAdicionarFuncionarios() {
        Funcionario funcionario1 = new Funcionario("Funcionario 1", "11122233300", "funcionario1@example.com");
        funcionario1.setCargo("Bibliotecário");
        em.persist(funcionario1);

        Funcionario funcionario2 = new Funcionario("Funcionario 2", "44455566600", "funcionario2@example.com");
        funcionario2.setCargo("Auxiliar");
        em.persist(funcionario2);

        em.getTransaction().commit();

        // Verifica se os funcionários foram persistidos
        assertNotNull(em.find(Funcionario.class, funcionario1.getIdPessoa()));
        assertNotNull(em.find(Funcionario.class, funcionario2.getIdPessoa()));
    }

    @Test
    public void testAdicionarLivros() {
        Livro livro1 = new Livro();
        livro1.setTitulo("Java Basics");
        livro1.setAutor("Autor A");
        em.persist(livro1);

        Livro livro2 = new Livro();
        livro2.setTitulo("Advanced Java");
        livro2.setAutor("Autor B");
        em.persist(livro2);

        em.getTransaction().commit();

        // Verifica se os livros foram persistidos
        assertNotNull(em.find(Livro.class, livro1.getIdLivro()));
        assertNotNull(em.find(Livro.class, livro2.getIdLivro()));
    }

    @Test
    public void testAdicionarEmprestimos() {
        Usuario usuario1 = new Usuario("Nome 1", "12345678900", "usuario1@example.com");
        em.persist(usuario1);

        Livro livro1 = new Livro();
        livro1.setTitulo("Java Basics");
        livro1.setAutor("Autor A");
        em.persist(livro1);

        Emprestimo emprestimo1 = new Emprestimo();
        emprestimo1.setUsuario(usuario1);
        emprestimo1.setDataEmprestimo(LocalDate.now());
        emprestimo1.setDataDevolucao(LocalDate.now().plusDays(14));
        emprestimo1.setLivrosEmprestados(Set.of(livro1));
        em.persist(emprestimo1);

        em.getTransaction().commit();

        // Verifica se o empréstimo foi persistido
        assertNotNull(em.find(Emprestimo.class, emprestimo1.getId()));
    }
    
    @Test
    public void testRemoverUsuario() {
        Usuario usuario = new Usuario("Nome 3", "02039627022", "joao@gmail.com");
        em.persist(usuario);
        em.getTransaction().commit();
        
        // Remover o usuário
        em.getTransaction().begin();
        Usuario usuarioRemover = em.find(Usuario.class, usuario.getIdPessoa());
        if (usuarioRemover != null) {
            em.remove(usuarioRemover);
        }
        em.getTransaction().commit();

        // Verifica se o usuário foi removido
        assertNull(em.find(Usuario.class, usuario.getIdPessoa()));
    }
}