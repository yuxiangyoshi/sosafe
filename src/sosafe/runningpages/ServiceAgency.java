/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosafe.runningpages;

import java.util.Observable;

/**
 *
 * @author yujiazhang
 */
public class ServiceAgency extends Observable{
    private String message;
    
    ServiceAgency() {
        //message = "Everything is ok";
    
    }
    
    public void setMessage(String msg) {
        message = msg;
        setChanged();
        notifyObservers();
    }
    
    
    public String getMessage() {
    	return message;
    }
    
}
