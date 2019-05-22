#include <IRremote.h>

//Ultrasonic Sensor
const int trigPin = 13;
const int echoPin = 12;

//Infrared Receiver
const int irPin = 11;
IRrecv irrecv(irPin);
decode_results results;

//Movement codes
String UP = "ff50af";
String DOWN = "ff6897";
String LEFT = "ff8877";
String RIGHT = "ffc837";
String OFF = "ff48b7";

//LED
const int ledPin = 2;

//Motors
const int motorPinA1 = 8;
const int motorPinA2 = 9;
const int motorAEnable = 0;

const int motorPinB1 = 5;
const int motorPinB2 = 4;
const int motorBEnable = 1;

const int delayTime = 1000;

void setup() {
  Serial.begin(9600);
  pinMode(ledPin, OUTPUT);

  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  
  pinMode(motorPinA1, OUTPUT);
  pinMode(motorPinA2, OUTPUT);
  pinMode(motorAEnable, OUTPUT);

  pinMode(motorPinB1, OUTPUT);
  pinMode(motorPinB2, OUTPUT);
  pinMode(motorBEnable, OUTPUT);

  irrecv.enableIRIn();
 
}

void distanceCheck()
{
  long duration, distance;
    digitalWrite(trigPin, LOW);  // Added this line
    delayMicroseconds(2); // Added this line
    digitalWrite(trigPin, HIGH);

    delayMicroseconds(10); // Added this line
    digitalWrite(trigPin, LOW);
    duration = pulseIn(echoPin, HIGH);
    distance = (duration / 2) / 29.1;

    if (distance > 0 && distance < 50)
    {
      digitalWrite(ledPin, HIGH); 
    }
    else {
      digitalWrite(ledPin, LOW); 
    }
}

void manualMode() {

  if (irrecv.decode(&results)) {
    String reading = String(results.value, HEX);
    Serial.println(reading);

    
    if (reading == UP)
    {
      digitalWrite(motorPinA1, HIGH);
      digitalWrite(motorPinA2, LOW);
      digitalWrite(motorAEnable, HIGH);

      digitalWrite(motorPinB1, HIGH);
      digitalWrite(motorPinB2, LOW);
      digitalWrite(motorBEnable, HIGH);

      delay(500);
      //distanceCheck();
    }
    else if (reading == DOWN)
    {
      digitalWrite(motorPinA1, LOW);
      digitalWrite(motorPinA2, HIGH);
      digitalWrite(motorAEnable, HIGH);

      digitalWrite(motorPinB1, LOW);
      digitalWrite(motorPinB2, HIGH);
      digitalWrite(motorBEnable, HIGH);
      
      delay(500);
      //stop();
      //distanceCheck();
    }
    else if (reading == LEFT)
    {
      digitalWrite(motorPinB2, LOW);
      digitalWrite(motorPinB1, HIGH); //stop one motor
      digitalWrite(motorBEnable, HIGH);   
      digitalWrite(motorAEnable, LOW);
      
      delay(500);
      //stop();
      //distanceCheck();
    }
    else if (reading == RIGHT)
    {
      digitalWrite(motorPinB2, HIGH);
      digitalWrite(motorPinB1, LOW); //stop one motor
      digitalWrite(motorBEnable, HIGH);   
      digitalWrite(motorAEnable, LOW);
     
      delay(500);
      //stop();
      //distanceCheck();
    }
    else 
    {
      stop();
    }
    
    
    irrecv.resume(); // Receive the next value
  }
  //delay(delayTime);
  
}

void stop() {
  digitalWrite(motorPinA1, LOW);
      digitalWrite(motorPinA2, LOW);
       digitalWrite(motorPinB2, LOW);
      digitalWrite(motorPinB1, LOW); 
      digitalWrite(motorBEnable, LOW);
      digitalWrite(motorAEnable, LOW);
}

void loop() {

     manualMode();
 
}
