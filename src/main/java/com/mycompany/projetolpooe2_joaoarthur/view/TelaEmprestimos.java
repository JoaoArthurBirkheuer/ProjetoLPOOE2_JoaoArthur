/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projetolpooe2_joaoarthur.view;
import com.mycompany.projetolpooe2_joaoarthur.dao.*;
import com.mycompany.projetolpooe2_joaoarthur.model.*;
import com.mycompany.projetolpooe2_joaoarthur.view.*;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TelaEmprestimos extends javax.swing.JFrame {

    /**
     * Creates new form TelaEmprestimos
     */
    public TelaEmprestimos() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        PersistenciaJPA jpa = new PersistenciaJPA();
    }
    
    private void realizarPesquisa() {
    String pesquisa = jTextField1.getText().trim(); // Campo de entrada para a pesquisa

    // Validar entrada: permitir nulo ou apenas números
    if (!pesquisa.isEmpty() && !pesquisa.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Insira um ID numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/ProjetoLPOOE2_JoaoArthur",
            "postgres",
            "jb12"
        );

        // Consultas SQL
        String sqlEmprestimos = """
            SELECT e.id AS idEmprestimo, 
                   TO_CHAR(e.dataemprestimo, 'DD/MM/YYYY') AS dataEmprestimo, 
                   TO_CHAR(e.datadevolucao, 'DD/MM/YYYY') AS dataDevolucao,
                   COALESCE(e.usuario_id, e.funcionario_id) AS idPessoa,
                   CASE WHEN e.usuario_id IS NOT NULL THEN 'U' ELSE 'F' END AS tipoPessoa
            FROM tb_emprestimo e
            WHERE (? IS NULL OR e.id = ? OR e.usuario_id = ? OR e.funcionario_id = ?)
            """;

        String sqlLivros = """
            SELECT el.emprestimo_id AS idEmprestimo, 
                   STRING_AGG(el.livro_id::TEXT, ', ') AS livros
            FROM tb_emprestimo_livro el
            GROUP BY el.emprestimo_id
            """;

        // Preparar e executar a consulta de empréstimos
        PreparedStatement pstmtEmprestimos = con.prepareStatement(sqlEmprestimos);
        if (pesquisa.isEmpty()) {
            pstmtEmprestimos.setNull(1, java.sql.Types.BIGINT);
            pstmtEmprestimos.setNull(2, java.sql.Types.BIGINT);
            pstmtEmprestimos.setNull(3, java.sql.Types.BIGINT);
            pstmtEmprestimos.setNull(4, java.sql.Types.BIGINT);
        } else {
            Long idPesquisa = Long.parseLong(pesquisa);
            pstmtEmprestimos.setLong(1, idPesquisa);
            pstmtEmprestimos.setLong(2, idPesquisa);
            pstmtEmprestimos.setLong(3, idPesquisa);
            pstmtEmprestimos.setLong(4, idPesquisa);
        }
        ResultSet rsEmprestimos = pstmtEmprestimos.executeQuery();

        // Executar a consulta de livros
        Statement stmtLivros = con.createStatement();
        ResultSet rsLivros = stmtLivros.executeQuery(sqlLivros);

        // Armazenar os livros associados a cada empréstimo
        Map<Long, String> mapaLivros = new HashMap<>();
        while (rsLivros.next()) {
            long idEmprestimo = rsLivros.getLong("idEmprestimo");
            String livros = rsLivros.getString("livros");
            mapaLivros.put(idEmprestimo, livros);
        }

        // Obter o modelo da tabela e limpar dados anteriores
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        tblModel.setRowCount(0);

        // Preencher os dados na tabela
        while (rsEmprestimos.next()) {
            long idEmprestimo = rsEmprestimos.getLong("idEmprestimo");
            String dataEmprestimo = rsEmprestimos.getString("dataEmprestimo");
            String dataDevolucao = rsEmprestimos.getString("dataDevolucao");
            String idPessoa = rsEmprestimos.getString("idPessoa");
            String tipoPessoa = rsEmprestimos.getString("tipoPessoa");
            String pessoaInfo = idPessoa + " (" + tipoPessoa + ")";
            String livros = mapaLivros.getOrDefault(idEmprestimo, ""); // IDs dos livros

            // Adicionar os dados no modelo
            tblModel.addRow(new Object[]{idEmprestimo, dataEmprestimo, dataDevolucao, pessoaInfo, livros});
        }

        // Fechar conexões
        rsEmprestimos.close();
        rsLivros.close();
        pstmtEmprestimos.close();
        stmtLivros.close();
        con.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao buscar os dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Control e Pesquisa de Empréstimos");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Pesquisa Por ID de empréstimo ou pessoa:");

        jButton2.setText("Novo Emprestimo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Deletar Selecionado");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Emp", "Empréstimo", "Devolução", "ID Pessoa", "Livro(s)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setText("jButton5");
        jButton5.addActionListener(evt -> mostrarDadosEmprestimos());
        jButton5.setText("Mostrar Dados");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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
                .addGap(60, 60, 60)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(100, 100, 100)
                .addComponent(jButton4)
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void mostrarDadosEmprestimos() {
    try {
        // Conexão com o banco
        Connection con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/ProjetoLPOOE2_JoaoArthur", "postgres", "jb12");

        // Consulta para a tabela tb_emprestimo
        String sqlEmprestimos = """
            SELECT e.id AS idEmprestimo, 
                   TO_CHAR(e.dataemprestimo, 'DD/MM/YYYY') AS dataEmprestimo, 
                   TO_CHAR(e.datadevolucao, 'DD/MM/YYYY') AS dataDevolucao,
                   COALESCE(e.usuario_id, e.funcionario_id) AS idPessoa,
                   CASE WHEN e.usuario_id IS NOT NULL THEN 'U' ELSE 'F' END AS tipoPessoa
            FROM tb_emprestimo e
            """;

        // Consulta para a tabela tb_emprestimo_livro
        String sqlLivros = """
            SELECT el.emprestimo_id AS idEmprestimo, 
                   STRING_AGG(el.livro_id::TEXT, ', ') AS livros
            FROM tb_emprestimo_livro el
            GROUP BY el.emprestimo_id
            """;

        // Executar a consulta de empréstimos
        Statement stmtEmprestimos = con.createStatement();
        ResultSet rsEmprestimos = stmtEmprestimos.executeQuery(sqlEmprestimos);

        // Executar a consulta de livros e armazenar em um mapa
        Statement stmtLivros = con.createStatement();
        ResultSet rsLivros = stmtLivros.executeQuery(sqlLivros);

        Map<Long, String> mapaLivros = new HashMap<>();
        while (rsLivros.next()) {
            long idEmprestimo = rsLivros.getLong("idEmprestimo");
            String livros = rsLivros.getString("livros");
            mapaLivros.put(idEmprestimo, livros);
        }

        // Obter o modelo da tabela e limpar dados anteriores
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        tblModel.setRowCount(0);

        // Processar os resultados dos empréstimos
        while (rsEmprestimos.next()) {
            long idEmprestimo = rsEmprestimos.getLong("idEmprestimo");
            String dataEmprestimo = rsEmprestimos.getString("dataEmprestimo");
            String dataDevolucao = rsEmprestimos.getString("dataDevolucao");
            String idPessoa = rsEmprestimos.getString("idPessoa");
            String tipoPessoa = rsEmprestimos.getString("tipoPessoa");
            String pessoaInfo = idPessoa + " (" + tipoPessoa + ")";

            // Obter os livros relacionados ao empréstimo
            String livros = mapaLivros.getOrDefault(idEmprestimo, "");

            // Adicionar os dados na tabela
            tblModel.addRow(new Object[]{idEmprestimo, dataEmprestimo, dataDevolucao, pessoaInfo, livros});
        }

        // Fechar conexões
        rsEmprestimos.close();
        rsLivros.close();
        stmtEmprestimos.close();
        stmtLivros.close();
        con.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao buscar os dados: " + ex.getMessage());
    }
}
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // novo
        TelaCadastroEmprestimo tce = new TelaCadastroEmprestimo();
        tce.setVisible(true);
        tce.setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
