package sosafe;
import sosafe.runningpages.Alarm;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author yuxia
 */
public class Admin {
    private Room[][] rooms;
    private Customer customer;
    private String password;
    private Alarm alarm;
    private Timer timer;
    private TimerTask[][] motionSensorOn;
    private TimerTask[][] motionSensorOff;
    private TimerTask[][] fireSensorOn;
    private TimerTask[][] fireSensorOff;
    private Boolean motionScheduled;
    private Boolean fireScheduled;
    private Boolean systemOn;
    
    //This class that manages everyone else
    public Admin(int numFloor, int numRoomPerStory){
        if (numFloor <= 0 || numRoomPerStory <= 0){
            System.out.println("invalid building");
        }
        timer = new Timer();
        customer = new Customer();
        //fill the rooms
        rooms = new Room[numFloor][numRoomPerStory];
        for (int i = 0; i < numFloor; i++){
            for (int j = 0; j < numRoomPerStory; j++){
                rooms[i][j] = new Room();
            }
        }
        systemOn = true;
        //4 matrix of timertasks to turnon/off motion/fire sensors
        motionSensorOn = new TimerTask[numFloor][numRoomPerStory];
        motionSensorOff = new TimerTask[numFloor][numRoomPerStory];
        fireSensorOn = new TimerTask[numFloor][numRoomPerStory];
        fireSensorOff = new TimerTask[numFloor][numRoomPerStory];
        //init the tasks
        for (int i = 0; i < numFloor; i++){
            for (int j = 0; j < numRoomPerStory; j++){
                motionSensorOn[i][j] = new TimerTask() {
                    @Override
                    public void run() {
                        //init with empty
                    }
                };
                motionSensorOff[i][j] = new TimerTask() {
                    @Override
                    public void run() {
                        //init with empty
                    }
                };
                fireSensorOn[i][j] = new TimerTask() {
                    @Override
                    public void run() {
                        //init with empty
                    }
                };
                fireSensorOff[i][j] = new TimerTask() {
                    @Override
                    public void run() {
                        //init with empty
                    }
                };
                
            }
        }
        fireScheduled = false;
        motionScheduled = false;
        password = "";
        alarm = new Alarm(this);
    }
    
    public Timer getTimer(){
        return timer;
    }
    
    public TimerTask[][] getFireOnTask(){
        fireScheduled = true;
        return fireSensorOn;       
    }
    
    public TimerTask[][] getFireOffTask(){
        //fireScheduled = true; always called with on task
        return fireSensorOff;
    }
    
    public TimerTask[][] getMotionOffTask(){
        return motionSensorOff;
    }
    
    public TimerTask[][] getMotionOnTask(){
        motionScheduled = true;
        return motionSensorOn;
    }
    
    public Boolean getFireScheduled(){
        return fireScheduled;
    }
    
    public Boolean getMotionScheduled(){
        return motionScheduled;
    }
    
    public Boolean getSystemStatus(){
        return systemOn;
    }
    
    public void turnOnSystem(){
        systemOn = true;
    }
    
    public void turnOffSystem(){
        systemOn = false;
    }
    
    public void setPassword(String pass){
        password = pass;
    }
    
    public String getPassword(){
        return password;
    }
    
    public Room[][] getRooms(){
        return rooms;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public int getNumOfFloor(){
        return rooms.length;
    }
    
    public int getNumRoomPerStory(){
        return rooms[0].length;
    }
    
    
    public int[] getSensorNumber() {
        int fireSensorNumber = 0;
        int motionSensorNumber = 0;
        for(int i = 0; i < getNumOfFloor(); i++) {
            for(int j = 0; j < getNumRoomPerStory();j++) {
                if(rooms[i][j].FireSensorInstalled()){
                    fireSensorNumber++;
                }
                if(rooms[i][j].MotionSensorInstalled()) {
                    motionSensorNumber++;
                }
            }
        }
        return new int[]{fireSensorNumber, motionSensorNumber};
        
    }
    
    public int getFireSensorNumber() {
        return getSensorNumber()[0];
    }
    
    public int getFireSensorTotalCost() {
        return getSensorNumber()[0]* 50;
    }
    
    public int getMotionSensorNumber() {
        return getSensorNumber()[1];
    }
    
    public int getMotionSensorTotalCost() {
        return getSensorNumber()[1] * 100;
    }
    
    public Alarm getAlarm() {
        return alarm;
    }
    
    
    
}