/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sosafe.runningpages;

import sosafe.runningpages.BillDisplayText;
import sosafe.runningpages.Bill;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sosafe.Admin;
import sosafe.Customer;
import sosafe.Room;

/**
 *
 * @author yuxia
 */
public class MainWindow extends javax.swing.JFrame implements Observer{
    private Admin admin;
    private Boolean passCorrect;
    /**
     * Creates new form MainWindow
     */
    public MainWindow(Admin ad) {
        initComponents();
        admin = ad;
        passCorrect = false;
        //this.setSize(1450, 1020);
        
        //"M|F", "M| ", " |F"
        DefaultTableModel model;
        model = (DefaultTableModel) displayTable.getModel();
        model.setRowCount(0);
        sysStatusLabel.setText("System ON");
        //displayTable.addColumn("");
        //5-> 1 because table addrow to bottom
        Room[][] rooms = admin.getRooms();
        for (int i = 4; i >= 0; i--){
            String floor = "Floor " + (i+1);
            Object[] items = new Object[6];
            items[0] = "Floor " + (i+1);
            for (int j = 0; j <= 4; j++){
                rooms[i][j].addObserver(this);
                //concat strings
                String motionOn = "  ";
                String motionS = "  ";
                String fireS = "  ";
                String fireOn = "  ";
                
                if (rooms[i][j].MotionSensorInstalled()){
                    motionS = " M ";
                }
                if (rooms[i][j].FireSensorInstalled()){
                    fireS = " F ";
                }
                if(rooms[i][j].motionSensorOn()){
                    motionOn = "ON";
                }
                if(rooms[i][j].FireSensorOn()){
                    fireOn = "ON";
                }
                /*if (rooms[i][j].MotionSensorInstalled() && rooms[i][j].FireSensorInstalled()){
                items[j+1] = "M | F";
                }*/
                items[j+1] = motionOn + motionS + "|" + fireS + fireOn;
                System.out.println("Floor " + i + "Room " + (j+1) + items[j+1]);
            }
            
            model.addRow(items);
        }
        displayTable.setShowGrid(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        displayTable.setDefaultRenderer(String.class, centerRenderer);
        displayTable.setDefaultEditor(Object.class, null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        billButton = new javax.swing.JButton();
        configureButton = new javax.swing.JButton();
        simulateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        etypeCombo = new javax.swing.JComboBox<>();
        sysStatusLabel = new javax.swing.JLabel();
        sysOffButton = new javax.swing.JButton();
        sysOnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        displayTable.setRowHeight(190);
        displayTable.setRowSelectionAllowed(false);
        displayTable.getTableHeader().setReorderingAllowed(false);
        displayTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                displayTableFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(displayTable);
        if (displayTable.getColumnModel().getColumnCount() > 0) {
            displayTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        }

        billButton.setText("Bill");
        billButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billButtonActionPerformed(evt);
            }
        });

