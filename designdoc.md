# sosafe
## Classes:
	Alarm;
	Sensor: on/off, room id, type;
	Customer: name, ID…
	System: has List of Sensors, Alarm, Password, customer; building;
		Building: collection of rooms?
	Intrusion/fire as events: one or two classes;
	Bill: has Customer; Array List of different charges
	Service provider

Buttons to simulate different events;

## User cases: 
1. Installation of the system: a) install sensors; b) set password
2. Configure sensors, set schedules
3. View bill? Generate/pay bill?
4. intrusion or fire; 

System, Sensor, Customer;
Installation, Configuration 

## System: 
Class Name: System
Super Classes: N/A
Sub Classes: N/A
Responsibility	Collaborator 
Know, maintain, provide, and display all the rooms	Room
Know, maintain, and prompt password	
Maintain customer information	Customer
Pass actors input to the other classes, as a centralized control 	Room, sensor, customer, bill


## Sensor:
Class Name: Sensor
Super Classes: N/A
Sub Classes: N/A (fire and motion sensor? Sensor is then an interface)
Responsibility	Collaborator 
Know and maintain the operation status 	System
Know and maintain the activation schedule 	System

## Customer:
Class Name: Customer
Super Classes: N/A
Sub Classes: N/A 
Responsibility	Collaborator 
Know and maintain the customer information 	System, bill

## Use-Case 1: System installation
Actors: Building management
Purpose and Description: To assign sensors onto the rooms in the building and set up user password.
Type: Primary and Essential (real?)
Cross-references: System configuration (using the password set up here); Bill generation (based on the number and types of sensors installed); 
Scenario Details: (when to input the building information?) (consider flow process with next and back buttons)
Actor Action			System Response		

1. Click install sensors 	
2. Show the Building drawing and instruction “select the rooms to install motion sensors”
3. Select the areas of the building that needs to be installed with motion sensors	
4. Show the marks of motion sensors in the areas selected
5. Click confirm	
6. De-highlight the building, remain the motion sensor marks
7. Click next 	
8. Highlight the Building drawing
9. Select the areas of the building that needs to be installed with fire sensors	
10. Show the marks of fire sensors in the areas selected
11. Click confirm	
12. De-highlight the building, remain the fire sensor marks
13. Click next	
14. show message “please set up the password” and prompted two times for password entering
15. Click finish	
16. show message “system installed”
	
Alternative Courses: Line 16: if the passwords entered are different for the two prompts, then show error message to ask for retry of password set up.
A back button is present and can be clicked to return to previous step and roll-back current change. 
A cancel button is present and can be clicked to roll-back all the changes made so far (optional).  

## Use-Case 2: System configuration
Actors: Building management
Purpose and Description: To manually activate/deactivate or schedule activation/deactivation of sensors in different areas.
Type: Primary and Essential 
Cross-references: System configuration (using the password set up there); 
Scenario Details: 
Actor Action	System Response
1. Click sensors configuration	
2. Prompted for password
3. Click an area	
4. Selected area highlighted, total of five buttons appears: “activate motion sensor”, “activate fire sensor”, “disarm motion sensor”, “disarm fire sensor”, “set schedule”
5. Click one of the buttons (set schedule in this case)	
6. prompt to select fire or motion sensor
7. Select one of the sensors by clicking 	
8. prompt to enter starting time of activation, and time of deactivation 
9. Click confirm	
10. Prompt disappear and the area is deselected 

Alternative Courses: Line 6: Four manual operations are trivial and the prompt would disappear after having clicked one of them. The area is de-highlighted.	
