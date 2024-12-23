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
    private Vector<Person> list;
    private DefaultTableModel tableModel;
    private static String infoFile = "info.txt";
    
    public phoneBookGUI() {
        this.list = new Vector<Person>();
        initComponents();
        initTable();
        setLocationRelativeTo(null);
    }
    private void initTable() {
        String[] colNames = {"Name", "Surname", "Phone"};
        this.tableModel = new DefaultTableModel(colNames, 0); // Initialize the table model
        this.jTable2.setModel(tableModel);
        
        File inFile = new File(infoFile);
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
    protected void addContactToTable(Person p) {
        Object[] data = {
            p.getName(),
            p.getSurname(),
            p.getPhone(),
        };
        this.tableModel.addRow(data);
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

    protected void updateRow(int rowIdx, Person p) {
        tableModel.setValueAt(p.getName(), rowIdx, 0);
        tableModel.setValueAt(p.getSurname(), rowIdx, 1);
        tableModel.setValueAt(p.getPhone(), rowIdx, 2);
        
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
        if (!inFile.delete())
        {
            System.err.println("Could not delete original file");
        }
        if (!tFile.renameTo(inFile))
        {
            System.err.println("Could not rename temporary file");
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

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
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("View");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Tools");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Help");
        jMenuBar1.add(jMenu5);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /* New button */
        PersonEditorGUI editor = new PersonEditorGUI(this, list);
        editor.setLocationRelativeTo(this);
        editor.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
        Person selected = list.get(selectedRow);
        PersonEditorGUI editor = new PersonEditorGUI(this, list, selected, selectedRow);
        editor.setLocationRelativeTo(this);
        editor.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            "No Selection", 
            JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        Person p = list.get(selectedRow);
        String conf = String.format("Are you sure you want to delete the contact %s %s?", p.getName(), p.getSurname());
        String[] opts = {"Yes", "No"};
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
            list.remove(selectedRow);
            tableModel.removeRow(selectedRow);
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
                        String nStr = String.format("%s;%s;%s;%s;%s;%d", 
                                                p.getId(),
                                                p.getName(),
                                                p.getSurname(),
                                                p.getAddress(),
                                                p.getPhone(),
                                                p.getAge()
                                                );
                        writer.write(nStr);
                        writer.newLine();
                    }
                }
            } catch(IOException e) 
            {
                e.printStackTrace();
            }
            if (!inFile.delete())
            {
                System.err.println("Could not delete original file");
            }
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
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
