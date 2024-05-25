package View;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * This class defines the structure of the selection screen for the type of 
 * storage device chosen by the user before starting to interact with the 
 * application.
 * @author Francesc Perez
 * @version 1.0
 */

public class DataStorageSelection extends javax.swing.JFrame {

    javax.swing.JCheckBox itemSelected;

    public DataStorageSelection() {
        initComponents();
        String projectDir = System.getProperty("user.dir");
        String s = File.separator;
        String pathImageLogo = projectDir + s + "images" + s + "logo.png";
        try {
            setIconImage(new ImageIcon(ImageIO.read(new File(pathImageLogo))).getImage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Application logo is not available. Can not be found in " + pathImageLogo, "Logo - People v1.0", JOptionPane.WARNING_MESSAGE);
        }
        setLocationRelativeTo(null);
        arrayListCheck.setSelected(true);
        itemSelected = arrayListCheck;
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

        answer = new javax.swing.JLabel();
        arrayListCheck = new javax.swing.JCheckBox();
        fileCheck = new javax.swing.JCheckBox();
        dataBaseCheck = new javax.swing.JCheckBox();
        hashMapCheck = new javax.swing.JCheckBox();
        fileSerializationCheck = new javax.swing.JCheckBox();
        dataBaseSerializationCheck = new javax.swing.JCheckBox();
        authorMail = new javax.swing.JLabel();
        accept = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Storage Selection - People v1.0");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusable(false);
        setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        setMaximumSize(new java.awt.Dimension(500, 550));
        setMinimumSize(new java.awt.Dimension(500, 550));
        setPreferredSize(new java.awt.Dimension(500, 550));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        answer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        answer.setText("What kind of data storage do you want to use? ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 24, 12, 24);
        getContentPane().add(answer, gridBagConstraints);

        arrayListCheck.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        arrayListCheck.setText("ArrayList");
        arrayListCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrayListCheckActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 24, 12, 24);
        getContentPane().add(arrayListCheck, gridBagConstraints);

        fileCheck.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fileCheck.setText("File");
        fileCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileCheckActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 24, 12, 24);
        getContentPane().add(fileCheck, gridBagConstraints);

        dataBaseCheck.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dataBaseCheck.setText("Database");
        dataBaseCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataBaseCheckActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 24, 12, 24);
        getContentPane().add(dataBaseCheck, gridBagConstraints);

        hashMapCheck.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        hashMapCheck.setText("HashMap");
        hashMapCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hashMapCheckActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 24, 12, 24);
        getContentPane().add(hashMapCheck, gridBagConstraints);

        fileSerializationCheck.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fileSerializationCheck.setText("File (Serialization)");
        fileSerializationCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSerializationCheckActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 24, 12, 24);
        getContentPane().add(fileSerializationCheck, gridBagConstraints);

        dataBaseSerializationCheck.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dataBaseSerializationCheck.setText("Database (Serialization)");
        dataBaseSerializationCheck.setEnabled(false);
        dataBaseSerializationCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataBaseSerializationCheckActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 24, 12, 24);
        getContentPane().add(dataBaseSerializationCheck, gridBagConstraints);

        authorMail.setFont(new java.awt.Font("Segoe UI", 2, 8)); // NOI18N
        authorMail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authorMail.setText("Author: francesc.perez@stucom.com - Version 1.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(12, 24, 12, 24);
        getContentPane().add(authorMail, gridBagConstraints);
        authorMail.getAccessibleContext().setAccessibleName("francesc.perez@stucom.com - version 1.0");

        accept.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        accept.setText("Accept");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 60, 12, 12);
        getContentPane().add(accept, gridBagConstraints);

        cancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 60);
        getContentPane().add(cancel, gridBagConstraints);

        getAccessibleContext().setAccessibleName("Data Storage Selection - People v1.0 ");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method allows you to select a single storage system, by default it 
     * is the "ArrayList". Only when there is a selection is the accept button 
     * activated so that the event can be sent to the controller.
     * @param jcb checkbox selected by user
     */
    private void JCB(javax.swing.JCheckBox jcb) {
        if (jcb.isSelected()) {
            itemSelected = jcb;
            for (Component component : getContentPane().getComponents()) {
                if (component instanceof javax.swing.JCheckBox && component != jcb) {
                    ((javax.swing.JCheckBox)component).setSelected(false);
                }
            }
            accept.setEnabled(true);
        } else {
            itemSelected = null;
            accept.setEnabled(false);
        }
    }

    public Component [] getAccept() {
        Component c [] = new Component[2];
        c[0] = accept;
        c[1] = itemSelected;
        return c;
    }

    private void arrayListCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrayListCheckActionPerformed
        JCB(arrayListCheck);
    }//GEN-LAST:event_arrayListCheckActionPerformed

    private void dataBaseSerializationCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataBaseSerializationCheckActionPerformed
        JCB(dataBaseSerializationCheck);
    }//GEN-LAST:event_dataBaseSerializationCheckActionPerformed

    private void hashMapCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hashMapCheckActionPerformed
        JCB(hashMapCheck);
    }//GEN-LAST:event_hashMapCheckActionPerformed

    private void fileCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileCheckActionPerformed
        JCB(fileCheck);
    }//GEN-LAST:event_fileCheckActionPerformed

    private void fileSerializationCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSerializationCheckActionPerformed
        JCB(fileSerializationCheck);
    }//GEN-LAST:event_fileSerializationCheckActionPerformed

    private void dataBaseCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataBaseCheckActionPerformed
        JCB(dataBaseCheck);
    }//GEN-LAST:event_dataBaseCheckActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JLabel answer;
    private javax.swing.JCheckBox arrayListCheck;
    private javax.swing.JLabel authorMail;
    private javax.swing.JButton cancel;
    private javax.swing.JCheckBox dataBaseCheck;
    private javax.swing.JCheckBox dataBaseSerializationCheck;
    private javax.swing.JCheckBox fileCheck;
    private javax.swing.JCheckBox fileSerializationCheck;
    private javax.swing.JCheckBox hashMapCheck;
    // End of variables declaration//GEN-END:variables
}
