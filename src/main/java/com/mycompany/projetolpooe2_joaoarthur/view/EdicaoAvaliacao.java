/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projetolpooe2_joaoarthur.view;

import com.mycompany.projetolpooe2_joaoarthur.dao.PersistenciaJPA;
import com.mycompany.projetolpooe2_joaoarthur.model.Avaliacao;
import com.mycompany.projetolpooe2_joaoarthur.model.Funcionario;
import com.mycompany.projetolpooe2_joaoarthur.model.Livro;
import com.mycompany.projetolpooe2_joaoarthur.model.Pessoa;
import com.mycompany.projetolpooe2_joaoarthur.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author pedro
 */
public class EdicaoAvaliacao extends javax.swing.JFrame {

    /**
     * Creates new form EdicaoAvaliacao
     */
    private Integer idAvaliacao;
    private JFrame parent;
    public EdicaoAvaliacao(JFrame parent, Integer idAvaliacao) {
        this.parent = parent;
        this.idAvaliacao = idAvaliacao;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        carregarDadosDaAvaliacao(idAvaliacao);
        PersistenciaJPA jpa = new PersistenciaJPA();
    }
    
    private void carregarDadosDaAvaliacao(int idAvaliacao) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        // Conectar ao banco de dados
        String url = "jdbc:postgresql://localhost:5432/ProjetoLPOOE2_JoaoArthur";
        String user = "postgres";
        String password = "jb12";
        conn = DriverManager.getConnection(url, user, password);

        // Carregar todos os nomes para a combo box
        String sqlUsuarios = "SELECT nome FROM tb_usuario";
        String sqlFuncionarios = "SELECT nome FROM tb_funcionario";
        
        Statement stmtUsuarios = conn.createStatement();
        Statement stmtFuncionarios = conn.createStatement();
        ResultSet rsUsuarios = stmtUsuarios.executeQuery(sqlUsuarios);
        ResultSet rsFuncionarios = stmtFuncionarios.executeQuery(sqlFuncionarios);
        comboNomes.removeAllItems();
        while (rsUsuarios.next()) {
            comboNomes.addItem(rsUsuarios.getString("nome"));
        }
        
        while (rsFuncionarios.next()) comboNomes.addItem(rsFuncionarios.getString("nome"));
        
        stmtUsuarios.close();
        rsUsuarios.close();
        
        // Carregar todos os livros para a combo box
        String sqlLivros = "SELECT titulo FROM tb_livro";
        Statement stmtLivros = conn.createStatement();
        ResultSet rsLivros = stmtLivros.executeQuery(sqlLivros);
        comboLivros.removeAllItems();
        while (rsLivros.next()) {
            comboLivros.addItem(rsLivros.getString("titulo"));
        }
        
        stmtLivros.close();
        rsLivros.close();

