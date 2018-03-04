package smsi;
import robocode.*;
import java.awt.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * SerenasRobot - a robot by (your name here)
 */
public class SerenasRobot extends AdvancedRobot
{
	/**
	 * run: SerenasRobot's default behavior
	 * trying to create oscillating movement behavior
	 */
	double distanceX, distanceY;
	double direction; //getHeading() to find direction bot is facing
	boolean ifRobotThere; //if there is a robot there
	int count;
	
	public void run() {
		// Initialization of the robot should be put here
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		setBulletColor(Color.red);
		// Robot main loop
		//gets a maximum distance robot should move based on the width and height of the battlefield
			count =0;
			distanceX = getBattleFieldWidth()-50;
			distanceY = getBattleFieldHeight()-50;
			ifRobotThere=false;
			turnLeft(getHeading()%90); // moving towards a wall
			ahead(distanceX);
			ifRobotThere=true;
			turnGunRight(90);
		while(true) {		
			ifRobotThere = true;
			direction = getHeading();
			
			if(count >= 2) {
				avoidWalls(10);
			}
			else {
				avoidWalls(0);
			}

			/*if(getY()>=(getBattleFieldHeight()-50) || getX() >= getBattleFieldWidth()-50){
					turnRight(90);
					if(direction==180){
					ahead(distanceX - 10);
					turnGunRight(360);
					}
					else if(direction == 0) {
					ahead(distanceX);
					turnRadarRight(360);
					}
					else if(direction == 90){
					ahead(distanceY);
					}
					else
					ahead(distanceY-50);
				}
			else{
			turnRight(90);	
			ahead(distanceX);
			}*/
			
								
			ifRobotThere=false;
			
			count++;
		}//end while
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		//fire(2);
		if(ifRobotThere)
			scan();
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitRobot(HitRobotEvent e){
		if(e.getBearing() > -90 && e.getBearing() < 90){
			back(100);
		}
		else{
			ahead(100);
		}
	}	
	
	private void avoidWalls(double buffer) {
		if(getY()+distanceY >=(getBattleFieldHeight()-50) || getX()+distanceX >= getBattleFieldWidth()-50){
					turnRight(90);
					if(direction==180){
					ahead(distanceX - 10);
					}
					else if(direction == 0) {
					ahead(distanceX-buffer);
					}
					else if(direction == 90){
					ahead(distanceY-buffer);
					turnGunRight(360);
					}
					else {
					turnRadarRight(360);
					ahead(distanceY-10);
					}
				}
		else {
			turnRight(90);	
			ahead(distanceX);
		}
	}
}