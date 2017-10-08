#define rMotor 3
#define lMotor 0
#define rSensor 2
#define lSensor 6

float crispLout;
float crispRout;


void main()
{
    while(1)
    {
        float delta = digital(rSensor) - digital(lSensor);
        fuzzify(delta);

        //if(crispLout <10 && crispRout <10)        //make sure its not stupid slow
        //  {
        //    crispLout += 10;
        //    crispRout += 10;
        //  }
        
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

       //THIS IS THE LINEAR INTERPOLATION
       if(delta < -37.5)
       {
          delta = (delta - (-50)) / ((-37.5) - (-50));
       }
       else
       {
          delta = ((-25) - delta) / ((-25) - (-37.5));
       }

       crispRout = defuzz(delta,100);
       crispLout = defuzz(delta,0); 
    }
    
    if(delta => -25 && delta < 0)
    {
        //negative small

       //THIS IS THE LINEAR INTERPOLATION
       if(delta < -12.5)
       {
          delta = (delta - (-25)) / ((-12.5) - (-25));
       }
       else
       {
          delta = ((0) - delta) / ((0) - (-12.5));
       }
        
        crispRout = defuzz(delta,75);
        crispLout = defuzz(delta,25);
    }
   
    if(delta > 0 && delta <= 25)
    {
        //positive small


       //THIS IS THE LINEAR INTERPOLATION
       if(delta < 12.5)
       {
          delta = (delta - (0)) / ((12.5) - (0));
       }
       else
       {
          delta = ((25) - delta) / ((25) - (12.5));
       }

        
        crispRout = defuzz(delta,25);
        crispLout = defuzz(delta,75);
    }
    
    if( delta > 25 && delta <= 50)
    {
     

        //positive big

       //THIS IS THE LINEAR INTERPOLATION
       if(delta < 37.5)
       {
          delta = (delta - (25)) / ((37.5) - (25));
       }
       else
       {
          delta = ((50) - delta) / ((50) - (37.5));
       }
        
        crispRout = defuzz(delta,0);
        crispLout = defuzz(delta,100);
    }
    
    else
    {
        //zero
        crispRout = 50.0;
        crispLout = 50.0;  
    }
}

float defuzz(float delta, float motorSpeed)
{                 
  return delta * motorSpeed;                    //interpolated delta multiplied by the set
						//multiplication rate we want for each category
}



