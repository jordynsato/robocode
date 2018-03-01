package sming_jmsato;

import robocode.*;
import java.awt.Color;

/**
 * BobaBot - an AdvancedRobot by Serena Ing and Jordyn Sato
 */
public class BobaBot extends AdvancedRobot
{
	/**
	 * run: BobaBot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
			scan();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		double x = this.getX();
		double y = this.getY();
		
		Targeting t = new Targeting(x, y, e.getDistance(), e.getBearingRadians(), e.getHeadingRadians(), e.getVelocity());
		t.calculateLinear();
		
		turnGunRight(t.getFireHeading());
		fire(1);
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		//back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
}
