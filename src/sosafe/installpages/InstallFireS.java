/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosafe.installpages;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sosafe.Admin;
import sosafe.Room;

/**
 *
 * @author yuxia
 */
public class InstallFireS extends javax.swing.JFrame {
    Admin admin;
    /**
     * Creates new form InstallFireS
     */
    public InstallFireS(Admin ad) {
        super("Installation of FIRE Sensors");
        admin = ad;
        
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultTableModel model;
            model = (DefaultTableModel) displayTable.getModel();
            model.setRowCount(0);
        //displayTable.addColumn("");
        for (int i = 5; i >= 1; i--){
            String floor = "Floor " + i;
            model.addRow(new Object[]{floor, false, false, false, false, false});
        }
        displayTable.setShowGrid(true);
    }
    
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //modify admin for passing
        Room[][] rooms = admin.getRooms();
        for (int i = 0; i < 5; i++){
            for (int j = 1; j < 6; j++){
                if ((Boolean)displayTable.getValueAt(i, j)){
                    System.out.println("Floor " + (5 - i) + ", Room " + j + "selected for Fire Sensor");
                    
                    rooms[5-i-1][j-1].installFireSensor();
                }
            }
        }
        
        JOptionPane.showMessageDialog(this, "Fire Sensors Implemented!");
        this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new SetPass(admin);
                frame.setVisible(true);
                frame.setTitle("Set up password");
                //new MainWindow(admin).setVisible(true);
            }
        });
        
        
        
        
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instructionLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        roomDisplayPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        instructionLabel.setText("Select the Rooms to Install FIRE Sensors");

        confirmButton.setText("Next");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        displayTable.setBackground(new java.awt.Color(255, 153, 153));
        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Building", "Room 1", "Room 2", "Room 3", "Room 4", "Room 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        displayTable.setRowHeight(50);
        displayTable.setRowSelectionAllowed(false);
        displayTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(displayTable);

        javax.swing.GroupLayout roomDisplayPanelLayout = new javax.swing.GroupLayout(roomDisplayPanel);
        roomDisplayPanel.setLayout(roomDisplayPanelLayout);
        roomDisplayPanelLayout.setHorizontalGroup(
            roomDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomDisplayPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        roomDisplayPanelLayout.setVerticalGroup(
            roomDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomDisplayPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roomDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instructionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roomDisplayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(instructionLabel)
                    .addComponent(confirmButton))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  
    /*public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstallFireS().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JTable displayTable;
    private javax.swing.JLabel instructionLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel roomDisplayPanel;
    // End of variables declaration//GEN-END:variables
}