try {
  
    int selectedRow = jTable1.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, selecione um empréstimo para deletar.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String idEmprestimoStr = jTable1.getValueAt(selectedRow, 0).toString();
    Integer idEmprestimo;
    idEmprestimo = Integer.valueOf(idEmprestimoStr);


    int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este empréstimo?", "Confirmação", JOptionPane.YES_NO_OPTION);
    if (confirm != JOptionPane.YES_OPTION) {
        return; // Se o usuário cancelar, não prossegue com a exclusão
    }

    // Configurar EntityManager
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoLPOOE2_JoaoArthur");
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    Emprestimo emprestimo = em.find(Emprestimo.class, idEmprestimo);

    if (emprestimo == null) {
        JOptionPane.showMessageDialog(this, "Erro: Empréstimo não encontrado no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        em.getTransaction().rollback();
        em.close();
        emf.close();
        return;
    }

    em.createNativeQuery("DELETE FROM tb_emprestimo_livro WHERE emprestimo_id = :idEmprestimo")
    .setParameter("idEmprestimo", idEmprestimo)
    .executeUpdate();

    em.remove(emprestimo);

    em.getTransaction().commit();
    em.close();
    emf.close();

    JOptionPane.showMessageDialog(this, "Empréstimo deletado com sucesso.");


} catch (Exception ex) {
    JOptionPane.showMessageDialog(this, "Erro ao deletar empréstimo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    ex.printStackTrace();
}

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmprestimos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
