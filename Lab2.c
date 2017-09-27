
/**
* Group 6
* Caleb Bushman, Derek Grove, Jacob moore
*
*/

#define motorL 0
#define motorR 3
#define touchL 7
#define touchR 8
#define turn90 1.85

void main()
{
    int leftCount = 0;
    while(1)
      {
        //proceed forward while switches are not pressed
        motor(motorL,75);
        motor(motorR,75);
        
        
        //both sensors touched the first time
        if((digital(touchL)) && (digital(touchR)) && (leftCount % 2 == 0))           
          {
            //reverse
            reverse();
            
            //turn left
            motor(motorL,50);
            motor(motorR,-50);
            sleep(turn90);
            
            leftCount++;
        }
        
        
        //both sensors touched the second time
        else if((digital(touchL)) && (digital(touchR)) && (leftCount % 2 == 1))            
          {
            //reverse
            reverse();
            
            //turn 180
            motor(motorL,50);
            motor(motorR,-50);
            sleep(2.0*turn90);
            
            leftCount++;
          }
        
        
        else if((digital(touchL)) && (!digital(touchR)))     //if the left switch was touched
          {
            //reverse
            reverse();
            //turn left to swap wall-to-sensor sides(changed from turn right)
            motor(motorR,-50);
            motor(motorL,50);
            sleep(turn90);
          }
        
        
        else if((digital(touchR)) && (!digital(touchL)))      //if the right switch was touched
          {
            //reverse
            reverse();
            //turn left slightly
            motor(motorL,50);
            motor(motorR,-50);
            sleep(0.3*turn90);
          }
    }
}


//reverses the robot for a set period of time
void reverse()
{
    //reverse for a second
    motor(motorL, -50);
    motor(motorR, -50);
    sleep(1.0);
    off(motorL);
    off(motorR);
}
