/*
HC-SR04 Ping distance sensor]
VCC to arduino 5v GND to arduino GND
Echo to Arduino pin 13 Trig to Arduino pin 12
Red POS to Arduino pin 11
Green POS to Arduino pin 10
560 ohm resistor to both LED NEG and GRD power rail
*/

const int trigPin = 13;
const int echoPin = 12;

const int button = 6;

const int motorPinA = 9;
const int motorPinB = 8;

const int speed = 150;
const int delayTime = 2000;

int state = HIGH;      // the current state of the output pin
int previous = LOW;

// the follow variables are long's because the time, measured in miliseconds,
// will quickly become a bigger number than can be stored in an int.
long time = 0;         // the last time the output pin was toggled
long debounce = 200;   // the debounce time, increase if the output flickers

void setup() {
  Serial.begin (9600);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  //pinMode(led, OUTPUT);
  //pinMode(led2, OUTPUT);
  pinMode(motorPinA, OUTPUT);
  pinMode(motorPinB, OUTPUT);

  pinMode(button, INPUT);
}

void loop() {

int buttonState;
//
buttonState = digitalRead(button);

if (buttonState == HIGH)
{
    long duration, distance;
  digitalWrite(trigPin, LOW);  // Added this line
  delayMicroseconds(2); // Added this line
  digitalWrite(trigPin, HIGH);
  
  delayMicroseconds(10); // Added this line
  digitalWrite(trigPin, LOW);
  duration = pulseIn(echoPin, HIGH);
  distance = (duration / 2) / 29.1;

  if (distance < 7) {
    //digitalWrite(led, HIGH);
    //digitalWrite(led2, LOW);

    //Turn bot

    analogWrite(motorPinB,speed); //stop one motor
    analogWrite(motorPinA,0);  
    delay(delayTime);
    //analogWrite(motorPin,0) ;

  }
  else {
    analogWrite(motorPinB,speed);
    analogWrite(motorPinA,speed);
  }
  delay(500);
 }
 else {
   analogWrite(motorPinB,0);
   analogWrite(motorPinA,0);
 }

  


//previous = buttonState;


}
