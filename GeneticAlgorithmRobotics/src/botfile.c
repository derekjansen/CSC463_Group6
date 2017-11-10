int score = 0;
 void main()
 { while(1) {closeToWall()} }
void closeToWall() { 
while(analog(0) < 246)
{farFromWall();} }
void farFromWall() { 
while(analog(1) > 180)
{doTwoCloseFar();} }
void doTwoFarFar() { 
while(analog(2) > 76)
{forward();}
while(analog(1) > 142)
{right();} }
void doTwoCloseClose() { 
while(analog(1) < 169)
{right();}
while(analog(2) < 246)
{closeToWall();} }
void doTwoFarClose() {
while(analog(0) < 188)
{forward();}
while(analog(2) > 92)
{farFromWall();} }
void doTwoFarClose() {
while(analog(0) > 179)
{left();}
while(analog(1) < 240)
{doTwoCloseFar();} }
void forward() 
{ motor(0, 50); motor(3, 50); }
void left() 
{ motor(0, -25); motor(3, 75); }
void right() 
{ motor(0, 75); motor(3, -25); }
void backup() 
{ motor(0, -50); motor(3, -50); }
void turnParallelToPosition() 
{ backup();
 sleep(0.5);  left();
 sleep(0.5);
 turnParallelToPosition()}void turnSquareWithWall() 
 { 
 if(analog(leftFront) > analog(rightFront)) 
	{  
 while(analog(LeftFront) > analog(rightFront)) 
 { 
 turnRight(); 
	} 
 } 
 if(analog(rightFront) > analog(leftFront)) 
	{ 
 while(analog(rightFront) > analog(leftFront)) 
 { 
 turnLeft(); 
 } 
 }}