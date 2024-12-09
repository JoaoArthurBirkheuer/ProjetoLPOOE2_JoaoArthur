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
 * @author Usuario
 */
public class TelaLivros extends javax.swing.JFrame {

    /**
     * Creates new form TelaLivros
     */
    public TelaLivros() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PersistenciaJPA jpa = new PersistenciaJPA();
    }
    
    private void realizarPesquisa(){
    try {
    String pesquisa = jTextField1.getText().trim();

    // Carregar o driver PostgreSQL
    Class.forName("org.postgresql.Driver");

    // Conectar ao banco
    Connection con = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/ProjetoLPOOE2_JoaoArthur", 
        "postgres", 
        "jb12"
    );

    Statement st = con.createStatement();
    String sql = "SELECT idLivro, titulo, autor FROM tb_livro WHERE idLivro::text ILIKE '%" + pesquisa + "%' OR titulo ILIKE '%" + pesquisa + "%' OR autor ILIKE '%" + pesquisa + "%'";
    ResultSet rs = st.executeQuery(sql);

    DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
    tblModel.setRowCount(0);

    while (rs.next()) {
        String id = String.valueOf(rs.getLong("idLivro"));
        String titulo = rs.getString("titulo");
        String autor = rs.getString("autor");

        String tbData[] = {id, titulo, autor};
        tblModel.addRow(tbData);
    }

    rs.close();
    st.close();
    con.close();
} catch (ClassNotFoundException | SQLException ex) {
    JOptionPane.showMessageDialog(this, "Erro na pesquisa: " + ex.getMessage());
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Controle e Pesquisa de Livros");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setText("Pesquisa:");

        jButton1.setText("Novo livro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Mostrar dados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Editar selecionado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Deletar selecionado");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Título", "Autor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
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
                .addGap(133, 133, 133)
                .addComponent(jLabel1)
                .addGap(133, 133, 133))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addGap(133, 133, 133))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(jButton3)
                        .addGap(30, 30, 30)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
// TODO add your handling code here:
        // mostrar dados
        try{
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/ProjetoLPOOE2_JoaoArthur", 
            "postgres", 
            "jb12"
        );

        Statement st = con.createStatement();
        String sql = "SELECT idlivro, titulo, autor FROM tb_livro";
        ResultSet rs = st.executeQuery(sql);

        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        tblModel.setRowCount(0);// tblModel.setRowCount(0); // Limpa os dados anteriores

        while (rs.next()) {
            String id = String.valueOf(rs.getInt("idlivro"));
            String titulo = rs.getString("titulo");
            String autor = rs.getString("autor");

            String tbData[] = {id, titulo, autor};
            tblModel.addRow(tbData);
        }

        rs.close();
        st.close();
        con.close();

    } catch (ClassNotFoundException ex) {
        Logger.getLogger(TelaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(TelaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Erro ao buscar dados: " + ex.getMessage());
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // novo registro
        TelaCadastroLivro tcl = new TelaCadastroLivro();
        tcl.setVisible(true);
        tcl.setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        // editar
        int linhaSelecionada = jTable1.getSelectedRow();

    if (linhaSelecionada == -1) {
    JOptionPane.showMessageDialog(this, "Por favor, selecione um livro na tabela.");
    return;
    }

    try {
        
        Integer idLivro = Integer.valueOf(jTable1.getValueAt(linhaSelecionada, 0).toString().trim());

        EdicaoCadastroLivro telaEdicao = new EdicaoCadastroLivro(this, idLivro); // Passa o ID correto
        telaEdicao.setVisible(true);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao processar o ID do usuário.");
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um livro para excluir!");
        return;
    }

    String id = (String) jTable1.getValueAt(selectedRow, 0);
    if (id == null || id.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Não é possível excluir registros vazios. Certifique-se de que os dados foram carregados corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(
            this,
            "Tem certeza que deseja excluir este livro e seus vínculos com empréstimos?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
    );

    if (confirm != JOptionPane.YES_OPTION) {
        return; // Usuário cancelou
    }

    DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
    int idLivro = Integer.parseInt(tblModel.getValueAt(selectedRow, 0).toString());

    try {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoLPOOE2_JoaoArthur");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Livro livro = em.find(Livro.class, idLivro);
        if (livro != null) {
            List<Avaliacao> avaliacoes = em.createQuery(
                    "SELECT a FROM Avaliacao a WHERE a.livro.id = :idLivro", Avaliacao.class)
                    .setParameter("idLivro", idLivro)
                    .getResultList();

            for (Avaliacao avaliacao : avaliacoes) {
                em.remove(avaliacao);
            }

            List<Emprestimo> emprestimos = em.createQuery(
                    "SELECT e FROM Emprestimo e JOIN e.livrosEmprestados l WHERE l.id = :idLivro", Emprestimo.class)
                    .setParameter("idLivro", idLivro)
                    .getResultList();

            for (Emprestimo emprestimo : emprestimos) {
                emprestimo.getLivrosEmprestados().remove(livro);
                em.persist(emprestimo);
            }

            em.remove(livro);

            System.out.println("Livro com ID " + idLivro + " e seus vínculos relacionados foram deletados.");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();

        JOptionPane.showMessageDialog(this, "Livro excluído com sucesso!");
        tblModel.removeRow(selectedRow); 
    } catch (Exception ex) {
        Logger.getLogger(TelaLivros.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Erro ao excluir livro: " + ex.getMessage());
    }


    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
