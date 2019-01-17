# Motor B controls Left-Right movement
# Motor C controls the height of arm
# Motor A controls the fingers

#import BrickPi.py file to use BrickPi operations
from BrickPi import *   

#curses library is used to get realtime keypress and time for sleep function
import time,pygame,math,sys	

# setup the serial port for communication
BrickPiSetup()  

pygame.init()

# Initialize the joysticks
pygame.joystick.init()

BrickPi.MotorEnable[PORT_B] = 1 #Enable the Motor B
BrickPi.MotorEnable[PORT_C] = 1 #Enable the Motor C
BrickPi.MotorEnable[PORT_A] = 1 #Enable the Motor A

BrickPiSetupSensors()   #Send the properties of sensors to BrickPi

# -------- Main Program Loop -----------
while True:
    
    BrickPi.MotorSpeed[PORT_B] = 0    #first setting all speeds to zero
    BrickPi.MotorSpeed[PORT_C] = 0
    BrickPi.MotorSpeed[PORT_A] = 0
    
    # EVENT PROCESSING STEP
    for event in pygame.event.get(): # User did something
        if event.type == pygame.QUIT: # If user clicked close
            done=True # Flag that we are done so we exit this loop

    # Get count of joysticks
    joystick_count = pygame.joystick.get_count()
    
    # For each joystick:
    for i in range(joystick_count):
        joystick = pygame.joystick.Joystick(i)
        joystick.init()
        
        # Usually axis run in pairs, up/down for one, and left/right for
        # the other.
        axes = joystick.get_numaxes()
        
        for i in range( axes ):
            axis = joystick.get_axis( i )
            realAxis = math.ceil(axis);
            if i == 0 :
                if realAxis == -1 :
                    print "Turning Left"
                    BrickPi.MotorSpeed[PORT_B] = -125 #100
                if realAxis == 1 :
                    print "Turning Right"
                    BrickPi.MotorSpeed[PORT_B] = 125 #-1000
            elif i == 1 :
                if realAxis == -1 :
                    print "Running Forward"
                    BrickPi.MotorSpeed[PORT_C] = 125 #125
                if realAxis == 1 :
                    print "Running Reverse"
                    BrickPi.MotorSpeed[PORT_C] = -125 #-70
            
        buttons = joystick.get_numbuttons()

        for i in range( buttons ):
            button = joystick.get_button( i )
            if i == 0 :
                if button == 1 :
                    BrickPi.MotorSpeed[PORT_A] = -90 #30
            if i == 1 :
                if button == 1 :
                    BrickPi.MotorSpeed[PORT_A] = 90 #-60
            if i == 2 :
                if button == 1 :
                    sys.exit(0)
                    
    #After setting the motor speeds, send values to BrickPi
    BrickPiUpdateValues()
    time.sleep(.1)    #pause for 100 ms
