int score = 0;
 void main()
 { while(1) {closeToWall()} }
void closeToWall() { 
while(analog(0) < 69)
{doTwoFarFar();} }
void farFromWall() { 
while(analog(2) > 142)
{right();} }
void doTwoFarFar() { 
while(analog(3) > 22)
{closeToWall();}
while(analog(1) > 149)
{closeToWall();} }
void doTwoCloseClose() { 
while(analog(0) < 100)
{backup();}
while(analog(1) < 102)
{doTwoFarClose();} }
void doTwoFarClose() {
while(analog(0) < 96)
{doTwoCloseClose();}
while(analog(0) > 114)
{backup();} }
void doTwoFarClose() {
while(analog(1) > 211)
{farFromWall();}
while(analog(0) < 101)
{doTwoFarClose();} }
void forward() 
{ motor(0, 50); motor(3, 50); }
void left() 
{ motor(0, -25); motor(3, 75); }
void right() 
{ motor(0, 75); motor(3, -25); }
