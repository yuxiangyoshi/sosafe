/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sosafe.runningpages;

import sosafe.runningpages.ServiceAgency;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.TimerTask;
import sosafe.Admin;
import sosafe.Customer;

/**
 *
 * @author yujiazhang
 */
//need to implement timer and recall mechanism
public class Alarm extends Observable{
    private Admin admin;
    private int fireTimes;
    private int intrusionTimes;
    private Boolean agencyResponded;
    private int fireCallNumber;
    private int intrusionCallNumber;
    private ServiceAgency serviceAgency;
    private Customer customer;
    private TimerTask previousFireTask;
    private TimerTask curFireTask;
    private TimerTask previousIntrusionTask;
    private TimerTask curIntrusionTask;
    private Date fireDate;
    private Date intrusionDate;
    private Boolean onFire;
    private Boolean onBreakin;
    
    
    public Alarm(Admin ad) {
        admin = ad;
        serviceAgency = new ServiceAgency();
        customer = new Customer();
        fireTimes = 0;
        intrusionTimes = 0;
        agencyResponded = false;
        onFire = false;
        onBreakin = false;
        //init preTask to avoid null pointer when first cancel;
        previousFireTask = new TimerTask() {
            @Override
            public void run() {
            }
        };
        previousIntrusionTask = new TimerTask() {
            @Override
            public void run() {
            }
        };
    }
    
    public void fireAlarm(){
        agencyResponded = false;
        fireTimes++;
        fireCallNumber = 1;
        fireDate = new Date();       
        curFireTask = new TimerTask() {
            @Override
            public void run() {              
                if(agencyResponded){ //agency calls back
                    curFireTask.cancel();
                    agencyResponded = false;
                }
                callToAgencyFire();
            }
        };
        admin.getTimer().scheduleAtFixedRate(curFireTask, 0, 60*1000);
        previousFireTask.cancel();
        previousFireTask = curFireTask;
        onFire = true;
        setChanged();
        notifyObservers();
    }
    
    public void turnOffFireAlarm(){
        onFire = false;
        setChanged();
        notifyObservers();
    }
    
    public Boolean getFireStatus(){
        return onFire;
    }
    
    public Boolean getBreakinStatus(){
        return onBreakin;
    }
    
    public void intrusionAlarm(){
        agencyResponded = false;
        intrusionTimes++;
        intrusionCallNumber = 1;
        intrusionDate = new Date();
        curIntrusionTask = new TimerTask() {
            @Override
            public void run() {
                if(agencyResponded){ //agency calls back
                    curFireTask.cancel();
                    agencyResponded = false;
                }
                callToAgencyMotion(); 
            }
        };
        admin.getTimer().scheduleAtFixedRate(curIntrusionTask, 0, 60*1000);
        previousIntrusionTask.cancel();
        previousIntrusionTask = curIntrusionTask;
        onBreakin = true;
        setChanged();
        notifyObservers();     
    }
    
    public void turnOffIntrusionAlarm(){
        onBreakin = false;
        setChanged();
        notifyObservers();
    }
    
    public void callToAgencyFire() {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String dangerTime = sdf.format(fireDate);        
        StringBuilder sb = new StringBuilder();
        sb.append("Call No." + fireCallNumber + ": \n" + customer.getName() +"'s Building is on fire!" + "\n");
        sb.append("Fire time is: " + dangerTime + "\n");
        sb.append("PLEASE CALL" + customer.getContactNumbers()[0] + " OR " +  customer.getContactNumbers()[1]);
        
        serviceAgency.setMessage(sb.toString());
        fireCallNumber++;
    }
    
    public void callToAgencyMotion() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String dangerTime = sdf.format(intrusionDate);
        
        StringBuilder sb = new StringBuilder();
        sb.append("Call No." + intrusionCallNumber + ": \n"+ customer.getName() + "'s Building is being intruded !" + "\n");
        sb.append("Intrusion time is: " + dangerTime + "\n");
        sb.append("PLEASE CALL" + customer.getContactNumbers()[0] + " OR " +  customer.getContactNumbers()[1]);
        
        serviceAgency.setMessage(sb.toString());
        intrusionCallNumber++;
    }
    
    public void alarmDown() {
    
    }
    
    public int getFireTime() {
        return fireTimes;
    }
    
    public int getIntrusionTime() {
        return intrusionTimes;
    }
    
    public void agencyRespond(String code){
        if (code.equals("help on the way")){
            agencyResponded = true;
            serviceAgency.setMessage("");
            turnOffFireAlarm();
            turnOffIntrusionAlarm();
        }  
    }
    
    public ServiceAgency getServiceAgency() {
        return serviceAgency;
    }
    
    
    //public static void main
    
}