        configureButton.setText("Configure Sensors");
        configureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configureButtonActionPerformed(evt);
            }
        });

        simulateButton.setText("Simulate");
        simulateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simulateButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Emergency Type:");

        etypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fire", "Break In" }));

        sysStatusLabel.setText("System Status:");

        sysOffButton.setText("Turn Off System");
        sysOffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sysOffButtonActionPerformed(evt);
            }
        });

        sysOnButton.setText("Turn On System");
        sysOnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sysOnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simulateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(configureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(billButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(39, 39, 39)
                                .addComponent(etypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sysStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sysOffButton)
                                .addGap(46, 46, 46)
                                .addComponent(sysOnButton)))
                        .addContainerGap(116, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simulateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(sysStatusLabel)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sysOffButton)
                    .addComponent(sysOnButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(configureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(billButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void displayTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_displayTableFocusGained
        
        /*int i = displayTable.getSelectedRow();
        int j = displayTable.getSelectedColumn();
        Room[][] rooms = admin.getRooms();
        //int i = displayTable.getSelectionModel().getLeadSelectionIndex();
        //int j = displayTable.getColumnModel().getSelectionModel().getLeadSelectionIndex();
        if(intrusionToggle.isSelected() && rooms[5-i-1][j-1].MotionSensorInstalled()){
        tempLabel.setText("intrustion in: " + "floor " + (5-i) + " room " + j);
        System.out.println("intrustion detected in: " + "floor " + (5-i) + " room " + j);
        }
        if(fireToggle.isSelected()&& rooms[5-i-1][j-1].FireSensorInstalled()){
        tempLabel2.setText("fire in: " + "floor " + (5-i) + " room " + j);
        System.out.println("fire detected in: " + "floor " + (5-i) + " room " + j);
        }
        //tempLabel.setText("floor " + (5-i) + " room " + j);
        System.out.println("floor " + (5-i) + " room " + j);
        //deselected table
        displayTable.clearSelection();*/
    }//GEN-LAST:event_displayTableFocusGained
    
    private void billButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billButtonActionPerformed
        Bill bill = new Bill(new Customer(),admin);
        //JOptionPane.showMessageDialog(this, bill.generateBill());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //JFrame frame = new BillDisplay(bill.generateBill());
                JFrame frame = new BillDisplayText(bill.generateInformation());
                frame.setVisible(true);
                frame.setTitle("SoSafe - Bill - " + admin.getCustomer().getName());
                //new MainWindow(admin).setVisible(true);
            }
        });
    }//GEN-LAST:event_billButtonActionPerformed
    
    private void configureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configureButtonActionPerformed
        // TODO add your handling code here:
        if(admin.getSystemStatus()){
            int i = displayTable.getSelectedRow();
            int j = displayTable.getSelectedColumn();
            
            if (i == -1 || j == -1){
                JOptionPane.showMessageDialog(this, "Please Select a room to be configured");
            } else {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new PassPrompt(admin, 5-i-1, j-1).setVisible(true);
                    }
                });
            }
        }
    }//GEN-LAST:event_configureButtonActionPerformed

    
    private void simulateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simulateButtonActionPerformed
        if(admin.getSystemStatus()){
            int i = displayTable.getSelectedRow();
            int j = displayTable.getSelectedColumn();
            
            if (i == -1 || j == -1){
                JOptionPane.showMessageDialog(this, "Please Select a room to simulate");
            } else {
                Room room = admin.getRooms()[5-i-1][j-1];
                
                if(etypeCombo.getSelectedIndex() == 0){ //fire
                    //simulate fire, call admin.getAlarm
                    if(room.FireSensorInstalled() && room.FireSensorOn()){
                        admin.getAlarm().fireAlarm();
                        System.out.println("fire button");
                    }
                    
                } else { // break in
                    //simulate breakin
                    if(room.MotionSensorInstalled() && room.motionSensorOn()){
                        admin.getAlarm().intrusionAlarm();
                        System.out.println("intrusion button");
                    }
                }
            }
        }
    }//GEN-LAST:event_simulateButtonActionPerformed

    private void sysOffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sysOffButtonActionPerformed
        displayTable.setBackground(new java.awt.Color(0,0,0));
        admin.turnOffSystem();
        sysStatusLabel.setText("System OFF");
    }//GEN-LAST:event_sysOffButtonActionPerformed

    private void sysOnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sysOnButtonActionPerformed
        displayTable.setBackground(new java.awt.Color(255,255,255));
        admin.turnOnSystem();
        sysStatusLabel.setText("System ON");
        
    }//GEN-LAST:event_sysOnButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow(new Admin(5,5)).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton billButton;
    private javax.swing.JButton configureButton;
    private javax.swing.JTable displayTable;
    private javax.swing.JComboBox<String> etypeCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton simulateButton;
    private javax.swing.JButton sysOffButton;
    private javax.swing.JButton sysOnButton;
    private javax.swing.JLabel sysStatusLabel;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void update(Observable o, Object arg) {
        DefaultTableModel model;
        model = (DefaultTableModel) displayTable.getModel();
        model.setRowCount(0);
        //displayTable.addColumn("");
        //5-> 1 because table addrow to bottom
        Room[][] rooms = admin.getRooms();
        for (int i = 4; i >= 0; i--){
            String floor = "Floor " + (i+1);
            Object[] items = new Object[6];
            items[0] = "Floor " + (i+1);
            for (int j = 0; j <= 4; j++){
                //concat strings
                String motionOn = "  ";
                String motionS = "  ";
                String fireS = "  ";
                String fireOn = "  ";
                
                if (rooms[i][j].MotionSensorInstalled()){
                    motionS = " M ";
                    motionOn = "OFF";
                    if(rooms[i][j].motionSensorOn()){
                        motionOn = "ON";
                    }
                }
                if (rooms[i][j].FireSensorInstalled()){
                    fireS = " F ";
                    fireOn = "OFF";
                    if(rooms[i][j].FireSensorOn()){
                        fireOn = "ON";
                    }
                }
                /*if (rooms[i][j].MotionSensorInstalled() && rooms[i][j].FireSensorInstalled()){
                items[j+1] = "M | F";
                }*/
                items[j+1] = motionOn + motionS + "|" + fireS + fireOn;
                System.out.println("Floor " + i + "Room " + (j+1) + items[j+1]);
            }
            
            model.addRow(items);
        }
        displayTable.setShowGrid(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        displayTable.setDefaultRenderer(String.class, centerRenderer);
    }
}
