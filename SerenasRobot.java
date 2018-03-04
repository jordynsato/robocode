package smsi;
import robocode.*;
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
	private double maxWidth, maxHeight;
	private double currentX, currentY, distance;
	private int wallPadding = 50;
	boolean ifRobotThere; //if there is a robot there

	public void run() {
		// Initialization of the robot should be put here
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		// Robot main loop
		//gets a maximum distance robot should move based on the width and height of the battlefield
			
			distance = Math.max(getBattleFieldWidth(), getBattleFieldHeight());
			ifRobotThere=false;
			turnLeft(getHeading() %90); // moving towards a wall
			ahead(distance);
			ifRobotThere=true;
			
		
		while(true) {		
			ifRobotThere = true;
			ahead(distance);
			ifRobotThere=false;
			turnRight(90);
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
			
			
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
