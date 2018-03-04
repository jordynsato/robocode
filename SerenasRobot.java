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
	private double distanceX, distanceY;
	private double direction; //getHeading() to find direction bot is facing
	boolean ifRobotThere; //if there is a robot there

	public void run() {
		// Initialization of the robot should be put here
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		setBulletColor(Color.red);
		// Robot main loop
		//gets a maximum distance robot should move based on the width and height of the battlefield
			
			distanceX = getBattleFieldWidth()-5;
			distanceY = getBattleFieldWidth()-5;
			ifRobotThere=false;
			turnLeft(getHeading() %90); // moving towards a wall
			ahead(distanceX);
			ifRobotThere=true;
			turnGunRight(90);
			//turnRight(90);
		
		while(true) {		
			ifRobotThere = true;
			direction = getHeading();
			if(getY()<=10||getY()>=getBattleFieldHeight()-10||
				getX() <= 10 || getX() >= getBattleFieldWidth()-10){
					turnRight(90);
					if(direction==0||direction==180){
					ahead(distanceX);
					}
					else{
					ahead(distanceY);
					}
				}
			else{
			turnRight(90);	
			ahead(distanceX);
			}
		
			ifRobotThere=false;
			//turnRight(90);
			
			
			
		}//end while
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1.5);
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
	
	
}