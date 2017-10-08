#define rMotor 3
#define lMotor 0
#define rSensor 2
#define lSensor 6

float crispLOut;
float crispRout;


void main()
{
    while(1)
    {
        float delta = digital(rSensor) - digital(lSensor);
        fuzzify(delta);

        //actual motor output here
        motor(lMotor,crispLout);
        motor(rMotor,crispRout); 
    }
}

/////NEED TO FIGURE OUT POSSIBLE DELTA VALUES AND SET ACCORDINGLY

void fuzzy(float delta)
{
    if (delta < - 25 && delta <= -50)
    {
       //negative big 
       crispRout = defuzz(delta,1);
       crispLout = defuzz(delta,0); 
    }
    
    if(delta => -25 && delta < 0)
    {
        //negative small
        crispRout = defuzz(delta,0.75);
        crispLout = defuzz(delta,0.25);
    }
   
    if(delta > 0 && delta <= 25)
    {
        //positive small
        crispRout = defuzz(delta,0.25);
        crispLout = defuzz(delta,0.75);
    }
    
    if( delta > 25 && delta <= 50)
    {
        //positive big
        crispRout = defuzz(delta,0);
        crispLout = defuzz(delta,1);
    }
    
    else//(delta == 0)  Set this as a range of values maybe? so it goes straight longer
    {
        //zero
        crispRout = 50.0;
        crispLout = 50.0;  
    }
}

float defuzz(float delta, float motorSpeed)
{ 
  float i;
  i = delta * motorSpeed;                   //delta multiplied by the set multiplication rate we want for each category
  i= (i/50) * 100;                     //maps it down to a correct possible motor speed  ***change 50 to the largest possible delta value
}



