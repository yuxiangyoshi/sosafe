/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosafe.runningpages;

import sosafe.Admin;
import sosafe.Customer;

/**
 *
 * @author yujiazhang
 */


public class Bill {
	private Customer customer;
	private Admin admin; 
        private int installationFee = 0;
        private int emergencyFee = 0;
	
	Bill(Customer customer, Admin admin) {
		this.customer = customer;
		this.admin = admin;
	}

    Bill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	public Object[][] generateInformation() {
            Object [][] result = new Object[15][2];
            result[0][0] = "Service Contract Id: " + customer.getId();
            result[0][1] = null;
            result[1][0] = "Customer Name: " + customer.getName();
            result[1][1] = null;
            result[2][0] = "Customer Address: " + customer.getAddress(); result[2][1] = null;
            result[3][0] = "Customer Email: " + customer.getEmail(); result[3][1] = null;
            result[4][0] = "Customer Contact Numbers: " + customer.getContactNumbers()[0] +", "+
                    customer.getContactNumbers()[1];
            result[4][1] = null;
            result[5][0] = "Effective dates: " + customer.getDate();
            result[5][1] = null;
            // installation fee
            result[6][0] = "Motion Sensor Initial Installation service charge:";
            result[6][1] =  "200";
            result[7][0] =  "The number of Motion Sensor "+  " X" + admin.getMotionSensorNumber();
            result[7][1] = admin.getMotionSensorTotalCost();
            result[8][0] = "Fire Sensor Initial Installation service charge:";
            result[8][1] = "240 (initial 300)";
            result[9][0] = "The number of Fire Sensor"  +  " X" + admin.getFireSensorNumber();
            result[9][1] =  admin.getFireSensorTotalCost();
            result[10][0] = "Total Installation Fee "; result[10][1] =  440 + admin.getMotionSensorTotalCost() + admin.getFireSensorTotalCost();
            result[11][0] = "Call Due to Fire " + " X" + admin.getAlarm().getFireTime();
            result[11][1] =   admin.getAlarm().getFireTime()*50;
            result[12][0] = "Call Due to Intrusion " + " X" + admin.getAlarm().getIntrusionTime();
            result[12][1] =  admin.getAlarm().getIntrusionTime()*20;
            result[13][0] = "Total Emergency Fee";
            result[13][1] =  admin.getAlarm().getIntrusionTime()*20 + admin.getAlarm().getFireTime()*50;
            result[14][0] = "Total";
            result[14][1] = admin.getAlarm().getIntrusionTime()*20 + admin.getAlarm().getFireTime()*50 + 440 + 
                         admin.getMotionSensorTotalCost() + admin.getFireSensorTotalCost();
           return result;
	}

}
