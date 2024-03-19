/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.financ.Telas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felip
 */
public class GridLayout extends javax.swing.JFrame {
    private DefaultTableModel modelo = new DefaultTableModel();
    /**
     * Creates new form GridLayout
     */
    public GridLayout() {
        initComponents();
        setLocationRelativeTo(this);
        carregaTabela();
    }
    
    public void carregaTabela(){
        modelo.addColumn("RA");
        modelo.addColumn("Nome");
        GrdAlunos.setModel(modelo);
        GrdAlunos.getColumnModel().getColumn(0).setPreferredWidth(10);
        GrdAlunos.getColumnModel().getColumn(1).setPreferredWidth(380);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DadoAlunos = new javax.swing.JPanel();
        lblRa = new javax.swing.JLabel();
        TxtRa = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        TxtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        GridExibir = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GrdAlunos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(2, 2));

        DadoAlunos.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Aluno"));
        DadoAlunos.setPreferredSize(new java.awt.Dimension(400, 300));

        lblRa.setText("Ra :");

        lblNome.setText("Nome :");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DadoAlunosLayout = new javax.swing.GroupLayout(DadoAlunos);
        DadoAlunos.setLayout(DadoAlunosLayout);
        DadoAlunosLayout.setHorizontalGroup(
            DadoAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DadoAlunosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DadoAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addGroup(DadoAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(DadoAlunosLayout.createSequentialGroup()
                            .addComponent(lblRa)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TxtRa))
                        .addGroup(DadoAlunosLayout.createSequentialGroup()
                            .addComponent(lblNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(319, Short.MAX_VALUE))
        );
        DadoAlunosLayout.setVerticalGroup(
            DadoAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DadoAlunosLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(DadoAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRa)
                    .addComponent(TxtRa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DadoAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(TxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(DadoAlunos);

        GridExibir.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabela Alunos"));

        GrdAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(GrdAlunos);

        javax.swing.GroupLayout GridExibirLayout = new javax.swing.GroupLayout(GridExibir);
        GridExibir.setLayout(GridExibirLayout);
        GridExibirLayout.setHorizontalGroup(
            GridExibirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GridExibirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );
        GridExibirLayout.setVerticalGroup(
            GridExibirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GridExibirLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        getContentPane().add(GridExibir);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        int Ra = Integer.parseInt(TxtRa.getText().replace("-", ""));
        String Nome = TxtNome.getText();
        modelo.addRow(new Object[]{Ra, Nome});
        TxtNome.setText(null);
        TxtRa.setText(null);
        TxtRa.requestFocus();
        JOptionPane.showMessageDialog(this.GridExibir, "Aluno cadastrado com sucesso");
    }//GEN-LAST:event_btnSalvarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DadoAlunos;
    private javax.swing.JTable GrdAlunos;
    private javax.swing.JPanel GridExibir;
    private javax.swing.JTextField TxtNome;
    private javax.swing.JTextField TxtRa;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRa;
    // End of variables declaration//GEN-END:variables
}
