/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosafe.runningpages;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import sosafe.Admin;
import sosafe.Customer;

/**
 *
 * @author yujiazhang
 */
public class BillDisplayText extends JFrame{
    private Object[][] billmsg;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton confirmButton;
    
    public BillDisplayText(Object[][] billmsg) {
        this.billmsg = billmsg;
        confirmButton = new JButton("CONFIRM");
        confirmButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
             
           }
        });
        
        String [] columns = {"Content", "Price"};
       
        for(int i = 0; i < billmsg.length; i++) {
           for(int j = 0; j < billmsg[0].length; j++) {
               System.out.print(billmsg[i][j]);
           } 
        }
        
        table = new JTable(billmsg,columns);
        table.setVisible(true);
        table.getColumnModel().getColumn(1).setPreferredWidth(130);
        table.getColumnModel().getColumn(1).setMaxWidth(150);
        table.getColumnModel().getColumn(1).setMinWidth(95);
        scrollPane = new JScrollPane(table);
        
        Container contentPane = getContentPane();
        contentPane.add(scrollPane);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
     
        //contentPane.add(content2);
        setSize(525,315);
        this.setLocationRelativeTo(null);
        
       // contentPane.add(table);
        
    }
    
    
    
    
    
}
