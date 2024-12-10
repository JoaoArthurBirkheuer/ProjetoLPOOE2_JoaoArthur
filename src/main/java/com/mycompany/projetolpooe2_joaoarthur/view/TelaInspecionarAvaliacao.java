/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projetolpooe2_joaoarthur.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class TelaInspecionarAvaliacao extends javax.swing.JFrame {

    /**
     * Creates new form TelaInspecionarAvaliacao
     */
    public TelaInspecionarAvaliacao(String idAvaliacao) {
    if (idAvaliacao == null || idAvaliacao.isEmpty()) {
        throw new IllegalArgumentException("O ID da avaliação não pode ser nulo ou vazio.");
    }
    initComponents();
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    carregarDados(idAvaliacao); // Passar o ID da avaliação
}

    /**
     * Carrega os dados fornecidos na TelaAvaliacao
     */
    public void carregarDados(String idAvaliacao) {
    
    String query = """
        SELECT 
            a.nota, 
            a.descricao, 
            CASE 
                WHEN a.usuario_id IS NOT NULL THEN a.usuario_id
                ELSE a.funcionario_id 
            END AS idAvaliador,
            l.titulo AS tituloLivro
        FROM tb_avaliacao a
        INNER JOIN tb_livro l ON a.livro_id = l.idlivro
        WHERE a.id = CAST(? AS bigint)
    """;

    // Conectar ao banco de dados
    try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoLPOOE2_JoaoArthur", "postgres", "jb12");
         PreparedStatement stmt = conn.prepareStatement(query)) {

        // Substituir o parâmetro da consulta
        stmt.setString(1, idAvaliacao); // ID da avaliação

        // Executar a consulta
        ResultSet rs = stmt.executeQuery();

        // Verificar se a consulta retornou resultados
        if (rs.next()) {
            // Obter os dados da avaliação
            int nota = rs.getInt("nota");
            String descricao = rs.getString("descricao");
            String idAvaliadorResultado = rs.getString("idAvaliador"); // ID do avaliador (usuario ou funcionario)
            String tituloLivroResultado = rs.getString("tituloLivro"); // Título do livro

            // Preencher os campos da tela com os dados da avaliação
            txtIdAvaliador.setText(idAvaliadorResultado); // Campo para ID do avaliador
            txtTituloLivro.setText(tituloLivroResultado); // Campo para título do livro
            lblNota.setText("Nota: " + nota); // Exibição da nota
            txtDescricao.setText(descricao); // Campo para descrição da avaliação
        } else {
            // Caso não encontre dados, exibir uma mensagem
            JOptionPane.showMessageDialog(this, "Avaliação não encontrada para o ID informado.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao consultar os dados da avaliação: " + e.getMessage());
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
        lblIdAvaliador = new javax.swing.JLabel();
        lblTituloLivro = new javax.swing.JLabel();
        txtIdAvaliador = new javax.swing.JTextField();
        txtTituloLivro = new javax.swing.JTextField();
        txtNota = new javax.swing.JTextField();
        lblNota = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Avaliação selecionada");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lblIdAvaliador.setText("ID do avaliador:");

        lblTituloLivro.setText("Título do livro:");

        txtIdAvaliador.setEditable(false);
        txtIdAvaliador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAvaliadorActionPerformed(evt);
            }
        });

        txtTituloLivro.setEditable(false);

        txtNota.setEditable(false);
        txtNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotaActionPerformed(evt);
            }
        });

        lblNota.setText("Nota:");

        lblDescricao.setText("Descrição:");

        txtDescricao.setEditable(false);
        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIdAvaliador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdAvaliador, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTituloLivro)
                                    .addComponent(lblNota)
                                    .addComponent(lblDescricao))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTituloLivro)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)))
                            .addComponent(btnFechar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdAvaliador)
                    .addComponent(txtIdAvaliador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTituloLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTituloLivro))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNota))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnFechar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdAvaliadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAvaliadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdAvaliadorActionPerformed

    private void txtNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotaActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInspecionarAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInspecionarAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInspecionarAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInspecionarAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new TelaInspecionarAvaliacao("1234", "O Senhor dos Anéis").setVisible(true);
            }
        }); */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblIdAvaliador;
    private javax.swing.JLabel lblNota;
    private javax.swing.JLabel lblTituloLivro;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtIdAvaliador;
    private javax.swing.JTextField txtNota;
    private javax.swing.JTextField txtTituloLivro;
    // End of variables declaration//GEN-END:variables
}