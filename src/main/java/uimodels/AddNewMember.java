package uimodels;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;

import controller.MemberController;
import javax.swing.SwingUtilities;

import models.LibraryMemberModel;

public class AddNewMember extends javax.swing.JPanel  implements Initializable{

    /**
     * Creates new form AddNewMember
     */
    public AddNewMember() {
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

        jLabel9 = new javax.swing.JLabel();
        role = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        firstName = new javax.swing.JTextField();
        state = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        zip = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        street = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        AddMemberBtn = new javax.swing.JButton();
        cancelAddBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        memberID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();

        jLabel9.setText("street");

        role.setModel(new DefaultComboBoxModel<>(businessmodels.Role.values()));
        role.setSelectedIndex(0);

        jLabel1.setText("FirstName");

        jLabel2.setText("LastName");

        jLabel3.setText("Phone");

        jLabel6.setText("City");

        jLabel4.setText("Address");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Zip");

        jLabel5.setText("Role");

        jLabel8.setText("state");

        AddMemberBtn.setText("Add");
        AddMemberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMemberBtnActionPerformed(evt);
            }
        });

        cancelAddBtn.setText("Cancel");
        cancelAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddBtnActionPerformed(evt);
            }
        });

        jLabel10.setText("Member ID");

        jLabel11.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(role, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phone)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddMemberBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(cancelAddBtn))
                    .addComponent(state, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(zip)
                    .addComponent(city, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(street, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(password)
                    .addComponent(lastName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(memberID, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(firstName))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(memberID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(street, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(zip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddMemberBtn)
                    .addComponent(cancelAddBtn))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddMemberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMemberBtnActionPerformed
        
        LibraryMemberModel newMember = new LibraryMemberModel(
            getFistName(), getLastName(), getPhone(), getMemberID(), getPassword()
            , getRole(), getStreet(), getCity(), getZip(), getState()
        );

        try {
            MemberController.getInstance().addMember(newMember, this); 
            getMainWindow().switch_panel(new MemberList());
            closeParentDialog();
        } catch (Exception e) {
            getMainWindow().showErrorDialog(e.getMessage());
        }
        
    }//GEN-LAST:event_AddMemberBtnActionPerformed

    private void cancelAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddBtnActionPerformed
        closeParentDialog();
    }//GEN-LAST:event_cancelAddBtnActionPerformed
    
    public MainWindow getMainWindow() {
        JDialog parentDialog = (JDialog)SwingUtilities.getWindowAncestor(this);
        return (MainWindow)parentDialog.getOwner();
    }

    public void closeParentDialog() {
        SwingUtilities.windowForComponent(this).dispose();
    }
    
    public String getFistName() { return firstName.getText(); }
    
    public String getLastName(){ return lastName.getText(); }
   
    public String getMemberID() { return memberID.getText(); }

    public String getPhone() { return phone.getText(); }
    
    public String getCity() { return city.getText(); }
    
    public String getState() { return state.getText(); }
    
    public String getStreet() { return street.getText(); }
    
    public String getZip() { return zip.getText(); }
    
    public String getPassword() { return password.getText(); }
    
    public businessmodels.Role getRole() { return (businessmodels.Role)role.getSelectedItem(); }
    
    public void onPanelVisible() {}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddMemberBtn;
    private javax.swing.JButton cancelAddBtn;
    private javax.swing.JTextField city;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastName;
    private javax.swing.JTextField memberID;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField phone;
    private javax.swing.JComboBox<businessmodels.Role> role;
    private javax.swing.JTextField state;
    private javax.swing.JTextField street;
    private javax.swing.JTextField zip;
    // End of variables declaration//GEN-END:variables
}
