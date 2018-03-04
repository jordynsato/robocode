package sming_jmsato;

import robocode.*;
import java.awt.Color;
import robocode.util.Utils;

/**
 * BobaBot - an AdvancedRobot by Serena Ing and Jordyn Sato
 */
public class BobaBot extends AdvancedRobot
{
	private double maxWidth, maxHeight;
	private double currentX, currentY, distance;
	private int wallPadding = 50;
	boolean ifRobotThere; //if there is a robot there
	
	/**
	 * run: BobaBot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		currentX = getX();
		currentY = getY();
		setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		setBulletColor(Color.red);
		setAdjustGunForRobotTurn(true);
		setAdjustRadarForRobotTurn(true);
		
		// Robot main loop
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
		double rHeading = this.getHeading();
		double tBearing = e.getBearing();		
		double gunHeading = this.getGunHeading();
		
		double turnAngle = Utils.normalRelativeAngleDegrees(rHeading + tBearing - gunHeading);

		turnGunRight(turnAngle);
		
		setFire(2);
		
		if(ifRobotThere)
			scan();
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		//back(10);
		//turnGunRight(e.getHeading() - this.getGunHeading());
		//fire(2);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		//back(20);
	}
}
