/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolpooe2_joaoarthur.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.mycompany.projetolpooe2_joaoarthur.model.Avaliacao;
import com.mycompany.projetolpooe2_joaoarthur.model.Pessoa;
import com.mycompany.projetolpooe2_joaoarthur.model.Usuario;
import com.mycompany.projetolpooe2_joaoarthur.model.Funcionario;
import com.mycompany.projetolpooe2_joaoarthur.model.Livro;
import com.mycompany.projetolpooe2_joaoarthur.model.Emprestimo;



public class PersistenciaJPA implements InterfaceBD {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        //parametro: é o nome da unidade de persistencia (Persistence Unit)
        factory
                = Persistence.createEntityManagerFactory("pu_lpoo_estacionamento");
        //conecta no bd e executa a estratégia de geração.
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {

        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void persist(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o); // Anexa o objeto ao contexto de persistência, se necessário
            }
            entity.persist(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao persistir a entidade: " + o.getClass().getSimpleName(), e);
            e.printStackTrace(); // Isso imprimirá o erro completo no console
            throw e;
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o); // Garantir que o objeto está no contexto de persistência
            }
            entity.remove(o); // Remover o objeto
            entity.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao remover entidade: " + o.getClass().getSimpleName());
            e.printStackTrace();
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

    /*
    Todos os métodos agora chamam getEntityManager() 
    para garantir que o EntityManager esteja sempre aberto e 
    pronto para uso.
     */
    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    // funções para listar dados 
    public List<Pessoa> getPessoas() {
        entity = getEntityManager();

        try {
            TypedQuery<Pessoa> query
                    = entity.createQuery("Select p from Pessoa p", Pessoa.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Pessoas: " + e);
            return null;
        }

    }


    public List<Pessoa> getPessoas(String nome) {
        entity = getEntityManager();

        try {
            TypedQuery<Pessoa> query
                    = entity.createQuery("Select p from Pessoa p where lower(p.nome) LIKE :n",
                            Pessoa.class);
            query.setParameter("n", "%" + nome.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Pessoas: " + e);
            return null;
        }

    }

    /*public List<Veiculo> getVeiculos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Veiculo> query
                    = em.createQuery("SELECT v FROM Veiculo v", Veiculo.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Veiculo> getVeiculos(String placa) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Veiculo> query
                    = em.createQuery("SELECT v FROM Veiculo v where lower(v.placa) LIKE :p", Veiculo.class);
            query.setParameter("p", "%" + placa.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Veiculo> getVeiculos(boolean apenasOficiais) {
        EntityManager em = getEntityManager();

        if (apenasOficiais) {
            // Busca apenas veículos oficiais
            TypedQuery<Veiculo> query = em.createQuery(
                    //O operador TYPE no JPQL permite verificar o tipo de entidade em herança
                    "SELECT v FROM Veiculo v WHERE TYPE(v) = VeiOficial", Veiculo.class);
            return query.getResultList();
        } else {
            // Busca todos os veículos
            TypedQuery<Veiculo> query = em.createQuery(
                    "SELECT v FROM Veiculo v", Veiculo.class);
            return query.getResultList();
        }
    }

    public Veiculo findVeiculoByPlaca(String placa) {
        EntityManager em = getEntityManager();
        Veiculo veiculo = null;

        try {
            em.getTransaction().begin();
            veiculo = em.createQuery("SELECT v FROM Veiculo v WHERE upper(v.placa) = :placa", Veiculo.class)
                    .setParameter("placa", placa.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Nenhum veículo encontrado com a placa: " + placa);
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            em.close();
        }

        return veiculo;
    }

    // funções para listar dados 
    public List<Modelo> getModelos() {
        entity = getEntityManager();

        try {
            TypedQuery<Modelo> query
                    = entity.createQuery("Select p from Modelo p", Modelo.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Modelos de Veículos: " + e);
            return null;
        }

    }

    // funções para listar dados 
    public List<EntradaSaida> getMovimentacoes(Date data) {
        entity = getEntityManager();

        try {
            TypedQuery<EntradaSaida> query
                    = entity.createQuery("Select p from EntradaSaida p", EntradaSaida.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Movimentações de Veículos (registros de entrada e saída)" + e);
            return null;
        }

    }*/
}