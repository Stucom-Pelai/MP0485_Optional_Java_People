package View;

import static OtherFunctions.DataValidation.calculateNifLetter;
import static OtherFunctions.DataValidation.validateNameLetter;
import static OtherFunctions.DataValidation.validateNifNumber;
import java.awt.dnd.DropTarget;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;

/**
 * @author Francesc Perez
 * @version 1.1.0
 */
public class Update extends javax.swing.JDialog {

    public Update(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        DropPhotoListener d = new DropPhotoListener(photo, this);
        DropTarget dropTarget = new DropTarget(this, d);
        read.setVisible(false);
    }

    public JButton getUpdate() {
        return update;
    }

    public JButton getRead() {
        return read;
    }

    public JTextField getNam() {
        return name;
    }

    public JDatePicker getDateOfBirth() {
        return dateOfBirth;
    }

    public JTextField getNif() {
        return nif;
    }

    public JLabel getPhoto() {
        return photo;
    }

    public JButton getUpdateReset() {
        return updateReset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        update = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nif = new javax.swing.JTextField();
        photo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dateOfBirth = new org.jdatepicker.JDatePicker();
        updateReset = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        read = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update - People v1.0");
        setMinimumSize(new java.awt.Dimension(810, 280));
        setPreferredSize(new java.awt.Dimension(810, 280));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        update.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update.setText("UPDATE");
        update.setMaximumSize(new java.awt.Dimension(194, 33));
        update.setMinimumSize(new java.awt.Dimension(194, 33));
        update.setPreferredSize(new java.awt.Dimension(194, 33));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        getContentPane().add(update, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("NIF ");
        jLabel1.setMaximumSize(new java.awt.Dimension(100, 22));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 22));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 12, 12, 12);
        getContentPane().add(jLabel1, gridBagConstraints);

        nif.setMaximumSize(new java.awt.Dimension(400, 22));
        nif.setMinimumSize(new java.awt.Dimension(400, 22));
        nif.setPreferredSize(new java.awt.Dimension(400, 22));
        nif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nifKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nifKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nifKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 12, 12, 24);
        getContentPane().add(nif, gridBagConstraints);

        photo.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setText("<html><center>PHOTO</center></br><br><center> <i>Supported formats: .GIF, .PNG, .JFIF, .JPG</i></center></br><br><center><i>Maximum size 64KB</i></center></html>");
        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        photo.setEnabled(false);
        photo.setMaximumSize(new java.awt.Dimension(150, 135));
        photo.setMinimumSize(new java.awt.Dimension(150, 135));
        photo.setPreferredSize(new java.awt.Dimension(150, 135));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 24, 12, 12);
        getContentPane().add(photo, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Name");
        jLabel3.setMaximumSize(new java.awt.Dimension(100, 22));
        jLabel3.setMinimumSize(new java.awt.Dimension(100, 22));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        getContentPane().add(jLabel3, gridBagConstraints);

        name.setEnabled(false);
        name.setMaximumSize(new java.awt.Dimension(400, 22));
        name.setMinimumSize(new java.awt.Dimension(400, 22));
        name.setPreferredSize(new java.awt.Dimension(400, 22));
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 24);
        getContentPane().add(name, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Date of Birth");
        jLabel8.setMaximumSize(new java.awt.Dimension(150, 22));
        jLabel8.setMinimumSize(new java.awt.Dimension(159, 22));
        jLabel8.setPreferredSize(new java.awt.Dimension(150, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        getContentPane().add(jLabel8, gridBagConstraints);

        dateOfBirth.setEnabled(false);
        dateOfBirth.setMaximumSize(new java.awt.Dimension(359, 22));
        dateOfBirth.setMinimumSize(new java.awt.Dimension(350, 22));
        dateOfBirth.setPreferredSize(new java.awt.Dimension(350, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 24);
        getContentPane().add(dateOfBirth, gridBagConstraints);

        updateReset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        updateReset.setText("RESET");
        updateReset.setMaximumSize(new java.awt.Dimension(194, 33));
        updateReset.setMinimumSize(new java.awt.Dimension(194, 33));
        updateReset.setPreferredSize(new java.awt.Dimension(194, 33));
        updateReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateResetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 24);
        getContentPane().add(updateReset, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 8)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Author: francesc.perez@stucom.com - Version 1.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 24, 12, 12);
        getContentPane().add(jLabel2, gridBagConstraints);

        read.setText("readnoVisible");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 12);
        getContentPane().add(read, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nifKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nifKeyPressed
        if (nif.isEditable()) {
            if (!validateNifNumber(evt.getKeyChar()) && evt.getKeyCode() != KeyEvent.VK_UP
                    && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_LEFT
                    && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_SHIFT
                    && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyCode() != KeyEvent.VK_DELETE) {
                JOptionPane.showMessageDialog(this, "Type only numbers [0-9]", "Read - People v1.0", JOptionPane.WARNING_MESSAGE);
                int posDelete = nif.getText().indexOf(evt.getKeyChar());
                StringBuilder newNif = new StringBuilder(nif.getText());
                nif.setText(newNif.deleteCharAt(posDelete).toString());
            }
        }
    }//GEN-LAST:event_nifKeyPressed

    private void nifKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nifKeyReleased
        if (nif.getText().length() == 8) {
            nif.setText(calculateNifLetter(nif.getText()));
            nif.setEditable(false);
            name.setEnabled(true);
            dateOfBirth.setEnabled(true);
            photo.setEnabled(true);
            read.doClick();
        }
    }//GEN-LAST:event_nifKeyReleased

    private void nifKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nifKeyTyped
        if (nif.getText().length() == 8) {
            nif.setText(calculateNifLetter(nif.getText()));
            nif.setEditable(false);
            name.setEnabled(true);
            dateOfBirth.setEnabled(true);
            photo.setEnabled(true);
            read.doClick();
        }             // TODO add your handling code here:
    }//GEN-LAST:event_nifKeyTyped

    private void updateResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateResetActionPerformed
        nif.setEditable(true);
        nif.setText("");
        name.setText("");
        //We reset the calendar date to the current date ...
        LocalDate dateLocate = LocalDate.now();
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = dateLocate.atStartOfDay(systemTimeZone);
        Date dateUtil = java.sql.Date.from(zonedDateTime.toInstant());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateUtil);
        DateModel<Calendar> dateModel = (DateModel<Calendar>) dateOfBirth.getModel();
        dateModel.setValue(calendar);
        //... but do not display it in the JDatePicker box
        dateOfBirth.getModel().setValue(null);
        photo.setIcon(null);        // TODO add your handling code here:
    }//GEN-LAST:event_updateResetActionPerformed

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        if (!validateNameLetter(evt.getKeyChar()) && evt.getKeyCode() != KeyEvent.VK_UP
                && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_LEFT
                && evt.getKeyCode() != KeyEvent.VK_RIGHT && evt.getKeyCode() != KeyEvent.VK_SHIFT
                && evt.getKeyCode() != KeyEvent.VK_BACK_SPACE && evt.getKeyCode() != KeyEvent.VK_DELETE) {
            JOptionPane.showMessageDialog(this, "Type only uppercase or lowercase letters, hyphens, and whitespace.", "UPdate - People v1.0", JOptionPane.WARNING_MESSAGE);
            int posDelete = name.getText().indexOf(evt.getKeyChar());
            StringBuilder newName = new StringBuilder(name.getText());
            name.setText(newName.deleteCharAt(posDelete).toString());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_nameKeyPressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdatepicker.JDatePicker dateOfBirth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nif;
    private javax.swing.JLabel photo;
    private javax.swing.JButton read;
    private javax.swing.JButton update;
    private javax.swing.JButton updateReset;
    // End of variables declaration//GEN-END:variables
}
