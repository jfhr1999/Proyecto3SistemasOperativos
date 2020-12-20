/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Gloriana
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneMainView = new javax.swing.JScrollPane();
        panelMainView = new javax.swing.JPanel();
        txtPath = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        btnCreate = new javax.swing.JButton();
        btnFile = new javax.swing.JButton();
        btnMkdir = new javax.swing.JButton();
        btnCambiardir = new javax.swing.JButton();
        btnListardir = new javax.swing.JButton();
        btnModfile = new javax.swing.JButton();
        btnVerpropiedades = new javax.swing.JButton();
        btnVerfile = new javax.swing.JButton();
        btnCopy = new javax.swing.JButton();
        btnMover = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paneMainView.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        paneMainView.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        paneMainView.setMinimumSize(new java.awt.Dimension(800, 400));
        paneMainView.setPreferredSize(new java.awt.Dimension(800, 400));

        panelMainView.setMaximumSize(new java.awt.Dimension(32767, 32767));
        panelMainView.setMinimumSize(new java.awt.Dimension(800, 400));
        panelMainView.setPreferredSize(new java.awt.Dimension(800, 400));
        panelMainView.setLayout(new javax.swing.BoxLayout(panelMainView, javax.swing.BoxLayout.LINE_AXIS));
        paneMainView.setViewportView(panelMainView);

        txtPath.setText("Root");

        jScrollPane1.setViewportView(jTree1);

        btnCreate.setText("CREATE");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnFile.setText("FILE");
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        btnMkdir.setText("MKDIR");
        btnMkdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMkdirActionPerformed(evt);
            }
        });

        btnCambiardir.setText("CambiarDIR");
        btnCambiardir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiardirActionPerformed(evt);
            }
        });

        btnListardir.setText("ListarDIR");
        btnListardir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListardirActionPerformed(evt);
            }
        });

        btnModfile.setText("ModFILE");
        btnModfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModfileActionPerformed(evt);
            }
        });

        btnVerpropiedades.setText("Propiedades");
        btnVerpropiedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerpropiedadesActionPerformed(evt);
            }
        });

        btnVerfile.setText("VerFile");
        btnVerfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerfileActionPerformed(evt);
            }
        });

        btnCopy.setText("CoPY");
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyActionPerformed(evt);
            }
        });

        btnMover.setText("MoVer");
        btnMover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoverActionPerformed(evt);
            }
        });

        btnRemove.setText("ReMove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPath)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(paneMainView, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(btnMkdir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCambiardir, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(btnListardir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVerpropiedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCopy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(662, 662, 662))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paneMainView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiardir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerpropiedades, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMover, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFile, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListardir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerfile, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMkdir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModfile, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFileActionPerformed

    private void btnMkdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMkdirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMkdirActionPerformed

    private void btnCambiardirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiardirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambiardirActionPerformed

    private void btnListardirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListardirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListardirActionPerformed

    private void btnModfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModfileActionPerformed

    private void btnVerpropiedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerpropiedadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerpropiedadesActionPerformed

    private void btnVerfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerfileActionPerformed

    private void btnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCopyActionPerformed

    private void btnMoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoverActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCambiardir;
    public javax.swing.JButton btnCopy;
    public javax.swing.JButton btnCreate;
    public javax.swing.JButton btnFile;
    public javax.swing.JButton btnListardir;
    public javax.swing.JButton btnMkdir;
    public javax.swing.JButton btnModfile;
    public javax.swing.JButton btnMover;
    public javax.swing.JButton btnRemove;
    public javax.swing.JButton btnVerfile;
    public javax.swing.JButton btnVerpropiedades;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTree jTree1;
    public javax.swing.JScrollPane paneMainView;
    public javax.swing.JPanel panelMainView;
    public javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables
}
