/*
* Copyright 2024 Riccardo Inverardi Galli
* Permission is hereby granted, free of charge, to any person obtaining a copy 
* of this software and associated documentation files (the “Software”), to deal 
* in the Software without restriction, including without limitation the rights 
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
* copies of the Software, and to permit persons to whom the Software is 
* furnished to do so, subject to the following conditions:
* The above copyright notice and this permission notice shall be included in 
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE 
* SOFTWARE.
*/
package com.mycompany.phonebook;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.io.*;
/**
 *
 * @author Riccardo Inverardi Galli
 */
public class phoneBookGUI extends javax.swing.JFrame {
    private Vector<Person> list; /* list that stores the contacts */
    private DefaultTableModel tableModel; /* table model used to update the table */
    private static String infoFile = "info.txt"; /* static string for the contacts file */
    
    public phoneBookGUI() {
        this.list = new Vector<Person>();
        initComponents();
        initTable();
        setLocationRelativeTo(null);
    }
    private void initTable() {
        /* This initializes the table model to a table of 3 columns and 0 rows */
        String[] colNames = {"Name", "Surname", "Phone"};
        this.tableModel = new DefaultTableModel(colNames, 0); 
        this.jTable2.setModel(tableModel);
        /* make a reference for the contacts file, and create the file if it 
         * does not exist yer */
        File inFile = new File(infoFile);
        if (!inFile.exists()) {
            try 
            {
            inFile.createNewFile();
            } catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        /* Read the file, populate the list and the table at the same time */
        try (BufferedReader reader = new BufferedReader(new FileReader(inFile))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                String[] fields = line.split(";");
                Person p = new Person(fields[0], fields[1],
                                      fields[2], fields[3], 
                                      fields[4], Integer.parseInt(fields[5]));
                this.list.add(p);
                Object[] data = {
                    p.getName(),
                    p.getSurname(),
                    p.getPhone(),
                };
                this.tableModel.addRow(data);
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    /* This methods adds a new contact p to the contacts table in the app. 
     * It also updates the contacts file  */
    protected void addContactToTable(Person p) {
        Object[] data = {
            p.getName(),
            p.getSurname(),
            p.getPhone(),
        };
        this.tableModel.addRow(data);
        this.list.add(p);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(infoFile, true))) {
        String row = String.format("%s;%s;%s;%s;%s;%d",
            p.getId(),
            p.getName(),
            p.getSurname(),
            p.getAddress(),
            p.getPhone(),
            p.getAge()
        );
        writer.write(row);
        writer.newLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    /* This method updates a Row in the table with newly entered info */
    protected void updateRow(int rowIdx, Person p) {
        tableModel.setValueAt(p.getName(), rowIdx, 0);
        tableModel.setValueAt(p.getSurname(), rowIdx, 1);
        tableModel.setValueAt(p.getPhone(), rowIdx, 2);
        
        /* Create two File objects for reading and writing. Writing is done on 
         * the temporary file, which is later transformed into the actual file. */
        File inFile = new File(infoFile);
        File tFile = new File("temp.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(inFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tFile)))
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                /* get each field for that particular line */
                String[] fields = line.split(";");
                /* identify the line to be updated through its unique id */
                String id = fields[0];
                if (id.equals(p.id)) 
                {
                    String nStr = String.format("%s;%s;%s;%s;%s;%d", 
                                                p.getId(),
                                                p.getName(),
                                                p.getSurname(),
                                                p.getAddress(),
                                                p.getPhone(),
                                                p.getAge()
                                                );
                    writer.write(nStr);
                } else 
                {
                    writer.write(line);
                }
                writer.newLine();
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        /* Delete the original file */
        if (!inFile.delete())
        {
            System.err.println("Could not delete original file");
        }
        /* Rename the temporary file */
        if (!tFile.renameTo(inFile))
        {
            System.err.println("Could not rename temporary file");
        }
            
    }
    /* This code was generated by the editor */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modify");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable2);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("New");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Modify");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Delete");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /* Code for the "New" button. It simply calls one of the constructors of 
     * the PersonEditorGUI class. If the fields are modified and the "Save" 
     * button is pressed, then a new contact will be created. This logic is 
     * implemented inside PersonEditorGUI */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /* New button */
        PersonEditorGUI editor = new PersonEditorGUI(this, list);
        editor.setLocationRelativeTo(this);
        editor.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /* Code for the "Modify" button */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /* Modify buttton */
        int selectedRow = jTable2.getSelectedRow();
        /* If no row has been selected, pop out a window that asks to select a 
         * row first */
        if (selectedRow == -1) 
        {
            JOptionPane.showMessageDialog(
            this, 
            "Plese select a contact before pressing the modify button.", 
            "No Selection", 
            JOptionPane.WARNING_MESSAGE
            );
        }
        /* Select the person to be modified through the index in the list. A 
         * constructor is then called with references to the list, the selected 
         * object, and the index of the selected object in the list. The contact
         * will be modified once the "Save" button is pressed in PersonEditorGUI */
        Person selected = list.get(selectedRow);
        PersonEditorGUI editor = new PersonEditorGUI(this, list, selected, selectedRow);
        editor.setLocationRelativeTo(this);
        editor.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    /* Code for the "Delete" button */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /* Delete button */
        int selectedRow = jTable2.getSelectedRow();
        /* If no row has been selected, pop out a window that asks to select a 
         * row first */
        if (selectedRow == -1) 
        {
            JOptionPane.showMessageDialog(
            this, 
            "Plese select a contact before pressing the delete button.", 
            "Invalid Selection", 
            JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        Person p = list.get(selectedRow);
        String conf = String.format("Are you sure you want to delete the contact %s %s?", p.getName(), p.getSurname());
        String[] opts = {"Yes", "No"};
        /* Get a confirmation over the deletion of person p */
        int confirm = JOptionPane.showOptionDialog(
                                this, 
                                conf, 
                                "Confirm Deletion", 
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opts,
                                opts[1]
                                );
        if (confirm == JOptionPane.YES_OPTION) 
        {
            /* Remove the contact from the list and from the table */
            list.remove(selectedRow);
            tableModel.removeRow(selectedRow);
            /* Remove the contact from the info.txt file. The procedure is 
             * similar to the update one */
            File inFile = new File(infoFile);
            File tFile = new File("temp.txt");
            
            try (BufferedReader reader = new BufferedReader(new FileReader(inFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tFile))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    String[] fields = line.split(";");
                    String id = fields[0];
                    if (id.equals(p.getId())) 
                    { /* If we find the line we want to delete, do nothing */
                        ;
                    } else 
                    {
                        String nStr = String.format("%s;%s;%s;%s;%s;%s", 
                                                fields[0],
                                                fields[1],
                                                fields[2],
                                                fields[3],
                                                fields[4],
                                                fields[5]
                                                );
                        writer.write(nStr);
                        writer.newLine();
                    }
                }
            } catch(IOException e) 
            {
                e.printStackTrace();
            }
            /* Delete the original file */
            if (!inFile.delete())
            {
                System.err.println("Could not delete original file");
            }
            /* Rename the temporary file */
            if (!tFile.renameTo(inFile))
            {
                System.err.println("Could not rename temporary file");
            }
            JOptionPane.showMessageDialog(
                                          this, 
                                          "Contact deleted successfully.", 
                                          "Success", 
                                          JOptionPane.INFORMATION_MESSAGE
                                          );
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    /* Code for "New" button in top level menu and for shortcut */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jButton1ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    /* Code for "Modify" button in top level menu and for shortcut */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jButton2ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    /* Code for "Delete" button in top level menu and for shortcut */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        jButton3ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(phoneBookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(phoneBookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(phoneBookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(phoneBookGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new phoneBookGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
