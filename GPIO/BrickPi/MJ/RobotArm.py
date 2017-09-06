# Motor B controls Left-Right movement
# Motor C controls the height of arm
# Motor A controls the fingers

# Direction keys - to move the arm
# Space will open the claw
# Z will close the claw

# The light sensor will be configured to also close if a certain 
# threshold is reached with an object being in front of it


from BrickPi import *   #import BrickPi.py file to use BrickPi operations
import curses #curses library is used to get realtime keypress and time for sleep function

BrickPiSetup()  # setup the serial port for communication

BrickPi.MotorEnable[PORT_B] = 1 #Enable the Motor B
BrickPi.MotorEnable[PORT_C] = 1 #Enable the Motor C
BrickPi.MotorEnable[PORT_A] = 1 #Enable the Motor D

BrickPi.SensorType[PORT_2] = TYPE_SENSOR_LIGHT_ON   #Set the type of sensor at PORT_2

BrickPiSetupSensors()   #Send the properties of sensors to BrickPi

stdscr = curses.initscr()	#initialize the curses object
curses.cbreak()			#to get special key characters 
stdscr.keypad(1)		#for getting values such as KEY_UP

key = ''
while key != ord('q'):		#press 'q' to quit from program
    
    #lightValue = BrickPi.Sensor[PORT_2]
    #print lightValue;
    key = stdscr.getch()	#get a character from terminal
    BrickPi.MotorSpeed[PORT_B] = 0	#first setting all speeds to zero
    BrickPi.MotorSpeed[PORT_C] = 0
    BrickPi.MotorSpeed[PORT_A] = 0
   
    stdscr.refresh()
    
        #change the motor speed based on key value
    if key == curses.KEY_LEFT : 
        BrickPi.MotorSpeed[PORT_B] = -125
    elif key == curses.KEY_RIGHT : 
        BrickPi.MotorSpeed[PORT_B] = 125
    elif key == curses.KEY_UP :
        BrickPi.MotorSpeed[PORT_C] = 125	#different values are used to bear the weight of arm and object
    elif key == curses.KEY_DOWN :
        BrickPi.MotorSpeed[PORT_C] = -125
    elif key == 32 :
        BrickPi.MotorSpeed[PORT_A] = -90	
    elif key == 122 :
        BrickPi.MotorSpeed[PORT_A] = 90
   

    #After setting the motor speeds, send values to BrickPi
    BrickPiUpdateValues()
    time.sleep(.1)	#pause for 100 ms
curses.endwin()
