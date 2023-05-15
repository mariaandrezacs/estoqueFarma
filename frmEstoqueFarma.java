/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoqueFarma;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andreza
 */
public class frmEstoqueFarma extends javax.swing.JFrame {

    /**
     * Creates new form frmEstoqueFarma
     */
    public frmEstoqueFarma() {
        initComponents();
        LeGridRemedio();
    }

    public void LeGridRemedio(){
        
        ArrayList<Remedio> listaRemedio = new ArrayList<Remedio>();
        DBRemedio db = new DBRemedio();
        
        listaRemedio = db.Listar("");
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("id");
        modelo.addColumn("laboratorio");
        modelo.addColumn("nome");
        modelo.addColumn("preço");
        
        Remedio re;
        
        Iterator ite = listaRemedio.iterator();
        
        while(ite.hasNext()){
            re = (Remedio)ite.next();
            
            Object[] ob = {re.getId(), re.getLaboratorio(), re.getNome(), re.getPreco()};
            modelo.addRow(ob);
            
        }
        
        tabRemedio.setModel(modelo);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabRemedio = new javax.swing.JTable();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArquivo = new javax.swing.JMenu();
        mnuAdicionar = new javax.swing.JMenuItem();
        mnuEditar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estoque Farma");

        tabRemedio.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabRemedio);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        mnuArquivo.setText("Remédio");

        mnuAdicionar.setText("Adicionar");
        mnuAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAdicionarActionPerformed(evt);
            }
        });
        mnuArquivo.add(mnuAdicionar);

        jMenuBar1.add(mnuArquivo);

        mnuEditar.setText("Editar");
        jMenuBar1.add(mnuEditar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                        .addComponent(btnAtualizar)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnAlterar)
                    .addComponent(btnAtualizar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAdicionarActionPerformed
        
        frmCadRemedio frm = new frmCadRemedio();
        frm.setVisible(true);
        
    }//GEN-LAST:event_mnuAdicionarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        
        int id = Integer.valueOf(tabRemedio.getValueAt(tabRemedio.getSelectedRow(), 0).toString());
                        
        DBRemedio db = new DBRemedio();
        Remedio rem = db.ConsultaId(id);
        
        frmCadRemedio frm = new frmCadRemedio();
        frm.lblId.setText(String.valueOf((rem.getId())));
        frm.txtLaboratorio.setText(rem.getLaboratorio());
        frm.txtNome.setText(rem.getNome());
        frm.txtPreco.setText(String.valueOf(rem.getPreco()));
        
        frm.setVisible(true);

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resp = JOptionPane.showConfirmDialog(this, "Deseja excluir o registro selecionado?", "Exclusao de registro", JOptionPane.YES_NO_OPTION);
                
        
        if(resp == JOptionPane.YES_OPTION){
            int id = Integer.valueOf(tabRemedio.getValueAt(tabRemedio.getSelectedRow(), 0).toString());
                        
            DBRemedio db = new DBRemedio();
            Remedio rem = db.ConsultaId(id);
            
            db.excluir(rem);
            
            LeGridRemedio();

        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        
        LeGridRemedio();
        JOptionPane.showMessageDialog(this, "Atualizado!");
    }//GEN-LAST:event_btnAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(frmEstoqueFarma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEstoqueFarma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEstoqueFarma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEstoqueFarma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmEstoqueFarma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btnAlterar;
    javax.swing.JButton btnAtualizar;
    javax.swing.JButton btnExcluir;
    javax.swing.JMenuBar jMenuBar1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JMenuItem mnuAdicionar;
    javax.swing.JMenu mnuArquivo;
    javax.swing.JMenu mnuEditar;
    javax.swing.JTable tabRemedio;
    // End of variables declaration//GEN-END:variables
}