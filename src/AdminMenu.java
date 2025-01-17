/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author reva.yoga
 */
public class AdminMenu extends javax.swing.JFrame {

    private String usernameLoggedIn;
    ReceiptOrder receiptPage = new ReceiptOrder();
    
    /**
     * Creates new form NewAdminMenu
     */
    public AdminMenu() {
        initComponents();
        receiptPage.isOnlyShowingReceiptFromAdmin = true;
    }
    
    void setupLayout(String usernameLoggedIn) {
        this.usernameLoggedIn = usernameLoggedIn;
        titleLabel.setText(titleLabel.getText() + " " + usernameLoggedIn);
        int countOrder = OrderCenter.sumOrder();
        
        if(countOrder > 0) {
            countOrder--;
        }
        
        jumlahReceiptLabel.setText(jumlahReceiptLabel.getText() + " " + countOrder);
        
        indexReceiptChoice.add("-");
        for (int i = 0; i < countOrder; i++) {
            indexReceiptChoice.add("" + (i+1));
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

        titleLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jumlahReceiptLabel = new javax.swing.JLabel();
        lihatReceiptLabel = new javax.swing.JLabel();
        indexReceiptChoice = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Welcome Admin: ");

        logoutButton.setText("Logout");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });

        jumlahReceiptLabel.setText("Jumlah Receipt: ");

        lihatReceiptLabel.setText("Lihat Receipt ke:");

        indexReceiptChoice.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                indexReceiptChoiceItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logoutButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lihatReceiptLabel)
                                .addGap(26, 26, 26)
                                .addComponent(indexReceiptChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jumlahReceiptLabel))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jumlahReceiptLabel)
                        .addGap(18, 18, 18)
                        .addComponent(lihatReceiptLabel))
                    .addComponent(indexReceiptChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(295, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        //logout untuk kembali ke menu awal login page
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.resetUsersLoggedIn();
        loginMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void indexReceiptChoiceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_indexReceiptChoiceItemStateChanged
        String indexReceipt = indexReceiptChoice.getSelectedItem();
        
        System.out.println("index: " + indexReceipt);
        
        // munculkan receipt page apabila index yang dipilih valid
        if(indexReceipt != "-" && indexReceipt != null) {
            int indexChoosen = Integer.valueOf(indexReceipt);
            indexChoosen--;
            System.out.println("index: " + indexChoosen);
            
            if(indexChoosen >= 0) {
                receiptPage.indexReceipt = indexChoosen;
                
                // After:
                ReceiptChecker choosenReceipt = new ReceiptChecker(indexChoosen);
                ReceiptChecker willShownReceipt = new ReceiptChecker(receiptPage.indexReceipt);
                
                if(choosenReceipt.equals(willShownReceipt)) {
                    receiptPage.setupLayout();
                    receiptPage.setVisible(true);
                } else {
                    System.out.println("error, receipt is not same with choosen one");
                }
            }
        }
    }//GEN-LAST:event_indexReceiptChoiceItemStateChanged

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
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice indexReceiptChoice;
    private javax.swing.JLabel jumlahReceiptLabel;
    private javax.swing.JLabel lihatReceiptLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
