/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import business.Biblioteca;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author MatheusSabino
 */
public final class Emprestimo extends javax.swing.JFrame {

    Biblioteca biblioteca;
    DefaultTableModel model;

    /**
     * Creates new form Emprestimo
     *
     * @param biblioteca
     */
    public Emprestimo(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        initComponents();
        listarProcedimentos();

        model = (DefaultTableModel) tblLivros.getModel();
        tblLivros.setRowSorter(new TableRowSorter(model));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLivros = new javax.swing.JTable();
        btnPedirEmprestimo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Emprestimo de Livro");

        jLabel2.setText("Selecione seu livro:");

        tblLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome do Livro", "Genero", "Autor", "Qtde disponível"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblLivros);
        if (tblLivros.getColumnModel().getColumnCount() > 0) {
            tblLivros.getColumnModel().getColumn(0).setHeaderValue("ID");
            tblLivros.getColumnModel().getColumn(1).setHeaderValue("Nome do Livro");
            tblLivros.getColumnModel().getColumn(2).setHeaderValue("Genero");
            tblLivros.getColumnModel().getColumn(3).setHeaderValue("Autor");
            tblLivros.getColumnModel().getColumn(4).setHeaderValue("Qtde disponível");
        }

        btnPedirEmprestimo.setText("Pedir livro emprestado");
        btnPedirEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedirEmprestimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(btnPedirEmprestimo)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPedirEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void btnPedirEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
        try {
            String valor = JOptionPane.showInputDialog(null, "Quantos livros deseja pegar emprestado?");
            Integer valorInt = Integer.valueOf(valor);
            Integer linhaSelecionada = tblLivros.getSelectedRow();
            String id = tblLivros.getValueAt(linhaSelecionada, 0).toString();
            Integer idTabela = Integer.valueOf(id);

            for (int i = 0; i < biblioteca.livros.size(); i++) {
                if (Objects.equals(biblioteca.livros.get(i).getId(), idTabela)) {
                    if (valorInt <= biblioteca.livros.get(i).getNumExemplares()) {
                        Integer input = JOptionPane.showConfirmDialog(null, "Confirma o emprestimo de "
                                + valorInt + " " + biblioteca.livros.get(i).getNome());
                        if (input == 0) {
                            biblioteca.livros.get(i).setNumExemplares(biblioteca.livros.get(i).getNumExemplares() - valorInt);
                           JOptionPane.showMessageDialog(null,"Emprestimo realizado com sucesso!");
                           listarProcedimentos();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Digite um valor menor do que "
                                + biblioteca.livros.get(i).getNumExemplares() + "para "
                                + biblioteca.livros.get(i).getNome());
                    }

                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Número inválido");
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
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Emprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Emprestimo(biblioteca).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnPedirEmprestimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblLivros;
    // End of variables declaration                   

    public void listarProcedimentos() {
        try {
            // ProcedimentoDAO procedimentodao = new ProcedimentoDAO();

            model = (DefaultTableModel) tblLivros.getModel();
            model.setNumRows(0);

            for (int num = 0; num < biblioteca.livros.size(); num++) {
                if (biblioteca.livros.get(num).getNumExemplares() > 0) {
                    model.addRow(new Object[]{
                        biblioteca.livros.get(num).getId(),
                        biblioteca.livros.get(num).getNome(),
                        biblioteca.livros.get(num).getGenero(),
                        biblioteca.livros.get(num).getAutor().getNome(),
                        biblioteca.livros.get(num).getNumExemplares()});
                }
            }
            DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            esquerda.setHorizontalAlignment(SwingConstants.LEFT);

            tblLivros.getColumnModel().getColumn(0).setCellRenderer(esquerda);
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tblLivros.getColumnModel().getColumn(2).setCellRenderer(centralizado);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ListarProcedimentos()" + e);
        }
    }

}
