int score = 0;
 void main()
 { while(1) {farFromWall()} }
void closeToWall() { 
while(analog(2) < 139)
{left();} }
void farFromWall() { 
while(analog(0) > 8)
{doTwoFarClose();} }
void doTwoFarFar() { 
while(analog(2) > 24)
{left();}
while(analog(0) > 58)
{doTwoFarClose();} }
void doTwoCloseClose() { 
while(analog(2) < 71)
{doTwoCloseClose();}
while(analog(1) < 217)
{backup();} }
void doTwoFarClose() {
while(analog(0) < 241)
{right();}
while(analog(0) > 14)
{doTwoCloseClose();} }
void doTwoFarClose() {
while(analog(2) > 136)
{doTwoFarFar();}
while(analog(0) < 19)
{doTwoCloseClose();} }
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
 doTwoFarFar()}void turnSquareWithWall() 
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