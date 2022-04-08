/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import javax.swing.JPanel;

import auth.*;
import business.Role;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


/**
 *
 * @author abenitrust
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        switch_panel(loginP);
        HomeMenu.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        HomeMenu = new javax.swing.JMenu();
        Home = new javax.swing.JMenuItem();
        booksMenu = new javax.swing.JMenuItem();
        membersMenu = new javax.swing.JMenuItem();
        logOut = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HomeMenu.setText("Navigate");

        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });
        HomeMenu.add(Home);

        booksMenu.setText("Books");
        booksMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksMenuActionPerformed(evt);
            }
        });
        HomeMenu.add(booksMenu);

        membersMenu.setText("Members");
        membersMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membersMenuActionPerformed(evt);
            }
        });
        HomeMenu.add(membersMenu);

        logOut.setText("Log out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        HomeMenu.add(logOut);

        jMenuBar1.add(HomeMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        switch_panel(getLandingPage());
    }//GEN-LAST:event_HomeActionPerformed

    private void booksMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksMenuActionPerformed
        switch_panel(getBookListPage());
    }//GEN-LAST:event_booksMenuActionPerformed

    private void membersMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membersMenuActionPerformed
        switch_panel(getMemberListPage());
    }//GEN-LAST:event_membersMenuActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        AuthenticationManager.INSTANCE.clearSession();
        switch_panel(getLoginPage());
    }//GEN-LAST:event_logOutActionPerformed

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
    
      
    public void switch_panel(Initializable p) {
        this.setContentPane((JPanel)p);
        this.pack();
        this.revalidate();
        p.onPanelVisible();
    }
    
    public LandingPageP getLandingPage() {
        return landingPageP;
    }
    
    public Login getLoginPage() {
        return loginP;
    }
    
    public BookList getBookListPage() {
        return bookListP;
    }
    
    public MemberList getMemberListPage() {
        return memberListP;
    }
    
    public AddNewBook getAddNewBookPage() {
        return addNewBookP;
    }
    
    public AddBookCopy getAddBookCopyPage() {
        return addBookCopyP;
    }
    
    public Checkout getCheckoutPage() {
        return checkoutP;
    }
    
    public javax.swing.JMenuItem getMembersMenu() {
        return membersMenu;
    }
    
    public javax.swing.JMenu getHomeMenu() {
        return HomeMenu;
    }
    
    public void showErrorDialog(String errMsg) {
        JOptionPane.showMessageDialog(this, errMsg, "Error", JOptionPane.ERROR_MESSAGE);
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Home;
    private javax.swing.JMenu HomeMenu;
    private javax.swing.JMenuItem booksMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem logOut;
    private javax.swing.JMenuItem membersMenu;
    // End of variables declaration//GEN-END:variables
    
    private Login loginP = new Login();
    private LandingPageP landingPageP = new LandingPageP();
    private BookList bookListP = new BookList();
    private MemberList memberListP = new MemberList();
    private AddNewBook addNewBookP = new AddNewBook();
    private AddBookCopy addBookCopyP = new AddBookCopy();
    private Checkout checkoutP = new Checkout();
    
}
