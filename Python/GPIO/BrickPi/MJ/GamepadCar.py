from BrickPi import *   #import BrickPi.py file to use BrickPi operations
import threading
import pygame,math,sys

BrickPiSetup()  # setup the serial port for communication
pygame.init()

# Initialize the joysticks
pygame.joystick.init()

BrickPi.MotorEnable[PORT_B] = 1 #Enable the Motor A
BrickPi.MotorEnable[PORT_C] = 1 #Enable the Motor D

BrickPi.SensorType[PORT_4] = TYPE_SENSOR_ULTRASONIC_CONT    #Setting the type of sensor at PORT4

BrickPiSetupSensors()   #Send the properties of sensors to BrickPi

running = True

class myThread (threading.Thread):        #This thread is used for keeping the motor running while the main thread waits for user input
    def __init__(self, threadID, name, counter):
        threading.Thread.__init__(self)
        self.threadID = threadID
        self.name = name
        self.counter = counter
    def run(self):
        while running:
            if BrickPi.Sensor[PORT_4] < 20 :        #Lesser value means more close
                print "Car Stopped due to very close object"
                BrickPi.MotorSpeed[PORT_B] = 0        # Set Speed=0 which means stop
                BrickPi.MotorSpeed[PORT_C] = 0
            BrickPiUpdateValues()       # Ask BrickPi to update values for sensors/motors
            time.sleep(.2)  

thread1 = myThread(1, "Thread-1", 1)        #Setup and start the thread
thread1.setDaemon(True)
thread1.start()  

# -------- Main Program Loop -----------
while True:
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
                    BrickPi.MotorSpeed[PORT_B] = 0  #Set the speed of MotorA (-255 to 255)
                    BrickPi.MotorSpeed[PORT_C] = -200  #Set the speed of MotorD (-255 to 255)
                if realAxis == 1 :
                    print "Turning Right"
                    BrickPi.MotorSpeed[PORT_B] = -200  #Set the speed of MotorA (-255 to 255)
                    BrickPi.MotorSpeed[PORT_C] = 0  #Set the speed of MotorD (-255 to 255)
            elif i == 1 :
                if realAxis == -1 :
                    print "Running Forward"
                    BrickPi.MotorSpeed[PORT_B] = 200  #Set the speed of MotorA (-255 to 255)
                    BrickPi.MotorSpeed[PORT_C] = 200  #Set the speed of MotorD (-255 to 255)
                if realAxis == 1 :
                    print "Running Reverse"
                    BrickPi.MotorSpeed[PORT_B] = -200  #Set the speed of MotorA (-255 to 255)
                    BrickPi.MotorSpeed[PORT_C] = -200  #Set the speed of MotorD (-255 to 255)
            
        buttons = joystick.get_numbuttons()

        for i in range( buttons ):
            button = joystick.get_button( i )
            if i == 0 :
                if button == 1 :
                    print "Stopped"
                    BrickPi.MotorSpeed[PORT_B] = 0    #Stop the motor
                    BrickPi.MotorSpeed[PORT_C] = 0
            if i == 1 :
                if button == 1 :
                    print "Bye"
                    sys.exit(0)
            