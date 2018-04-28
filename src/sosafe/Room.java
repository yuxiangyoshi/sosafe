/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosafe;

import java.util.Observable;

/**
 *
 * @author yuxia
 */
public class Room extends Observable{
    private Boolean hasMotionSensor;
    private Boolean hasFireSensor;
    private Boolean motionSensorOn;
    private Boolean fireSensorOn;
    //private Admin admin;
    
    public Room(){
        //admin = ad;
        hasMotionSensor = false;
        hasFireSensor = false;
        motionSensorOn = false;
        fireSensorOn = false;
    }
    
    public Boolean MotionSensorInstalled(){
        return hasMotionSensor;
    }
    
    public Boolean FireSensorInstalled(){
        return hasFireSensor;
    }
    
    public Boolean FireSensorOn(){
        return fireSensorOn;
    }
    
    public Boolean motionSensorOn(){
        return motionSensorOn;
    }
    
    public void installMotionSensor(){
        hasMotionSensor = true;
        motionSensorOn = true;
    }
    
    public void installFireSensor(){
        hasFireSensor = true;
        fireSensorOn = true;
    }
    
    
    public void turnOnMotionS(){
        motionSensorOn = true;
        setChanged();
        notifyObservers();
    }
    
    public void turnOffMotionS(){
        motionSensorOn = false;
        setChanged();
        notifyObservers();
    }
    
    public void turnOnFireS(){
        fireSensorOn = true;
        setChanged();
        notifyObservers();
    }
    
    public void turnOffFireS(){
        fireSensorOn = false;
        setChanged();
        notifyObservers();
    }
}