        // Buscar dados específicos da avaliação
        String sql = """
            SELECT a.descricao, a.nota, u.nome AS nome_usuario, f.nome AS nome_funcionario, l.titulo AS titulo_livro
            FROM tb_avaliacao a
            LEFT JOIN tb_usuario u ON a.usuario_id = u.idpessoa
            LEFT JOIN tb_funcionario f ON a.funcionario_id = f.idpessoa
            LEFT JOIN tb_livro l ON a.livro_id = l.idlivro
            WHERE a.id = ?
        """;

        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idAvaliacao);
        rs = stmt.executeQuery();

        if (rs.next()) {
            // Selecionar o nome do usuário ou funcionário associado à avaliação
            String nomeUsuario = rs.getString("nome_usuario");
            String nomeFuncionario = rs.getString("nome_funcionario");
            
            if (nomeFuncionario != null) {
                comboNomes.setSelectedItem(nomeFuncionario);
            } else if (nomeUsuario != null) {
                comboNomes.setSelectedItem(nomeUsuario);
            }

            // Selecionar o título do livro
            String tituloLivro = rs.getString("titulo_livro");
            comboLivros.setSelectedItem(tituloLivro);

            // Carregar a nota no componente de estrelas
            int nota = rs.getInt("nota");
            starRating1.setStar(nota);

            // Carregar a descrição no JTextArea
            String descricao = rs.getString("descricao");
            txtDescricao.setText(descricao);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum dado encontrado para o ID da avaliação: " + idAvaliacao);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao carregar dados da avaliação: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboNomes = new javax.swing.JComboBox<>();
        comboLivros = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblLivro = new javax.swing.JLabel();
        lblNota = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        txtRealizarAlterações = new javax.swing.JButton();
        starRating1 = new com.mycompany.projetolpooe2_joaoarthur.view.StarRating();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Editar Avaliação");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        comboNomes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNomesActionPerformed(evt);
            }
        });

        lblNome.setText("Seu nome:");

        lblLivro.setText("Livro:");

        lblNota.setText("Nota:");

        lblDescricao.setText("Descrição:");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        txtRealizarAlterações.setText("Realizar alterações");
        txtRealizarAlterações.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRealizarAlteraçõesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(lblLivro)
                    .addComponent(lblDescricao)
                    .addComponent(lblNota))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(starRating1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(comboLivros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboNomes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(txtRealizarAlterações))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboNomes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLivro)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNota)
                    .addComponent(starRating1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(txtRealizarAlterações)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRealizarAlteraçõesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRealizarAlteraçõesActionPerformed
        // TODO add your handling code here:
        // realizar alterações
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoLPOOE2_JoaoArthur");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            String nomeSelecionado = (String) comboNomes.getSelectedItem();
            String livroSelecionado = (String) comboLivros.getSelectedItem();
            String descricao = txtDescricao.getText();
            int nota = starRating1.getStar();

            if (nomeSelecionado == null || livroSelecionado == null || descricao.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos devem estar preenchidos.");
                return;
            }

            Avaliacao avaliacao = em.find(Avaliacao.class, idAvaliacao);
            if (avaliacao != null) {
                avaliacao.setDescricao(descricao);
                avaliacao.setNota(nota);

                Livro livro = buscarLivroPorTitulo(livroSelecionado, em);
                if (livro != null) {
                    avaliacao.setLivro(livro);
                }

                Object pessoa = buscarPessoaPorNome(nomeSelecionado, em);
                if (pessoa != null) {
                    if (pessoa instanceof Usuario) {
                        avaliacao.setUsuario((Usuario) pessoa);
                    } else if (pessoa instanceof Funcionario) {
                        avaliacao.setFuncionario((Funcionario) pessoa);
                    }
                }

                em.merge(avaliacao);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Alterações realizadas com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Avaliação não encontrada.");
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao realizar alterações.");
        } finally {
            em.close();
            emf.close();
        }
    }//GEN-LAST:event_txtRealizarAlteraçõesActionPerformed

    private void comboNomesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNomesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboNomesActionPerformed
    private Livro buscarLivroPorTitulo(String titulo, EntityManager em) {
        try {
            return em.createQuery("SELECT l FROM Livro l WHERE l.titulo = :titulo", Livro.class)
                    .setParameter("titulo", titulo)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     private Object buscarPessoaPorNome(String nome, EntityManager em) {
        try {
            Usuario usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :nome", Usuario.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
            if (usuario != null) return usuario;
        } catch (Exception ignored) {
        }

        try {
            Funcionario funcionario = em.createQuery("SELECT f FROM Funcionario f WHERE f.nome = :nome", Funcionario.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
            if (funcionario != null) return funcionario;
        } catch (Exception ignored) {
        }

        return null;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Abrir a tela principal
        SwingUtilities.invokeLater(() -> new TelaAvaliacao().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboLivros;
    private javax.swing.JComboBox<String> comboNomes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblLivro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNota;
    private com.mycompany.projetolpooe2_joaoarthur.view.StarRating starRating1;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JButton txtRealizarAlterações;
    // End of variables declaration//GEN-END:variables
}
