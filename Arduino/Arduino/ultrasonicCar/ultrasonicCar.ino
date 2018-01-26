//Ultrasonic Sensor
const int trigPin = 13;
const int echoPin = 12;

//On and Off switch
const int button = 6;

//Motors
const int motorPinA1 = 8;
const int motorPinA2 = 9;
const int motorAEnable = 0;

const int motorPinB1 = 5;
const int motorPinB2 = 4;
const int motorBEnable = 1;

const int delayTime = 200;

void setup() {
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(button, INPUT);
  
  pinMode(motorPinA1, OUTPUT);
  pinMode(motorPinA2, OUTPUT);
  pinMode(motorAEnable, OUTPUT);

  pinMode(motorPinB1, OUTPUT);
  pinMode(motorPinB2, OUTPUT);
  pinMode(motorBEnable, OUTPUT);
 
}

void loop() {

  int buttonState;
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

    if (distance < 50) {

      //Make bot go in reverse
      //digitalWrite(motorPinA1,LOW);
      //digitalWrite(motorPinA2,HIGH);
      //digitalWrite(motorPinB2,HIGH);
      //digitalWrite(motorPinB1,LOW);
      //delay(1500);

      //Turn bot
      digitalWrite(motorPinB2, LOW);
      digitalWrite(motorPinB1, HIGH); //stop one motor
      digitalWrite(motorBEnable, HIGH);   
      digitalWrite(motorAEnable, LOW);
      delay(delayTime);

    }
    else {
      digitalWrite(motorPinA1, HIGH);
      digitalWrite(motorPinA2, LOW);
      digitalWrite(motorAEnable, HIGH);

      digitalWrite(motorPinB1, HIGH);
      digitalWrite(motorPinB2, LOW);
      digitalWrite(motorBEnable, HIGH);
    }
    delay(500);
  }
  else {
    digitalWrite(motorBEnable, LOW);
    digitalWrite(motorAEnable, LOW);
  }

}
