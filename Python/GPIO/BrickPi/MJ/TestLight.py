from BrickPi import *   #import BrickPi.py file to use BrickPi operations

BrickPiSetup()  # setup the serial port for communication

BrickPi.MotorEnable[PORT_A] = 1 #Enable the Motor D

BrickPi.SensorType[PORT_2] = TYPE_SENSOR_LIGHT_ON   #Set the type of sensor at PORT_1

BrickPiSetupSensors()   #Send the properties of sensors to BrickPi

while True:
    result = BrickPiUpdateValues()  # Ask BrickPi to update values for sensors/motors 
    if not result :
        lightValue = BrickPi.Sensor[PORT_2]
        print lightValue
        if lightValue < 600 :
            BrickPi.MotorSpeed[PORT_A] = 90
        elif lightValue > 600 :
            BrickPi.MotorSpeed[PORT_A] = -90
                #BrickPi.Sensor[PORT] stores the value obtained from sensor
    time.sleep(.01)     # sleep for 10 ms