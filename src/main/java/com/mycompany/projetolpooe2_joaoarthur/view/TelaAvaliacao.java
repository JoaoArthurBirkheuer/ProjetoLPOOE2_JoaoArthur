/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.mycompany.projetolpooe2_joaoarthur.view;

import com.mycompany.projetolpooe2_joaoarthur.model.*;
import com.mycompany.projetolpooe2_joaoarthur.dao.*;
import com.mycompany.projetolpooe2_joaoarthur.view.EdicaoCadastroUsuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pedro
 */
public class TelaAvaliacao extends javax.swing.JFrame {

    /** Creates new form TelaAvaliacao */
    public TelaAvaliacao() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnMostrarDados = new javax.swing.JButton();
        btnFazerAvaliacao = new javax.swing.JButton();
        btnEditarSelecionado = new javax.swing.JButton();
        btnDeletarSelecionado = new javax.swing.JButton();
        btnInspecionarAvaliacao = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Avaliações");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Avaliação", "ID do avaliador", "Livro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Pesquisa:");

        btnMostrarDados.setText("Mostrar dados");
        btnMostrarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarDadosActionPerformed(evt);
            }
        });

        btnFazerAvaliacao.setText("Fazer avaliação");
        btnFazerAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFazerAvaliacaoActionPerformed(evt);
            }
        });

        btnEditarSelecionado.setText("Editar selecionado");
        btnEditarSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarSelecionadoActionPerformed(evt);
            }
        });

        btnDeletarSelecionado.setText("Deletar selecionado");
        btnDeletarSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarSelecionadoActionPerformed(evt);
            }
        });

        btnInspecionarAvaliacao.setText("Inspecionar avaliação");
        btnInspecionarAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInspecionarAvaliacaoActionPerformed(evt);
            }
        });

        jTextField2.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                realizarPesquisa();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                realizarPesquisa();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                realizarPesquisa();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDeletarSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditarSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFazerAvaliacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMostrarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInspecionarAvaliacao)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMostrarDados)
                        .addGap(18, 18, 18)
                        .addComponent(btnInspecionarAvaliacao)
                        .addGap(18, 18, 18)
                        .addComponent(btnFazerAvaliacao)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarSelecionado)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletarSelecionado))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarDadosActionPerformed
    try {
        // Carregar o driver PostgreSQL
        Class.forName("org.postgresql.Driver");

        // Conectar ao banco
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/ProjetoLPOOE2_JoaoArthur", 
            "postgres", 
            "jb12"
        );

        // Criar a consulta SQL
        String sql = """
            SELECT 
                        a.id AS idAvaliacao,
                        CASE 
                            WHEN a.usuario_id IS NOT NULL THEN a.usuario_id
                            WHEN a.funcionario_id IS NOT NULL THEN a.funcionario_id
                            ELSE NULL
                        END AS idAvaliador,
                        l.titulo AS tituloLivro
                    FROM tb_avaliacao a
                    INNER JOIN tb_livro l ON a.livro_id = l.idlivro
        """;

        // Executar a consulta
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        // Obter o modelo da tabela
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        tblModel.setRowCount(0); // Limpa os dados anteriores

        // Popular a tabela
        while (rs.next()) {
            String idAvaliador = rs.getString("idAvaliador");
            String tituloLivro = rs.getString("tituloLivro");
            String idAvaliacao = rs.getString("idAvaliacao");

            // Adicionar os dados na tabela
            String[] tbData = {idAvaliacao, idAvaliador, tituloLivro};
            tblModel.addRow(tbData);
        }

        // Fechar conexões
        rs.close();
        st.close();
        con.close();

    } catch (ClassNotFoundException ex) {
        Logger.getLogger(TelaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(TelaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Erro ao buscar dados: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnMostrarDadosActionPerformed

    private void btnFazerAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFazerAvaliacaoActionPerformed
        TelaFazerAvaliacao telaFazerAvaliacao = new TelaFazerAvaliacao();
        telaFazerAvaliacao.setVisible(true);
        telaFazerAvaliacao.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnFazerAvaliacaoActionPerformed

    private void btnInspecionarAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInspecionarAvaliacaoActionPerformed
    // Capturar a linha selecionada na tabela
    int selectedRow = jTable1.getSelectedRow();
    
    // Verificar se uma linha foi selecionada
    if (selectedRow != -1) {
        // Obter os dados da linha selecionada
        String idAvaliacao = (String) jTable1.getValueAt(selectedRow, 0);  // ID da Avaliação
        
        // Abrir a TelaInspecionarAvaliacao e passar os dados da avaliação
        TelaInspecionarAvaliacao telaInspecionarAvaliacao = new TelaInspecionarAvaliacao(idAvaliacao);
        telaInspecionarAvaliacao.setVisible(true);
        telaInspecionarAvaliacao.setLocationRelativeTo(this);
    } else {
        // Caso não tenha sido selecionada nenhuma linha
        JOptionPane.showMessageDialog(this, "Por favor, selecione uma avaliação para inspecionar.");
    }

    }//GEN-LAST:event_btnInspecionarAvaliacaoActionPerformed

    private void btnDeletarSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarSelecionadoActionPerformed
        // TODO add your handling code here:
        // deletar
        int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Selecione uma avaliação para excluir!");
        return;
    }

    String id = (String) jTable1.getValueAt(selectedRow, 0);
    if (id == null || id.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Não é possível excluir registros vazios. Certifique-se de que os dados foram carregados corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(
            this,
            "Tem certeza que deseja excluir esta avaliação?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
    );

    if (confirm != JOptionPane.YES_OPTION) {
        return; // Usuário cancelou
    }

    DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
    int idAvaliacao = Integer.parseInt(tblModel.getValueAt(selectedRow, 0).toString());

    try {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoLPOOE2_JoaoArthur");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Avaliacao avaliacao = em.find(Avaliacao.class, idAvaliacao);
        if (avaliacao != null) {
   

            em.remove(avaliacao);

            System.out.println("Avaliação com ID " + idAvaliacao + " foi deletada.");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();

        JOptionPane.showMessageDialog(this, "Avaliação excluída com sucesso!");
        tblModel.removeRow(selectedRow); 
    } catch (Exception ex) {
        Logger.getLogger(TelaLivros.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Erro ao excluir avaliação: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnDeletarSelecionadoActionPerformed

    private void btnEditarSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarSelecionadoActionPerformed
        // TODO add your handling code here:
        // editar 
        // TODO add your handling code here:
        // editar
        int linhaSelecionada = jTable1.getSelectedRow();

    if (linhaSelecionada == -1) {
    JOptionPane.showMessageDialog(this, "Por favor, selecione um usuário na tabela.");
    return;
    }

    try {
        Integer idAvaliacao = Integer.valueOf(jTable1.getValueAt(linhaSelecionada, 0).toString());

        EdicaoAvaliacao telaEdicao = new EdicaoAvaliacao(this, idAvaliacao);
        telaEdicao.setVisible(true);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao processar o ID do usuário.");
    }
    }//GEN-LAST:event_btnEditarSelecionadoActionPerformed

    private void realizarPesquisa() {
    try {
        String pesquisa = jTextField2.getText().trim();

        // Carregar driver PostgreSQL
        Class.forName("org.postgresql.Driver");

        // Conectar ao banco de dados
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/ProjetoLPOOE2_JoaoArthur", 
            "postgres", 
            "jb12"
        );

        // Consulta SQL
        String sql = 
            "SELECT a.id, " +
            "       CASE WHEN u.idpessoa IS NOT NULL THEN u.idpessoa ELSE f.idpessoa END AS idAvaliador, " +
            "       l.titulo AS tituloLivro " +
            "FROM tb_avaliacao a " +
            "LEFT JOIN tb_usuario u ON a.usuario_id = u.idpessoa " +
            "LEFT JOIN tb_funcionario f ON a.funcionario_id = f.idpessoa " +
            "LEFT JOIN tb_livro l ON a.livro_id = l.idlivro " +
            "WHERE CAST(a.id AS TEXT) ILIKE ? " +
            "   OR CAST(a.funcionario_id AS TEXT) ILIKE ? " +
            "   OR CAST(a.usuario_id AS TEXT) ILIKE ? " +
            "   OR l.titulo ILIKE ?";

        // Preparar statement para evitar SQL Injection
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "%" + pesquisa + "%");
        stmt.setString(2, "%" + pesquisa + "%");
        stmt.setString(3, "%" + pesquisa + "%");
        stmt.setString(4, "%" + pesquisa + "%");

        ResultSet rs = stmt.executeQuery();

        // Limpar tabela antes de exibir resultados
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        tblModel.setRowCount(0);

        // Preencher tabela com resultados da consulta
        while (rs.next()) {
            String idAvaliacao = String.valueOf(rs.getLong("id"));
            String idAvaliador = String.valueOf(rs.getLong("idAvaliador"));
            String tituloLivro = rs.getString("tituloLivro");

            String tbData[] = {idAvaliacao, idAvaliador, tituloLivro};
            tblModel.addRow(tbData);
        }

        // Fechar recursos
        rs.close();
        stmt.close();
        con.close();
    } catch (ClassNotFoundException | SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erro na pesquisa: " + ex.getMessage());
    }
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAvaliacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletarSelecionado;
    private javax.swing.JButton btnEditarSelecionado;
    private javax.swing.JButton btnFazerAvaliacao;
    private javax.swing.JButton btnInspecionarAvaliacao;
    private javax.swing.JButton btnMostrarDados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
