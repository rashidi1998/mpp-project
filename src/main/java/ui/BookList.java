/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import auth.AuthenticationManager;
import business.Book;
import business.Role;
import controller.BookController;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abenitrust
 */
public class BookList extends javax.swing.JPanel implements Initializable {

    /**
     * Creates new form BookListP
     */
    public BookList() {
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

        addBookBtn = new javax.swing.JButton();
        addBookCopyBtn = new javax.swing.JButton();
        tablePane = new javax.swing.JScrollPane();
        bookListTable = new javax.swing.JTable();

        addBookBtn.setText("AddBook");
        addBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookBtnActionPerformed(evt);
            }
        });

        addBookCopyBtn.setText("Add Copy");
        addBookCopyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookCopyBtnActionPerformed(evt);
            }
        });

        bookListTable.setModel(initTable());
        tablePane.setViewportView(bookListTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBookBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addBookCopyBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBookBtn)
                    .addComponent(addBookCopyBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookBtnActionPerformed
        MainWindow container = getMainWindow();
        container.switch_panel(container.getAddNewBookPage());
    }//GEN-LAST:event_addBookBtnActionPerformed

    private void addBookCopyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookCopyBtnActionPerformed
        MainWindow container = getMainWindow();
        container.switch_panel(container.getAddBookCopyPage());
    }//GEN-LAST:event_addBookCopyBtnActionPerformed
    
    public Object[][] getTableData(){
        BookController controller = BookController.getInstance();
        List<Book> books = controller.getBookList(); 
        Object[][] data = new Object[books.size()][3];
        int rowCount = 0;

        for(Book book: books) {
            data[rowCount][0] = book.getTitle();
            data[rowCount][1] = book.getIsbn();
            data[rowCount][2] = book.getCopyCount();
            rowCount++;
        }
        
        return data;
    }
    

    public DefaultTableModel initTable() {
        Object[][] data = getTableData();        
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        return model;
    }
    
    private MainWindow getMainWindow() {
        return (MainWindow)SwingUtilities.getWindowAncestor(this);
    }
    
    public void updateBtnVisiblityByRole() {
        Role memberRole = AuthenticationManager.INSTANCE.getUser().getRole();
        switch(memberRole) {
            case ADMIN:
                addBookBtn.setVisible(true);
                addBookCopyBtn.setVisible(true);
                break;
            case LIBRARIAN:
                addBookBtn.setVisible(false);
                addBookCopyBtn.setVisible(false);
                break;
            case BOTH:
                addBookBtn.setVisible(true);
                addBookCopyBtn.setVisible(true);
            default:
                break;
        }
    }

    public void onPanelVisible() {
        DefaultTableModel model = (DefaultTableModel)bookListTable.getModel();
        model.setDataVector(getTableData(), columnNames);
        model.fireTableDataChanged();
        updateBtnVisiblityByRole();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookBtn;
    private javax.swing.JButton addBookCopyBtn;
    private javax.swing.JTable bookListTable;
    private javax.swing.JScrollPane tablePane;
    // End of variables declaration//GEN-END:variables
    private String[] columnNames = {"Title", "ISBN", "Copies" };
}